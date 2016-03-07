package testVerktyg;

public class AdminController {
	//Instance variables
	private AdminView view;
	private AdminModel model;
	private QuestionCreator q;

	// Constructor
	public AdminController(){
		view = new AdminView();
		model = new AdminModel();

		view.getBtnCreateQuest().setOnAction(e -> {
			q = new QuestionCreator();
			view.setCenterView(q.getScene());
		});

		view.getBtnSaveTest().setOnAction(e -> {
			// Save button in default admin view
		});

		q.getBtnSaveForm().setOnAction(e -> { // Save form, method call to reset field for new input
			model.makeTest(q.getForm());
			q.resetField();
		});

		q.getBtnFinish().setOnAction(e-> { //  Call method to save entire test, reset field, go back to default view
			model.saveTest();
			q.resetField();
			view.setDefaultView();		
		});
	}

}
