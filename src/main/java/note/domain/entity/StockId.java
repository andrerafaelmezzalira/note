package note.domain.entity;

import java.io.Serializable;

public class StockId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Terminal terminal;

	private Note note;
	
	public void setNote(Note note) {
		this.note = note;
	}
	
	public Note getNote() {
		return note;
	}
	
	public void setTerminal(Terminal terminal) {
		this.terminal = terminal;
	}
	
	public Terminal getTerminal() {
		return terminal;
	}
}
