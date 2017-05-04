package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Achat implements Serializable{
	private int id;
	private int id_client; // ou private Client client; 
	private Date date;
	private List<Jeux> jeux; // private List<id> jeux;
	
	public Achat() {
		this.jeux = new ArrayList<Jeux>();
	}
	
	public Achat( int id, int id_client, Date date) {
		//super();
    	this.id = id;
    	this.id_client = id_client;
    	this.date = date;
    	this.jeux = new ArrayList<Jeux>();
	}
	
	public Achat( int id_client, Date date, List<Jeux> jeux) {
		//super();
    	this.id_client = id_client;
    	this.date = date;
    	this.jeux = new ArrayList<Jeux>();
	}
	



	@Override
	public String toString(){
		return id + " " + id_client;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_client() {
		return id_client;
	}
	public void setId_client(int id_client) {
		this.id_client = id_client;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Jeux> getJeux() {
		return jeux;
	}
	public void setJeux(List<Jeux> jeux) {
		this.jeux = jeux;
	}
	
	

}
