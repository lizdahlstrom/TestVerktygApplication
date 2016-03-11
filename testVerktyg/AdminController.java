package testVerktyg;

import javax.persistence.EntityManager;

import javafx.stage.Stage;

public class AdminController {
	//Instance variables
	private AdminView view;
	private AdminModel model;
	private QuestionCreator q;
	private Stage stage;
	private int userId;

	// Constructor
	public AdminController(Stage stage, EntityManager em, int userId){
		this.stage = stage;
		this.userId = userId;
		view = new AdminView();
		q = new QuestionCreator();
		model = new AdminModel();

		// Create question button
		view.getBtnCreateQuest().setOnAction(e -> {
			q = new QuestionCreator();
			view.getCenter().getChildren().clear(); // clears anchorpane 
			view.getCenter().getChildren().add(q.getQuestionList()); // adds vbox
		});
		// Save btn
		view.getBtnSaveTest().setOnAction(e-> {
			model.saveTest(em, userId);

		});

		q.getBtnFinish().setOnAction(e ->{
			q.saveAndReset();
			view.getCenter().getChildren().clear();
			view.setDefaultView();
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
