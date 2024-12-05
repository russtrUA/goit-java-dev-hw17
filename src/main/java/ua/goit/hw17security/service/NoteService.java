package ua.goit.hw17security.service;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.hw17security.exception.NoteNotFoundException;
import ua.goit.hw17security.model.Note;
import ua.goit.hw17security.model.dto.NoteUpdateRequest;
import ua.goit.hw17security.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class NoteService {
    private static final String EXCEPTION_MESSAGE = "Note with id %d not found.";
    private final NoteRepository noteRepository;
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    public Note add(Note note) {
        return noteRepository.save(note);
    }

    public void deleteById(long id) {
        noteRepository.deleteById(id);
    }

    @Transactional
    public void update(NoteUpdateRequest noteUpdateRequest) {
        Note note = noteRepository.findById(noteUpdateRequest.id()).orElseThrow(() -> new NoteNotFoundException(String.format(EXCEPTION_MESSAGE, noteUpdateRequest.id())));
        note.setTitle(noteUpdateRequest.title());
        note.setContent(noteUpdateRequest.content());
        noteRepository.save(note);
    }

    public Note getById(long id) {
       return noteRepository.findById(id).orElseThrow(() -> new NoteNotFoundException(String.format(EXCEPTION_MESSAGE, id)));
    }

}
