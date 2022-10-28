package com.biblio.dao;
import com.biblio.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblio.dao.dbConnection;

public class UserDao {
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (username, password,niveau) VALUES "
			+ " (?, ?,?);"; 
	private static final String SELECT_USER_BY_ID = "select id,username,niveau from users where id =?"; 
	private static final String SELECT_ALL_USERS = "select * from users";
	private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
	private static final String UPDATE_USERS_SQL = "update users set username = ?, niveau = ? where id = ?;";
	private static final String UPDATE_PASSWORD_USERS_SQL = "update users set password = ? where id = ?;";
	private static final String AUTH_USER = "select * from users where username = ? and password = ?";
	

 
//	INSERT USER
	
//	insertAdherentAsUser
	
	public void insertUser(User user) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try( Connection connection =   dbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getPassword()); 
			preparedStatement.setString(3, user.getNiveau()); 
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
 
	
	public User authUser(String username, String password) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(AUTH_USER);) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id"); 
				String userPseudo = rs.getString("username"); 
				String niveau = rs.getString("niveau"); 
				user = new User(id, userPseudo,niveau);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	
	public List<User> selectAllUsers() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<User> users = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String username = rs.getString("username");
				String niveau = rs.getString("niveau"); 
				users.add(new User(id, username, niveau));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(users);
		return users;
	}
	
	
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection =   dbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	
	public User selectUser(int id) {
		User user = null;
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id_user = rs.getInt("id"); 
				String username = rs.getString("username");
				String niveau = rs.getString("niveau");
				user = new User(id_user ,username, niveau);
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return user;
	}
	
//	public User selectUserAdherent(int id) {
//		User user = null;
//		// Step 1: Establishing a Connection
//		try (Connection connection =   dbConnection.getConnection();
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_ADHERENT_BY_ID);) {
//			preparedStatement.setInt(1, id);
//			System.out.println(preparedStatement);
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//
//			// Step 4: Process the ResultSet object.
//			while (rs.next()) {
//				int id_user = rs.getInt("id"); 
//				String username = rs.getString("username");
//				String niveau = rs.getString("niveau");
//				user = new User(id_user ,username, niveau);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();		}
//		return user;
//	}
	
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection =   dbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			statement.setString(1, user.getUsername());
			statement.setString(2, user.getNiveau()); 
			statement.setInt(3, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean updatePasswordUser(User user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection =   dbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE users set password =? WHERE id =?");) {
			statement.setString(1, user.getPassword());  
			statement.setInt(2, user.getId());
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public int countUser() {
		int nbrUser = 0;
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select count(id) as nbrUser from users")) {
			 
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				nbrUser = rs.getInt("nbrUser"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return nbrUser;
	}





}
