package beans;

import java.io.Serializable;
import java.util.Date;


public class Client implements Serializable, Comparable<Client>{
	private int id;
	private String nom;
    private String prenom;
    private String email;
    private String tel;
    private String username;
    private String pwd;
    private Date date_naissance;
    private String adresse;
    private String pays;
    private String ville;
    private String code_postal;

    
    public Client(){
    	
    }
    

    public Client(String nom, String prenom, String email,String tel,String username, String pwd, Date date_naissance, String adresse, String pays, String ville, String code_postal ){
    	//super();
    	this.nom = nom;
    	this.prenom = prenom;
    	this.email = email;
    	this.tel = tel;
    	this.username = username;
    	this.pwd = pwd;
    	this.date_naissance = date_naissance;
    	this.adresse = adresse;
    	this.pays = pays;
    	this.ville = ville;
    	this.code_postal = code_postal;
    }
    
	public Client( int id, String nom, String prenom, String email, String tel, String username, String pwd, Date date_naissance, String adresse, String pays, String ville, String code_postal) {
		//super();
    	this.id = id;
    	this.nom = nom;
    	this.prenom = prenom;
    	this.email = email;
    	this.tel = tel;
    	this.username = username;
    	this.pwd = pwd;
    	this.date_naissance = date_naissance;
    	this.adresse = adresse;
    	this.pays = pays;
    	this.ville = ville;
    	this.code_postal = code_postal;
	}


	@Override
	public int compareTo(Client o) {
		return 0;
	}
	
	@Override
	public String toString(){
		return nom + " " + prenom;
		
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public Date getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(Date date_naissance) {
		this.date_naissance = date_naissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}


}
