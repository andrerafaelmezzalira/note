package note.bank.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import note.bank.service.BankService;

@RestController
public class BankApi {

	@Autowired
	private BankService service;

	@PostMapping(value = "/supply")
	public @ResponseBody String bankNoteSupply(@RequestParam Integer noteValue, @RequestParam Integer quantity,
			@RequestParam String startDate, @RequestParam String deliveryDate) throws Exception {
		return service.bankNoteSupply(noteValue, quantity, startDate, deliveryDate);
	}
}