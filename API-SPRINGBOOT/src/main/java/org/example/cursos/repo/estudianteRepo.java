package org.example.cursos.repo;
import org.example.cursos.entities.estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
public interface estudianteRepo extends JpaRepository<estudiante, Long>{}
