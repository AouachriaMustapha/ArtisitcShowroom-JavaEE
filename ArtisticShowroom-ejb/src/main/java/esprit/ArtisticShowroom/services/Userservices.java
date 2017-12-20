package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import esprit.ArtisticShowroom.persistence.Administrator;
import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Client;
import esprit.ArtisticShowroom.persistence.Owner;
import esprit.ArtisticShowroom.persistence.User;




@Stateless
public class Userservices implements IUserservices {
	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public boolean addUser(User user) {
		try {
			em.persist(user);
			return true;
		} catch (Exception e) {
			return false;
		}}
	

	@Override
	public User authentificate(String login, String password) {
		
		User User =null;
		Query query = em.createQuery("select a from User a where a.login=:l and a.password=:p");  
		query.setParameter("l", login).setParameter("p", password);
		try {
			User =(User) query.getSingleResult();
		} catch (Exception e) {
			User = null;
		}
		return User;}


	@Override
	public void addArtist(Artist artist) {
		em.persist(artist);
		
	}


	@Override
	public void addOwner(Owner owner) {
		em.persist(owner);

		
	}


	@Override
	public void addClient(Client client) {
		em.persist(client);

	}


	@Override
	public void addAministrateur(Administrator admin) {
		em.persist(admin);

	}


	@Override
	public List<User> recupereUser() {
		TypedQuery<User> query = em.createQuery("select h from User h", User.class);
		return query.getResultList();
	}


	@Override
	public void suppArtist(Artist a) {
		a=em.find(Artist.class,a.getId());
		em.remove(em.merge(a));
		
		
	}


	@Override
	public void suppOwner(Owner o) {
		 o =em.find(Owner.class,o.getId());
		em.remove(em.merge(o));
		
	}


	@Override
	public void suppClient(Client c) {
		c=em.find(Client.class, c.getId());
		em.remove(em.merge(c));
		
	}




	@Override
	public void uppArtist(Artist artist) {
		em.merge(artist);
		
		
	}


	@Override
	public void uppOwner(Owner owner) {
		em.merge(owner);
		// TODO Auto-generated method stub
		
	}


	@Override
	public void uppClient(Client client) {
		em.merge(client);
		
		
	}


	@Override
	public void uppAministrateur(Administrator admin) {
		
		em.merge(admin);
		
		
	}


	@Override
	public List<Artist> recupererListArtists() {
		String type="artist";
		TypedQuery<Artist> query = em.createQuery("select h from Artist h ", Artist.class);
		
		return query.getResultList();
	}


	@Override
	public List<Artist> chercherArtistParNom(String nom) {
		String type="artist";
		TypedQuery<Artist> query = em.createQuery("select h from User h where h.type=:type and firstname=:nom", Artist.class);
		query.setParameter("nom",nom );
		query.setParameter("type",type );
		return query.getResultList();
		
	}


	@Override
	public List<Artist> chercherArtistParNomEtExperiences(String nom, Integer exp) {
		String type="artist";
		TypedQuery<Artist> query = em.createQuery("select h from User h where h.type=:type and h.firstname=:nom and h.experience=:e ", Artist.class);
		query.setParameter("type",type );
		query.setParameter("nom",nom );
		query.setParameter("e",exp );
		return query.getResultList();
		
	}


	@Override
	public void suppUser(int id) {
     
		em.remove(em.find(User.class, id));
	}


	@Override
	public List<Owner> recupererListOwners() {
		TypedQuery<Owner> query = em.createQuery("select h from Owner h", Owner.class);
		return query.getResultList();
		
	}


	@Override
	public List<Client> recupererListClients() {
		TypedQuery<Client> query = em.createQuery("select h from Client h", Client.class);
		return query.getResultList();
	}


	@Override
	public List<Owner> newowner() {
		TypedQuery<Owner> query = em.createQuery("select h from Owner h where h.confirm=0", Owner.class);
		return query.getResultList();
	}

    
	

	@Override
	public User FindUserByid(int id) {
		// TODO Auto-generated method stub
		return em.find(User.class, id) ;
	}


	@Override
	public Artist FindArtistByid(int id) {
		return em.find(Artist.class, id);
	}


	@Override
	public Owner FindOwnerByid(int id) {
		// TODO Auto-generated method stub
		return em.find(Owner.class, id);
	}


	@Override
	public Client FindClientByid(int id) {
		// TODO Auto-generated method stub
		return em.find(Client.class, id);
	}


	@Override
	public List<Artist> newartist() {
		TypedQuery<Artist> query = em.createQuery("select h from Artist h where h.confirm=0", Artist.class);
		return query.getResultList();
	}


	@Override
	public void uppuser(User u) {
		em.merge(u);
		
	}


	@Override
	public int nbrartistconfirm() {
		// TODO Auto-generated method stub
		Query q=em.createQuery("select count(a) from Artist a where a.confirm=1  ");
		 int count= Integer.parseInt(q.getSingleResult().toString());
		 
		 return count ;		 
	}


	@Override
	public int nbrartistnoconfirm() {
		Query q=em.createQuery("select count(a) from Artist a where a.confirm = 0  ");
		 int count= Integer.parseInt(q.getSingleResult().toString());
	 
		 return count ;
	}


	@Override
	public int nbrownerconfirm() {
		Query q=em.createQuery("select count(a) from Owner a where a.confirm = 1  ");
		 int count= Integer.parseInt(q.getSingleResult().toString());
		 
		 return count ;		 
	}


	@Override
	public int nbrownernoconfirm() {
		Query q=em.createQuery("select count(a) from Owner a where a.confirm = 0  ");
		 int count= Integer.parseInt(q.getSingleResult().toString());		 
	 return count ;
	 
	}


	@Override
	public Artist getArtistById(int id) {
		TypedQuery<User> query = em.createQuery("select h from Artist h where h.id=:id", User.class);
		query.setParameter("id", id);
		return (Artist) query.getSingleResult();
	
	
	}
// public int  nbrartistconfirm ()
// {
//	 Query q=em.createQuery("select count(a) from artist a where a.confirm = 1  ");
//	 int count= Integer.parseInt(q.getSingleResult().toString());
//	 
//	 return count ;
//	 
// }
//	
// public int  nbrartistnoconfirm ()
// {
//	 Query q=em.createQuery("select count(a) from artist a where a.confirm = 0  ");
//	 int count= Integer.parseInt(q.getSingleResult().toString());
//	 
//	 return count ;
//	 
// }
// 
// public int  nbrownerconfirm ()
// {
//	 Query q=em.createQuery("select count(a) from owner a where a.confirm = 1  ");
//	 int count= Integer.parseInt(q.getSingleResult().toString());
//	 
//	 return count ;
//	 
// }
// public int  nbrownernoconfirm ()
// {
//	 Query q=em.createQuery("select count(a) from owner a where a.confirm = 0  ");
//	 int count= Integer.parseInt(q.getSingleResult().toString());
//	 
//	 return count ;
//	 
// }


	@Override
	public List<User> chercherUserParNom(String nom) {
		// TODO Auto-generated method stub
		TypedQuery<User> query = em.createQuery("select h from User h where h.firstName=:nom", User.class);
		query.setParameter("nom",nom );
		return query.getResultList();
	}
	
	}


