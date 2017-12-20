package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetailsPk implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Date detailDate ;
	@Column(name = "fk_artwork")
	private int artworkId;
	@Column(name = "fk_space")
	private int spaceId;
	
	
	
	
	
	public Date getDetailDate() {
		return detailDate;
	}
	public void setDetailDate(Date detailDate) {
		this.detailDate = detailDate;
	}
	public int getArtworkId() {
		return artworkId;
	}
	public void setArtworkId(int artworkId) {
		this.artworkId = artworkId;
	}
	public int getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + artworkId;
		result = prime * result + ((detailDate == null) ? 0 : detailDate.hashCode());
		result = prime * result + spaceId;
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
		DetailsPk other = (DetailsPk) obj;
		if (artworkId != other.artworkId)
			return false;
		if (detailDate == null) {
			if (other.detailDate != null)
				return false;
		} else if (!detailDate.equals(other.detailDate))
			return false;
		if (spaceId != other.spaceId)
			return false;
		return true;
	}
	
	
	
	
	

}
