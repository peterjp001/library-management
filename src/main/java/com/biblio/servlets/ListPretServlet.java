package com.biblio.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.LivreDao;
import com.biblio.dao.PretDao;
import com.biblio.model.Livre;
import com.biblio.model.PretAdherent;

/**
 * Servlet implementation class ListPretServlet
 */
@WebServlet("/listpret")
public class ListPretServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PretDao pretDao;
	private LivreDao livreDao;
	
   /**
    * @see HttpServlet#HttpServlet()
    */
	
	public void init() {
		pretDao = new PretDao();
		livreDao = new LivreDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPretServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
 
		
		List<PretAdherent> listPret = pretDao.selectAllPret();
		request.setAttribute("listPret", listPret); 
		RequestDispatcher biblio = request.getRequestDispatcher("/list_pret.jsp");
		biblio.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idPret =Integer.parseInt(request.getParameter("idPret")); 
		int idLivre =Integer.parseInt(request.getParameter("idLivre")); 
		int quantite =Integer.parseInt(request.getParameter("quantite")); 
			try {
				pretDao.updateStatutPret(idPret);
				livreDao.updateQuantite(quantite+1,idLivre);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
			request.setAttribute("message", "Livre Retourne");
			request.setAttribute("type","success");
		doGet(request, response);
	}

}
