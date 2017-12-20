package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Local;
import esprit.ArtisticShowroom.persistence.QuestionSurvey;
import esprit.ArtisticShowroom.persistence.Survey;

@Local
public interface IQuestionManagementLocal {
	
	void AddQuestion (QuestionSurvey question);
	void DeleteQuestion (QuestionSurvey question);
	void ModifyQuestion (QuestionSurvey question);
	QuestionSurvey FindQuestion(int id);
	List <Survey> ListSurvey();
	List <QuestionSurvey> ListQuestions();

}
