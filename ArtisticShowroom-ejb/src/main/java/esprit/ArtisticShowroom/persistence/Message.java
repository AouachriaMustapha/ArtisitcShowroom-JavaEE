package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Message
 *
 */
@Entity
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private int idMessage;

	
	private Date date;

	private String text;

	
	private User sender;

	
	private User receiver;

	public Message() {
	}

	
	public Message(User src, User dest, String text) {
		this.sender = src;
		this.receiver = dest;
		this.text = text;
		this.date = new Date();
	}

	
	




	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getIdMessage() {
		return this.idMessage;
	}
	

	public void setIdMessage(int idMessage) {
		this.idMessage = idMessage;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return date;
	}



	public void setDate(Date date) {
		this.date = date;
	}


	@ManyToOne
	@JoinColumn(name = "idSender")
	public User getReceiver() {
		return this.receiver;
	}

	public void setReceiver(User reciver) {
		this.receiver = reciver;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@ManyToOne
	@JoinColumn(name = "idReceiver")
	public User getSender() {
		return this.sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	@Override
	public int hashCode() {
		return idMessage;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Message))
			return false;
		Message other = (Message) obj;
		if (idMessage != other.idMessage)
			return false;
		return true;
	}

}