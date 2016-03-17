package testVerktyg.clientFXML;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import testVerktyg.Choice;
import testVerktyg.ClientModel;
import testVerktyg.Test;

public class ClientViewController implements Initializable {

	@FXML
	private VBox clientWindow;
	@FXML
	private VBox testViewBox;
	@FXML
	private MenuItem menuShow;
	@FXML
	private MenuItem menuClose;
	@FXML
	private MenuItem menuSave;
	@FXML
	private MenuItem menuQuit;
	@FXML
	private AnchorPane centerContent;
	@FXML
	private Button btnNext;
	@FXML
	private Button btnPrev;
	@FXML
	private Button btnStart;
	@FXML
	private ListView<String> listView;
	@FXML
	private Label lblTitle;
	@FXML
	private Label lblTimer;
	@FXML
	private Label lblQuestionCount;
	@FXML
	private Label lblQuestion;
	@FXML
	private ToggleGroup tGroup = new ToggleGroup();

	private ArrayList<RadioButton> btnList = new ArrayList<>();

	private ClientModel clientModel = new ClientModel();;

	public ClientViewController() {
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showListView();

		// Actionevents
		menuShow.setOnAction(e -> {

		});
		menuClose.setOnAction(e -> {

		});

		menuSave.setOnAction(e -> {
			// Take testResult from testViewController and send to DB
		});
		menuQuit.setOnAction(e -> {
			Platform.exit();
		});
		btnNext.setOnAction(e -> {
			if(clientModel.getQuestionCounter() < clientModel.getQuestionsize()){
				clientModel.gradeQuestion(clientModel.getCurrQuestion(), getSelectedItem());
				if(clientModel.getQuestionCounter() == clientModel.getQuestionsize() -1){
					btnNext.setText("Finish");
				}
				showNextQuestion();
			}
			else{
				clientModel = new ClientModel();
				testViewBox.setVisible(false);
				btnNext.setText("Next");

				listView.setVisible(true);
				btnStart.setVisible(true);
			}});

		btnPrev.setOnAction(e -> {

		});

		btnStart.setOnAction(e -> {

			String selectedStr = listView.getSelectionModel().getSelectedItem();
			System.out.println("Selected item:" + selectedStr);

			clientModel.setCurrTest(Integer.parseInt(selectedStr)); // Sending testtitle
			listView.setVisible(false);
			btnStart.setVisible(false);
			// string to set test
			showNextQuestion();

		});
		System.out.println("ClientView init complete");
	}

	private void showListView(){
		testViewBox.setVisible(false);
		ArrayList <String>arrayList = new ArrayList<>();
		clientModel.getTests().forEach(test ->{
			arrayList.add(Integer.toString(test.getTestId()));
		});
		ObservableList<String> observableList = FXCollections.observableArrayList(arrayList);
		listView.setItems(observableList);
		listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
		listView.getSelectionModel().select(0);// selects item with index 0 by default
		listView.setVisible(true);
		btnStart.setVisible(true);
		System.out.println("Updated list of tests...");
	}

	private void showNextQuestion() {
		cleanQuestionView();
		testViewBox.setVisible(true);
		System.out.println("Showing next question...");
		if(clientModel.getQuestionCounter() <= clientModel.getQuestionsize())
			clientModel.generateQuestion();
		Test test = clientModel.getCurrTest();
		lblTitle.setText("Test title: \" " + test.getTestTitle() + "\" "); // Test title
		lblQuestionCount.setText("Question: " + clientModel.getQuestionCounter() + "/" + clientModel.getQuestionsize());

		generateView(clientModel.getCurrChoices());
	}

	public void generateView(List<Choice> options) {
		for (Choice option : options) {
			RadioButton rButton = new RadioButton(option.getChoice());
			btnList.add(rButton);
			rButton.setToggleGroup(tGroup);
			rButton.setUserData(option.getChoiceId()); // saving choiceId
			System.out.println("Adding option button...");
		}
		testViewBox.getChildren().add(new Label(clientModel.getCurrQuestion().getQuestion()));
		btnList.forEach(btn -> {
			testViewBox.getChildren().add(btn); // adds btns to vbox
		});
	}

	public void cleanQuestionView(){
		testViewBox.getChildren().clear();
		btnList.clear();
	}

	public int getSelectedItem() {
		// Code for getting selectedItem from togglegroup nere
		System.out.println(tGroup.getSelectedToggle().getUserData());
		return (int) tGroup.getSelectedToggle().getUserData();
	}

}