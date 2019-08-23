package note.domain.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import note.domain.entity.Stock;
import note.domain.entity.StockId;
import note.domain.entity.Terminal;

public interface StockRepository extends Repository<Stock, StockId> {

	List<Stock> findStockByTerminalAndQuantityGreaterThanAndNoteValueLessThanEqualOrderByNoteValueDesc(
			Terminal terminal, Integer quantity, Integer value);

	void save(Stock stock);
}
