package testVerktyg;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the questions database table.
 *
 */
@Entity
@Table(name = "questions")
@NamedQueries({ @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
		@NamedQuery(name = "Question.findByTestId", query = "SELECT q FROM Question q WHERE q.test.testId =:testId") })
public class Question implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questId;

	private String question;

	// private String questions;

	// bi-directional many-to-one association to Choice
	// @OneToMany(mappedBy = "question")
	// private List<Choice> choices;

	// bi-directional many-to-one association to Test
	@ManyToOne
	@JoinColumn(name = "testId")
	private Test test;

	public Question() {
	}

	public int getQuestId() {
		return this.questId;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	/*
	 * public String getQuestions() { return this.questions; }
	 *
	 * public void setQuestions(String questions) { this.questions = questions;
	 * }
	 *//*
		 * public List<Choice> getChoices() { return this.choices; }
		 *
		 * public void setChoices(List<Choice> choices) { this.choices =
		 * choices; }
		 */
	/*
	 * public Choice addChoice(Choice choice) { getChoices().add(choice);
	 * choice.setQuestion(this);
	 *
	 * return choice; }
	 *
	 * public Choice removeChoice(Choice choice) { getChoices().remove(choice);
	 * choice.setQuestion(null);
	 *
	 * return choice; }
	 */

	public Test getTest() {
		return this.test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

}