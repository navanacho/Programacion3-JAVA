package org.example.cursos.cursosAplication.service;
import org.example.cursos.cursosAplication.entities.curso;
import org.example.cursos.cursosAplication.entities.estudiante;
import org.example.cursos.cursosAplication.entities.profesor;
import org.example.cursos.cursosAplication.repo.cursoRepo;
import org.example.cursos.cursosAplication.repo.estudianteRepo;
import org.example.cursos.cursosAplication.repo.profesorRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@Service
public class cursoService {
    private final cursoRepo cursoRepository;
    private final estudianteRepo estudianteRepository;
    private final profesorRepo profesorRepository;

    public cursoService(cursoRepo cursoRepository, estudianteRepo estudianteRepository, profesorRepo profesorRepository) {
        this.cursoRepository = cursoRepository;
        this.estudianteRepository = estudianteRepository;
        this.profesorRepository = profesorRepository;
    }

    public List<curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Transactional
    public curso crearCursoConProfesor(String nombreCurso, profesor profesorData){
        profesor prof = null;
        if(profesorData != null && profesorData.getEmail() != null){
            prof = profesorRepository.findByEmail(profesorData.getEmail())
                    .orElseGet(() -> profesorRepository.save(profesorData));
        }
        if (prof == null && profesorData != null) {
            prof = profesorRepository.save(profesor.builder()
                    .nombre(profesorData.getNombre())
                    .email(profesorData.getEmail())
                    .build());


        }
        curso nuevoCurso = curso.builder()
                .nombre(nombreCurso)
                .profesor(prof)
                .build();
        return cursoRepository.save(nuevoCurso);
    }

    @Transactional
    public curso asignarEstudiante(Long cursoId, Set<Long> estudianteIds) {
        curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Set<estudiante> estudiantes = new HashSet<>(estudianteRepository.findAllById(estudianteIds));
        curso.getEstudiantes().addAll(estudiantes);
        return cursoRepository.save(curso);
    }

    public List<curso> obtenerCursos (Long estudianteId) {
        return cursoRepository.findByEstudiantesId(estudianteId);
    }
}
