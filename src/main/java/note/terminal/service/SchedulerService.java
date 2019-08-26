package note.terminal.service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import note.terminal.domain.entity.Terminal;

@Service
public class SchedulerService {

	@Autowired
	private TaskScheduler taskScheduler;

	@Autowired
	private SupplyService service;

	public void supply(Integer noteValue, Integer quantity, String deliveryDate, Terminal terminal) {
		taskScheduler.schedule(new Runnable() {
			@Override
			public void run() {
				service.supply(noteValue, quantity, terminal);
			}
		}, Date.from(LocalDateTime.parse(deliveryDate).atZone(ZoneId.systemDefault()).toInstant()));
	}

}