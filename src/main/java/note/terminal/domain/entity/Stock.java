package note.terminal.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Check;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "noteValue", "terminal_id" }) })
@Check(constraints = "(note_value = 10 or note_value = 20 or note_value = 50 or note_value = 100) and quantity >= 0")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Terminal terminal;

	@Column(nullable = false)
	private Integer noteValue;

	@Column(nullable = false)
	private Integer quantity;

	public void setNoteValue(Integer noteValue) {
		this.noteValue = noteValue;
	}

	public Integer getNoteValue() {
		return noteValue;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	public Terminal getTerminal() {
		return terminal;
	}
}
