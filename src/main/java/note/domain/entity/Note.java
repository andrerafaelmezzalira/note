package note.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Check;

@Entity
@Check(constraints = "value = 10 or value = 20 or value = 50 or value = 100")
public class Note {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false)
	private Integer value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setValue(Integer value) {
		this.value = value;
	}
	public Integer getValue() {
		return value;
	}
	
}
