package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Remote;

import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Ratingartist;
import esprit.ArtisticShowroom.persistence.Subscription;
import esprit.ArtisticShowroom.persistence.User;
@Remote
public interface IsubscriptionRemote {
	
	   boolean ajouterSubscription(Subscription subscription);
	   boolean ajouterSubscription2(Subscription subscription);
		void deleteSubscription(Subscription s);
		Subscription FindById(int id) ;
		void UpdateSubscription(Subscription s);
		public void ConfirmerSubscription(Subscription s);
		List<Subscription> GetAllSubscription();
	    User FindArtistById(int id);
		List<Subscription> GetAllSubscriptionFin();
		void alertSubscription(Subscription s);
		Ratingartist FindMarkById(int id);
		
		public int NbreTypeSubscriptionClassic() ;
		public int NbreTypeSubscriptionGold() ;
}
