package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Exposure
 *
 */
@Entity

public class Exposure implements Serializable {

	
	private int id;
	private String name;
	private String startDate;
	private String endDate;
	private Survey survey;
	private Space space;
	private List<Artwork> artworks;
	private static final long serialVersionUID = 1L;
	

	public Exposure() {
		super();
	}  
	
	
	@OneToMany(cascade={CascadeType.MERGE},fetch=FetchType.EAGER)
	public List<Artwork> getArtworks() {
		return artworks;
	}



	public void setArtworks(List<Artwork> artworks) {
		this.artworks = artworks;
	}



   @ManyToOne(cascade={CascadeType.MERGE})
   @JoinColumn(name="fk_space")
	public Space getSpace() {
		return space;
	}




	public void setSpace(Space space) {
		this.space = space;
	}




	@OneToOne(cascade={CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name="fk_survey")
	public Survey getSurvey() {
		return survey;
	}



	public void setSurvey(Survey survey) {
		this.survey = survey;
	}



	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
   
}
