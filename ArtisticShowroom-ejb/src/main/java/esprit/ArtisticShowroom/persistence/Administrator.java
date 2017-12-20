package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import esprit.ArtisticShowroom.persistence.User;

/**
 * Entity implementation class for Entity: Administrator
 *
 */
@Entity
@DiscriminatorValue("administrateur")
public class Administrator extends User implements Serializable {
      
	private static final long serialVersionUID = 1L;

	public Administrator() {
		super();
	}

	

	
}
