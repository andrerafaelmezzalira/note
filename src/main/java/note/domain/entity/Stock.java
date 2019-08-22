package note.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(StockId.class)
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
