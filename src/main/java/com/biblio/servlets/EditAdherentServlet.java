package com.biblio.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.AdherentDao;
import com.biblio.dao.UserDao;
import com.biblio.model.Adherent;
import com.biblio.model.User; 

 
@WebServlet("/editAdherent")
public class EditAdherentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdherentDao adherentDao;
	private UserDao UserDao;
	
	public void init() {
		 adherentDao = new AdherentDao();
		 UserDao = new UserDao();
	}
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("id") == null) {
			response.sendRedirect("/gestionBiblioUneph/adherent");
		}
		else {
			int id = Integer.parseInt(request.getParameter("id"));
			Adherent adherentData =  adherentDao.selectAdherent(id); 
			if(adherentData == null) {
				response.sendRedirect("/gestionBiblioUneph/adherent");
			}else { 
					request.setAttribute("adherentData", adherentData);  
					RequestDispatcher dispatcher = request.getRequestDispatcher("edit_adherent.jsp");
					dispatcher.forward(request, response);
			}
			
		}
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
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
		try {
			adherentDao.updateAdherent(new Adherent(id,nom, prenom, cin_nif, sexe,date_naissance, adresse, telephone, email, profession, statut));
			request.setAttribute("message", "Adherent Modifies");
			request.setAttribute("type","success");
			doGet(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
