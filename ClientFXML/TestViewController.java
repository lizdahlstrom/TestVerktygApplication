package ClientFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import testVerktyg.Question;
import testVerktyg.Test;

public class TestViewController implements Initializable {
	// Instance variables
	@FXML private VBox view;
	@FXML private VBox centerVbox;
	@FXML private Label lblQuestion = new Label();
	@FXML private ToggleGroup tGroup = new ToggleGroup();
	private int questionCount = 0;
	private int questionNum;
	private int count;

	private ArrayList <RadioButton> btnList = new ArrayList<>();
	private Test test;

	//Constructor
	public TestViewController() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		tGroup.selectedToggleProperty().addListener((ChangeListener<Toggle>) (ov, toggle, new_toggle) -> {
			if (new_toggle == null)
				System.out.println("toggle null");
			else
				System.out.println("toggle something");
		});
	}

	private void showQuestion(Question question){
		System.out.println("Test test");
		lblQuestion.setText(question.getQuestion());
		System.out.println("Test test 2 ");
		question.getChoices().forEach((choice)-> {
			RadioButton rButton = new RadioButton(choice.getChoice());// sets label with radiobutton
			String choiceId = Integer.toString(choice.getChoiceId());
			rButton.setId(choiceId);
			rButton.setToggleGroup(tGroup);
			btnList.add(rButton);
			centerVbox.getChildren().add(rButton);
			System.out.println("Added Radiobutton");			
		});

		//		placeChoices();
	}

	private void placeChoices(){
		btnList.forEach((rBtn) -> {
			centerVbox.getChildren().add(rBtn);
		});
	}

	//	private Choice getChosenAnswer(){
	//	}

	public Test getTest(){
		return test;
	}

	public void setTest(Test test){
		this.test = test;
	}

	public void gotoNextQuestion(){
		Question question = test.getQuestions().get(count);
		count += 1; 
		showQuestion(question);
	}

	public void gotoPrevQuestion(){

	}

	public Question getCurrentQ(){
		return test.getQuestions().get(count);
	}

	public VBox getVbox(){
		return view;
	}
}