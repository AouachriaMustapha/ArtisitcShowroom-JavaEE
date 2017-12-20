package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import esprit.ArtisticShowroom.persistence.QuestionSurvey;
import esprit.ArtisticShowroom.persistence.Survey;
import esprit.ArtisticShowroom.services.IQuestionManagementLocal;

@ManagedBean
@ViewScoped
public class listQuestion {
	
	private List<QuestionSurvey> filtredQuestion;
	private List<QuestionSurvey> questions;
	private List<Survey> Surveys;
	
	private Survey survey;
	private QuestionSurvey qs;
	
	private String question;
	private boolean answer;
	
	private Boolean renderUpdateForm = false;

	@EJB
	IQuestionManagementLocal questionLocal;

	
	@PostConstruct
	public void init()
	{
		qs = new QuestionSurvey();
		survey = new Survey();
		

		questions = new ArrayList<>();
		Surveys = new ArrayList<>();
		
		
		questions = questionLocal.ListQuestions();
		Surveys = questionLocal.ListSurvey();

		
//		for (Exposure exposure : exposures)		
//			{
//				Artworks = exposure.getArtworks();
//				Collections.sort(Artworks);
//			}
	}
	
	
	public String updateQuestion() {
		System.out.println(qs.getId());
		questionLocal.ModifyQuestion(qs);
		return "/ServiceExposure/ManageQuestion?faces-redirect=true";
	}
	
	public String deleteQuestion() {
		questionLocal.DeleteQuestion(qs);;
		return "/ServiceExposure/ManageQuestion?faces-redirect=true";
	}
	



	public void getListExposure()
	{}


	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}
	


	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}




	public List<Survey> getSurveys() {
		return Surveys;
	}


	public void setSurveys(List<Survey> surveys) {
		Surveys = surveys;
	}


	public List<QuestionSurvey> getFiltredQuestion() {
		return filtredQuestion;
	}


	public void setFiltredQuestion(List<QuestionSurvey> filtredQuestion) {
		this.filtredQuestion = filtredQuestion;
	}


	public List<QuestionSurvey> getQuestions() {
		return questions;
	}


	public void setQuestions(List<QuestionSurvey> questions) {
		this.questions = questions;
	}


	public QuestionSurvey getQs() {
		return qs;
	}


	public void setQs(QuestionSurvey qs) {
		this.qs = qs;
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

	public void addMessage(){
		
		String summary = answer ? "Checked" : "Unchecked";
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
		
	}

}
