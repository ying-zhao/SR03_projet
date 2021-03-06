package controllers;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import beans.Client;
import dao.ClientDao;

@Path("/users")
public class ClientController {
	//private ClientDao client;
	
	public ClientController(){
		//client = new ClientDao();
	}
	
	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listClients(){
		List<Client> listClients = ClientDao.findAll();
		return Response.ok(listClients).build();
	}
	
	@GET
	@Path("/{idClient}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findClient(@PathParam("idClient") String id){
		if(id == null)
			return Response.serverError().entity(id).build();
		try {
			Client c = ClientDao.find( Integer.valueOf(id));
			return Response.ok(c).build();
		}catch(RuntimeException e){
			return Response.status(Response.Status.NOT_FOUND).entity("User not found by ID: " + id).build();
		}
	}
	
	@DELETE
	@Path("/{idClient}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteClient(@PathParam("idClient") String id){
		if(id == null)
			return Response.serverError().entity(id).build();
		try {
			ClientDao.delete(Integer.valueOf(id));
			return Response.ok().build();
		}catch (RuntimeException e){
			return Response.status(Response.Status.NOT_FOUND).entity("User not found by ID: " + id).build();
		}
	}
	
	@POST
	@Path("/addUser")
	@Produces("text/plain")
	public Response addUser(@FormParam("nom") String nom,
			@FormParam("prenom") String prenom,
			@FormParam("email") String email,
			@FormParam("tel") String tel,
			@FormParam("username") String username,
			@FormParam("pwd") String pwd,
			@FormParam("date_nassance") Date date_naissance,
			@FormParam("adresse") String adresse,
			@FormParam("pays") String pays,
			@FormParam("code_postal") String code_postal,
			@FormParam("ville") String ville){
		
		
		System.out.println("-------------post-------");
		
		Client c = new Client( nom, prenom, email, tel, username, pwd, date_naissance, adresse, pays, ville, code_postal);
		
		ClientDao.insert(c);
		
		return Response
				   .status(200) //200 - ok , 201 -  created
				   .entity("a new client is added : nom: " + nom + ", prenom: " + prenom
					+ ", email:" + email + ", telephone:" + tel + ", username:" + username + ", password:" + pwd + ", date naissance:" + date_naissance + 
					", adresse:" + adresse + ", pays:" + pays + ", code postal:" + code_postal + ", ville:" + ville).build();
	}
}
