package note.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "bankCode", "terminalCode" }) })
public class Terminal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Integer bankCode;

	@Column(nullable = false)
	private Integer terminalCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
