package esprit.ArtisticShowroom.presentation.mbeans;


import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.services.ISurveyManagementLocal;

@ManagedBean
public class addSurvey {
	
	private Survey survey;
	private String name;
	private String note;
	


	@EJB
	ISurveyManagementLocal surveyLocal;
	
	public String addNewSurvey(){
		
		survey = new Survey();
		survey.setName(name);
		survey.setNote(note);
		surveyLocal.AddSurvey(survey);
		
		return "/ServiceExposure/ManageSurvey?faces-redirect=true";
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
