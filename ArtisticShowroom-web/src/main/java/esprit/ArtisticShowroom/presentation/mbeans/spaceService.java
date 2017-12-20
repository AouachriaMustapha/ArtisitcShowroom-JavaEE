package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import esprit.ArtisticShowroom.persistence.Space;
import esprit.ArtisticShowroom.services.IExposureManagementLocal;

@ManagedBean(name="spaceService", eager = true)
@ApplicationScoped
public class spaceService {
	
	private List<Space> spaces;
	
	@EJB
	IExposureManagementLocal exposureLocal;
	
	@PostConstruct
	public void init(){
		
		spaces = new ArrayList<Space>();
		spaces = exposureLocal.ListSpaces();
		 
	}

	public List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}

}
