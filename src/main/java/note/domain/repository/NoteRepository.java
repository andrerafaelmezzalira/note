package note.domain.repository;

import org.springframework.data.repository.Repository;

import note.domain.entity.Note;

public interface NoteRepository extends Repository<Note, Integer> {

}
