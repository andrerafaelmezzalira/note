package note.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.domain.entity.Stock;

@Service
public class MovementService {

	@Autowired
	private StockService stockService;

	@Transactional(rollbackOn = Exception.class)
	public void movement(Integer bankCode, Integer terminalCode, Integer value) throws Exception {

		List<Stock> stocks = stockService.findStocks(bankCode, terminalCode, value);

		for (Stock stock : stocks) {

			Integer notes = (int) (value.doubleValue() / stock.getNoteValue().doubleValue());

			if (value.toString().endsWith("0") && (!notes.equals(0) && stock.getQuantity() >= notes)) {
				stock.setQuantity(stock.getQuantity() - notes);
				stockService.save(stock);
				System.out.println("Quantidade de notas no estoque apos esta operacao " + stock.getQuantity());
				value = value - (stock.getNoteValue() * notes);
				if (value.equals(0)) {
					break;
				}
			}

		}

		if (!value.equals(0)) {
			throw new Exception("Falta de notas no estoque!");
		}
	}

}