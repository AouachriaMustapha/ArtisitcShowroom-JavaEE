package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.ArtisticShowroom.persistence.QuestionSurvey;
import esprit.ArtisticShowroom.persistence.Survey;

@Remote
public interface IQuestionManagementRemote {
	
	void AddQuestion (QuestionSurvey question);
	void DeleteQuestion (QuestionSurvey question);
	void ModifyQuestion (QuestionSurvey question);
	QuestionSurvey FindQuestion(int id);
	List <Survey> ListSurvey();
	List <QuestionSurvey> ListQuestions();

}
