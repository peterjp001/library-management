package com.biblio.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.LivreDao;
import com.biblio.model.Livre;
import com.biblio.model.User;

/**
 * Servlet implementation class EditLivreServlet
 */
@WebServlet("/editLivre")
public class EditLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private LivreDao livreDao;
	
	public void init() {
		livreDao = new LivreDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		if(request.getParameter("id") == null) {
			response.sendRedirect("/gestionBiblioUneph/adherent");
		}else {
			int id = Integer.parseInt(request.getParameter("id"));
			Livre livreData = (Livre) livreDao.selectLivre(id);
			request.setAttribute("livreData", livreData);
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit_livre.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String titre = request.getParameter("titre");
        String auteur = request.getParameter("auteur"); 
        String date_parution = request.getParameter("date_parution"); 
        String resume = request.getParameter("resume"); 
        String categorie = request.getParameter("categorie"); 
        String quantite = request.getParameter("quantite"); 
        String etat = request.getParameter("etat"); 
		try {
			livreDao.updateLivre( new Livre(id,titre, auteur, date_parution, resume, categorie, quantite, etat));
			request.setAttribute("message", "Livre Modifies");
			request.setAttribute("type","success");
			doGet(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
