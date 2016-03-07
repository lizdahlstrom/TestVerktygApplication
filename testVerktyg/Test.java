package testVerktyg;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tId;
	@ManyToOne
	private int qId;

}
