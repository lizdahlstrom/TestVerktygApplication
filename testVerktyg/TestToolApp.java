package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import testVerktyg.ClientFXML.CIientViewController;

/**
 *
 * JAVAFX Application
 *
 */

public class TestToolApp extends Application {
	// Instance variables
	private InlogView inlogView;
	private InlogModel inlogModel;
	private CIientViewController clientContr;
	private AdminController adminContr;
	private String title = "Testverktyg";
	private Stage primaryStage;
	private EntityManagerFactory emfactory;
	private EntityManager em;
	private int userId;
	//	Scene adminScene;
	private Scene scene;

	private final String adminViewPath = "adminViews/AdminView.fxml";
	private final String clientViewPath = "ClientFXML/ClientView.fxml";

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		// FXMLLoader.load(TestToolApp.class.getResource("adminViews/AdminView.fxml"));

		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();

		// Temporary VBox with button ... needed to launch login window
		Button button = new Button("Login");
		VBox vboxs = new VBox();
		vboxs.getChildren().add(button);
		button.setOnAction(e -> {
			loginStart();
		});
		primaryStage.setScene(new Scene(vboxs));
		primaryStage.show();
	}

	public void loginStart() {
		inlogModel = new InlogModel();
		inlogView = new InlogView();
		if (inlogModel.isInputValid(inlogView.getName()) && inlogModel.isInputValid(inlogView.getPass())) {

			Boolean isAdmin = inlogModel.isAdmin(inlogView.getName(), inlogView.getPass(), em);
			userId = inlogModel.getUId();

			if (isAdmin) {
				adminContr = new AdminController(userId);
				primaryStage.setTitle(title + ": Admin View");
				loadView(adminViewPath);
				primaryStage.setScene(scene);

			} else if (!isAdmin && inlogModel.isPupil(inlogView.getName(), inlogView.getPass(), emfactory, em)) {
				clientContr = new CIientViewController();
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

	public void loadView(String path){
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
