package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;


import esprit.ArtisticShowroom.persistence.Artwork;
import esprit.ArtisticShowroom.persistence.Exposure;
import esprit.ArtisticShowroom.persistence.Space;
import esprit.ArtisticShowroom.persistence.Survey;

@Stateless
public class ExposureManagement implements IExposureManagementRemote, IExposureManagementLocal {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public void AddExposure(Exposure exposure) {
		em.persist(exposure);
		
	}

	@Override
	public void DeleteExposure(Exposure exposure) {
		exposure = em.find(Exposure.class, exposure.getId());
		em.remove(exposure);
		
		
	}

	@Override
	public void ModifyExposure(Exposure exposure) {
		
		em.merge(exposure);
		
	}


	@Override
	public Exposure FindExposure(int id) {
		
		return em.find(Exposure.class, id);
	}

	@Override
	public List<Exposure> RecoverListExposures() {
		
		TypedQuery<Exposure> query = em.createQuery("select e from Exposure e", Exposure.class);
		return query.getResultList();
	}

	@Override
	public List<Exposure> FindExposureByDate(String dateExp) {

	TypedQuery<Exposure> query = em.createQuery
			("select e from Exposure e where e.startDate=:dateExp or e.endDate=:dateExp", Exposure.class);
		query.setParameter("dateExp", dateExp);
		return query.getResultList();
	}

	@Override
	public List<Exposure> FindExposureByAdressSpace(String adressSpace) {

		TypedQuery<Exposure> query = em.createQuery
				("select e from Exposure e where e.space.adress=:adressSpace", Exposure.class);
			query.setParameter("adressSpace", adressSpace);
			return query.getResultList();
	}

	@Override
	public void AffectArtwork(Exposure exposure, Artwork artwork) {
		
		artwork = em.find(Artwork.class, artwork.getId());
		artwork.setExposure(exposure);
//		exposure.getArtworks().add(artwork);
		
	}

	@Override
	public void AffectSpace(Exposure exposure, Space space) {
		
		space = em.find(Space.class, space.getId());
		exposure.setSpace(space);
		
	}

	@Override
	public void AffectSurvey(Exposure exposure, Survey survey) {		
		
		survey = em.find(Survey.class, survey.getId());
		exposure.setSurvey(survey);
		
	}

	@Override
	public List<Artwork> ListArtworks() {
		TypedQuery<Artwork> query = em.createQuery("select a from Artwork a", Artwork.class);
		return query.getResultList();
	}

	@Override
	public List<Space> ListSpaces() {
		TypedQuery<Space> query = em.createQuery("select sp from Space sp", Space.class);
		return query.getResultList();
	}

	@Override
	public List<Survey> ListSurveys() {
		TypedQuery<Survey> query = em.createQuery("select su from Survey su", Survey.class);
		return query.getResultList();
	}

	@Override
	public List<Space> RentalSpace() {
		

		TypedQuery<Space> query = em.createQuery("Select s From Space s",Space.class);
		return query.getResultList();
		
		
	}

	@Override
	public int NbreDispoSpace() {
		
		Query query = em.createQuery("Select count(*) From Space s where s.disponibility = 1");
		
		int count = Integer.parseInt(query.getSingleResult().toString());
		return count;
	}

	@Override
	public int NbreNoDispoSpace() {
		Query query = em.createQuery("Select count(*) From Space s where s.disponibility = 0");
		
		int count = Integer.parseInt(query.getSingleResult().toString());
		return count;
	}



}
