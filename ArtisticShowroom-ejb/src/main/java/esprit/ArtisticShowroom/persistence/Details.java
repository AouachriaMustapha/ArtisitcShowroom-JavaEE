package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Details implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private DetailsPk id;
	
	@ManyToOne
	@JoinColumn(name="fk_artwork", insertable = false, updatable = false)
	private Artwork artwork;
	
	
	@ManyToOne
	@JoinColumn(name="fk_space", insertable = false, updatable = false)
	private Space space;
	
	@ManyToOne
	private Exposure exposure;
	
	
	
	@ManyToOne
	public Exposure getExposure() {
		return exposure;
	}

	public void setExposure(Exposure exposure) {
		this.exposure = exposure;
	}

	public DetailsPk getId() {
		return id;
	}

	public void setId(DetailsPk id) {
		this.id = id;
	}

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public Space getSpace() {
		return space;
	}

	public void setSpace(Space space) {
		this.space = space;
	}
	
	
	

}
