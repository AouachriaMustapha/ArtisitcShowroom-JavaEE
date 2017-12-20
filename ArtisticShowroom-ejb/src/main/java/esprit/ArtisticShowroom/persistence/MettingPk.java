package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MettingPk implements Serializable{
	
	
	
	private String place;
	
	private Date mettingDate;
	
	@Column(name = "fk_artist")
	private int artistId;
	
	@Column(name = "fk_owner")
	private int ownerId;
	
	
	private static final long serialVersionUID = 1L;
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public Date getMettingDate() {
		return mettingDate;
	}
	public void setMettingDate(Date mettingDate) {
		this.mettingDate = mettingDate;
	}
	public int getArtistId() {
		return artistId;
	}
	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artistId;
		result = prime * result + ((mettingDate == null) ? 0 : mettingDate.hashCode());
		result = prime * result + ownerId;
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MettingPk other = (MettingPk) obj;
		if (artistId != other.artistId)
			return false;
		if (mettingDate == null) {
			if (other.mettingDate != null)
				return false;
		} else if (!mettingDate.equals(other.mettingDate))
			return false;
		if (ownerId != other.ownerId)
			return false;
		if (place == null) {
			if (other.place != null)
				return false;
		} else if (!place.equals(other.place))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	

}
