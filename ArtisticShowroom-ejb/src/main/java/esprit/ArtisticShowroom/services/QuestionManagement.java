package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import esprit.ArtisticShowroom.persistence.QuestionSurvey;
import esprit.ArtisticShowroom.persistence.Survey;

@Stateless
public class QuestionManagement implements IQuestionManagementLocal,IQuestionManagementRemote {

	@PersistenceContext
	EntityManager em;
	
	@Override
	public void AddQuestion(QuestionSurvey question) {
		em.persist(question);
	}

	@Override
	public void DeleteQuestion(QuestionSurvey question) {
		question = em.find(QuestionSurvey.class, question.getId());
		em.remove(question);
		
	}

	@Override
	public void ModifyQuestion(QuestionSurvey question) {
		em.merge(question);
		
	}

	@Override
	public QuestionSurvey FindQuestion(int id) {
		return em.find(QuestionSurvey.class, id);
	}

	@Override
	public List<Survey> ListSurvey() {
		TypedQuery<Survey> query = em.createQuery("select s from Survey s", Survey.class);
		return query.getResultList();
	}

	@Override
	public List<QuestionSurvey> ListQuestions() {
		TypedQuery<QuestionSurvey> query = em.createQuery("select q from QuestionSurvey q", QuestionSurvey.class);
		return query.getResultList();
	}

}
