package testVerktyg;

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

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		inlogView = new InlogView();
		inlogModel = new InlogModel();
		adminContr = new AdminController(primaryStage);


		if(inlogModel.isAdmin(inlogView.getName(), inlogView.getPass())){
			primaryStage.setTitle(title + ": Admin View");
			primaryStage.setScene(adminContr.getView().getAdminScene());
		}
		else if(!inlogModel.isAdmin(inlogView.getName(), inlogView.getPass())){
			primaryStage.setTitle(title + ": Client View");
			clientView = new ClientView();
			primaryStage.setScene(clientView.getTestView());
		}
		primaryStage.show();
	}

}
