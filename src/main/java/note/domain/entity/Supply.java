package note.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import org.hibernate.annotations.Check;

@Entity
@IdClass(SupplyId.class)
@Check(constraints = "(note_value = 10 or note_value = 20 or note_value = 50 or note_value = 100) and quantity >= 0 and delivery_date > start_date")
public class Supply {

	@Id
	private Integer bankCode;

	@Id
	private Integer terminalCode;

	@Id
	private LocalDateTime startDate;

	@Column(nullable = false)
	private LocalDateTime deliveryDate;

	@Column(nullable = false)
	private Integer noteValue;

	@Column(nullable = false)
	private Integer quantity;

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setNoteValue(Integer noteValue) {
		this.noteValue = noteValue;
	}
	
	public Integer getNoteValue() {
		return noteValue;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
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
