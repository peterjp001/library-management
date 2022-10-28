package com.biblio.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.AdherentDao;
import com.biblio.dao.LivreDao;
import com.biblio.dao.PretDao;
import com.biblio.model.Livre;
import com.biblio.model.Pret; 

/**
 * Servlet implementation class PretServlet
 */
@WebServlet("/pret")
public class PretServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivreDao livreDao;
	private AdherentDao adherentDao;
	private PretDao pretDao;
	public void init() {
		livreDao = new LivreDao();
		adherentDao = new AdherentDao();
		pretDao = new PretDao();
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PretServlet() {
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
			response.sendRedirect("/gestionBiblioUneph/preterlivre");
		}else {
			int id = Integer.parseInt(request.getParameter("id"));
			Livre livreData = (Livre) livreDao.selectLivre(id);
			request.setAttribute("livreData", livreData);
			RequestDispatcher dispatcher = request.getRequestDispatcher("preter_livre.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idLivre"));
		String nom = request.getParameter("nom"); 
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone"); 
		int quantite= Integer.parseInt(request.getParameter("quantite"));
		
		if(!nom.trim().equals("") || !prenom.trim().equals("") || !telephone.trim().equals("")) {
			int id_adherent = adherentDao.selectIdAdherent(nom, prenom, telephone);
			if(id_adherent > 0) {
				Date date_pret = Date.valueOf(request.getParameter("date_pret"));
				Date date_retour = Date.valueOf(request.getParameter("date_retour"));
				
				
				int acceptedNbrDays = (int) (((date_retour.getTime() - date_pret.getTime())/ (1000 * 60 * 60 * 24)) % 365);
				if(acceptedNbrDays>=2 && acceptedNbrDays <=15) {
					try {
						PretDao.insertPret( new Pret(id,id_adherent,date_pret,date_retour));
						livreDao.updateQuantite(quantite-1,id);
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					request.setAttribute("message", "Pret Effectue");
					request.setAttribute("type","success");
				}else {
					request.setAttribute("message", "Pret Valide entre 2 a 15 jours");
					request.setAttribute("type","warning");
				}
			}else {
				request.setAttribute("message", "Cet adherent n'existe pas!");
				request.setAttribute("type","warning");
			}
			
//					
					
				 
		}else {
			request.setAttribute("message", "Champ(s) vide");
			request.setAttribute("type","danger");
			
		}
		
		doGet(request, response);
		
//		System.out.println(id);
//		System.out.println(nom);
//		System.out.println(prenom);
//		System.out.println(telephone);

}
	
}
