package beans;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class Jeux implements Serializable{
	private int id;
    private String console;
    private List<TypeDeJeux> typeJeux;
    private String titre;
    private String photo;
    private double prix;
    private Date sortie;
    private int Nombre; //il faut ajouter dans la BDD
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}

	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Date getSortie() {
		return sortie;
	}
	public void setSortie(Date sortie) {
		this.sortie = sortie;
	}
	public int getNombre() {
		return Nombre;
	}
	public void setNombre(int nombre) {
		Nombre = nombre;
	}
	public List<TypeDeJeux> getTypeJeux() {
		return typeJeux;
	}
	public void setTypeJeux(List<TypeDeJeux> typeJeux) {
		this.typeJeux = typeJeux;
	}
}
