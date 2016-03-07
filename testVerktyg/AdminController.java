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

		q.getBtnSave().setOnAction(e -> {
			//model.makeTest(q.getForm());
		});

	}




}
