package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Achat implements Serializable{
	private int id;
	private int id_client; // ou private Client client; 
	private Date date;
	private List<Jeux> jeux; // private List<id> jeux;
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
