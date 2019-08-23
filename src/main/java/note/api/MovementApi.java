package note.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import note.service.MovementService;

@RestController
public class MovementApi {

	@Autowired
	private MovementService service;

	@RequestMapping(value = "/movement/{bankCode}/{terminalCode}/{value}", method = RequestMethod.GET)
	public void movement(@PathVariable Integer bankCode, @PathVariable Integer terminalCode, @PathVariable Integer value)
			throws Exception {
		service.movement(bankCode, terminalCode, value);
	}
}