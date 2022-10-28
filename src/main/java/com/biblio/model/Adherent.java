package com.biblio.model;

import java.sql.Date;

public class Adherent {
	
	protected int id;
	protected String nom,prenom,cin_nif,sexe, adresse,	telephone,	email,	profession,	statut,date_naissance;
	
	
	 
	public Adherent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Adherent(int id, String nom, String prenom, String cin_nif, String sexe,String date_naissance, String adresse, String telephone,
			String email, String profession, String statut) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin_nif = cin_nif;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.profession = profession;
		this.statut = statut;
		
	}
//	nom	prenom	cin_nif	sexe	date_naissance	adresse	telephone	email	profession	statut	

	public Adherent( String nom, String prenom, String cin_nif, String sexe,String date_naissance, String adresse, String telephone,
			String email, String profession, String statut) {
		super(); 
		this.nom = nom;
		this.prenom = prenom;
		this.cin_nif = cin_nif;
		this.sexe = sexe;
		this.date_naissance = date_naissance;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.profession = profession;
		this.statut = statut;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getCin_nif() {
		return cin_nif;
	}
	public void setCin_nif(String cin_nif) {
		this.cin_nif = cin_nif;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getDate_naissance() {
		return date_naissance;
	}
	public void setDate_naissance(String date_naissance) {
		this.date_naissance = date_naissance;
	}	
	
	
	

}
