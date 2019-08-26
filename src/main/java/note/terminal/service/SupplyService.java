package note.terminal.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.terminal.domain.entity.Terminal;
import note.terminal.domain.entity.Stock;
import note.terminal.domain.entity.Supply;
import note.terminal.domain.repository.SupplyRepository;

@Service
public class SupplyService {

	@Autowired
	private SupplyRepository repository;

	@Autowired
	private StockService service;

	@Transactional(rollbackOn = Exception.class)
	public void supply(Integer noteValue, Integer quantity, Terminal terminal) {

		Stock stock = service.findStockByTerminalAndNoteValue(terminal, noteValue);

		if (stock == null) {
			stock = new Stock();
			stock.setNoteValue(noteValue);
			stock.setTerminal(terminal);
		}
		stock.setQuantity(quantity);
		service.save(stock);
	}

	@Transactional(rollbackOn = Exception.class)
	public String bankNoteSupply(Integer noteValue, Integer quantity, String startDate, String deliveryDate,
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

		return deliveryDate;
	}

}