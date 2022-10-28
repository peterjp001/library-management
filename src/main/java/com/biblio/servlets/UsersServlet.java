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

import com.biblio.dao.UserDao;
import com.biblio.model.User;

/**
 * Servlet implementation class UsersServlet
 */
@WebServlet("/user")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao UserDao;
	
	public void init() {
		UserDao = new UserDao();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		List<User> listUser = UserDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher biblio = request.getRequestDispatcher("/utilisateurs.jsp");
		biblio.forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("password"); 
		String cpassword = request.getParameter("cpassword"); 
		String niveau = request.getParameter("niveau"); 
		
		if(!username.trim().equals("") && !password.trim().equals("") && !cpassword.trim().equals("")) {
			if(password.trim().equals(cpassword)) {
				
				try {
					UserDao.insertUser(new User(username,password,niveau));
					request.setAttribute("message", "Utilisateur ajoute !");
					request.setAttribute("type", "success");
					doGet(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else {
				request.setAttribute("message", "Mot De Passe non identique");
				request.setAttribute("type", "danger");
				doGet(request, response);
			}
			
		}else {
			request.setAttribute("message", "Veuillez remplir les champs vide !");
			request.setAttribute("type", "danger");
			doGet(request, response);
		}
		
		
		
	}
 

}
