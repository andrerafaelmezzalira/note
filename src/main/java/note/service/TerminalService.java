package note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.domain.repository.TerminalRepository;

@Service
public class TerminalService {

	@Autowired
	private TerminalRepository repository;
}