package testVerktyg;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class AdminController {
	private AdminModel model = new AdminModel();
	private int uId;
	private Question question = new Question();
	private Choice choice;
	private ArrayList<Choice> choices = new ArrayList<>();

	private ArrayList<String> options = new ArrayList<>();

	private double y = 60;
	private TextField ans;
	private ArrayList<TextField> ansList1 = new ArrayList<>();
	private ObservableList<TextField> ansList; // = new ObservableList<>();

	@FXML // fx:id ="adminWindow"
	private Pane adminWindow;

	@FXML // fx:id ="mainMenu"
	private MenuBar mainMenu;

	@FXML // fx:id ="file"
	private Menu file;

	@FXML // fx:id ="newTest"
	private MenuItem newTest;

	@FXML // fx:id ="questionWindow"
	private AnchorPane questionWindow;

	@FXML // fx:id ="btnSaveQuestion"
	private Button btnSaveQuestion;

	@FXML // fx:id "btnSaveTest"
	private Button btnSaveTest;

	@FXML // fx:id ="btnAddAns"
	private Button btnAddAns;

	@FXML // fx:id ="cmbCorrAns"
	private ComboBox<String> cmbCorrAns;

	@FXML // fx:id ="txtQueryField"
	private TextField txtQueryField;

	@FXML // fx:id = "txtFirstField"
	private TextField txtFirstField;

	// Constructor

	public AdminController() {

	}

	public AdminController(int uId) {
		this.uId = uId;

	}

	// Getters and setters

	public AdminModel getModel() {
		return model;
	}

	public void setuId(int uId) {
		this.uId = uId;
	}

	public void cleanTestmaker() {
		txtQueryField.clear();
		txtFirstField.clear();
		questionWindow.getChildren().removeAll(ansList);
		ansList.clear();
		txtFirstField = new TextField();
		cmbCorrAns.getItems().clear();
	}

	@FXML
	public void initialize() {
		newTest.setOnAction((value) -> {
			System.out.println("TEst");
			questionWindow.setVisible(true);
			System.out.println("uid : " + uId);

		});

		btnSaveQuestion.setOnAction((value) -> {
			question.setQuestion(txtQueryField.getText());
			ansList.forEach((tf) -> {
				if (!tf.getText().isEmpty() && !tf.getText().equals(null)) {
					options.add(tf.getText());

				}
			});
			options.forEach((item) -> {
				choice = new Choice();
				if (item.equalsIgnoreCase(cmbCorrAns.getValue())) {
					choice.setIsTrue((byte) 1);
				} else {
					choice.setIsTrue((byte) 0);
				}
				choice.setChoice(item);

				choices.add(choice);

			});
			// question.setChoices(choices);
			model.makeTest(question, choices);
			// cleanTestmaker();
		});

		btnSaveTest.setOnAction((push) -> {

			model.saveTest(uId);
		});

		btnAddAns.setOnAction((value) -> {
			if (ansList.size() >= 6) {

			} else {

				ans = new TextField();
				ans.setPrefWidth(353);
				ans.setLayoutX(104);
				ans.setLayoutY(242 + y);
				y = y + 35;
				adminWindow.getChildren().add(ans);

				ansList.add(ans);

			}
		});
		ansList1.add(txtFirstField);
		ansList = FXCollections.observableList(ansList1);

		ansList.addListener(new ListChangeListener<TextField>() {

			@SuppressWarnings("rawtypes")
			@Override
			public void onChanged(ListChangeListener.Change change) {
				while (change.next()) {
					if (change.wasAdded()) {
						cmbCorrAns.getItems().clear();
						ansList.forEach((item) -> {
							if (!item.getText().isEmpty()) {
								cmbCorrAns.getItems().add(item.getText());
							}
						});

					}

				}
			}
		});

	}
}
