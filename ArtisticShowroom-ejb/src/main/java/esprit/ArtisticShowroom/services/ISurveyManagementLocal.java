package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Local;

import esprit.ArtisticShowroom.persistence.Exposure;
import esprit.ArtisticShowroom.persistence.QuestionSurvey;
import esprit.ArtisticShowroom.persistence.Survey;

@Local
public interface ISurveyManagementLocal {
	
	void AddSurvey (Survey survey);
	void DeleteSurvey (Survey survey);
	void ModifySurvey (Survey survey);
	void AffectQuestions(Survey survey, QuestionSurvey qs);
	Survey FindSurvey(int id);
	List <Survey> ListSurvey();
	List <QuestionSurvey> ListQuestions();
	List <Exposure> ListExpousures();
	List <Survey> FindSurveyByNote(String note);
	List <Survey> FindSurveyByDateExposure(String dateExp);
	List<Long> countValidQuestion();
	List<Long> countNoValidQuestion();
	List <Survey> distinctSurveyQuestions();

}
