package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity

public class Ratingartist implements Serializable {

	private static final long serialVersionUID = 1L;
	private RatingartistPK pk ;
	private Artist artist;
	private Client client;
	private double mark;
	private double result;

	
	@EmbeddedId
	public RatingartistPK getPk() {
		return pk;
	}

	public void setPk(RatingartistPK pk) {
		this.pk = pk;
	}
	@ManyToOne
	@JoinColumn(name="id_artist", insertable=false , updatable=false )
	public Artist getArtist() {
		return artist;
	}

	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	@ManyToOne
	@JoinColumn(name="id_client", insertable=false , updatable=false )
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public double getMark() {
		return mark;
	}

	public void setMark(double mark) {
		this.mark = mark;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

}