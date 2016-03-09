package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javafx.stage.Stage;

public class AdminController {
	//Instance variables
	private AdminView view;
	private AdminModel model;
	private QuestionCreator q;
	private Stage stage;

	// Constructor
	public AdminController(Stage stage, EntityManagerFactory emfactory, EntityManager em){
		this.stage = stage;
		view = new AdminView();
		//model = new AdminModel();

		// Create question button
		view.getBtnCreateQuest().setOnAction(e -> {
			q = new QuestionCreator();
			view.getCenter().getChildren().clear(); // clears anchorpane 
			view.getCenter().getChildren().add(q.getQuestionList()); // adds vbox
		});
		// Save btn
		view.getBtnSaveTest().setOnAction(e-> {
			model.saveTest(emfactory, em);

		});

	}

	// Getters and setters
	public AdminView getView() {
		return view;
	}

	public AdminModel getModel() {
		return model;
	}

}
