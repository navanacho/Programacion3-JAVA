package org.example.cursos.cursosAplication.repo;
import org.example.cursos.cursosAplication.entities.estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
public interface estudianteRepo extends JpaRepository<estudiante, Long>{}
