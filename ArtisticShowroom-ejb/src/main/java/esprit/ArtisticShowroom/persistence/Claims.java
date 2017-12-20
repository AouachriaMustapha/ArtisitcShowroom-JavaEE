package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Claims
 *
 */
@Entity

public class Claims implements Serializable {

	
	private int id;
	private String subject;
	private List<Details> details;
	private static final long serialVersionUID = 1L;

	public Claims() {
		super();
	}   
	
	@OneToMany
	public List<Details> getDetails() {
		return details;
	}


	public void setDetails(List<Details> details) {
		this.details = details;
	}





	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getSubject() {
		return this.subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
   
}
