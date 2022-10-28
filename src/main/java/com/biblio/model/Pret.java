package com.biblio.model;
import java.sql.Date;
public class Pret {
	
	private int id;
	private int id_livre;
	private int id_adherent;
	private Date date_pret;
	private Date date_retour;
	
	
	public Pret(int id, int id_livre, int id_adherent, Date date_pret, Date date_retour) {
		super();
		this.id = id;
		this.id_livre = id_livre;
		this.id_adherent = id_adherent;
		this.date_pret = date_pret;
		this.date_retour = date_retour;
	}
	
	public Pret(  int id_livre, int id_adherent, Date date_pret, Date date_retour) {
		super(); 
		this.id_livre = id_livre;
		this.id_adherent = id_adherent;
		this.date_pret = date_pret;
		this.date_retour = date_retour;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_livre() {
		return id_livre;
	}

	public void setId_livre(int id_livre) {
		this.id_livre = id_livre;
	}

	public int getId_adherent() {
		return id_adherent;
	}

	public void setId_adherent(int id_adherent) {
		this.id_adherent = id_adherent;
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
	
	
	
	

}
