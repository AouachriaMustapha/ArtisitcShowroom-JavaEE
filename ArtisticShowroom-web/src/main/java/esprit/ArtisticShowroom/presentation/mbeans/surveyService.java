package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.services.IExposureManagementLocal;

@ManagedBean(name="surveyService", eager = true)
@ApplicationScoped
public class surveyService {
	
	private List<Survey> surveys;
	
	@EJB
	IExposureManagementLocal exposureLocal;
	
	@PostConstruct
	public void init(){
		
		surveys = new ArrayList<Survey>();
		surveys = exposureLocal.ListSurveys();
		 
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

}
