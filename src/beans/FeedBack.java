package beans;

import java.io.Serializable;

public class FeedBack implements Serializable{
	private int note;
	private String comment;
	private Client client;//private int id_client;
	private Jeux jeu;//private int id_jeu;
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public Jeux getJeu() {
		return jeu;
	}
	public void setJeu(Jeux jeu) {
		this.jeu = jeu;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
}
