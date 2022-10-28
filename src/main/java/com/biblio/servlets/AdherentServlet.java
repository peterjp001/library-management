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

import com.biblio.dao.AdherentDao;
import com.biblio.model.Adherent;
import com.biblio.model.User;

/**
 * Servlet implementation class AdheerentServlet
 */
@WebServlet("/adherent")
public class AdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdherentDao adherentDao;
	
	public void init() {
		AdherentDao adherentDao = new AdherentDao();
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Adherent> listAdherent = AdherentDao.selectAllAdherents();
		request.setAttribute("listAdherent", listAdherent);
		RequestDispatcher biblio = request.getRequestDispatcher("/adherent.jsp");
		biblio.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		id	nom	prenom	cin_nif	sexe	date_naissance	adresse	telephone	email	profession	statut	
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom"); 
		String cin_nif = request.getParameter("cin_nif"); 
		String sexe = request.getParameter("sexe"); 
		String date_naissance = request.getParameter("date_naissance");
		String adresse = request.getParameter("adresse"); 
		String email = request.getParameter("email"); 
		String telephone = request.getParameter("telephone");  
		String profession = request.getParameter("profession"); 
		String statut = request.getParameter("statut");
		
		
		if(!nom.trim().equals("") && !prenom.trim().equals("") && !cin_nif.trim().equals("") && !sexe.trim().equals("") 
				&& !date_naissance.trim().equals("")&& !adresse.trim().equals("") && !email.trim().equals("")
				&& !telephone.trim().equals("") && !profession.trim().equals("")&& !statut.trim().equals("")) { 
				
				try {
					AdherentDao.insertAdherent(new Adherent(nom, prenom, cin_nif, sexe,date_naissance, adresse, telephone, email, profession, statut));
					request.setAttribute("message", "Adherent ajoute !");
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
