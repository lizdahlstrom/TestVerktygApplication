package testVerktyg;

public class Questions {

	private int questId;
	private String question;

	public Questions(int questId, String question) {
		super();
		this.questId = questId;
		this.question = question;
	}

	public int getQuestId() {
		return questId;
	}

	public void setQuestId(int questId) {
		this.questId = questId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

}
