package esprit.ArtisticShowroom.presentation.mbeans;


import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import javax.faces.bean.ViewScoped;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

import org.primefaces.model.UploadedFile;

import esprit.ArtisticShowroom.persistence.*;
import esprit.ArtisticShowroom.services.IUserservices;

@ManagedBean
@ViewScoped
public class ArtistBean {

	@EJB
	private IUserservices gestionuser;
	
	@ManagedProperty("#{authBean}")
	private AuthentificationBean authBean;
	
	private UploadedFile uploadedFile;
	private Artist artist ;
	
	
	@PostConstruct
	public void init() {
		int a =authBean.getUser().getId() ;
		artist=gestionuser.FindArtistByid(a);
		
	}
	public void modifier(){
		gestionuser.uppArtist(artist);
		init();
			}
	public IUserservices getGestionuser() {
		return gestionuser;
	}
	public void setGestionuser(IUserservices gestionuser) {
		this.gestionuser = gestionuser;
	}
	
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public AuthentificationBean getAuthBean() {
		return authBean;
	}
	public void setAuthBean(AuthentificationBean authBean) {
		this.authBean = authBean;
	}

	
	
	
	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	
	public void updatephoto() throws IOException
	{ 
		
    String fileName = FilenameUtils.getName(uploadedFile.getFileName());
    String contentType = uploadedFile.getContentType();
    byte[] bytes = uploadedFile.getContents();
    
    SecureRandom random = new SecureRandom();
    String nomFich = new BigInteger(130, random).toString(32);
	
    String repertoir = "O:/JEE/workspace/ArtisticShowroom/ArtisticShowroom/ArtisticShowroom-web/src/main/webapp/resources/images/uploadfile/";
	
    File img = new File(repertoir+nomFich+".jpg");
    FileUtils.writeByteArrayToFile(img,bytes);
    String fileNameDB =nomFich+".jpg";
		
    artist.setPictureUrl(fileNameDB);
    
    gestionuser.uppArtist(artist);
     init();
		
		
	}
	
	
}
