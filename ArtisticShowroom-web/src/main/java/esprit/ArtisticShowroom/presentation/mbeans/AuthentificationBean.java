package esprit.ArtisticShowroom.presentation.mbeans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import esprit.ArtisticShowroom.persistence.Administrator;
import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Client;
import esprit.ArtisticShowroom.persistence.Owner;
import esprit.ArtisticShowroom.persistence.User;
import esprit.ArtisticShowroom.services.IUserservices;

@ManagedBean (name = "authBean")
@SessionScoped
public class AuthentificationBean {
	private User user;
	private boolean loggedIn = false;
	private String userType;
	private Artist artist ;
	 private Client client ;
	 private Owner Ownr ;
	 private String type;
	
	@EJB
	 private IUserservices userB;

	
	
	
	    private String nom;
	    private String pass;
	    private String desc;
	    private String login;
	    private String prenom;
	    private String mail;
	    private int phone;
	    private int age;
	    private String postalCode;
	    private String street;
	    private String city;
	    private int experience ;
	
	
	
	@PostConstruct
	public void init() {
		user = new User();
		artist = new Artist();
		Ownr =new Owner();
		client= new Client();
	}
	
	public String connect() {

		String navigateTo = "";

		user = userB.authentificate(user.getLogin(), user.getPassword());

		if (null == user) {
			loggedIn = false;
			user = new User();

			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "WRONG CREDENTIALS!",
					"LOGIN OR PASSWORD ARE NOT VALID!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			

		} else {
			loggedIn = true;

			HttpSession session = SessionBean.getSession();
			session.setAttribute("login", user);

			if (user instanceof Client && user.getConfirm()==1) {

				navigateTo = "/Template/index2?faces-redirect=true";
				userType = "client";

			} else if (user instanceof Artist && user.getConfirm()==1) {

				navigateTo = "/profiles/artistprofile?faces-redirect=true";
				userType = "artist";
			}
			else if (user instanceof Owner && user.getConfirm()==1) {

				navigateTo = "/profiles/profilowner?faces-redirect=true";
				userType = "owner";
			}
			else if (user instanceof Administrator && user.getConfirm()==1) {

				navigateTo = "/profiles/dashboard?faces-redirect=true";
				userType = "administrateur";
			}
		}
		return navigateTo;
	}
	
	public String logout() {
		loggedIn = false;
		//user = new User();
		HttpSession session = SessionBean.getSession();
		session.invalidate();
		return "/public/authentification?faces-redirect=true";
	}
	
	public String desactiverUser() {
		userB.suppUser(user.getId());
		return "/customer/authentification?faces-redirect=true";
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
	
	
	public Owner getOwnr() {
		return Ownr;
	}

	public void setOwnr(Owner ownr) {
		Ownr = ownr;
	}

	public String adduser()
	{ 
		String navigateTo = "";
		
		System.out.println(type);
		if (type.contentEquals("Artist"))
		
	{
		
			artist.setFirstName(nom);
			artist.setPassword(pass);
			artist.setLogin(login);
			artist.setAge(age);
			artist.setPhone(phone);
			artist.setDescription(desc);
			artist.setLastName(prenom);
			artist.setMail(mail);
			artist.setStreet(street);
			artist.setCity(city);
			artist.setExperience(experience);
			artist.setPostalCode(postalCode);
			artist.setConfirm(0);
			userB.addArtist(artist);
			navigateTo= "/public/validerartist?faces-redirect=true";
	}
	else if (type.contentEquals("Client")){
		 
	
		client.setFirstName(nom);
		client.setPassword(pass);
		client.setLogin(login);
		client.setAge(age);
		client.setPhone(phone);
		client.setLastName(prenom);
		client.setConfirm(1);
		client.setMail(mail);
		client.setStreet(street);
		client.setCity(city);
		client.setConfirm(1);
		client.setPostalCode(postalCode);
		
		userB.addClient(client);
		navigateTo= "/public/authentification?faces-redirect=true";
		
	} else if (type.contentEquals("Owner")){
		
		
		Ownr.setFirstName(nom);
		Ownr.setPassword(pass);
		Ownr.setLogin(login);
		Ownr.setAge(age);
		Ownr.setPhone(phone);
		Ownr.setLastName(prenom);
		Ownr.setMail(mail);
		Ownr.setStreet(street);
		Ownr.setCity(city);
		Ownr.setPostalCode(postalCode);
		Ownr.setConfirm(0);
		userB.addOwner(Ownr);
		
		navigateTo= "/public/validerinscri?faces-redirect=true";
	}
		
		return navigateTo;}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	} 
	

	
	
	


}
