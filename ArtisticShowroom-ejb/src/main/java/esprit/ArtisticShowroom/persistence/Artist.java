package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import esprit.ArtisticShowroom.persistence.User;

/**
 * Entity implementation class for Entity: Artist
 *
 */
@Entity
@DiscriminatorValue("artist")
public class Artist extends User implements Serializable {

	
	private int experience;
	private String description;
	private List<Subscription> subscription;
	private List<Artwork> artworks;
	private List<Metting> mettings;
	
	private List<Specialty> specialtys;
	private static final long serialVersionUID = 1L;

	public Artist() {
		super();
	}   
	
	
	@OneToMany(mappedBy="artist")
	@XmlTransient
	public List<Metting> getMettings() {
		return mettings;
	}

	public void setMettings(List<Metting> mettings) {
		this.mettings = mettings;
	}

	
	@ManyToMany
	@XmlTransient
	public List<Specialty> getSpecialtys() {
		return specialtys;
	}

	public void setSpecialtys(List<Specialty> specialtys) {
		this.specialtys = specialtys;
	}


	@OneToMany
	@XmlTransient
	public List<Artwork> getArtworks() {
		return artworks;
	}



	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}



	
	

	@OneToMany(mappedBy = "artist")
	@XmlTransient
	public List<Subscription> getSubscription() {
		return subscription;
	}


	public void setSubscription(List<Subscription> subscription) {
		this.subscription = subscription;
	}


	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}   
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
   
}
