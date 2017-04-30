package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Jeux;

public class JeuxDao {
	public static List<Jeux> findAll() {
		

		List<Jeux> listJeux = new ArrayList<Jeux>();
		Connection cnx=null;
		try {
			cnx = ConnexionBDD.getInstance().getCnx();
			// ou Class.forName(com.mysql.jdbc.Driver.class.getName());

			
			//Requete
			String sql = "SELECT id,description,prix FROM jeux";
			PreparedStatement ps = cnx.prepareStatement(sql);
			
			//Execution et traitement de la réponse
			ResultSet res = ps.executeQuery();
			
			/*while(res.next()){
				listJeux.add(new Jeux(res.getInt("id"),
						res.getString("description"),
						res.getDouble("prix")));
			}*/
			
			res.close();
			ConnexionBDD.getInstance().closeCnx();			
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return listJeux;
	}
}
