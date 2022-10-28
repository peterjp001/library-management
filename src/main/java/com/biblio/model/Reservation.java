package com.biblio.model;

public class Reservation {
	
	private int id;
	private int idLivre;
	private int idAdherent;
	private boolean statut;
	
	
	public Reservation(  int idLivre, int idAdherent) {
		super(); 
		this.idLivre = idLivre;
		this.idAdherent = idAdherent; 
	}
	
	
	public Reservation(int id, int idLivre, int idAdherent, boolean statut) {
		super();
		this.id = id;
		this.idLivre = idLivre;
		this.idAdherent = idAdherent;
		this.statut = statut;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdLivre() {
		return idLivre;
	}


	public void setIdLivre(int idLivre) {
		this.idLivre = idLivre;
	}


	public int getIdAdherent() {
		return idAdherent;
	}


	public void setIdAdherent(int idAdherent) {
		this.idAdherent = idAdherent;
	}


	public boolean isStatut() {
		return statut;
	}


	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	
	
	
	
	

}
