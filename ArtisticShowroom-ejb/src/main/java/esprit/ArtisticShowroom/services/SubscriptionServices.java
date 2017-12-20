package esprit.ArtisticShowroom.services;


import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Ratingartist;
import esprit.ArtisticShowroom.persistence.Subscription;
import esprit.ArtisticShowroom.persistence.User;
import tn.esprit.ArtisticShowroom.util.EmailSender;



@Stateless
public class SubscriptionServices implements IsubscriptionLocal, IsubscriptionRemote{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@EJB
	private IsubscriptionLocal subscriptionLocal;
	Artist artist;
	public SubscriptionServices() {
		
	}
	

	
	
	@Override
	public boolean ajouterSubscription(Subscription subscription) {
	
	
		try {
			entityManager.merge(subscription);
			return true;
		} catch (Exception e) {
		
		return false;}
	}
	
	
	@Override
	public boolean ajouterSubscription2(Subscription subscription) {
		
		try {
			entityManager.merge(subscription);
			return true;
		} catch (Exception e) {
		
		return false;}
	}
	
	
	
	

	@Override
	public void deleteSubscription(Subscription s) {
		String c  = s.getArtist().getMail();
		
		s = entityManager.find(Subscription.class, s.getId());
		entityManager.remove(entityManager.merge(s));
		EmailSender.SendEmail(c, "SHOWROOM Subscription Manager",
				"Your Subscription Has been Banished");
		
	}
	
	Calendar cal =Calendar.getInstance();
	Calendar cal1 =Calendar.getInstance();
	@Override
	public void ConfirmerSubscription(Subscription sub) {
		String c  = sub.getArtist().getMail();
		SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		cal1.add(Calendar.YEAR,+1 );
		sub.setDatedebut(dateOnly.format(cal.getTime()));
		
		
		sub.setDatefin(dateOnly.format(cal1.getTime()));
		entityManager.merge(sub);
		EmailSender.SendEmail(c, "SHOWROOM Subscription Manager",
				"Your Subscription has been confirmed");
		
	}
	Calendar cal2 =Calendar.getInstance();
	Calendar cal3 =Calendar.getInstance();
	@Override
	public void ConfirmerSubscription2(Subscription sub) {
		String c  = sub.getArtist().getMail();
		SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		cal3.add(Calendar.MONTH,3 );
		sub.setDatedebut(dateOnly.format(cal2.getTime()));
		
		sub.setDatefin(dateOnly.format(cal3.getTime()));
		entityManager.merge(sub);
		EmailSender.SendEmail(c, "SHOWROOM Subscription Manager",
				"Your Subscription has been confirmed");
	}

	@Override
	public Subscription FindById(int id) {
		return entityManager.find(Subscription.class, id);
	}

	@Override
	public void UpdateSubscription(Subscription s) {
		entityManager.merge(s);
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Subscription> GetAllSubscription() {
		String jpql = "SELECT s FROM Subscription s ORDER BY s.type";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
	
	
	
	
	Calendar cal4 =Calendar.getInstance();
	@SuppressWarnings("unchecked")
	@Override
	public List<Subscription> GetAllSubscriptionFin() {
		SimpleDateFormat dateOnly = new SimpleDateFormat("MM/dd/yyyy");
		String date = dateOnly.format(cal4.getTime());

		String jpql = "SELECT d FROM Subscription d where d.datefin=:date ORDER BY d.type";	
		Query query = entityManager.createQuery(jpql);
		query.setParameter("date",date);
		return query.getResultList();
	}

	@Override
	public Artist FindArtistById(int id) {
TypedQuery<Artist> query= entityManager.createQuery("select h from User h where h.Id=:id",Artist.class);
query.setParameter("id", id);
		return query.getSingleResult();
	}
	public void alertSubscription(Subscription s){
		String c  = s.getArtist().getMail();
		EmailSender.SendEmail(c, "SHOWROOM Subscription Manager",
				"Your Subscription Has been Ended ToDay !!!");
		
	}
	




	@Override
	public void Reduce(Subscription sub) {
		int a = sub.getArtist().getExperience();
		String c  = sub.getArtist().getMail();
		float y =sub.getPrice();
		if ( a>=3){
			int b =a*10;
			float r =y*b/100; 
			float w =y-r;
			sub.setPrice(w);
			entityManager.merge(sub);
			EmailSender.SendEmail(c, "SHOWROOM Subscription Manager",
					"You get a discount to your subscription price for  "+r);
			
		
	}	

}




	@Override
	public Ratingartist FindMarkById(int id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public int NbreTypeSubscriptionClassic() {
		
Query query = entityManager.createQuery("Select count(*) From Subscription s where s.type like 'Classic'");


		int count = Integer.parseInt(query.getSingleResult().toString());
		return count;
		
	}




	@Override
	public int NbreTypeSubscriptionGold() {
		
		Query query = entityManager.createQuery("Select count(*) From Subscription s where s.type like 'Gold'");
		

				int count = Integer.parseInt(query.getSingleResult().toString());
				return count;
	}
	
	
	
	




	
	
	}
	
	
