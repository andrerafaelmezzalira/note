package note.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import note.domain.repository.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository repository;
}