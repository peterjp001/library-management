package com.biblio.servlets;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.AdherentDao;
import com.biblio.dao.LivreDao;
import com.biblio.dao.PretDao;
import com.biblio.dao.ReservationDao;
import com.biblio.model.Livre;
import com.biblio.model.Pret;
import com.biblio.model.Reservation;

/**
 * Servlet implementation class ReservationServlet
 */
@WebServlet("/reserver")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LivreDao livreDao;
	private AdherentDao adherentDao;
	private PretDao pretDao;
	private ReservationDao resDao;
	public void init() {
		livreDao = new LivreDao();
		adherentDao = new AdherentDao();
		pretDao = new PretDao();
		resDao = new ReservationDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationServlet() {
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
			RequestDispatcher dispatcher = request.getRequestDispatcher("reservation.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("idLivre"));
		String nom = request.getParameter("nom"); 
		String prenom = request.getParameter("prenom");
		String telephone = request.getParameter("telephone");  
		
		if(!nom.trim().equals("") || !prenom.trim().equals("") || !telephone.trim().equals("")) {
			int id_adherent = adherentDao.selectIdAdherent(nom, prenom, telephone);
			if(id_adherent > 0) {
				
				try {
					resDao.newReservation(new Reservation(id,id_adherent));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.setAttribute("message", "Reservation Effectue!");
				request.setAttribute("type","success");
				
			 
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
	}

}
