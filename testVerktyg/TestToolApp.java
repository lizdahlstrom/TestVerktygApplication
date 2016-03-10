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
	private InlogView inlogView;
	private InlogModel inlogModel;
	private ClientController clientContr;
	private AdminController adminContr;
	private String title = "Testverktyg";
	private EntityManagerFactory emfactory;
	private EntityManager em;
	private int userId;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		inlogModel = new InlogModel();
		inlogView = new InlogView();
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();

		Boolean isAdmin = inlogModel.isAdmin(inlogView.getName(), inlogView.getPass(), emfactory, em);
		userId = inlogModel.getUId();

		if(isAdmin){
			adminContr = new AdminController(primaryStage, em, userId);
			primaryStage.setTitle(title + ": Admin View");
			primaryStage.setScene(adminContr.getView().getAdminScene());
		}
		else if(!isAdmin && inlogModel.isPupil(inlogView.getName(), inlogView.getPass(), emfactory, em)){
			clientContr = new ClientController(primaryStage,em, userId);
			primaryStage.setTitle(title + ": Client View");
			primaryStage.setScene(clientContr.getView().getTestView());
		}
		else{
			inlogView = new InlogView();
			inlogModel = new InlogModel();
		}
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception{
		em.close();
		emfactory.close();
	}

}
