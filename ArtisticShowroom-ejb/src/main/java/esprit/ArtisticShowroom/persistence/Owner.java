package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

import esprit.ArtisticShowroom.persistence.User;

/**
 * Entity implementation class for Entity: Owner
 *
 */
@Entity
@DiscriminatorValue("owner")
public class Owner extends User implements Serializable {

	private List<Metting> mettings;
	private  List<Space> spaces;
	private static final long serialVersionUID = 1L;

	public Owner() {
		super();
	}

	@OneToMany
	@XmlTransient
	public List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		this.spaces = spaces;
	}
	@OneToMany(mappedBy="owner")
	@XmlTransient
	public List<Metting> getMettings() {
		return mettings;
	}

	public void setMettings(List<Metting> mettings) {
		this.mettings = mettings;
	}
   
	
	
	
}
