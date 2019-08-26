package note.terminal.domain.repository;

import org.springframework.data.repository.Repository;

import note.terminal.domain.entity.Terminal;

public interface TerminalRepository extends Repository<Terminal, Integer> {

	Terminal findTerminalByBankAndName(String bankName, String terminalName);

	Terminal findById(Integer id);

}
