package com.biblio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblio.model.PretAdherent;
import com.biblio.model.Reservation;
 

public class ReservationDao {
	
	private static final String INSERT_RESERVATION= "INSERT INTO reservation(id_livre, id_adherent) VALUES (?,?)";
private static final String LIST_ALL_RESERVATION = "select adherent.id as idAdherent,livre.id as idLivre, reservation.id as idReservation , nom,prenom,telephone,adresse,email,titre,auteur,quantite,reservation.statut from adherent inner join reservation on adherent.id = reservation.id_adherent inner join livre where reservation.id_livre = livre.id AND reservation.statut = 1;";
	
	public void newReservation(Reservation res) throws SQLException {
		System.out.println(INSERT_RESERVATION);
		// try-with-resource statement will auto close the connection.
		try( Connection connection =   dbConnection.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION)) {
			preparedStatement.setInt(1, res.getIdLivre());
			preparedStatement.setInt(2, res.getIdAdherent());  
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public List<PretAdherent> selectAllRes() {
 
		// using try-with-resources to avoid closing resources (boiler plate code)
		List<PretAdherent> pretAdherent = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection =   dbConnection.getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(LIST_ALL_RESERVATION);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int idAdherent = rs.getInt("idAdherent");
				int idLivre = rs.getInt("idLivre");
				int idReservation = rs.getInt("idReservation");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom"); 
				String telephone = rs.getString("telephone");
				String email = rs.getString("email");
				String adresse = rs.getString("adresse"); 
				String titre = rs.getString("titre");
				String auteur = rs.getString("auteur"); 
				int quantite = rs.getInt("quantite"); 
				 
				pretAdherent.add(new PretAdherent(idAdherent,idLivre,idReservation,nom,prenom,telephone,adresse,email,titre,auteur,quantite));
			 
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return pretAdherent;
	}
 
	
	

}
