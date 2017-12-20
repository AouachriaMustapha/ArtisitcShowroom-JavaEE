package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class RatingartistPK implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id_client;
	private int id_artist;
	
	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_artist() {
		return id_artist;
	}

	public void setId_artist(int id_artist) {
		this.id_artist = id_artist;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_artist;
		result = prime * result + id_client;
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
		RatingartistPK other = (RatingartistPK) obj;
		if (id_artist != other.id_artist)
			return false;
		if (id_client != other.id_client)
			return false;
		return true;
	}

	

}
