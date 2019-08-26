package note.terminal.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import note.terminal.service.MovementService;

@RestController
public class MovementApi {

	@Autowired
	private MovementService service;

	@PostMapping(value = "/movement")
	public void movement(@RequestParam String bankName, @RequestParam String terminalName, @RequestParam Integer value)
			throws Exception {
		service.movement(bankName, terminalName, value);
	}
}