package testVerktyg;

import javafx.stage.Stage;

public class ClientController {
	// Instance variables
	private ClientModel model;
	private ClientView view;
	private Stage stage;

	public ClientController(Stage stage){
		this.stage = stage;
		model = new ClientModel();
		view = new ClientView();

		view.getBtnNext().setOnAction(e->{

		});

		view.getBtnPrev().setOnAction(e-> {

		});

		view.getBtnSend().setOnAction(e-> {

		});

	}

	public ClientModel getModel() {
		return model;
	}

	public ClientView getView() {
		return view;
	}


}
