package esprit.ArtisticShowroom.persistence;

import java.io.File;
import java.io.Serializable;
import java.lang.String;
import java.sql.Blob;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
	    name="type"
	    
	)


public class User implements Serializable {

	
	private int Id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private int phone;
	private int age;
    private String street;
    private String city;
    private String postalCode;
    private String mail;
    private String pictureUrl;
    private String fileUrl;
    @Lob
	private byte[] photo;
	private int confirm;
	
	private static final long serialVersionUID = 1L;

	public User() {
		super();
	} 
	
	
	
	
	public String getPictureUrl() {
		return pictureUrl;
	}




	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}



	

	public String getFileUrl() {
		return fileUrl;
	}




	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}




	public int getConfirm() {
		return confirm;
	}




	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}





	public int getAge() {
		return age;
	}




	public void setAge(int age) {
		this.age = age;
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




	public String getPostalCode() {
		return postalCode;
	}




	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}






    
	




	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return this.Id;
	}

	
	




	public void setId(int Id) {
		this.Id = Id;
	} 
	
	@Lob
	public byte[] getPhoto() {
		return photo;
	}




	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}




	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}   
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public int getPhone() {
		return this.phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}   
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
   
}
