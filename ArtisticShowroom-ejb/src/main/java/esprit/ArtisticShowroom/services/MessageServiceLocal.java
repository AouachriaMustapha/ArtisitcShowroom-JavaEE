package esprit.ArtisticShowroom.services;

import java.util.List;

import javax.ejb.Local;

import esprit.ArtisticShowroom.persistence.Message;



@Local
public interface MessageServiceLocal {
	public List<Message> getMessagesFromTo(int idSrc, int idDest);
	public List<Message> getMessagesFor(int idUser);
	public void sendMessage(int idSrc, int idDest, String text);
	public void deleteMessage(int id);
	public void deleteConversation(int id);
}
