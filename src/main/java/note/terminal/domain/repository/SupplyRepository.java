package note.terminal.domain.repository;

import java.time.LocalDateTime;

import org.springframework.data.repository.Repository;

import note.terminal.domain.entity.Supply;
import note.terminal.domain.entity.Terminal;

public interface SupplyRepository extends Repository<Supply, Integer> {

	void save(Supply supply);

	Supply findSupplyByStartDateLessThanEqualAndDeliveryDateGreaterThanEqualAndTerminal(LocalDateTime startDate,
			LocalDateTime startDate2, Terminal terminal);

}
