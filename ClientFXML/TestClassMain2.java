package ClientFXML;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

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
		//		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		//		em = emfactory.createEntityManager();
		//		TestReader testReader = new TestReader(em);
		//		Test test = testReader.getTestById(2);
		//		String strtest = test.getQuestions().get(0).getQuestion();
		//		System.out.println("test har laddat id... " + test.getTestId() + strtest);
		//
		//		CIientViewController cvc = new CIientViewController(em,test);
		//		cvc.startTest(test);

		Parent root =  FXMLLoader.load(getClass().getResource("ClientView.fxml"));

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
