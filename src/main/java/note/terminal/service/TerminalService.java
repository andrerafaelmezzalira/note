package note.terminal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.terminal.domain.entity.Terminal;
import note.terminal.domain.repository.TerminalRepository;

@Service
public class TerminalService {

	@Autowired
	private TerminalRepository repository;

	public Terminal getTerminal(String bankName, String terminalName) {
		return repository.findTerminalByBankAndName(bankName, terminalName);
	}

	public Terminal getById(Integer id) {
		return repository.findById(id);
	}

}