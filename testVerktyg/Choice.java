package testVerktyg;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the choices database table.
 * 
 */
@Entity
@Table(name="choices")
@NamedQuery(name="Choice.findAll", query="SELECT c FROM Choice c")
public class Choice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int choiceId;

	private String choice;

	private byte isTrue;

	//bi-directional many-to-one association to Question
	@ManyToOne
	@JoinColumn(name="questionId")
	private Question question;

	public Choice() {
	}

	public int getChoiceId() {
		return this.choiceId;
	}

	public void setChoiceId(int choiceId) {
		this.choiceId = choiceId;
	}

	public String getChoice() {
		return this.choice;
	}

	public void setChoice(String choice) {
		this.choice = choice;
	}

	public byte getIsTrue() {
		return this.isTrue;
	}

	public void setIsTrue(byte isTrue) {
		this.isTrue = isTrue;
	}

	public Question getQuestion() {
		return this.question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

}