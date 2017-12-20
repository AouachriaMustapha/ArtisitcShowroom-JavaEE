package esprit.ArtisticShowroom.presentation.mbeans;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.UploadedFile;

import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Client;
import esprit.ArtisticShowroom.persistence.User;
import esprit.ArtisticShowroom.persistence.Owner;
import esprit.ArtisticShowroom.services.IUserservices;



@ManagedBean(name="inscrib")
@ViewScoped
public class UserBean implements Serializable {
    @EJB
	IUserservices userB;
    
    @ManagedProperty("#{authBean}")
    AuthentificationBean autht;
    
    private UploadedFile uploadedFile;
    private UploadedFile uploadedFile1;
    
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
    private String type;
	

   
	 private User user = new User();
	 private Artist artist = new Artist();
	 private Client client = new Client();
	 private Owner Owner = new Owner();
	 
	 
	 
	 @PostConstruct
		public void init() {

		 user = new User();
		 artist = new Artist();
		 client = new Client();
		 Owner = new Owner();
		}
	 
	 
	 
	 





public String addartist() throws IOException{
	 String fileName1 = FilenameUtils.getName(uploadedFile.getFileName());
     String contentType1 = uploadedFile.getContentType();
     String fileName = FilenameUtils.getName(uploadedFile1.getFileName());
     String contentType = uploadedFile1.getContentType();
     byte[] bytes = uploadedFile.getContents();
     byte[] bytes1 = uploadedFile.getContents();
     
     SecureRandom random1 = new SecureRandom();
     String nomFich1 = new BigInteger(130, random1).toString(32);
    
     
     SecureRandom random = new SecureRandom();
     String nomFich = new BigInteger(130, random).toString(32);
	
     String repertoir = "C:/Users/mustapha-/workspace/ArtisticShowroom/ArtisticShowroom/ArtisticShowroom-web/src/main/webapp/resources/images/uploadfile/";
	
     File img = new File(repertoir+fileName);
     FileUtils.writeByteArrayToFile(img,bytes);
     String fileNameDB =fileName;
     
     File img1 = new File(repertoir+fileName1);
     FileUtils.writeByteArrayToFile(img1,bytes1);
     String fileNameDB1 =fileName1;
     
	     int a= autht.getArtist().getId();
	      artist=userB.FindArtistByid(a);
	        System.out.println(fileNameDB);
			System.out.println(artist.getId());
			System.out.println(artist.getLogin());
			//artist.setPhoto(bytes);
			artist.setPictureUrl(fileNameDB);
			artist.setFileUrl(fileNameDB1);
			artist.setDescription(desc);
			artist.setExperience(experience);
			userB.uppArtist(artist);
			
			return "/public/traitmentdedemande?faces-redirect=true";
		}

 
 public String addclient(){
	    Client a= new Client();
		a.setFirstName(nom);
		a.setPassword(pass);
		a.setLogin(login);
		a.setAge(age);
		a.setConfirm(1);
		a.setPhone(phone);
		a.setLastName(prenom);
		a.setMail(mail);
		a.setStreet(street);
		a.setCity(city);
		a.setPostalCode(postalCode);
		
		userB.addClient(a);
		
		return "/userManage/authentification?faces-redirect=true";
	}

 
 public String addowner() throws IOException{
	    int b = autht.getOwnr().getId();
	    Owner=userB.FindOwnerByid(b);
	    String fileName = FilenameUtils.getName(uploadedFile.getFileName());
	     String contentType = uploadedFile.getContentType();
	     byte[] bytes = uploadedFile.getContents();
	     
	     SecureRandom random = new SecureRandom();
	     String nomFich = new BigInteger(130, random).toString(32);
		
	     String repertoir = "C:/Users/mustapha-/workspace/ArtisticShowroom/ArtisticShowroom/ArtisticShowroom-web/src/main/webapp/resources/images/uploadfile/";
		
	     File img = new File(repertoir+fileName);
	     FileUtils.writeByteArrayToFile(img,bytes);
	     String fileNameDB =fileName;
         Owner.setPictureUrl(fileNameDB);
		
		userB.uppOwner(Owner);
		
		return "/public/traitmentdedemande?faces-redirect=true";
	}
 
 

 

public String modifuser()
{
	userB.uppuser(user);
	
	return "/profiles/dashboard?faces-redirect=true";
}






public String getType() {
	return type;
}


public AuthentificationBean getAutht() {
	return autht;
}





public void setAutht(AuthentificationBean autht) {
	this.autht = autht;
}






public UploadedFile getUploadedFile1() {
	return uploadedFile1;
}









public void setUploadedFile1(UploadedFile uploadedFile1) {
	this.uploadedFile1 = uploadedFile1;
}









public void setType(String type) {
	this.type = type;
}


public int getAge() {
	return age;
}


public void setAge(int age) {
	this.age = age;
}


public String getCity() {
	return city;
}


public void setCity(String city) {
	this.city = city;
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

public int getExperience() {
	return experience;
}

public void setExperience(int experience) {
	this.experience = experience;
}



public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
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

public Owner getOwner() {
	return Owner;
}

public void setOwner(Owner owner) {
	Owner = owner;
}





public UploadedFile getUploadedFile() {
	return uploadedFile;
}





public void setUploadedFile(UploadedFile uploadedFile) {
	this.uploadedFile = uploadedFile;
}
	 
	 
 
	


	 
	 
	 
	

}
