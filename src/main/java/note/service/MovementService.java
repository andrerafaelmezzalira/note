package note.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.domain.entity.Stock;
import note.domain.entity.Terminal;

@Service
public class MovementService {

	@Autowired
	private TerminalService terminalService;

	@Autowired
	private StockService stockService;

	@Transactional(rollbackOn = Exception.class)
	public void movement(Integer bankCode, Integer terminalCode, Integer value) throws Exception {

		System.out.println("Valor solicitado " + value);

		Terminal terminal = terminalService.get(bankCode, terminalCode);

		if (terminal == null) {
			throw new Exception("Terminal não encontrado!");
		}

		List<Stock> stocks = stockService.findStocks(terminal, value);

		if (stocks.isEmpty()) {
			System.err.println("Valor solicitado é menor que o valor da nota mínima neste terminal");
			throw new Exception("Valor solicitado é menor que o valor da nota mínima neste terminal");
		}

		for (Stock stock : stocks) {

			Integer noteValue = stock.getNote().getValue();
			Integer notes = (int) (value.doubleValue() / noteValue.doubleValue());

			if (notes.equals(0)) {
				continue;
			}

			System.out.println("Valor da nota " + noteValue);
			System.out.println("Quantidade de notas necessárias " + notes);
			System.out.println("Quantidade de notas no estoque " + stock.getQuantity());
			if (stock.getQuantity() >= notes) {
				stock.setQuantity(stock.getQuantity() - notes);
				stockService.save(stock);
				System.out.println("Quantidade de notas no estoque apos esta operacao " + stock.getQuantity());
				System.out.println("valor solicitado pelo cliente era " + value);
				value = value - (noteValue * notes);
				System.out.println("agora ficou " + value);
				if (value.equals(0)) {
					break;
				}
			} else {
				System.err.println("quantidade de notas no estoque é menor do que o numero de notas necessarias ");
			}
		}

		if (!value.equals(0)) {
			System.err.println("Falta de notas no estoque");
			throw new Exception("Falta de notas no estoque!");
		}
		System.err.println("sucesso!");
	}

}