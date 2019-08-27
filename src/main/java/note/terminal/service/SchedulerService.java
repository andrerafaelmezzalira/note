package note.terminal.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import note.terminal.domain.entity.Stock;
import note.terminal.domain.entity.Terminal;

@Service
public class SchedulerService {

	@Autowired
	private TaskScheduler taskScheduler;

	@Autowired
	private StockService service;

	public void supply(Integer noteValue, Integer quantity, String deliveryDate, Terminal terminal) throws Exception {

		Stock stock = service.findStockByTerminalAndNoteValue(terminal, noteValue);

		if (stock == null) {
			throw new Exception("estoque não existe, favor criar antes");
		}

		taskScheduler.schedule(new Runnable() {
			@Override
			public void run() {
				stock.setQuantity(quantity);
				service.save(stock);

			}
		}, Date.from(LocalDateTime.parse(deliveryDate).atZone(ZoneId.systemDefault()).toInstant()));
	}

}