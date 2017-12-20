package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Metting implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	
	@EmbeddedId
	private MettingPk id;
	@ManyToOne
	@JoinColumn(name="fk_artist", insertable = false, updatable = false)
	private Artist artist;
	@ManyToOne
	@JoinColumn(name="fk_owner", insertable = false, updatable = false)
	private Owner owner ;
	
	
	
	
	public MettingPk getId() {
		return id;
	}
	public void setId(MettingPk id) {
		this.id = id;
	}
	public Artist getArtist() {
		return artist;
	}
	public void setArtist(Artist artist) {
		this.artist = artist;
	}
	public Owner getOwner() {
		return owner;
	}
	public void setOwner(Owner owner) {
		this.owner = owner;
	}
	

	
	
	
}
