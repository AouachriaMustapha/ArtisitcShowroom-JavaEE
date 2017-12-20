package esprit.ArtisticShowroom.webservices;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Client;
import esprit.ArtisticShowroom.persistence.Owner;
import esprit.ArtisticShowroom.persistence.User;
import esprit.ArtisticShowroom.services.IUserservices;

@Path("/users")
@RequestScoped
public class UserResources {
	
	@EJB
	IUserservices userB;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  Response getuser(){
		return Response.ok(userB.recupereUser()).build();
	}

	
	@GET
	@Path("newartists")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response getNArtist(){
		return Response.ok(userB.newartist()).build();
	}
	
	@GET
	@Path("newowners")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response getNOwners(){
		return Response.ok(userB.newowner()).build();
	}
	
	
	
	@GET
	@Path("artists")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response getArtist(){
		return Response.ok(userB.recupererListArtists()).build();
	}
	
	@POST
	@Path("/adduser")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response adduser(User u)
	{
		userB.addUser(u);
		return Response.ok().build();
	}
	
	@POST
	@Path("/artist")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addartist(Artist a)
	{
		userB.addArtist(a);
		return Response.ok().build();
	}
	
	@POST
	@Path("/client")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addclient(Client u)
	{
		userB.addClient(u);
		return Response.ok().build();
	}
	
	@POST
	@Path("/owner")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addowner(Owner o)
	{
		userB.addOwner(o);
		return Response.ok().build();
	}
	
	
	@GET
	@Path("clients")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response getClient(){
		return Response.ok(userB.recupererListClients()).build();
	}
	
	@GET
	@Path("owners")
	@Produces(MediaType.APPLICATION_JSON)
	public  Response getOwners(){
		return Response.ok(userB.recupererListOwners()).build();
	}
	
	

	
	@GET
	@Path("getuser/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByName(@PathParam("n") String name) {
		List<User> u = userB.chercherUserParNom(name);
		if (u != null)

			return Response.status(Status.OK).entity(u).build();

		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Path("get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserById(@PathParam("id") int id) {
		User u = userB.FindUserByid(id);
		if (u != null)

			return Response.status(Status.OK).entity(u).build();

		return Response.status(Status.NOT_FOUND).build();
	}

	@GET
	@Path("auth/{login}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public JsonObject doAuthenticate(@PathParam("login")String login,@PathParam("password")String password) {
		User u = userB.authentificate(login, password);

	return Json.createObjectBuilder()
			.add("login", u.getLogin())
			.add("password", u.getPassword())
			.add("firstName",u.getFirstName())
			.add("lastName",u.getLastName())
			.build();

	}
	
	@PUT
	@Path("uppartist/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateArtist(@PathParam("id") int id, Artist updateduser) {
	Artist a = new Artist();
	a=userB.FindArtistByid(id);
	updateduser=a;
     userB.uppArtist(updateduser);
     }
	
	@PUT
	@Path("uppuser/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateuser(@PathParam("id") int id, User updateduser) {
	User a = new User();
	a=userB.FindUserByid(id);
	a.setFirstName(updateduser.getFirstName());
	a.setLastName(updateduser.getLastName());
	a.setLogin(updateduser.getLogin());
	a.setPassword(updateduser.getPassword());
     userB.uppuser(a);
     }
	
	@PUT
	@Path("uppclient/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateClient(@PathParam("id") int id, Client updateduser) {
	Client c = new Client();
	c=userB.FindClientByid(id);
	c.setLogin(updateduser.getLogin());
	c.setPassword(updateduser.getPassword());
	c.setFirstName(updateduser.getFirstName());
	c.setLastName(updateduser.getLastName());
	c.setAge(updateduser.getAge());
	c.setMail(updateduser.getMail());
     userB.uppClient(c);
     }
	
	
	@PUT
	@Path("uppowner/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateOwner(@PathParam("id") int id, Owner updateduser) {
	Owner o = new Owner();
	o=userB.FindOwnerByid(id);
	o.setLogin(updateduser.getLogin());
	o.setPassword(updateduser.getPassword());
	o.setFirstName(updateduser.getFirstName());
	o.setLastName(updateduser.getLastName());
	o.setAge(updateduser.getAge());
	o.setMail(updateduser.getMail());
	
     userB.uppOwner(o);
     }
	
	
	
	@DELETE
	@Path("delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteUser(@PathParam("id") int id) {
		User u = userB.FindUserByid(id);
		if (u != null) {
			userB.suppUser(id);
			return Response.status(Status.OK).build();
		}

		return Response.status(Status.NOT_FOUND).build();
	}
	
}
