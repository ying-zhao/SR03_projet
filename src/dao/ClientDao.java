package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import beans.Client;

public class ClientDao {
	
	public static int insert(Client c) {
		int res = 0;
				
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "insert into clients (nom, prenom, email, tel, username, pwd, date_naissance, adresse, pays, ville, code_postal) " +
					"VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getTel());
			ps.setString(5, c.getUsername());
			ps.setString(6, c.getPwd());
			ps.setDate(7, (Date) c.getDate_naissance());
			ps.setString(8, c.getAdresse());
			ps.setString(9, c.getPays());
			ps.setString(10, c.getVille());
			ps.setString(11, c.getCode_postal());
			
			
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int update(Client c) {
		int res = 0;
		
		Connection cnx=null;
		
		try {
			// chargement du driver
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Requete
			String sql = "UPDATE clients SET nom=?,prenom=?,email=?,tel=?,username=?,pwd=?,date_naissance=?,adresse=?,pays=?,ville=?,code_postal=? from clients WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getEmail());
			ps.setString(4, c.getTel());
			ps.setString(5, c.getUsername());
			ps.setString(6, c.getPwd());
			ps.setDate(7, (Date) c.getDate_naissance());
			ps.setString(8, c.getAdresse());
			ps.setString(9, c.getPays());
			ps.setString(10, c.getVille());
			ps.setString(11, c.getCode_postal());
			ps.setInt(12, c.getId());
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static int delete(int id) {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

				
			//Requete
			String sql = "DELETE FROM clients WHERE id=?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}
	
	public static List<Client> findAll() {
		List<Client> clients = new ArrayList<Client>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT id,nom, prenom, email, tel, username, pwd, date_naissance, adresse, pays, ville, code_postal FROM clients";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				clients.add(new Client
						(res.getInt("id"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("email"),
						res.getString("tel"),
						res.getString("username"),
						res.getString("pwd"),
						res.getDate("date_naissance"),
						res.getString("adresse"),
						res.getString("pays"),
						res.getString("ville"),
						res.getString("code_postal")
						));
			}
			
			res.close();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//

		return clients;
	}
	
	public static Client find(int id) {
		Client c = null;
		
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

		
			//Requete
			String sql = "SELECT id,nom,prenom,email,tel,username,pwd,date_naissance,adresse,pays,ville, code_postal FROM clients WHERE id=?";
			//en parler a la soutenance
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				c = new Client
						(res.getInt("id"),
						res.getString("nom"),
						res.getString("prenom"),
						res.getString("email"),
						res.getString("tel"),
						res.getString("username"),
						res.getString("pwd"),
						res.getDate("date_naissance"),
						res.getString("adresse"),
						res.getString("pays"),
						res.getString("ville"),
						res.getString("code_postal")
						);
				break;
			}
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return c;
	}
	
	
}
