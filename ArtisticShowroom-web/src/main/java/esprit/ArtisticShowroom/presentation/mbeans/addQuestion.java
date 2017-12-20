package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import esprit.ArtisticShowroom.persistence.QuestionSurvey;
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.services.IQuestionManagementLocal;

@ManagedBean
public class addQuestion {
	
	private QuestionSurvey qs;
	private Survey survey;
	private List<Survey> surveys;
	private String question;
	private boolean answer;
	
	@EJB
	IQuestionManagementLocal questionLocal;
	
    @ManagedProperty(value="#{surveyService}")
    private surveyService su;
    
	@PostConstruct
	public void init(){
		survey = new Survey();
		surveys = new ArrayList<>();
		surveys = su.getSurveys();
		 
	}
	
	public String addNewQuestion() {

		
		qs = new QuestionSurvey();
		qs.setQuestion(question);
		qs.setAnswer(answer);
		qs.setSurvey(survey);
		questionLocal.AddQuestion(qs);
		return "/ServiceExposure/ManageQuestion?faces-redirect=true";
	}


	public QuestionSurvey getQs() {
		return qs;
	}

	public void setQs(QuestionSurvey qs) {
		this.qs = qs;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public List<Survey> getSurveys() {
		return surveys;
	}

	public void setSurveys(List<Survey> surveys) {
		this.surveys = surveys;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}
	

	
	public surveyService getSu() {
		return su;
	}

	public void setSu(surveyService su) {
		this.su = su;
	}

	public void addMessage(){
		
		String summary = answer ? "Checked" : "Unchecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
		
	}

}
