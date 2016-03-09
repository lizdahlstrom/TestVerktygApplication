package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * JAVAFX Application
 * 
 */

public class TestToolApp extends Application {
	//Instance variables
	private ClientView clientView;
	//	private AdminView adminView;
	private InlogView inlogView;
	private InlogModel inlogModel;
	private ClientController clientContr;
	private AdminController adminContr;
	private String title = "Testverktyg";
	private EntityManagerFactory emfactory;
	private EntityManager em;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		inlogView = new InlogView();
		inlogModel = new InlogModel();
		emfactory = Persistence.createEntityManagerFactory("EclipseLink_JPA");
		em = emfactory.createEntityManager();

		if(inlogModel.isAdmin(inlogView.getName(), inlogView.getPass())){
			adminContr = new AdminController(primaryStage, emfactory, em);
			primaryStage.setTitle(title + ": Admin View");
			primaryStage.setScene(adminContr.getView().getAdminScene());
		}
		else if(!inlogModel.isAdmin(inlogView.getName(), inlogView.getPass())){
			clientContr = new ClientController(primaryStage);
			primaryStage.setTitle(title + ": Client View");
			primaryStage.setScene(clientContr.getView().getTestView());
		}

		primaryStage.show();
	}

}
