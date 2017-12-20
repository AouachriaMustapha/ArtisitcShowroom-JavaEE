package esprit.ArtisticShowroom.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: AnswerSurvey
 *
 */
@Entity

public class AnswerSurvey implements Serializable {

	
	private int id;
	private String answer;
	private QuestionSurvey questionSurvey;
	private static final long serialVersionUID = 1L;

	public AnswerSurvey() {
		super();
	}
	
	@OneToOne
	@JoinColumn(name="fk_questionsuervey")
	public QuestionSurvey getQuestionSurvey() {
		return questionSurvey;
	}


	public void setQuestionSurvey(QuestionSurvey questionSurvey) {
		this.questionSurvey = questionSurvey;
	}




	@Id    
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
   
}
