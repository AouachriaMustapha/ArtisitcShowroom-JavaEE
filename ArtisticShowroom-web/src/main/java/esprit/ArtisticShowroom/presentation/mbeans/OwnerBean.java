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

import esprit.ArtisticShowroom.persistence.Owner;
import esprit.ArtisticShowroom.services.IUserservices;

@ManagedBean
@ViewScoped
public class OwnerBean {

	
	@EJB
	private IUserservices gestionuser;
	
	@ManagedProperty("#{authBean}")
	private AuthentificationBean authBean;
	
	private UploadedFile uploadedFile;
	
	private Owner o;
	
	@PostConstruct
	public void init() {
		int a =authBean.getUser().getId() ;
		o=gestionuser.FindOwnerByid(a);
		System.out.println(o.getFirstName());
		
		
	}
	
	
	
	public void modifier(){
		gestionuser.uppOwner(o);
		init();
	
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



	public Owner getO() {
		return o;
	}



	public void setO(Owner o) {
		this.o = o;
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
		
    o.setPictureUrl(fileNameDB);
    
    gestionuser.uppOwner(o);
     init();
	}
	
	
	
	
	
	
}
