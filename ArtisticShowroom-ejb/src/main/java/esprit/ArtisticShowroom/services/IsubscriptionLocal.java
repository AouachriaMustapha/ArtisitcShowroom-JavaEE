package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Local;

import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Ratingartist;
import esprit.ArtisticShowroom.persistence.Subscription;
import esprit.ArtisticShowroom.persistence.User;

@Local
public interface IsubscriptionLocal {
	
	   boolean ajouterSubscription(Subscription subscription);
	   boolean ajouterSubscription2(Subscription subscription);
		void deleteSubscription(Subscription s);
		Subscription FindById(int id) ;
		void UpdateSubscription(Subscription s);
		public void ConfirmerSubscription(Subscription s);
	  
		User FindArtistById(int id);
		List<Subscription> GetAllSubscription();
		void ConfirmerSubscription2(Subscription sub);
				List<Subscription> GetAllSubscriptionFin();
				void Reduce(Subscription sub);
				void alertSubscription(Subscription s);
			Ratingartist FindMarkById(int id);
			public int NbreTypeSubscriptionClassic() ;
			public int NbreTypeSubscriptionGold() ;
			
	
		

		
		

}
