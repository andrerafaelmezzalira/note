package note.domain.repository;

import org.springframework.data.repository.Repository;

import note.domain.entity.Stock;
import note.domain.entity.StockId;

public interface StockRepository extends Repository<Stock, StockId> {

}
