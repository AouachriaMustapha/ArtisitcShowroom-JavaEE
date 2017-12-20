package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import esprit.ArtisticShowroom.persistence.Artwork;
import esprit.ArtisticShowroom.persistence.Exposure;
import esprit.ArtisticShowroom.persistence.Space;
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.services.IExposureManagementLocal;

@ManagedBean
@ViewScoped
public class listExposure {
	


	private List<Exposure> filtredExposure;
	private List<Exposure> exposures;
	private List<Artwork> Artworks;
	private List<Space> Spaces;
	private List<Survey> Surveys;
	
	private Artwork artwork;
	private Space space;
	private Survey survey;
	private Exposure exposure;
	
	private String name;
	private String startDate;
	private String endDate;
	private String adress;
	private String note;
	
	private Boolean renderUpdateForm = false;

	@EJB
	IExposureManagementLocal exposureLocal;

	
	@PostConstruct
	public void init()
	{
		exposure = new Exposure();
		artwork = new Artwork();
		space = new Space();
		survey = new Survey();
		
		exposures = new ArrayList<>();
		Artworks = new ArrayList<>();
		Spaces = new ArrayList<>();
		Surveys = new ArrayList<>();
		
		
		exposures = exposureLocal.RecoverListExposures();
		Artworks = exposureLocal.ListArtworks();
		Spaces = exposureLocal.ListSpaces();
		Surveys = exposureLocal.ListSurveys();

		
		for (Exposure exposure : exposures)		
			{
				Artworks = exposure.getArtworks();
				Collections.sort(Artworks);
			}
	}
	
	
	public String updateExposure() {
		System.out.println(exposure.getId());
		exposureLocal.ModifyExposure(exposure);
		return "/ServiceExposure/ManageExposure?faces-redirect=true";
	}
	
	public String deleteExposure() {
		exposureLocal.DeleteExposure(exposure);
		return "/ServiceExposure/ListExposure?faces-redirect=true";
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

	public Artwork getArtwork() {
		return artwork;
	}

	public void setArtwork(Artwork artwork) {
		this.artwork = artwork;
	}

	public void getListExposure()
	{}


	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
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

	public List<Exposure> getExposures() {
		return exposures;
	}

	public void setExposures(List<Exposure> exposures) {
		this.exposures = exposures;
	}


	public List<Artwork> getArtworks() {
		return Artworks;
	}


	public void setArtworks(List<Artwork> artworks) {
		Artworks = artworks;
	}


	public List<Space> getSpaces() {
		return Spaces;
	}


	public void setSpaces(List<Space> spaces) {
		Spaces = spaces;
	}


	public List<Survey> getSurveys() {
		return Surveys;
	}


	public void setSurveys(List<Survey> surveys) {
		Surveys = surveys;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Exposure> getFiltredExposure() {
		return filtredExposure;
	}


	public void setFiltredExposure(List<Exposure> filtredExposure) {
		this.filtredExposure = filtredExposure;
	}
	
	

}
