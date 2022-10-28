package com.biblio.model;

import java.sql.Date;

public class PretAdherent {

	private int idAdherent,idLivre,idPret,idReservation;
	private String nom,prenom,telephone,adresse,email,titre,auteur;
	private Date date_pret,date_retour;
	
	private int duration;
	private int delai;
	private int quantite;
	
	public PretAdherent(int idAdherent, int idLivre, int idPret, String nom, String prenom, String telephone,
			String adresse, String email, String titre, String auteur, int quantite,Date date_pret, Date date_retour) {
		super();
		this.idAdherent = idAdherent;
		this.idLivre = idLivre;
		this.idPret = idPret;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.email = email;
		this.titre = titre;
		this.auteur = auteur;
		this.quantite = quantite;
		this.date_pret = date_pret;
		this.date_retour = date_retour; 
	}

	public PretAdherent(int idAdherent, int idLivre, int idReservation, String nom, String prenom,
			String telephone, String adresse, String email, String titre, String auteur, int quantite) {
		super();
		this.idAdherent = idAdherent;
		this.idLivre = idLivre;
		this.idReservation = idReservation;
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.adresse = adresse;
		this.email = email;
		this.titre = titre;
		this.auteur = auteur;
		this.quantite = quantite;
	}

	public int getIdAdherent() {
		return idAdherent;
	}

	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}

	public int getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}

	public int getIdPret() {
		return idPret;
	}
	
	

	public int getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(int idReservation) {
		this.idReservation = idReservation;
	}

	public void setIdPret(int idPret) {
		this.idPret = idPret;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String gettelephone() {
		return telephone;
	}

	public void settelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}
	
	

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public Date getDate_pret() {
		return date_pret;
	}

	public void setDate_pret(Date date_pret) {
		this.date_pret = date_pret;
	}

	public Date getDate_retour() {
		return date_retour;
	}

	public void setDate_retour(Date date_retour) {
		this.date_retour = date_retour;
	}

	public int getDuration() {
		int duration = (int) (((this.getDate_retour().getTime() - this.getDate_pret().getTime())/ (1000 * 60 * 60 * 24)) % 365);
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getDelai() {
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new Date(date.getTime());
		
		int delai = (int) ((( this.getDate_retour().getTime() - sqlDate.getTime() )/ (1000 * 60 * 60 * 24)) % 365);
		
		return delai+1;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	
	
	
	
	
	
	
}

 
