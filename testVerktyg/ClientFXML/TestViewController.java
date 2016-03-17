package testVerktyg.clientFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import testVerktyg.Choice;
import testVerktyg.Test;

public class TestViewController implements Initializable {
	// Instance variables
	@FXML
	private VBox view;
	@FXML
	private VBox centerVbox;
	@FXML
	private Label lblQuestion;
	@FXML
	private ToggleGroup tGroup = new ToggleGroup();

	private ArrayList<RadioButton> btnList = new ArrayList<>();
	private Test test;

	// Constructor
	public TestViewController() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		centerVbox = new VBox();
	}

	public void generateView(List<Choice> options) {
		for (Choice option : options) {
			RadioButton rButton = new RadioButton(option.getChoice());
			btnList.add(rButton);
			rButton.setToggleGroup(tGroup);
			rButton.setUserData(option.getChoiceId()); // saving choiceId
			System.out.println("Adding option button...");
		}
		btnList.forEach(btn -> {
			centerVbox.getChildren().add(btn); // adds btns to vbox
		});
	}

	public void cleanQuestionView(){

		centerVbox.getChildren().clear();
		btnList.clear();
	}

	public void getSelectedItem() {
		// Code for getting selectedItem from togglegroup nere
	}

	public ToggleGroup getTGroup() {
		return tGroup;
	}

	public void setlblQuestion(String strQuestion) {
		lblQuestion = new Label();
		System.out.println("Set testlabel.");
		lblQuestion.setText("Question: "  + strQuestion);

	}

	public void testsysout(){
		System.out.println("Test view controller calls");
	}
}