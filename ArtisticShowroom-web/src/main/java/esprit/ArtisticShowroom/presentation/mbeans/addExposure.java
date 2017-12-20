package esprit.ArtisticShowroom.presentation.mbeans;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import esprit.ArtisticShowroom.persistence.Artwork;
import esprit.ArtisticShowroom.persistence.Exposure;
import esprit.ArtisticShowroom.persistence.Space;
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.services.IExposureManagementLocal;



@ManagedBean
public class addExposure {

	private Exposure exposure;
	private Survey survey;
	private Artwork artwork;
	private Space space;
	private List<Artwork> selectedArtworks;
	private List<Artwork> artworks;
	private List<Space> spaces;
	private List<Survey> surveys;
	private String name;
	private String startDate;
	private String endDate;
	

	
	@EJB
	IExposureManagementLocal exposureLocal;
	
    @ManagedProperty(value="#{artworkService}")
    private artworkService arts;
    
    @ManagedProperty(value="#{spaceService}")
    private spaceService sp;
    
    @ManagedProperty(value="#{surveyService}")
    private surveyService su;
    
	@PostConstruct
	public void init(){
		artwork = new Artwork();
		space = new Space();
		survey = new Survey();
		
		selectedArtworks = new ArrayList<>();
		artworks = new ArrayList<>();
		spaces = new ArrayList<>();
		surveys = new ArrayList<>();
		
		artworks =arts.getArtworks();
		spaces = sp.getSpaces();
		surveys = su.getSurveys();
		 
	}
	
	
	public String addExposurex() {

		
		exposure = new Exposure();
		exposure.setName(name);
		exposure.setStartDate(startDate);
		exposure.setEndDate(endDate);
		exposure.setArtworks(selectedArtworks);
		exposure.setSpace(space);
		exposure.setSurvey(survey);	
		exposureLocal.AddExposure(exposure);
		return "/ServiceExposure/ListExposure?faces-redirect=true";
	}



	public List<Artwork> getArtworks() {
		return artworks;
	}


	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
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



	public Survey getSurvey() {
		return survey;
	}



	public void setSurvey(Survey survey) {
		this.survey = survey;
	}



	public Exposure getExposure() {
		return exposure;
	}




	public void setExposure(Exposure exposure) {
		this.exposure = exposure;
	}




	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public List<Space> getSpaces() {
		return spaces;
	}


	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}


	public List<Survey> getSurveys() {
		return surveys;
	}


	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}


	public artworkService getArts() {
		return arts;
	}


	public void setArts(artworkService arts) {
		this.arts = arts;
	}


	public spaceService getSp() {
		return sp;
	}


	public void setSp(spaceService sp) {
		this.sp = sp;
	}


	public surveyService getSu() {
		return su;
	}


	public void setSu(surveyService su) {
		this.su = su;
	}


	public List<Artwork> getSelectedArtworks() {
		return selectedArtworks;
	}


	public void setSelectedArtworks(List<Artwork> selectedArtworks) {
		this.selectedArtworks = selectedArtworks;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


}
