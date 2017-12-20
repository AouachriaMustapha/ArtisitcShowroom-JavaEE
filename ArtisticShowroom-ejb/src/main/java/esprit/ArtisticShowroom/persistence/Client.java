package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import esprit.ArtisticShowroom.persistence.User;

/**
 * Entity implementation class for Entity: Client
 *
 */
@Entity
@DiscriminatorValue("client")
public class Client extends User implements Serializable {

	private List<BookingPurchasing> bookingpurchasing;
	
	private static final long serialVersionUID = 1L;

	public Client() {
		super();
	}

	@OneToMany
	@XmlTransient
	public List<BookingPurchasing> getBookingpurchasing() {
		return bookingpurchasing;
	}

	public void setBookingpurchasing(List<BookingPurchasing> bookingpurchasing) {
		this.bookingpurchasing = bookingpurchasing;
	}
 
	
}
