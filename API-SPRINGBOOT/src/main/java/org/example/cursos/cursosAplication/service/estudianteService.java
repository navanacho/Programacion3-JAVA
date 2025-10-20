package org.example.cursos.cursosAplication.service;
import org.example.cursos.cursosAplication.entities.estudiante;
import org.example.cursos.cursosAplication.repo.estudianteRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class estudianteService {
    private final estudianteRepo estudianteRepository;

    public estudianteService(estudianteRepo estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public estudiante crear(estudiante e){return estudianteRepository.save(e);}
    public List<estudiante> listar(){return estudianteRepository.findAll();}
}
