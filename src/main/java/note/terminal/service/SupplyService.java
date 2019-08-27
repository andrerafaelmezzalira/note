package note.terminal.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.terminal.domain.entity.Supply;
import note.terminal.domain.entity.Terminal;
import note.terminal.domain.repository.SupplyRepository;

@Service
public class SupplyService {

	@Autowired
	private SupplyRepository repository;

	public void bankNoteSupply(Integer noteValue, Integer quantity, String startDate, String deliveryDate,
			Terminal terminal) throws Exception {

		Supply supply = new Supply();
		supply.setNoteValue(noteValue);
		supply.setQuantity(quantity);
		supply.setStartDate(LocalDateTime.parse(startDate));
		supply.setDeliveryDate(LocalDateTime.parse(deliveryDate));
		supply.setTerminal(terminal);

		if (repository.findSupplyByStartDateLessThanEqualAndDeliveryDateGreaterThanEqualAndTerminal(
				supply.getStartDate(), supply.getStartDate(), supply.getTerminal()) != null) {
			throw new Exception("já existe um pedido em andamento");
		}

		repository.save(supply);
	}

}