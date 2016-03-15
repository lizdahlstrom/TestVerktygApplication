package ClientFXML;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import testVerktyg.Test;

public class TestViewController implements Initializable {
	// Instance variables
	@FXML private VBox view;
	@FXML private VBox centerVbox;
	@FXML private Label lblQuestion;
	private ToggleGroup tGroup;
	private int questionCount;


	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	public void initTest(Test test){
		questionCount = test.getQuestions().size();
		tGroup = new ToggleGroup();

		test.getQuestions().forEach((question) -> {
			lblQuestion = new Label(question.getQuestion()); // gets string with question

			question.getChoices().forEach((choice)-> {
				RadioButton rButton = new RadioButton(choice.getChoice());// sets label with radiobutton
				rButton.setToggleGroup(tGroup);
			});

		});
	}

	public VBox getVbox(){
		return view;
	}
}
