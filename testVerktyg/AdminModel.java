package testVerktyg;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdminModel {
	private ArrayList<Question> tests = new ArrayList<>();
	private ArrayList<ArrayList<Choice>> qChoices = new ArrayList<>();
	private EntityManagerFactory emfactory;
	private EntityManager em;
	User users = new User();
	Test test = new Test();
	Question questions = new Question();
	Choice options = new Choice();

	public AdminModel() {
	}

	public void makeTest(Question question, ArrayList<Choice> choices) {
		tests.add(question);
		qChoices.add(choices);
	}

	public void saveTest(int uid) {
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();

		// System.out.println("EntityManager : " + em);

		em.getTransaction().begin();

		// users.setUId(uId);
		// em.persist(users);

		// test.setQuestions(tests);

		em.persist(test);

		tests.forEach((form) -> {

			questions.setQuestion(form.getQuestion());

			em.persist(questions);

			qChoices.forEach((option) -> {
				option.forEach((answer) -> {
					options.setChoice(answer.getChoice());
				});

				form.getChoices().forEach((corr) -> {
					if (options.getChoice() == corr.getChoice() && corr.getIsTrue() == 1) {
						options.setIsTrue((byte) 1);

					} else {
						options.setIsTrue((byte) 0);
						;
					}

				});
				em.persist(options);
			});

			form.getChoices().forEach((option) -> {
				options.setChoice(option.getChoice());

				form.getChoices().forEach((corr) -> {
					if (options.getChoice() == corr.getChoice() && corr.getIsTrue() == 1) {
						options.setIsTrue((byte) 1);

					} else {
						options.setIsTrue((byte) 0);
						;
					}

				});
				em.persist(options);
			});

		});

		em.getTransaction().commit();
	}

	public ArrayList<Question> getTests() {
		return tests;
	}

}
