package com.biblio.servlets;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biblio.model.User;
import com.biblio.rapport.GeneratePdf;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.biblio.dao.UserDao;
/**
 * Servlet implementation class managementServlet
 */
@WebServlet("/auth")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao UserDao;
	
	public void init() {
		UserDao = new UserDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher biblio = request.getRequestDispatcher("/");
		biblio.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		
		if(!username.trim().equals("") && !password.trim().equals("")) {
			User authUser = UserDao.authUser(username, password);
			
			if(authUser != null) {
				HttpSession session = request.getSession(false);
				session.setAttribute("username", authUser.getUsername());
				session.setAttribute("id", authUser.getId());
				session.setAttribute("id_adherent", authUser.getId_adherent());
				session.setAttribute("niveau", authUser.getNiveau());
				response.sendRedirect("/biblio/accueil");
			} else {
				request.setAttribute("message", "Identifiants Incorrect");
				RequestDispatcher biblio = request.getRequestDispatcher("/");
				biblio.forward(request, response);
			}
		
		
	}else {
		request.setAttribute("message", "Veuillez remplir les espaces vides !");
		RequestDispatcher biblio = request.getRequestDispatcher("/");
		biblio.forward(request, response);
	}

}
	
	public void pdf() throws FileNotFoundException {
	String path = "src/main/webapp/assets/rapport_pdf/biblioRapport.pdf";
		
		PdfDocument pdf = new PdfDocument (new PdfWriter (new FileOutputStream (path)));
		Document document = new Document (pdf, PageSize.A4);
		 
		
		document.add(new Paragraph("Hello"));
		document.close();
	}
	
}
