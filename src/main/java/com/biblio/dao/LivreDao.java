package com.biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblio.model.Livre;
import com.biblio.model.User; 

public class LivreDao {
//	count(DISTINCT(categorie))
	private static final String INSERT_LIVRE_SQL = "INSERT INTO livre  (titre, auteur, date_parution, resume, categorie, quantite, etat) VALUES  (?,?,?,?,?,?,?)";
	private static final String SELECT_ALL_LIVRE = "select * from livre";
	private static final String SELECT_LIVRE_BY_ID = "select * from livre where id =?";
	private static final String UPDATE_LIVRE_SQL = "update livre set titre = ?, auteur = ?, date_parution = ?, resume = ?, categorie = ?, quantite = ? , etat = ? where id = ?;";
	private static final String UPDATE_QUANTITE_LIVRE = "UPDATE livre set quantite = ? where id = ?";
	private static final String AUTEUR_LIVRE_QUATITE = "select auteur, count(DISTINCT(livre.id)) as nbrLivre, count(transaction_livre.id_livre) as nbrLivrePreter from livre inner join transaction_livre on livre.id = transaction_livre.id_livre GROUP by auteur";
	
	//	private static final String PRETER_LIVRE_SQL = 
	
	
	public void insertLivre(Livre livre) throws SQLException {
		System.out.println(INSERT_LIVRE_SQL);
		// try-with-resource statement will auto close the connection.
		try( Connection connection =   dbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_LIVRE_SQL)) {
//			id	titre	auteur	date_parution	resume	categorie	quantite	etat	
			preparedStatement.setString(1, livre.getTitre());
			preparedStatement.setString(2, livre.getAuteur()); 
			preparedStatement.setString(3, livre.getDate_parution());
			preparedStatement.setString(4, livre.getResume());
			preparedStatement.setString(5, livre.getCategorie()); 
			preparedStatement.setString(6, livre.getQuantite());
			preparedStatement.setString(7, livre.getEtat());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public List<Livre> selectAllLivres() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Livre> livre = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_LIVRE);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur"); 
				String date_parution = rs.getString("date_parution");
				String resume = rs.getString("resume"); 
				String categorie = rs.getString("categorie");
				String quantite = rs.getString("quantite"); 
				String etat = rs.getString("etat"); 
				livre.add(new Livre(id,titre, auteur, date_parution, resume, categorie, quantite, etat));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return livre;
	}
	
	public Livre selectLivre(int id) {
		Livre livre = null;
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LIVRE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id_livre = rs.getInt("id");
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur"); 
				String date_parution = rs.getString("date_parution");
				String resume = rs.getString("resume"); 
				String categorie = rs.getString("categorie");
				String quantite = rs.getString("quantite"); 
				String etat = rs.getString("etat"); 
				livre = new Livre(id_livre,titre, auteur, date_parution, resume, categorie, quantite, etat);
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return livre;
	}
	
	public boolean updateLivre(Livre livre) throws SQLException {
		boolean rowUpdated;
		try (Connection connection =   dbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_LIVRE_SQL);) {
			statement.setString(1, livre.getTitre());
			statement.setString(2, livre.getAuteur()); 
			statement.setString(3, livre.getDate_parution());
			statement.setString(4, livre.getResume());
			statement.setString(5, livre.getCategorie()); 
			statement.setString(6, livre.getQuantite());
			statement.setString(7, livre.getEtat()); 
			statement.setInt(8, livre.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public boolean updateQuantite(int quantite , int id) throws SQLException {
		boolean rowUpdated;
		try (Connection connection =   dbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_QUANTITE_LIVRE);) {
			statement.setInt(1, quantite);
			statement.setInt(2, id); 

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public int countCategorie() {
		int nbrCat = 0;
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select count(DISTINCT(categorie)) as nbrCat from livre")) {
			 
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				 nbrCat = rs.getInt("nbrCat"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return nbrCat;
	}
	
	public int countAuteur() {
		int nbrAuteur = 0;
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select count(DISTINCT(auteur)) as nbrAuteur from livre")) {
			 
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				nbrAuteur = rs.getInt("nbrAuteur"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return nbrAuteur;
	}
	
	public int countLivre() {
		int nbrLivre = 0;
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select count(id) as nbrLivre from livre")) {
			 
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				nbrLivre = rs.getInt("nbrLivre"); 
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return nbrLivre;
	} 
	
	public List<Livre>  livreByCategorie() {
		List<Livre> lbc = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select categorie, count(DISTINCT(id)) as nbrLivre from livre GROUP by categorie")) {
			 
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String categorie =  rs.getString("categorie");
				int nbrLivre = rs.getInt("nbrLivre");
				lbc.add(new Livre(categorie,nbrLivre));
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return lbc;
	} 
	
	public List<Livre> selectCustomALP() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Livre> livre = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(AUTEUR_LIVRE_QUATITE);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) { 
				String auteur = rs.getString("auteur");
				int nbrLivre = rs.getInt("nbrLivre"); 
				int nbrLivrePreter = rs.getInt("nbrLivrePreter"); 
				livre.add(new Livre(auteur,nbrLivre,nbrLivrePreter)); 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return livre;
	}
}
  