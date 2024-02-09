package ru.suborg.javaspring06.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.suborg.javaspring06.models.Note;
import ru.suborg.javaspring06.services.NoteService;

import java.util.List;

/**
 * Контроллер обработки заметок.
 */
@RestController
@RequestMapping("/")
public class NoteController {
    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<Note>> allNotes(){
        return ResponseEntity.ok().body(service.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNote(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getNoteById(id));
    }

    @PostMapping()
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return ResponseEntity.ok().body(service.createNote(note));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id,
                                           @RequestBody Note note){
        return ResponseEntity.ok().body(service.updateNote(id, note));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        service.removeNote(id);
        return ResponseEntity.ok().build();
    }
} 
