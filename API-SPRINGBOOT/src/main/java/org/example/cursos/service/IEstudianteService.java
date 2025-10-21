package org.example.cursos.service;

import org.example.cursos.entities.estudiante;
import java.util.List;

public interface IEstudianteService {
    estudiante crear(estudiante e);
    List<estudiante> listar();
}
