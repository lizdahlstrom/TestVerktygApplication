package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * JAVAFX Application
 *
 */

public class TestToolApp extends Application {
	// Instance variables
	private InlogView inlogView;
	private InlogModel inlogModel;
	private ClientController clientContr;
	private AdminController adminContr;
	private String title = "Testverktyg";
	private Stage primaryStage;
	private EntityManagerFactory emfactory;
	private EntityManager em;
	private int userId;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

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
				adminContr = new AdminController(primaryStage, em, userId);
				primaryStage.setTitle(title + ": Admin View");
				primaryStage.setScene(adminContr.getView().getAdminScene());
			} else if (!isAdmin && inlogModel.isPupil(inlogView.getName(), inlogView.getPass(), emfactory, em)) {
				clientContr = new ClientController(primaryStage, em, userId);
				primaryStage.setTitle(title + ": Client View");
				primaryStage.setScene(clientContr.getView().getTestView());
			} else {
				System.out.println(inlogModel.getErrorMsg());
			}
		} else {
			System.out.println("Login failed... invalid format for input.");
		}
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception {
		em.close();
		emfactory.close();
	}
}
