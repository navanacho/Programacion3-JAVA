package org.example.cursos.cursosAplication.repo;
import org.example.cursos.cursosAplication.entities.curso;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface cursoRepo extends JpaRepository<curso, Long> {
    // Devuelve cursos donde participa un estudiante por su id
    List<curso> findByEstudiantesId(Long estudianteId);
}
