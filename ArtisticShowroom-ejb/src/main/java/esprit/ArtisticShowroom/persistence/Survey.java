package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Survey
 *
 */
@Entity

public class Survey implements Serializable {

	
	private int id;
	private String name;
	private String note;
	private Exposure exposure;
	private List<QuestionSurvey> Questions;
	private static final long serialVersionUID = 1L;

	public Survey() {
		super();
	}   
	
	
	
	@OneToMany(mappedBy="survey",cascade=CascadeType.REMOVE)
	public List<QuestionSurvey> getQuestions() {
		return Questions;
	}

	public void setQuestions(List<QuestionSurvey> questions) {
		Questions = questions;
	}

	@OneToOne(mappedBy="survey",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	public Exposure getExposure() {
		return exposure;
	}



	public void setExposure(Exposure exposure) {
		this.exposure = exposure;
	}



	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return name;
	}



	public Survey(int id, String name, String note, Exposure exposure, List<QuestionSurvey> questions) {
		super();
		this.id = id;
		this.name = name;
		this.note = note;
		this.exposure = exposure;
		Questions = questions;
	}   

   
}
