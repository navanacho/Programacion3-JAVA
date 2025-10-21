package org.example.cursos.repo;
import org.example.cursos.entities.profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface profesorRepo extends JpaRepository<profesor, Long> {
    Optional<profesor> findByEmail(String email);
}
