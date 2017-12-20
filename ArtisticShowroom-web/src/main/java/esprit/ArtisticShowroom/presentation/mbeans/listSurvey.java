package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import esprit.ArtisticShowroom.persistence.Exposure;
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.services.ISurveyManagementLocal;

@ManagedBean
@ViewScoped
public class listSurvey {
	
	private List<Survey> surveys;
	private List<Exposure> exposures;
	private List<Survey> filtredSurvey;
	
	private Survey survey;
	private Exposure exposure;
	
	private String name;
	private String note;
	
	private Boolean renderUpdateForm = false;
	
	@EJB
	ISurveyManagementLocal surveyLocal;
	
	@PostConstruct
	public void init()
	{
		
		
		survey = new Survey();
		exposure = new Exposure();
		
		
		surveys = new ArrayList<>();
		exposures = new ArrayList<>();
		
		
		surveys = surveyLocal.ListSurvey();
		exposures = surveyLocal.ListExpousures();

	}
	
	public String updateSurvey(){
		
		surveyLocal.ModifySurvey(survey);
		return "/ServiceExposure/ManageSurvey?faces-redirect=true";
		
	}
	
	public String deleteSurvey(){
		
		surveyLocal.DeleteSurvey(survey);
		return"/ServiceExposure/ManageSurvey?faces-redirect=true";
		
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}



	public List<Exposure> getExposures() {
		return exposures;
	}

	public void setExposures(List<Exposure> exposures) {
		this.exposures = exposures;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Survey> getFiltredSurvey() {
		return filtredSurvey;
	}

	public void setFiltredSurvey(List<Survey> filtredSurvey) {
		this.filtredSurvey = filtredSurvey;
	}
	
	

}
