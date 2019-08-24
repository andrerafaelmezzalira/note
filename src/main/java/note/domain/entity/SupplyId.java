package note.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class SupplyId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer bankCode;

	private Integer terminalCode;

	private LocalDateTime startDate;

	public void setBankCode(Integer bankCode) {
		this.bankCode = bankCode;
	}

	public Integer getBankCode() {
		return bankCode;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setTerminalCode(Integer terminalCode) {
		this.terminalCode = terminalCode;
	}

	public Integer getTerminalCode() {
		return terminalCode;
	}
}
