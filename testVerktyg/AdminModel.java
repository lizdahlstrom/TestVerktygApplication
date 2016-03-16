package testVerktyg;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AdminModel {
	private ArrayList<Question> tests = new ArrayList<>();
	private ArrayList<ArrayList<Choice>> qChoices = new ArrayList<>();
	private EntityManagerFactory emfactory;
	private EntityManager em;
	User user = new User();
	Test test = new Test();
	Question questions = new Question();
	Choice options = new Choice();
	private Query query;

	public AdminModel() {
	}

	public void makeTest(Question question, ArrayList<Choice> choices) {
		tests.add(question);
		qChoices.add(choices);
	}

	public void saveTest(int uId) {
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();

		System.out.println("uid = " + uId);
		// System.out.println("EntityManager : " + em);

		em.getTransaction().begin();
		query = em.createNamedQuery("User.findUserById", User.class);
		query.setParameter("uId", uId);

		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println("Error, Can not find User Id : " + uId);
			e.printStackTrace();

		}

		// users.setUId(uId);
		// users.setIsAdmin(true);
		// em.persist(users);

		// test.setTestId(0);
		test.setUser(user);
		// test.setQuestions(tests);

		em.persist(test);

		tests.forEach((form) -> {
			questions.setTest(test);
			questions.setQuestion(form.getQuestion());

			em.persist(questions);

			qChoices.forEach((option) -> {
				option.forEach((answer) -> {
					options.setQuestion(questions);
					options.setChoice(answer.getChoice());
					if (options.getChoice() == answer.getChoice() && answer.getIsTrue() == 1) {
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
