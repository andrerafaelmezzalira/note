package note.domain.repository;

import org.springframework.data.repository.Repository;

import note.domain.entity.Terminal;

public interface TerminalRepository extends Repository<Terminal, Integer> {

	Terminal findByBankCodeAndTerminalCode(Integer bankCode, Integer terminalCode);

}
