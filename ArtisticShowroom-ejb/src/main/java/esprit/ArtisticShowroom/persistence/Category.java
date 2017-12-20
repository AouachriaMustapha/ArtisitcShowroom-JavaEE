package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Category
 *
 */
@Entity

public class Category implements Serializable {

	
	private int Id;
	private String description;
	private List<Artwork> artworks;
	private static final long serialVersionUID = 1L;

	public Category() {
		super();
	} 
	
	
	@OneToMany
	public List<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}


	@Id    
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
   
}
