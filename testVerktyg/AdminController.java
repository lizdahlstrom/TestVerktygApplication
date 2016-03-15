package testVerktyg;

import java.util.ArrayList;

import javax.persistence.EntityManager;

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
	// Instance variables
	private AdminView view;
	private AdminModel model;
	// private QuestionCreator q;
	// private Stage stage;
	private int uId;
	// private TestToolApp mainApp;
	private EntityManager em;
	private Question question = new Question();
	private Choice choice = new Choice();
	// private URL adminView =
	// TestToolApp.class.getResource("adminViews/AdminView.fxml");

	private double y = 60;
	private TextField ans;
	private ArrayList<TextField> ansList1 = new ArrayList<>();
	private ObservableList<TextField> ansList; // = new ObservableList<>();
	// private ArrayList<String> ansSList;

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
	public AdminController() {// EntityManager em, int uId) { // Stage stage,
								// EntityManager em, int
								// userId) {
		// this.uId = uId;
		// this.em = em;

		/*
		 * this.stage = stage; this.userId = userId; view = new AdminView(); q =
		 * new QuestionCreator(); model = new AdminModel();
		 * 
		 * // Create question button view.getBtnCreateQuest().setOnAction(e -> {
		 * q = new QuestionCreator(); view.getCenter().getChildren().clear(); //
		 * clears anchorpane
		 * view.getCenter().getChildren().add(q.getQuestionList()); // adds //
		 * vbox }); // Save btn view.getBtnSaveTest().setOnAction(e -> {
		 * model.saveTest(em, userId);
		 * 
		 * });
		 * 
		 * q.getBtnFinish().setOnAction(e -> { q.saveAndReset();
		 * view.getCenter().getChildren().clear(); view.setDefaultView(); });
		 */
	}

	public AdminController(EntityManager em, int uId) {
		this.em = em;
		this.uId = uId;

	}

	// Getters and setters
	public AdminView getView() {
		return view;
	}

	public AdminModel getModel() {
		return model;
	}

	public void setEm(EntityManager em) {
		this.em = em;
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
			System.out.println(adminWindow.getChildren());
		});

		btnSaveQuestion.setOnAction((value) -> {
			question.setQuestion(txtQueryField.getText());
			ansList.forEach((tf) -> {
				System.out.println("testing : " + tf.getText());
				if (!tf.getText().isEmpty() && !tf.getText().equals(null)) {

					choice.setChoice(tf.getText());
					if (choice.getChoice().equalsIgnoreCase(cmbCorrAns.getValue())) {
						choice.setIsTrue((byte) 1);
					} else {
						choice.setIsTrue((byte) 0);
					}
					System.out.println("question : " + question.getQuestion());
					System.out.println("choice : " + choice.getChoice());
					// System.out.println(question.getQuestions());
					question.addChoice(choice);
				}
			});

			model.makeTest(question);
			// cleanTestmaker();
		});

		btnSaveTest.setOnAction((push) -> {
			model.saveTest(em, uId);
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

			@Override
			public void onChanged(ListChangeListener.Change change) {
				while (change.next()) {
					if (change.wasAdded()) {
						cmbCorrAns.getItems().clear();
						ansList.forEach((item) -> {
							if (!item.getText().isEmpty()) {
								cmbCorrAns.getItems().add(item.getText());
								System.out.println(item.getText());
							}
						});

					}

				}
			}
		});

	}
	/*
	 * public void setMain(TestToolApp mainApp) { this.mainApp = mainApp; }
	 */
}
