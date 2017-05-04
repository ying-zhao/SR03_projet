package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import beans.Achat;
import beans.Jeux;

public class AchatDao {

	
	public static int insert(Achat c) {
		int res=0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//insert a command
			String sql = "insert into achats (client_id, date) " +
					"VALUES(?,?)";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, c.getId_client());
			ps.setDate(2, c.getDate());
			res = ps.executeUpdate();
			
			
			//know the id of this command
			String sql1 = "select id from achats where client_id = ? and date = ?";
			PreparedStatement ps1 = cnx.prepareStatement(sql1);
			ps1.setInt(1, c.getId_client());
			ps1.setDate(2, c.getDate());
			int id = 0;
			
			
			ResultSet res1 = ps1.executeQuery();
			while(res1.next()){
				id = res1.getInt("id");
			}
			res1.close();
			
			
			
			//insert les jeux correspondant dans le tableau Achat_jeux
			
			for (Jeux j : c.getJeux()) {
				String sql2 = "insert into Achat_jeux (achat, jeu) values(?,?)";
				PreparedStatement pst = cnx.prepareStatement(sql2);
                pst.setInt(1, id);
                pst.setInt(2, j.getId());
                pst.addBatch();
                res = pst.executeUpdate();
                }
			
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	public static List<Achat> findAll() {
		List<Achat> achats = new ArrayList<Achat>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT id,client_id, date FROM achats";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			while(res.next()){
				achats.add(new Achat
						(res.getInt("id"),
						res.getInt("client_id"),
						res.getDate("date")
						));
				
			}
			res.close();
			ps.close();
			
			
			//search jeux for every achat
			for (Achat a : achats) {
				String sql1 = "select jeu from achat_jeux where achat = ?";
				PreparedStatement pst = cnx.prepareStatement(sql1);
                pst.setInt(1, a.getId());
    			ResultSet res1 = pst.executeQuery();
    			while(res1.next()){
    				//Jeux jeu = JeuxDao.find(id); -------------- to do 
    				a.getJeux().add(new Jeux(
    						res1.getInt("jeu")));
    				}
    			 res1.close();
    			 pst.close();
    			}
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return achats;
	}
	
	public static Achat find(int id) {
		Achat achat = new Achat();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			
			//Request
			String sql = "SELECT id,client_id, date FROM achats where id =?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1, id);
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			while(res.next()){
				achat = new Achat
						(res.getInt("id"),
						res.getInt("client_id"),
						res.getDate("date")
						);
				
			}
			
			//search games for this command
			String sql1 = "select jeu from achat_jeux where achat = ?";
			PreparedStatement pst = cnx.prepareStatement(sql1);
            pst.setInt(1, id);
    		ResultSet res1 = pst.executeQuery();
    		while(res1.next()){
    			//Jeux.find(id); -------------- to do 
    			achat.getJeux().add(new Jeux(res1.getInt("jeu")));
    				}
    		res1.close();
    		res.close();
    		
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return achat;
	}
	
	public static int delete(int id) {
		int res = 0;
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());
			//Requete
			String sql = "DELETE FROM achat_jeux WHERE achat =?";
			PreparedStatement ps = cnx.prepareStatement(sql);
			ps.setInt(1,id);
			
			//Execution et traitement de la réponse
			res = ps.executeUpdate();
			
			String sql1 = "DELETE FROM achats WHERE id=?";
			PreparedStatement pst = cnx.prepareStatement(sql1);
			pst.setInt(1,id);
			
			//Execution et traitement de la réponse
			res = pst.executeUpdate();
			
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
}
