package note.bank.service;

import org.springframework.stereotype.Service;

@Service
public class BankService {

	public String bankNoteSupply(Integer noteValue, Integer quantity, String startDate, String deliveryDate) {

		// aqui o banco implementa sua politica de liberação de notas, pode alterar a
		// data da entrega se precisar
		return deliveryDate;
	}
}