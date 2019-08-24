package note.domain.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import note.domain.entity.Stock;
import note.domain.entity.StockId;

public interface StockRepository extends Repository<Stock, StockId> {

	List<Stock> findStockByBankCodeAndTerminalCodeAndQuantityGreaterThanAndNoteValueLessThanEqualOrderByNoteValueDesc(
			Integer bankCode, Integer terminalCode, Integer quantity, Integer value);

	void save(Stock stock);
}
