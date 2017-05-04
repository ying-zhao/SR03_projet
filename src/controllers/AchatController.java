package controllers;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Achat;
import beans.Jeux;
import dao.AchatDao;
import dao.ConnexionBDD;

@Path("/commands")
public class AchatController {
	
	public AchatController(){
		//achat = new AchatDao();
	}
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listAchats(){
		List<Achat> listAchats = AchatDao.findAll();
		return Response.ok(listAchats).build();
	}
	
	@GET
	@Path("/{idAchat}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findClient(@PathParam("idAchat") String id){
		if(id == null)
			return Response.serverError().entity(id).build();
		try {
			Achat c = AchatDao.find( Integer.valueOf(id));
			return Response.ok(c).build();
		}catch(RuntimeException e){
			return Response.status(Response.Status.NOT_FOUND).entity("User not found by ID: " + id).build();
		}
	}
	
	@DELETE
	@Path("/{idAchat}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClient(@PathParam("idAchat") String id){
		if(id == null)
			return Response.serverError().entity(id).build();
		try {
			AchatDao.delete(Integer.valueOf(id));
			return Response.ok().build();
		}catch (RuntimeException e){
			return Response.status(Response.Status.NOT_FOUND).entity("User not found by ID: " + id).build();
		}
	}
	
	@POST
	@Path("/addCommand")
	@Produces("text/plain")
	public Response addCommand(@FormParam("client_id") Integer client_id,
			@FormParam("jeux_id1") Integer jeux_id1,
			@FormParam("jeux_id2") Integer jeux_id2,
			@FormParam("jeux_id3") Integer jeux_id3)
			{

		Achat achat = new Achat();
		achat.setId_client(client_id);
		Date currentTime = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String dateString = formatter.format(currentTime);

	    SimpleDateFormat bartDateFormat =  new SimpleDateFormat("yyyy-MM-dd");  
	    String dateStringToParse = dateString;  
	    try {  
	    	java.util.Date date = bartDateFormat.parse(dateStringToParse);  
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
	        achat.setDate(sqlDate);
	    }  
	    catch (Exception ex) {  
	        System.out.println(ex.getMessage());  
	    }
	    if (jeux_id1 != null){
	    	achat.getJeux().add(new Jeux(jeux_id1));
	    }
	    if (jeux_id2 != null){
	    	achat.getJeux().add(new Jeux(jeux_id2));
	    }
	    if (jeux_id3 != null){
	    	achat.getJeux().add(new Jeux(jeux_id3));
	    }
	    
		
		System.out.println("------------------------------jeux id"+jeux_id1);

		
		AchatDao.insert(achat);
		
		return Response
				   .status(200) //200 - ok , 201 -  created
				   .entity("a new command is added ").build();
	}
	
}
