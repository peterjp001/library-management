package com.biblio.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.biblio.model.User;

import com.biblio.dao.UserDao;

/**
 * Servlet implementation class EditUserServlet
 */
@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao UserDao;
	
	public void init() {
		UserDao = new UserDao();
	}  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
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
			response.sendRedirect("/gestionBiblioUneph/user");
		}else {
			int id = Integer.parseInt(request.getParameter("id"));
			User userData = (User) UserDao.selectUser(id);
			request.setAttribute("userData", userData);
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit_user.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String option = request.getParameter("option"); 
		switch(option) {
		
		case "changePassword":
			int idp = Integer.parseInt(request.getParameter("id"));
			String password = request.getParameter("password"); 
			String cpassword = request.getParameter("cpassword"); 
			if(!password.trim().equals("") && !cpassword.trim().equals("")) {
				if(password.equals(cpassword) ) {
					try {
						UserDao.updatePasswordUser(new User(idp,password));
						request.setAttribute("message", "Mot de passe Modifie");
						request.setAttribute("type","success");
						doGet(request, response);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				else {
					request.setAttribute("message", "Mot de passe non identique");
					request.setAttribute("type","danger");
					doGet(request, response);
					
				}
			}else {
				request.setAttribute("message", "Veuillez remplire les champs vides");
				request.setAttribute("type","danger");
				doGet(request, response);
			}
			
			break;
			
		case "changeInfo":
			int id = Integer.parseInt(request.getParameter("id"));
			String username = request.getParameter("username");
			String niveau = request.getParameter("niveau");
			try {
				UserDao.updateUser(new User(id,username,niveau));
				request.setAttribute("message", "Infos Connection Modifies");
				request.setAttribute("type","success");
				doGet(request, response);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
			
		
		
		}
		
//		doGet(request, response);
		
	}

}
