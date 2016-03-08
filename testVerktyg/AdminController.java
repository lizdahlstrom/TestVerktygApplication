package testVerktyg;

import javafx.stage.Stage;

public class AdminController {
	//Instance variables
	private AdminView view;
	private AdminModel model;
	private QuestionCreator q;
	private Stage stage;

	// Constructor
	public AdminController(Stage stage){
		this.stage = stage;
		view = new AdminView();
		model = new AdminModel();
		//
		//		view.getBtnCreateQuest().setOnAction(e -> {
		//			q = new QuestionCreator();
		//			view.setCenterView(q.getScene());
		//		});
		//
		//		view.getBtnSaveTest().setOnAction(e -> {
		//			// Save button in default admin view
		//		});
		//
		//		q.getBtnSaveForm().setOnAction(e -> { // Save form, method call to reset field for new input
		//			model.makeTest(q.getForm());
		//			q.resetField();
		//		});
		//
		//		q.getBtnFinish().setOnAction(e-> { //  Call method to save entire test, reset field, go back to default view
		//			model.saveTest();
		//			q.resetField();
		//			view.setDefaultView();		
		//		});
	}

	// Getters and setters
	public AdminView getView() {
		return view;
	}

	public AdminModel getModel() {
		return model;
	}

}
