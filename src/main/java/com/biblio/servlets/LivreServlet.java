package com.biblio.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.LivreDao;
//import com.biblio.dao.UserDao;
import com.biblio.model.Livre;
//import com.biblio.model.User;
import com.biblio.model.User;

/**
 * Servlet implementation class LivreServlet
 */
@WebServlet("/livre")
public class LivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
private LivreDao livreDao;
	
	public void init() {
		livreDao = new LivreDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Livre> listLivre = livreDao.selectAllLivres();
		int nbrCat = livreDao.countCategorie();
		int nbrAuteur = livreDao.countAuteur();
		request.setAttribute("listLivre", listLivre);
		request.setAttribute("nbrCat",nbrCat);
		request.setAttribute("nbrAuteur",nbrAuteur);
		RequestDispatcher biblio = request.getRequestDispatcher("/livre.jsp");
		biblio.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       String titre = request.getParameter("titre");
           String auteur = request.getParameter("auteur"); 
           String date_parution = request.getParameter("date_parution"); 
           String resume = request.getParameter("resume"); 
           String categorie = request.getParameter("categorie"); 
           String quantite = request.getParameter("quantite"); 
           String etat = request.getParameter("etat"); 
		
		if(!titre.trim().equals("") && !auteur.trim().equals("") && !date_parution.trim().equals("") && !resume.trim().equals("") && !categorie.trim().equals("") && !quantite.trim().equals("") && !etat.trim().equals("")) { 
				
				try {
					livreDao.insertLivre(new Livre(titre, auteur, date_parution, resume, categorie, quantite, etat));
					request.setAttribute("message", "Livre ajoute !");
					request.setAttribute("type", "success");
					doGet(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}else {
			request.setAttribute("message", "Veuillez remplir les champs vide !");
			request.setAttribute("type", "danger");
			doGet(request, response);
		}
		

}
}