package esprit.ArtisticShowroom.persistence;

import java.io.File;
import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Artwork
 *
 */
@Entity

public class Artwork implements Serializable,Comparable<Artwork> {

	
	private int Id;
	private String name;
	private String description;
	private float price;
	private File photo;
	private Artist artist;
	private BookingPurchasing bookingPurchasing ;
	private Category category;
	private List<Details> details;
	private Exposure exposure;
	private static final long serialVersionUID = 1L;

	public Artwork() {
		super();
	} 
	
	@OneToMany(mappedBy="artwork")
	public List<Details> getDetails() {
		return details;
	}


	@OneToOne
	public BookingPurchasing getBookingPurchasing() {
		return bookingPurchasing;
	}

	public void setBookingPurchasing(BookingPurchasing bookingPurchasing) {
		this.bookingPurchasing = bookingPurchasing;
	}

	public void setDetails(List<Details> details) {
		this.details = details;
	}


	@ManyToOne
	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	@ManyToOne
	public Artist getArtist() {
		return artist;
	}



	public void setArtist(Artist artist) {
		this.artist = artist;
	}


	@ManyToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="fk_exposure")
	public Exposure getExposure() {
		return exposure;
	}

	public void setExposure(Exposure exposure) {
		this.exposure = exposure;
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}
	
	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}   
	public float getPrice() {
		return this.price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Artwork o) {
		float comparePrice = ((Artwork)o).getPrice();
		if (this.price - comparePrice > 0)
			return 1;
		else if(this.price - comparePrice < 0)
			return -1;
		else return 0;
		
		
	}

	@Override
	public String toString() {
		return name;
	}

	public Artwork(int id, String name, String description, float price, File photo, Artist artist,
			BookingPurchasing bookingPurchasing, Category category, List<Details> details, Exposure exposure) {
		super();
		Id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.photo = photo;
		this.artist = artist;
		this.bookingPurchasing = bookingPurchasing;
		this.category = category;
		this.details = details;
		this.exposure = exposure;
	}
	
	
   
}
