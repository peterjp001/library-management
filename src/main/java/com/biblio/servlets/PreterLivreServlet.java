package com.biblio.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.dao.LivreDao;
import com.biblio.model.Livre;

/**
 * Servlet implementation class preterLivre
 */
@WebServlet("/preterlivre")
public class PreterLivreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LivreDao livreDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public void init() {
		livreDao = new LivreDao();
	}
	
    public PreterLivreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<Livre> listLivre = livreDao.selectAllLivres();
		request.setAttribute("listLivre", listLivre); 
		RequestDispatcher biblio = request.getRequestDispatcher("/pret.jsp");
		biblio.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
