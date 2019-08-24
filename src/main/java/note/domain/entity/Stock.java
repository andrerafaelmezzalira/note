package note.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.Check;

@Entity
@IdClass(StockId.class)
@Check(constraints = "(note_value = 10 or note_value = 20 or note_value = 50 or note_value = 100) and quantity >= 0")
public class Stock {

	@Id
	private Integer bankCode;

	@Id
	private Integer terminalCode;

	@Id
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

	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}

	public Integer getBankCode() {
		return bankCode;
	}

	public void setTerminalCode(Integer terminalCode) {
		this.terminalCode = terminalCode;
	}

	public Integer getTerminalCode() {
		return terminalCode;
	}
}
