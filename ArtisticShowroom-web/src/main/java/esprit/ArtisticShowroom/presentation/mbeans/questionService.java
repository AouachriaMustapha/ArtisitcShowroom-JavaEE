package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import esprit.ArtisticShowroom.persistence.QuestionSurvey;
import esprit.ArtisticShowroom.services.ISurveyManagementLocal;

@ManagedBean(name="questionService", eager = true)
@ApplicationScoped
public class questionService {
	
	private List<QuestionSurvey> questions;

	@EJB
	ISurveyManagementLocal surveyLocal;
	
	@PostConstruct
	public void init(){
		
		questions = new ArrayList<QuestionSurvey>();
		questions = surveyLocal.ListQuestions();
		 
	}

	public List<QuestionSurvey> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionSurvey> questions) {
		this.questions = questions;
	}


	

}
