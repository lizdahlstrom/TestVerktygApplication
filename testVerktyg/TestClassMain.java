package testVerktyg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestClassMain extends Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane mainWindow = (Pane) FXMLLoader.load(TestClassMain.class.getResource("adminViews/Något.fxml"));

		Scene scene = new Scene(mainWindow);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
