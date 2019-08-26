package note.terminal.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Check;

@Entity
@Check(constraints = "delivery_date >= start_date")
public class Supply {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Integer noteValue;

	@Column(nullable = false)
	private Integer quantity;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Terminal terminal;

	@Column(nullable = false)
	private LocalDateTime startDate;

	@Column(nullable = false)
	private LocalDateTime deliveryDate;


	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	public Terminal getTerminal() {
		return terminal;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

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
}
