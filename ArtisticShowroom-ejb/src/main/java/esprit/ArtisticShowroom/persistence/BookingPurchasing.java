package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: BookingPurchasing
 *
 */
@Entity

public class BookingPurchasing implements Serializable {

	
	private int id;
	private Date bookingDate;
	private Date purchasingDate;
	private float advencePayement;
	private Client client ;
	private Artwork artwork;
	private static final long serialVersionUID = 1L;

	public BookingPurchasing() {
		super();
	} 
	
	
	
	@OneToOne(mappedBy="bookingPurchasing")
	public Artwork getArtwork() {
		return artwork;
	}


	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}


	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	@ManyToOne
	@JoinColumn(name="fk_client")
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public float getAdvencePayement() {
		return this.advencePayement;
	}

	public void setAdvencePayement(float advencePayement) {
		this.advencePayement = advencePayement;
	}
	public Date getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
	public Date getPurchasingDate() {
		return purchasingDate;
	}
	public void setPurchasingDate(Date purchasingDate) {
		this.purchasingDate = purchasingDate;
	}
   
}
