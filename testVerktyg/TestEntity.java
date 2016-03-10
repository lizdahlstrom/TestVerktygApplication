package testVerktyg;

import static javax.persistence.AccessType.FIELD;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//Denna klassen talar 
@Entity
@Table(name="Tests")
@Access(FIELD)

@Cacheable
@NamedQueries({ 
	@NamedQuery(name = "TestEntity.findAll", query = "SELECT t FROM TestEntity t"), 
	@NamedQuery(name = "TestEntity.findByUserId", query = "SELECT t FROM TestEntity t WHERE t.users.uId = :uId") // !Unsure if correct
})
public class TestEntity implements Serializable { // Implements serializable in order to be sent and stored as an object of bytes
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	@ManyToOne
	@JoinColumn(name="uId") // Join with users
	private Users users;

	public TestEntity(int testId, Users users) {
		super();
		this.testId = testId;
		this.users = users;
	}

	public TestEntity() {
		super();
	}

	public Users getUsers() {
		return users;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

}
