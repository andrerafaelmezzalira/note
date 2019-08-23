package note.domain.entity;

import java.io.Serializable;

public class StockId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer terminal;

	private Integer note;

	public void setNote(Integer note) {
		this.note = note;
	}
	
	public Integer getNote() {
		return note;
	}
	
	public void setTerminal(Integer terminal) {
		this.terminal = terminal;
	}
	
	public Integer getTerminal() {
		return terminal;
	}
}
