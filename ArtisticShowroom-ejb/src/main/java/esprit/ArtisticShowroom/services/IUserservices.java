package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;

import esprit.ArtisticShowroom.persistence.Administrator;
import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Client;
import esprit.ArtisticShowroom.persistence.Owner;
import esprit.ArtisticShowroom.persistence.User;





@Local
public interface IUserservices {
	
public Artist getArtistById(int id);
public int  nbrartistconfirm ();
public int  nbrartistnoconfirm ();
public int  nbrownerconfirm ();
public int  nbrownernoconfirm ();
public	boolean addUser(User user);
public	User authentificate(String login, String password);
public	void addArtist(Artist artist);
public	void addOwner(Owner owner);
public	void suppUser(int id);
public	void addClient(Client client);
public	void addAministrateur(Administrator admin);
public	void suppArtist(Artist a);
public	void suppOwner(Owner o);
public	void suppClient(Client c);	
public	void uppuser(User u);
public	void uppArtist(Artist artist);
public	void uppOwner(Owner owner);
public	void uppClient(Client client);
public	void uppAministrateur(Administrator admin);
public	User  FindUserByid(int id);
public Artist FindArtistByid (int id);
public Owner FindOwnerByid (int id);
public Client FindClientByid (int id);
public	List<Artist> recupererListArtists();
public	List<Owner> recupererListOwners();
public	List<Client> recupererListClients();
public	List<Artist> chercherArtistParNom(String nom);
public	List<User> chercherUserParNom(String nom);
public	List<Owner>  newowner();
public	List<Artist>  newartist();	
public	List<Artist> chercherArtistParNomEtExperiences(String nom, Integer e);
public	List<User> recupereUser();
	
    
}
