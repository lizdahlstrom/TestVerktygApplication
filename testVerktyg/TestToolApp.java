package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * JAVAFX Application
 *
 */

public class TestToolApp extends Application {
	// Instance variables
	private static InlogView inlogView;
	private static InlogModel inlogModel;
	private static String title = "Testverktyg";
	private static Stage primaryStage;
	private static EntityManagerFactory emfactory;
	private static EntityManager em;
	public static int userId;
	private static Scene scene;

	private final static String adminViewPath = "adminViews/AdminView.fxml";
	private final static String clientViewPath = "clientFXML/ClientView.fxml";
	private final String StartPagePath = "StartPage.fxml";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		TestToolApp.primaryStage = primaryStage;

		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();

		primaryStage.setTitle(title + "StartPage");
		loadView(StartPagePath);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void loginStart() {
		inlogModel = new InlogModel();
		inlogView = new InlogView();
		if (inlogModel.isInputValid(inlogView.getName()) && inlogModel.isInputValid(inlogView.getPass())) {

			Boolean isAdmin = inlogModel.isAdmin(inlogView.getName(), inlogView.getPass(), em);
			userId = inlogModel.getUId();

			if (isAdmin) {
				primaryStage.setTitle(title + ": Admin View");
				loadView(adminViewPath);
				primaryStage.setScene(scene);

			} else if (!isAdmin && inlogModel.isPupil(inlogView.getName(), inlogView.getPass(), emfactory, em)) {
				primaryStage.setTitle(title + ": Client View");
				loadView(clientViewPath);
				primaryStage.setScene(scene);
			} else {
				System.out.println(inlogModel.getErrorMsg());
			}
		} else {
			System.out.println("Login failed... invalid format for input.");
		}
		primaryStage.show();
	}

	public static void loadView(String path) {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(TestToolApp.class.getResource(path));
			Parent root = loader.load();
			scene = new Scene(root);
			System.out.println("Sucessfully loaded view...");
		} catch (Exception e) {
			System.out.println("Exception loading view: " + e);
		}
	}

	@Override
	public void stop() throws Exception {
		em.close();
		emfactory.close();
	}
}
