package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: QuestionSurvey
 *
 */
@Entity

public class QuestionSurvey implements Serializable {

	
	private int id;
	private String question;
	private boolean answer;
	private Survey survey;
	private static final long serialVersionUID = 1L;

	public QuestionSurvey() {
		super();
	} 
	
	
	
	@ManyToOne(fetch=FetchType.EAGER,cascade={CascadeType.MERGE})
	@JoinColumn(name="fk_survey")
	public Survey getSurvey() {
		return survey;
	}




	public void setSurvey(Survey survey) {
		this.survey = survey;
	}




	public boolean isAnswer() {
		return answer;
	}



	public void setAnswer(boolean answer) {
		this.answer = answer;
	}



	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return this.id;
	}


	public void setId(int id) {
		this.id = id;
	}   
	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}
   
}
