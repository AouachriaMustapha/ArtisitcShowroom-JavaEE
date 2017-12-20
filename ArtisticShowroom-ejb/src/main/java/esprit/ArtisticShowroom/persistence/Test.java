package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Test
 *
 */
@Entity

public class Test implements Serializable {

	
	private int id;
	private String name;
	private String prenon;
	private static final long serialVersionUID = 1L;

	public Test() {
		super();
	}   
	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}   
	public String getPrenon() {
		return this.prenon;
	}

	public void setPrenon(String prenon) {
		this.prenon = prenon;
	}
   
}
