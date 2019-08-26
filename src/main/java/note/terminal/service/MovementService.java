package note.terminal.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.terminal.domain.entity.Stock;
import note.terminal.domain.entity.Terminal;

@Service
public class MovementService {

	@Autowired
	private StockService stockService;

	@Autowired
	private TerminalService terminalService;

	@Autowired
	private BankRequestService bankRequestService;

	@Autowired
	private SupplyService supplyService;

	@Transactional(rollbackOn = Exception.class)
	public void movement(String bankName, String terminalName, Integer value) throws Exception {

		Terminal terminal = terminalService.getTerminal(bankName, terminalName);

		if (terminal == null) {
			throw new Exception("credenciais não encontradas");
		}

		List<Stock> stocks = stockService.findStocks(terminal, value);

		Integer noteValue = null;
		for (Stock stock : stocks) {

			Integer notes = (int) (value.doubleValue() / stock.getNoteValue().doubleValue());

			if (notes > 0 && stock.getQuantity() >= notes) {
				stock.setQuantity(stock.getQuantity() - notes);
				stockService.save(stock);
				value -= (stock.getNoteValue() * notes);
				if (stock.getQuantity().equals(0)) {
					noteValue = stock.getNoteValue();
				}
				if (value.equals(0)) {
					break;
				}
			}

		}

		if (noteValue != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
			String startDate = LocalDateTime.now().format(formatter);
			String deliveryDate = LocalDateTime.now().plusMinutes(terminal.getUpdateStockInMinute()).format(formatter);
			try {
				supplyService.bankNoteSupply(noteValue, terminal.getUpdateStockQuantity(), startDate, deliveryDate,
						terminal);
				bankRequestService.bankNoteSupply(noteValue, terminal.getUpdateStockQuantity(), startDate, deliveryDate,
						terminal);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (!value.equals(0)) {
			throw new Exception("Não foi possível realizar a transferência");
		}
	}
}