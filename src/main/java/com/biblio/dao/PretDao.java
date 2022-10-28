package com.biblio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblio.model.Pret;
import com.biblio.model.PretAdherent;
import com.biblio.model.User;
 

public class PretDao {
	
	private static final String MAKE_PRET = "INSERT INTO transaction_livre (id_livre, id_adherent, date_pret, date_retour) VALUES(?,?,?,?)";
	private static final String LIST_ALL_PRET_WITH_ADHERENT = "select adherent.id as idAdherent,livre.id as idLivre, transaction_livre.id as idPret , nom,prenom,telephone,adresse,email,titre,auteur,quantite,date_pret,date_retour,statut_pret from adherent inner join transaction_livre on adherent.id = transaction_livre.id_adherent inner join livre where transaction_livre.id_livre = livre.id AND transaction_livre.statut_pret = 1"; 
	private static final String UPDATE_STATUT_PRET = "UPDATE transaction_livre set statut_pret = 0 WHERE id = ?";
	
	
	
	
	public static void insertPret(Pret pret) throws SQLException {
		 
		// try-with-resource statement will auto close the connection.
		try( Connection connection =   dbConnection.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(MAKE_PRET)) {
			preparedStatement.setInt(1, pret.getId_livre());
			preparedStatement.setInt(2, pret.getId_adherent()); 
			preparedStatement.setDate(3, (Date) pret.getDate_pret());
			preparedStatement.setDate(4, (Date) pret.getDate_retour());  
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<PretAdherent> selectAllPret() {

 
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<PretAdherent> pretAdherent = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(LIST_ALL_PRET_WITH_ADHERENT);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idAdherent = rs.getInt("idAdherent");
				int idLivre = rs.getInt("idLivre");
				int idPret = rs.getInt("idPret");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom"); 
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse"); 
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur"); 
				int quantite = rs.getInt("quantite");
				Date date_pret = Date.valueOf(rs.getString("date_pret"));
				Date date_retour = Date.valueOf(rs.getString("date_retour")); 
				 
				pretAdherent.add(new PretAdherent(idAdherent,idLivre,idPret,nom,prenom,telephone,adresse,email,titre,auteur,quantite,date_pret,date_retour));
			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return pretAdherent;
	}
	
	
	public boolean updateStatutPret(int idPret) throws SQLException {
		boolean rowUpdated;
		try (Connection connection =   dbConnection.getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_STATUT_PRET)) {
			statement.setInt(1, idPret);  
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

}
