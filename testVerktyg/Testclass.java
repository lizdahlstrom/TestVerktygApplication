package testVerktyg;

import java.net.URL;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Testclass implements Initializable {
	private static User user;
	private static Test test;
	private static EntityManagerFactory emfactory;
	private static EntityManager em;
	private static Query query;

	@FXML // fx:id ="mainWindow"
	private Pane mainWindow;

	@FXML // fx:id ="mainMenu"
	private MenuBar mainMenu;

	@FXML // fx:id ="file"
	private Menu file;

	@FXML // fx:id ="newTest"
	private MenuItem newTest;

	@FXML // fx:id ="QuestionWindow"
	private AnchorPane questionWindow;

	@FXML // fx:id ="blankPane"
	private AnchorPane blankPane;

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
			try {
				questionWindow = (AnchorPane) FXMLLoader
						.load(TestClassMain.class.getResource("adminViews/questionWindow.fxml"));
			} catch (Exception e) {
			}
			// mainWindow.getChildren().remove(blankPane);
			mainWindow.getChildren().add(questionWindow);
			System.out.println(mainWindow.getChildren());
		});

		mainWindow.setOnMouseEntered((event) -> {
			// System.out.println("TESTINGTESTINGTESTING");

		});

	}

}
