package com.biblio.servlets;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.biblio.dao.LivreDao;
import com.biblio.dao.AdherentDao;
import com.biblio.dao.UserDao;
import com.biblio.model.Livre; 

/**
 * Servlet implementation class biblioServlet
 */


@WebServlet("/accueil")
public class biblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LivreDao livreDao;
    private AdherentDao adherentDao;
    private UserDao userDao;

    public void init() {
		livreDao = new LivreDao();
		adherentDao = new AdherentDao();
		userDao = new UserDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	// TODO Auto-generated method stub
		
		doGet(request, response);
	}
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		    
		    int nbrUser = userDao.countUser();
			int nbrCat = livreDao.countCategorie();
			int nbrAuteur = livreDao.countAuteur();
			int nbrLivre = livreDao.countLivre();
			int nbrAdherent = adherentDao.countAderent();
			
			List<Livre> listLivre = livreDao.selectAllLivres();
			List<Livre> li = livreDao.selectCustomALP();
			List<Livre> lbc = livreDao.livreByCategorie();
			
			request.setAttribute("lbc", lbc);
			request.setAttribute("li", li);
			request.setAttribute("listLivre", listLivre);
			request.setAttribute("nbrUser",nbrUser);
			request.setAttribute("nbrAdherent",nbrAdherent);
			request.setAttribute("nbrCat",nbrCat);
			request.setAttribute("nbrAuteur",nbrAuteur);
			request.setAttribute("nbrLivre", nbrLivre);
			RequestDispatcher biblio = request.getRequestDispatcher("/home.jsp");
			biblio.forward(request, response); 
		 
		
	}

 
}
