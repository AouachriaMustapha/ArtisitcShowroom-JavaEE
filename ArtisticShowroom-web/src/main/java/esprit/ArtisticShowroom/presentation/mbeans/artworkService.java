package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import esprit.ArtisticShowroom.persistence.Artwork;
import esprit.ArtisticShowroom.services.IExposureManagementLocal;

@ManagedBean(name="artworkService", eager = true)
@ApplicationScoped
public class artworkService {
	
	private List<Artwork> artworks; 
	
	@EJB
	IExposureManagementLocal exposureLocal;
	
	@PostConstruct
	public void init(){
		
		artworks = new ArrayList<Artwork>();
		artworks = exposureLocal.ListArtworks();
		 
	}

	public List<Artwork> getArtworks() {
		return artworks;
	}

	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}
	

}
