package ClientFXML;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestClassMain extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root =  FXMLLoader.load(getClass().getResource("ClientView.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
