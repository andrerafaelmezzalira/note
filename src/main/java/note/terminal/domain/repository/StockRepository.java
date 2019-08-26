package note.terminal.domain.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import note.terminal.domain.entity.Terminal;
import note.terminal.domain.entity.Stock;

public interface StockRepository extends Repository<Stock, Integer> {

	List<Stock> findStockByTerminalAndQuantityGreaterThanAndNoteValueLessThanEqualOrderByNoteValueDesc(
			Terminal terminal, Integer quantity, Integer value);

	Stock findStockByTerminalAndNoteValue(Terminal terminal, Integer noteValue);

	void save(Stock stock);
}
