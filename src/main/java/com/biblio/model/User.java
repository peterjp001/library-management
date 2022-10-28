package com.biblio.model;

public class User {


	protected int id;
	protected int id_adherent;
	protected String username;
	protected String password;
	protected String niveau;
	


	
	public User() {
	}
	
	public User(int id, int id_adherent, String username,String niveau) {
		super();
		this.id = id; 
		this.username = username; 
		this.niveau = niveau;
	}
	

	public User(int id, String username, String password,String niveau) {
		super();
		this.id = id;
		this.username = username;
		this.password = password; 
		this.niveau = niveau;
	}
	public User(String username, String password,String niveau) {
		super(); 
		this.username = username;
		this.password = password; 
		this.niveau = niveau;
	}
	
	public User(int id, String username,String niveau) {
		super();
		this.id = id; 
		this.username = username; 
		this.niveau = niveau;
	}
	public User(int id, String password) {
		super();
		this.id = id; 
		this.password = password;  
	}
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getId_adherent() {
		return id_adherent;
	}


	public void setId_adherent(int id_adherent) {
		this.id_adherent = id_adherent;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

}
