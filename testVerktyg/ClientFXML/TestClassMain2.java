package testVerktyg.clientFXML;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestClassMain2 extends Application {
	private EntityManagerFactory emfactory;
	private EntityManager em;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Application.launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();

		System.out.println("test??");
		// CIientViewController cvc = new CIientViewController(em, test);
		// cvc.startTest(test);

		Parent root = FXMLLoader.load(getClass().getResource("clientView.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
