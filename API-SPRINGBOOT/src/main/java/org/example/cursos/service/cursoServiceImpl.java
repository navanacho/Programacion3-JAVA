package org.example.cursos.service;
import lombok.ToString;
import org.example.cursos.entities.curso;
import org.example.cursos.entities.estudiante;
import org.example.cursos.entities.profesor;
import org.example.cursos.repo.cursoRepo;
import org.example.cursos.repo.estudianteRepo;
import org.example.cursos.repo.profesorRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

@ToString
@Service
public class cursoServiceImpl implements ICursosService {
    private final cursoRepo cursoRepository;
    private final estudianteRepo estudianteRepository;
    private final profesorRepo profesorRepository;

    public cursoServiceImpl(cursoRepo cursoRepository, estudianteRepo estudianteRepository, profesorRepo profesorRepository) {
        this.cursoRepository = cursoRepository;
        this.estudianteRepository = estudianteRepository;
        this.profesorRepository = profesorRepository;
    }

    @Override
    public List<curso> listarCursos() {
        return cursoRepository.findAll();
    }

    @Override
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

    @Override
    public curso asignarEstudiante(long cursoId, Set<Long> estudianteId) {
        return null;
    }

    @Override
    public static List<curso> cursosEstudiante(Long estudianteId) {
        return List.of();
    }

    @Transactional
    @Override
    public curso asignarEstudiante(Long cursoId, Set<Long> estudianteIds) {
        curso curso = cursoRepository.findById(cursoId).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
        Set<estudiante> estudiantes = new HashSet<>(estudianteRepository.findAllById(estudianteIds));
        curso.getEstudiantes().addAll(estudiantes);
        return cursoRepository.save(curso);
    }

    @Override
    public List<curso> obtenerCursos(Long estudianteId) {
        return cursoRepository.findByEstudiantesId(estudianteId);
    }
}
