package esprit.ArtisticShowroom.presentation.mbeans;


import java.util.ArrayList;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;



import esprit.ArtisticShowroom.persistence.Artist;
import esprit.ArtisticShowroom.persistence.Subscription;
import esprit.ArtisticShowroom.services.IUserservices;
//import esprit.ArtisticShowroom.persistence.User;
import esprit.ArtisticShowroom.services.IsubscriptionLocal;


@ManagedBean (name ="subscriptionBean")
@ViewScoped
public class SubscriptionBean {
	

	
	public SubscriptionBean() {
		
	}
	//private User user = new User();
	private Artist ar ;
	private List<Subscription> subscriptions = new ArrayList<>();
	private Subscription subscriptionadd = null;
	private List<Subscription> ssfin = new ArrayList<>();

	public List<Subscription> getSsfin() {
		return ssfin;
	}

	public void setSsfin(List<Subscription> ssfin) {
		this.ssfin = ssfin;
	}
	@ManagedProperty("#{authBean}")
	private AuthentificationBean authBean;
	@EJB
	private IsubscriptionLocal subscriptionLocal;
	@EJB
	private IUserservices Iuser;
	@EJB
	IUserservices userservice;
	
	@EJB
	IUserservices iuser;
	@PostConstruct
	public void init() {
	ar	= new Artist();
		subscriptionadd = new Subscription();
		subscriptions = subscriptionLocal.GetAllSubscription();
		
        ssfin= subscriptionLocal.GetAllSubscriptionFin();
	}

	public List<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(List<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	public Subscription getSubscriptionadd() {
		return subscriptionadd;
	}

	public void setSubscriptionadd(Subscription subscriptionadd) {
		this.subscriptionadd = subscriptionadd;
	}
	
	
	
	
	
	

	public AuthentificationBean getAuthBean() {
		return authBean;
	}

	public void setAuthBean(AuthentificationBean authBean) {
		this.authBean = authBean;
	}

	public Artist getAr() {
		return ar;
	}

	public void setAr(Artist ar) {
		this.ar = ar;
	}

	public String ListSpaces() {
		subscriptions = subscriptionLocal.GetAllSubscription();
		return "AllSubscriptions.xhtml";
	}
	
	public String doDeleteclient(Subscription s) {
		String navigateTo = null;
		//String varetat ;
		//varetat=s.getEtat()
		if ( s.getEtat().contentEquals("Waiting")) {
			subscriptionLocal.deleteSubscription(s);
		subscriptions = subscriptionLocal.GetAllSubscription();
		navigateTo = "AllSubscriptions.xhtml";
			
		}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You can not delete Your Subscription"));
			
		}
		
		return navigateTo;
	}
	  public String doConfirm(Subscription sub){
	
			String navigateTo = null;
			if ( sub.getType().contentEquals("Gold")) {
			sub.setEtat("Confirmed");
			subscriptionLocal.ConfirmerSubscription(sub);
			subscriptions = subscriptionLocal.GetAllSubscription();
			navigateTo = "AllSubscriptions.xhtml";}
			else {
				sub.setEtat("Confirmed");
				subscriptionLocal.ConfirmerSubscription2(sub);
				subscriptions = subscriptionLocal.GetAllSubscription();
				navigateTo = "AllSubscriptions.xhtml";
				
			}
			return navigateTo;
		  
	  }
	  
	  public String doUpdateclient(Subscription s){
			String navigateTo = null;
			if ( s.getEtat().contentEquals("Waiting")) {
			if ( s.getType().contentEquals("Gold")){
			s.setType("Classic");
			s.setPrice(250);
			subscriptionLocal.UpdateSubscription(s);
			subscriptions = subscriptionLocal.GetAllSubscription();
			navigateTo = "AllSubscriptions.xhtml";}
			else {
				s.setType("Gold");
				s.setPrice(500);
				subscriptionLocal.UpdateSubscription(s);
				subscriptions = subscriptionLocal.GetAllSubscription();
				navigateTo = "AllSubscriptions.xhtml";}
			}
			else {FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You can not update Your Subscription"));
			
				
			}
			
			return navigateTo;
		  
	  }
	
	public String doAdd() {

		String navaigateTo = "";
		int ar=authBean.getUser().getId();
		
		System.out.println(ar);
		subscriptionadd.setEtat("Waiting");
		subscriptionadd.setPrice(500);
		subscriptionadd.setType("Gold");
		subscriptionadd.setArtist(Iuser.getArtistById(ar));
		//subscriptionLocal.ajouterSubscription(subscriptionadd);
		subscriptions = subscriptionLocal.GetAllSubscription();
		//subscriptionadd = new Subscription();
		subscriptionLocal.ajouterSubscription(subscriptionadd);
		navaigateTo = "AllSubscriptions.xhtml";
		
		return navaigateTo;

	}
	
	
	public String doAdd2() {

		String navaigateTo = "";
		int ar=authBean.getUser().getId();
		System.out.println(ar);
		subscriptionadd.setEtat("Waiting");
		subscriptionadd.setPrice(225);
		subscriptionadd.setType("Classic");
		subscriptionadd.setArtist(Iuser.getArtistById(ar));
		subscriptionLocal.ajouterSubscription(subscriptionadd);
		subscriptions = subscriptionLocal.GetAllSubscription();
		//subscriptionadd = new Subscription();

		navaigateTo = "AllSubscriptions.xhtml";
		return navaigateTo;

	}
	
	
	public String doDelete(Subscription s) {
		String navigateTo = null;
		subscriptionLocal.deleteSubscription(s);
		subscriptions = subscriptionLocal.GetAllSubscription();
		navigateTo = "AllSubscriptions.xhtml";
		return navigateTo;
	}
	public String doDelete2(Subscription s) {
		String navigateTo = null;
		subscriptionLocal.deleteSubscription(s);
		ssfin = subscriptionLocal.GetAllSubscriptionFin();
		navigateTo = "AllSubscriptions.xhtml";
		return navigateTo;
	}

	
	public void liste2(){
		
	
	}
	public String doreduce(Subscription sub){
	
		String navigateTo = null;
	if(sub.getEtat().contentEquals("Waiting")&&sub.getPrice()==500||sub.getPrice()==225){
		subscriptionLocal.Reduce(sub);
		subscriptions = subscriptionLocal.GetAllSubscription();

        navigateTo = "AllSubscriptions.xhtml";
        return navigateTo;
			
	}return navigateTo;

	 
  }
	
	public String doAlert(Subscription s){
		
		String navigateTo = null;
		subscriptionLocal.alertSubscription(s);
		ssfin = subscriptionLocal.GetAllSubscriptionFin();
		navigateTo = "AllSubscriptions.xhtml";
		return navigateTo;
			
	

	 
  }
	

}
	
	
	
	

