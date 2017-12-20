package esprit.ArtisticShowroom.services;

import java.util.List;
import javax.ejb.Remote;

import esprit.ArtisticShowroom.persistence.Message;


@Remote
public interface MessageServiceRemote {
	public List<Message> getMessagesFromTo(int src, int dest);
	public List<Message> getMessagesFor(int idUser);
	public void sendMessage(int src, int dest, String text);
	public void deleteMessage(int id);
	public void removeMessage(Message m);
}
