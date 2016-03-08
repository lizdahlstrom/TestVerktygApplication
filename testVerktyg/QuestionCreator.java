package testVerktyg;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class QuestionCreator {
	private Button btnTitle, btnSave, btnAddOption, btnSaveForm, btnFinish;
	private TextField txtQuestion, txtOption;
	private RadioButton radCorr;

	private ArrayList<TextField> ansField;
	private ArrayList<RadioButton> ansCorr;
	private VBox questionList;

	private ArrayList<String> options = new ArrayList<>();
	private Form question = new Form();

	private Scene scene;

	public QuestionCreator() {
		startQuestionCreator();
	}

	public void startQuestionCreator() {
		btnTitle = new Button("Title");
		btnSave = new Button("Save");
		btnFinish = new Button("Finish");
		btnSaveForm = new Button("Save Form");
		txtQuestion = new TextField();
		btnAddOption = new Button("+");
		questionList = new VBox();
		questionList.getChildren().addAll(btnTitle, btnSave, txtQuestion, btnAddOption, btnSaveForm, btnFinish);
		questionList.setPrefSize(400, 400);

		btnAddOption.setOnAction(event -> generateOptionField());
		btnSave.setOnAction(event -> saveQuestion());
		scene = new Scene(questionList, 400, 400);
	}



	public VBox getQuestionList() {
		return questionList;
	}

	public Scene getScene() {
		return scene;
	}

	private void generateOptionField() {
		txtOption = new TextField();
		radCorr = new RadioButton();
		ansField.add(txtOption);
		ansCorr.add(radCorr);
		questionList.getChildren().addAll(txtOption, radCorr);
	}

	public Form getForm() {
		return question;
	}

	private void saveQuestion() { // move to model ??
		getAnsField().forEach((item) -> options.add(item.getText()));
		question.setOptions(options);
		question.setQuery(txtQuestion.getText());

		getCorrAns().forEach((rb) -> {
			if (rb.isSelected()) {
				question.setCorrAns(getCorrAns().indexOf(rb));
			}
		});

	}

	public void resetField(){
		// Code should reset questionfield
	}

	// Getters and setters
	private ArrayList<TextField> getAnsField() {
		return ansField;
	}

	private ArrayList<RadioButton> getCorrAns() {
		return ansCorr;
	}

	public Button getBtnTitle() {
		return btnTitle;
	}

	public Button getBtnFinish() {
		return btnFinish;
	}

	public Button getBtnAddOption() {
		return btnAddOption;
	}

	public Button getBtnSaveForm() {
		return btnSaveForm;
	}

}
