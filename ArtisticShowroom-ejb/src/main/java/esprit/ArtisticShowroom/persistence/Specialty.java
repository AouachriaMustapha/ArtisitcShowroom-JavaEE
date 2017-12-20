package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Specialty
 *
 */
@Entity

public class Specialty implements Serializable {

	
	private int id;
	private String description;
	private List<Artist> artists;
	private static final long serialVersionUID = 1L;

	public Specialty() {
		super();
	}  
	
	
	
	
	@ManyToMany(mappedBy="specialtys")
	public List<Artist> getArtists() {
		return artists;
	}


	public void setArtists(List<Artist> artists) {
		this.artists = artists;
	}





	@Id    
	public int getId() {
		return this.id;
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
   
}
