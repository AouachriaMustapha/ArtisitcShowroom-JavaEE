package esprit.ArtisticShowroom.persistence;

import java.io.File;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Space
 *
 */
@Entity

public class Space implements Serializable {

	
	private int id;
	private String name;
	private String description;
	private String adress;
	private boolean disponibility;
	private float rentalPrice;
	private File file; 
	private Owner owner ;
	private List<Exposure> exposure;
	private List<Details> details;
	private static final long serialVersionUID = 1L;

	public Space() {
		super();
	}
	
	@OneToMany(mappedBy="space")
	public List<Details> getDetails() {
		return details;
	}


	public void setDetails(List<Details> details) {
		this.details = details;
	}


	@OneToMany(mappedBy="space",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	public List<Exposure> getExposure() {
		return exposure;
	}

	public void setExposure(List<Exposure> exposure) {
		this.exposure = exposure;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	@ManyToOne
	public Owner getOwner() {
		return owner;
	}


	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public void setId(int id) {
		this.id = id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public String getAdress() {
		return this.adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}   
	public boolean getDisponibility() {
		return this.disponibility;
	}

	public void setDisponibility(boolean disponibility) {
		this.disponibility = disponibility;
	}   
	public float getRentalPrice() {
		return this.rentalPrice;
	}

	public void setRentalPrice(float rentalPrice) {
		this.rentalPrice = rentalPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

	public Space(int id, String name, String description, String adress, boolean disponibility, float rentalPrice,
			File file, Owner owner, List<Exposure> exposure, List<Details> details) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.adress = adress;
		this.disponibility = disponibility;
		this.rentalPrice = rentalPrice;
		this.file = file;
		this.owner = owner;
		this.exposure = exposure;
		this.details = details;
	}
	
	
   
}
