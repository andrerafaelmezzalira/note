package note.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.domain.entity.Stock;
import note.domain.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;

	public List<Stock> findStocks(Integer bankCode, Integer terminalCode, Integer value) {
		return repository
				.findStockByBankCodeAndTerminalCodeAndQuantityGreaterThanAndNoteValueLessThanEqualOrderByNoteValueDesc(
						bankCode, terminalCode, 0, value);
	}

	public void save(Stock stock) {
		repository.save(stock);
	}
}