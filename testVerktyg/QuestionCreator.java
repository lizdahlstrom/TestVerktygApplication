package testVerktyg;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class QuestionCreator {
	private Button title, save, addOption;
	private TextField txtQuestion, txtOption;
	private RadioButton radCorr;
	private ArrayList<TextField> ansField;
	private ArrayList<RadioButton> ansCorr;
	private VBox questionList;

	private ArrayList<String> options = new ArrayList<>();
	private Form question = new Form();;

	private Scene scene;

	public QuestionCreator() {
		startQuestionCreator();
	}

	public void startQuestionCreator() {
		title = new Button("Title");
		save = new Button("Save");
		txtQuestion = new TextField();
		addOption = new Button("+");
		questionList = new VBox();
		questionList.getChildren().addAll(title, save, txtQuestion, addOption);
		questionList.setPrefSize(400, 400);

		addOption.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				generateOptionField();
			}

		});
		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				saveQuestion();
			}
		});
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

	private void saveQuestion() {
		getAnsField().forEach((item) -> options.add(item.getText()));
		question.setOptions(options);
		question.setQuery(txtQuestion.getText());

		getCorrAns().forEach((rb) -> {
			if (rb.isSelected()) {
				question.setCorrAns(getCorrAns().indexOf(rb));
			}
		});

	}

	private ArrayList<TextField> getAnsField() {
		return ansField;
	}

	private ArrayList<RadioButton> getCorrAns() {
		return ansCorr;
	}

}
