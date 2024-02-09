package ru.suborg.javaspring06.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.suborg.javaspring06.models.Note;

/**
 * Репозиторий для работы с сущностью заметки.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
