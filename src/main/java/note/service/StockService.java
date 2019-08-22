package note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.domain.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository repository;
}