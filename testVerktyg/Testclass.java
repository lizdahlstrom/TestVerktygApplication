package testVerktyg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Testclass {
	private static User user;
	private static Test test;
	private static EntityManagerFactory emfactory;
	private static EntityManager em;
	private static Query query;

	public static void main(String[] args) {
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();
		em.getTransaction().begin();
		user = new User();
		test = new Test();
		query = em.createNamedQuery("User.findUserByNameAndPw", User.class);
		query.setParameter("uName", "någon");
		query.setParameter("uPass", "hemligt");
		query.setMaxResults(1000);
		System.out.println("Användar idn är : " + query.getSingleResult());

		// List<Test> tests = new ArrayList<Test>();
		// em.persist(tests);
		// user.setUId(2);
		// user.setUName("någon");
		// user.setUPass("hemligt");
		// user.setIsAdmin((byte) 0);
		// user.setTests(tests);
		// test.setUser(user);
		// em.persist(user);
		// em.persist(test);
		// em.getTransaction().commit();
	}

}
