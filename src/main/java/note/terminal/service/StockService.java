package note.terminal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.terminal.domain.entity.Terminal;
import note.terminal.domain.entity.Stock;
import note.terminal.domain.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	public List<Stock> findStocks(Terminal terminal, Integer value) {
		return repository.findStockByTerminalAndQuantityGreaterThanAndNoteValueLessThanEqualOrderByNoteValueDesc(
				terminal, 0, value);
	}

	public void save(Stock stock) {
		repository.save(stock);
	}

	public Stock findStockByTerminalAndNoteValue(Terminal terminal, Integer noteValue) {
		return repository.findStockByTerminalAndNoteValue(terminal, noteValue);
	}

}