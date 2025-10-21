package org.example.cursos.service;

import org.example.cursos.entities.curso;
import org.example.cursos.entities.profesor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

public interface ICursosService {
    List<curso> listarCursos();
    curso crearCursoConProfesor(String nombreCurso, profesor profesorData);
    curso asignarEstudiante(long cursoId, Set<Long> estudianteId);
    List<curso> cursosEstudiante(Long estudianteId);

    @Transactional
    curso asignarEstudiante(Long cursoId, Set<Long> estudianteIds);

    List<curso> obtenerCursos(Long estudianteId);
}
