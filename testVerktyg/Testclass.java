package testVerktyg;
<<<<<<< Updated upstream

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Testclass implements Initializable {
	private static User user;
	private static Test test;
	private static EntityManagerFactory emfactory;
	private static EntityManager em;
	private static Query query;
	// private QuestionWindowController questionWindow;
	private double y = 40;
	private TextField ans;
	private ArrayList<TextField> ansList1 = new ArrayList<>();
	private ObservableList<TextField> ansList; // = new ObservableList<>();
	private ArrayList<String> ansSList;

	@FXML // fx:id ="mainWindow"
	private Pane mainWindow;

	@FXML // fx:id ="mainMenu"
	private MenuBar mainMenu;

	@FXML // fx:id ="file"
	private Menu file;

	@FXML // fx:id ="newTest"
	private MenuItem newTest;

	@FXML // fx:id ="questionWindow"
	private AnchorPane questionWindow;

	@FXML // fx:id ="btnAddAns"
	private Button btnAddAns;

	@FXML // fx:id ="cmbCorrAns"
	private ComboBox cmbCorrAns;

	@FXML // fx:id = "txtFirstField"
	private TextField txtFirstField;

	public static void main(String[] args) {

		/*
		 * emfactory =
		 * Persistence.createEntityManagerFactory("Eclipselink_JPA"); em =
		 * emfactory.createEntityManager(); em.getTransaction().begin(); user =
		 * new User(); test = new Test();
		 */

		/*
		 * query = em.createNamedQuery("User.findUserByNameAndPw", User.class);
		 * query.setParameter("uName", "någon"); query.setParameter("uPass",
		 * "hemligt"); // user = (User) query.getResultList();
		 * System.out.println("Användar idn är : " + query.getResultList());
		 */
		// List<Test> tests = new ArrayList<Test>();
		// em.persist(tests);
		// user.setUId(2);
		// user.setUName("någon");
		// user.setUPass("hemligt");
		// user.setIsAdmin((byte) 0);
		// user.setTests(tests);
		// test.setUser(user);
		// em.persist(user);
		// em.persist(test);
		// em.getTransaction().commit();
	}

	@Override
	public void initialize(URL Något, ResourceBundle resources) {

		// assert mainWindow != null : "fx:id=\"mainWindow\" was not injected:
		// check your FXML file 'Något.fxml'.";

		newTest.setOnAction((value) -> {
			System.out.println("TEst");
			questionWindow.setVisible(true);
			System.out.println(mainWindow.getChildren());
		});

		btnAddAns.setOnAction((value) -> {
			if (ansList.size() >= 6) {

			} else {

				ans = new TextField();
				ans.setPrefWidth(353);
				mainWindow.getChildren().add(ans);
				ans.setLayoutX(104);
				ans.setLayoutY(242 + y);
				y = y + 40;
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

					if (change.wasUpdated()) {
						cmbCorrAns.getItems().setAll(getAnsStrings());
					}
				}
			}
		});

	}

	public ArrayList<String> getAnsStrings() {
		ansList.forEach((item) -> {
			ansSList.add(item.getText());

		});
		return ansSList;
	}
}
=======
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Testclass extends Application {
	//Views
	@FXML private Label label;
	@FXML private TextField field;
	

	private TestClassMain inlog;
	public void setTestToolApp(TestClassMain inlog){
		this.inlog = inlog;
	}
	
	public void handleButton(){
		String text = field.getText();
		label.setText(text);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}


		
	}
>>>>>>> Stashed changes
