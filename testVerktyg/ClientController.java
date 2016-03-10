package testVerktyg;

import javax.persistence.EntityManager;

import javafx.stage.Stage;

public class ClientController {
	// Instance variables
	private ClientModel model;
	private ClientView view;
	private Stage stage;
	private TestReader testReader;

	public ClientController(Stage stage, EntityManager eManager){
		this.stage = stage;
		model = new ClientModel();
		view = new ClientView();
		testReader = new TestReader(eManager);

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
