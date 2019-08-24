package note.domain.entity;

import java.io.Serializable;

public class StockId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer bankCode;

	private Integer terminalCode;

	private Integer noteValue;

	public void setNoteValue(Integer noteValue) {
		this.noteValue = noteValue;
	}

	public Integer getNoteValue() {
		return noteValue;
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
