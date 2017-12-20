package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.ArtisticShowroom.persistence.Exposure;
import esprit.ArtisticShowroom.persistence.QuestionSurvey;
import esprit.ArtisticShowroom.persistence.Survey;

@Stateless
public class SurveyManagement implements ISurveyManagementLocal, ISurveyManagementRemote {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void AddSurvey(Survey survey) {
		em.persist(survey);
	}

	@Override
	public void DeleteSurvey(Survey survey) {
		survey = em.find(Survey.class, survey.getId());
		em.remove(survey);
		
	}

	@Override
	public void ModifySurvey(Survey survey) {
		em.merge(survey);
		
	}

	@Override
	public void AffectQuestions(Survey survey, QuestionSurvey qs) {
		qs = em.find(QuestionSurvey.class, qs.getId());
		qs.setSurvey(survey);
		
	}

	@Override
	public Survey FindSurvey(int id) {
		
		return em.find(Survey.class, id);
	}

	@Override
	public List<Survey> ListSurvey() {
		TypedQuery<Survey> query = em.createQuery("select s from Survey s", Survey.class);
		return query.getResultList();
	}

	@Override
	public List<Survey> FindSurveyByNote(String note) {

		TypedQuery<Survey> query = em.createQuery
				("select s from Survey s where s.note=:note", Survey.class);
			query.setParameter("note", note);
			return query.getResultList();
	}

	@Override
	public List<Survey> FindSurveyByDateExposure(String dateExp) {

		TypedQuery<Survey> query = em.createQuery
		("select s from Survey s where s.exposure.startDate=:dateExp or s.exposure.endDate=:dateExp", Survey.class);
			query.setParameter("dateExp", dateExp);
			return query.getResultList();
	}

	@Override
	public List<QuestionSurvey> ListQuestions() {
		TypedQuery<QuestionSurvey> query = em.createQuery("select q from QuestionSurvey q", QuestionSurvey.class);
		return query.getResultList();
	}

	@Override
	public List<Exposure> ListExpousures() {
		TypedQuery<Exposure> query = em.createQuery("select e from Exposure e", Exposure.class);
		return query.getResultList();
	}

	@Override
	public List<Long> countValidQuestion() {
			Query query = em.createQuery("select distinct count (*) from QuestionSurvey q inner join q.survey s where q.survey.id = s.id and q.answer = 1 group by s.id");
			List<Long> lst = (List<Long>)query.getResultList();
			return lst;
	}

	@Override
	public List<Long> countNoValidQuestion() {
		Query query = em.createQuery("select distinct count (*) from QuestionSurvey q inner join q.survey s where q.survey.id = s.id and q.answer = 0 group by s.id");
		List<Long> lst = (List<Long>) query.getResultList();
		return lst;
	}

	@Override
	public List<Survey> distinctSurveyQuestions() {
		Query query = em.createQuery("select (q.survey) from QuestionSurvey q inner join q.survey s where q.survey.id = s.id group by s.id");
		List<Survey> lst = (List<Survey>)query.getResultList();
		return lst;
	}

}
