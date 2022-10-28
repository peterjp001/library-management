package com.biblio.model;

public class Livre {
	
	private int id,nbrLivre,nbrLivrePreter;
	private String titre, auteur,date_parution,resume,categorie,quantite,etat;	
	

	public Livre() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public Livre(String auteur,int nbrLivre, int nbrLivrePreter ) {
		super();
		this.nbrLivre = nbrLivre;
		this.nbrLivrePreter = nbrLivrePreter;
		this.auteur = auteur;
	}
	
	public Livre(String categorie,int nbrLivre ) {
		super();
		this.nbrLivre = nbrLivre; 
		this.categorie = categorie;
	}




	public Livre(int id, String titre, String auteur, String date_parution, String resume, String categorie,
			String quantite, String etat) {
		super();
		this.id = id;
		this.titre = titre;
		this.auteur = auteur;
		this.date_parution = date_parution;
		this.resume = resume;
		this.categorie = categorie;
		this.quantite = quantite;
		this.etat = etat;
	}
	
	public Livre( String titre, String auteur, String date_parution, String resume, String categorie,
			String quantite, String etat) {
		super(); 
		this.titre = titre;
		this.auteur = auteur;
		this.date_parution = date_parution;
		this.resume = resume;
		this.categorie = categorie;
		this.quantite = quantite;
		this.etat = etat;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getDate_parution() {
		return date_parution;
	}

	public void setDate_parution(String date_parution) {
		this.date_parution = date_parution;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public String getQuantite() {
		return quantite;
	}

	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}



	public int getNbrLivre() {
		return nbrLivre;
	}



	public int getNbrLivrePreter() {
		return nbrLivrePreter;
	}



	public void setNbrLivrePreter(int nbrLivrePreter) {
		this.nbrLivrePreter = nbrLivrePreter;
	}



	public void setNbrLivre(int nbrLivre) {
		this.nbrLivre = nbrLivre;
	}
	
	

	
	

}
