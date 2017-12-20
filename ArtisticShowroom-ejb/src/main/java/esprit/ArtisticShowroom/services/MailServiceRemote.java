package esprit.ArtisticShowroom.services;

import javax.ejb.Remote;

@Remote
public interface MailServiceRemote {
	void send(String addresses, String topic, String textMessage);
}
