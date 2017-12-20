package esprit.ArtisticShowroom.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


import esprit.ArtisticShowroom.persistence.Message;
import esprit.ArtisticShowroom.persistence.User;
import esprit.ArtisticShowroom.services.IUserservices;
import esprit.ArtisticShowroom.services.MessageServiceLocal;


@ManagedBean(name = "MessageBean")
@SessionScoped
public class MessageBean {
	
	@ManagedProperty("#{authBean}")
    AuthentificationBean autht;
	
	private User user;
	private List<Message> inbox;
	
	private int otherUserId;
	
	private List<Message> conversation;
	private Message message;
	private String text;
	
	public List<Message> Inbox() {
	int a=autht.getUser().getId();
		return inbox = messageService.getMessagesFor(a);
	}
	
	@EJB
	MessageServiceLocal messageService;
	
	 @EJB
	IUserservices userB;
	
	
	@PostConstruct
	public void init() {
		user= new User();
	    message = new Message();
		
	}

	
	
	
	public String getText() {
		return text;
	}




	public void setText(String text) {
		this.text = text;
	}


	


	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public String Converstation(int idUser) {
		int a=autht.getUser().getId();
		String navigateTo = "/chat/conversation?faces-redirect=true";
		conversation = messageService.getMessagesFromTo( idUser,a);
		//otherUserId = idUser;
		return navigateTo;
	}

	public void SendMessage() {
		int a=autht.getUser().getId();
		
		messageService.sendMessage(otherUserId,a , message.getText());
		conversation = messageService.getMessagesFromTo(a, otherUserId);
		message = new Message();
		message.setReceiver(new User());
	}
	
	public void doSend(int idUser){
		  
		int a=autht.getUser().getId();
		messageService.sendMessage(idUser, a, message.getText());
		inbox = messageService.getMessagesFor(a);
		message = new Message();
		message.setReceiver(new User());
	}

	public void DeleteMessages() {
		int a=autht.getUser().getId();
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
			.getRequest();
	String txtAnotherProperty = request.getParameter("toDelete");
		if (txtAnotherProperty.length() > 0) {
			String[] array = txtAnotherProperty.split(";");
			for (String idMessage : array) {
				int id = Integer.parseInt(idMessage);
				messageService.deleteConversation(id);
			}
		}
		inbox = messageService.getMessagesFor(a);
	}
	
	

	public List<User> UsersList() {
		return userB.recupereUser();
	}
	

	
//	public String sendMessage() throws Exception {
//		Date actuelle = new Date();
	//	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	//	String act = dateFormat.format(actuelle);	
		//message.setSender(((User)SessionBean.getSession().getAttribute("login")));
	//	message.setDateSend(act);
		//message.setReciver(reciver);
		//iml.SendMessageByClient(message);		
		//return "/messages/listmessage?faces-redirect=true";
	//}
	


	

	public List<Message> getInbox() {
		return inbox;
	}



	public void setInbox(List<Message> inbox) {
		this.inbox = inbox;
	}


	public int getOtherUserId() {
		return otherUserId;
	}


	public void setOtherUserId(int otherUserId) {
		this.otherUserId = otherUserId;
	}


	public List<Message> getConversation() {
		return conversation;
	}


	public void setConversation(List<Message> conversation) {
		this.conversation = conversation;
	}


	public Message getMessage() {
		return message;
	}


	public void setMessage(Message message) {
		this.message = message;
	}




	public AuthentificationBean getAutht() {
		return autht;
	}

	public void setAutht(AuthentificationBean autht) {
		this.autht = autht;
	}
	
	
	
	
	
	
	
	
}
