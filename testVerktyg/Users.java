package testVerktyg;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Users")
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int uId;
	private String uName;
	private String uPassWord;
	private boolean isAdmin;

	@OneToMany(mappedBy="users") // Join with TestEntity
	private List <TestEntity> tests;
	
	public Users(int id, String name, String passWord, Boolean isAdmin) {
		super();
		this.uId = id;
		this.uName = name;
		this.uPassWord = passWord;
		this.isAdmin = isAdmin;
	}

	public Users() {
		super();
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public int getId() {
		return uId;
	}

	public void setId(int id) {
		this.uId = id;
	}

	public String getName() {
		return uName;
	}

	public void setName(String name) {
		this.uName = name;
	}

	public String getPassWord() {
		return uPassWord;
	}

	public void setPassWord(String passWord) {
		this.uPassWord = passWord;
	}

}
