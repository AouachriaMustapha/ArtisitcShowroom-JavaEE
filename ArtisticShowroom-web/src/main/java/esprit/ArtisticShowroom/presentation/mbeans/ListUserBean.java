package esprit.ArtisticShowroom.presentation.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Client;
import esprit.ArtisticShowroom.persistence.Owner;
import esprit.ArtisticShowroom.persistence.User;
import esprit.ArtisticShowroom.services.IUserservices;
@ManagedBean (name="userbean")
@ViewScoped
public class ListUserBean implements Serializable {
	
	
	@EJB
	IUserservices userB;
	private List<User> users;
	private List<Owner> nusers;
	private List<Artist> ausers;
	private List<User> filtredusers;
	private List<Artist> artists;
	private List<Owner> owners;
	private List<Client> clients;
	private List<Artist> filtredartists;
	private List<Owner> filterdowners;
	private List<Client> filtredclients;
	private Artist artiste;
	private User user;
	private Owner o ;

	 
	@PostConstruct
	 public void init(){
		artiste = new Artist();
		user =new User();
		o = new Owner();
		users= new ArrayList<>();
		users=userB.recupereUser();
		owners= new ArrayList<>();
		owners=userB.recupererListOwners();
		clients= new ArrayList<>();
		clients=userB.recupererListClients();
	//	artists=new ArrayList<>();
		artists=userB.recupererListArtists();
		nusers=  new ArrayList<>();
		nusers=userB.newowner();
		ausers=userB.newartist();
		
	 }


	
	
	
	public List<Artist> getAusers() {
		return ausers;
	}





	public void setAusers(List<Artist> ausers) {
		this.ausers = ausers;
	}





	public List<Artist> getFiltredartists() {
		return filtredartists;
	}



	public void setFiltredartists(List<Artist> filtredartists) {
		this.filtredartists = filtredartists;
	}

	
	public List<User> getFiltredusers() {
		return filtredusers;
	}



	public void setFiltredusers(List<User> filtredusers) {
		this.filtredusers = filtredusers;
	}



	public List<Owner> getFilterdowners() {
		return filterdowners;
	}


	

	public List<Owner> getNusers() {
		return nusers;
	}



	public void setNusers(List<Owner> nusers) {
		this.nusers = nusers;
	}



	public void setFilterdowners(List<Owner> filterdowners) {
		this.filterdowners = filterdowners;
	}



	public List<Client> getFiltredclients() {
		return filtredclients;
	}



	public void setFiltredclients(List<Client> filtredclients) {
		this.filtredclients = filtredclients;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public void suppowner(Owner owner)
	{  
		userB.suppOwner(owner);
		
		init();
	}

	public void suppartist(Artist artist)
	{  
		userB.suppArtist(artist);
		
		init();
	}
	
	public void suppclient(Client client)
	{  
		userB.suppClient(client);
		
		init();
	}
	
	 public void modifUser()
	 {
		 userB.uppArtist(artiste);
		 
	 }
	 
	 public void confirmartis(Artist a)
	 { 
		a.setConfirm(1); 
	  userB.uppArtist(a);
	  
	  init();
	 }

	 public void confirmowner(Owner u)
	 { 
		u.setConfirm(1); 
	  userB.uppOwner(u);
	 
	  init();
	 }
	


	public List<Artist> getArtists() {
		return artists;
	}


	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}


	public List<Owner> getOwners() {
		return owners;
	}


	public void setOwners(List<Owner> owners) {
		this.owners = owners;
	}


	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}


	public List<User> getUsers() {
		return users;
	}


	public void setUsers(List<User> users) {
		this.users = users;
	}


	public Artist getArtiste() {
		return artiste;
	}


	public void setArtiste(Artist artiste) {
		this.artiste = artiste;
	}

 	
	
	
	
	
	
	

}
