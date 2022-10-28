package com.biblio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblio.model.Adherent;
import com.biblio.model.User; 
 	
public class AdherentDao {
//	com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO adherent   (nom,	prenom,	cin_nif, sexe, date_naissance, adresse,	telephone,	email,	profession,	statut) VALUES  ('Jean Pierre','Wendy','3009-0092344','masculin','Etudiant','2022-05-10','Caracolie','48423991','wendy@gmail.com','Agronome');
	private static final String INSERT_ADHERENT_SQL = "INSERT INTO adherent   (nom,prenom,cin_nif,sexe,date_naissance,adresse,telephone,email,profession,statut) VALUES  (?,?,?,?,?,?,?,?,?,?);";
	private static final String SELECT_ADHERENT_BY_ID = "select * from adherent where id = ?";
	private static final String SELECT_ALL_ADHERENTS = "select * from adherent";
//	private static final String DELETE_ADHERENT_SQL = "delete from adherent where id = ?;";
	private static final String UPDATE_ADHERENT_SQL = "update adherent set nom = ?, prenom = ?, cin_nif = ?, sexe = ?,	date_naissance=?,	adresse= ?,	telephone = ?,	email = ?,	profession = ?,	statut = ?	 where id = ?;"; 
	private static final String FIND_ID_ADHERENT_BY_FLF = "select id from adherent where nom = ? and prenom = ? and telephone = ?";


	public static void insertAdherent(Adherent adherent) throws SQLException {
		 
		// try-with-resource statement will auto close the connection.
		try( Connection connection =   dbConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADHERENT_SQL)) {
			preparedStatement.setString(1, adherent.getNom());
			preparedStatement.setString(2, adherent.getPrenom()); 
			preparedStatement.setString(3, adherent.getCin_nif());
			preparedStatement.setString(4, adherent.getSexe()); 
			preparedStatement.setString(5, adherent.getDate_naissance());
			preparedStatement.setString(6, adherent.getAdresse()); 
			preparedStatement.setString(7, adherent.getTelephone());
			preparedStatement.setString(8, adherent.getEmail());
			preparedStatement.setString(9, adherent.getProfession());
			preparedStatement.setString(10, adherent.getStatut()); 
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Adherent> selectAllAdherents() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Adherent> adherents = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADHERENTS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String cin_nif = rs.getString("cin_nif");
				String sexe = rs.getString("sexe");
				String adresse = rs.getString("adresse"); 
				String telephone = rs.getString("telephone");
				String email = rs.getString("email"); 
				String profession = rs.getString("profession");
				String statut = rs.getString("statut");
				String date_naissance = rs.getString("date_naissance"); 
				adherents.add(new Adherent(id, nom, prenom, cin_nif, sexe,date_naissance, adresse, telephone, email, profession, statut));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return adherents;
	}
	
	public Adherent selectAdherent(int id) {
		Adherent adherent = null;
			// Step 1: Establishing a Connection
		try (Connection connection  =   dbConnection.getConnection();
				
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADHERENT_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id_adherent = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String cin_nif = rs.getString("cin_nif");
				String sexe = rs.getString("sexe");
				String adresse = rs.getString("adresse"); 
				String telephone = rs.getString("telephone");
				String email = rs.getString("email"); 
				String profession = rs.getString("profession");
				String statut = rs.getString("statut");
				String date_naissance = rs.getString("date_naissance");
				adherent = new Adherent(id_adherent, nom, prenom, cin_nif, sexe,date_naissance, adresse, telephone, email, profession, statut);
			}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return adherent;
	}
	
	public int selectIdAdherent(String nom, String prenom, String telephone) {
		int  id_adherent = 0;
			// Step 1: Establishing a Connection
		try (Connection connection  =   dbConnection.getConnection();
				
			// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID_ADHERENT_BY_FLF);) {
			preparedStatement.setString(1, nom);
			preparedStatement.setString(2, prenom);
			preparedStatement.setString(3, telephone);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) { 
				 id_adherent = rs.getInt("id");
				}
		} catch (SQLException e) {
			e.printStackTrace();		}
		return id_adherent;
	}
	
	public boolean updateAdherent(Adherent adherent) throws SQLException {
		boolean rowUpdated;
		try (Connection connection =   dbConnection.getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_ADHERENT_SQL);) {
			statement.setString(1, adherent.getNom());
			statement.setString(2, adherent.getPrenom()); 
			statement.setString(3, adherent.getCin_nif());
			statement.setString(4, adherent.getSexe()); 
			statement.setString(5, adherent.getDate_naissance());
			statement.setString(6, adherent.getAdresse()); 
			statement.setString(7, adherent.getTelephone());
			statement.setString(8, adherent.getEmail());
			statement.setString(9, adherent.getProfession());
			statement.setString(10, adherent.getStatut());
			statement.setInt(11, adherent.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}
	
	public int countAderent() {
		int nbrLivre = 0;
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement("select count(id) as nbrLivre from adherent")) {
			 
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
}
