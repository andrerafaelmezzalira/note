package note.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Check;

@Entity
@IdClass(StockId.class)
@Check(constraints = "quantity >= 0")
public class Stock {

	@ManyToOne
	@Id
	private Terminal terminal;

	@ManyToOne
	@Id
	private Note note;

	@Column(nullable =  false)
	private Integer quantity;

	public void setNote(Note note) {
		this.note = note;
	}
	public Note getNote() {
		return note;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	public Terminal getTerminal() {
		return terminal;
	}
}
