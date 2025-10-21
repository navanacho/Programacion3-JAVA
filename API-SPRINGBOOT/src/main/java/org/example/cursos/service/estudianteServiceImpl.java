package org.example.cursos.service;
import org.example.cursos.entities.estudiante;
import org.example.cursos.repo.estudianteRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class estudianteServiceImpl implements IEstudianteService{
    private final estudianteRepo estudianteRepository;

    public estudianteServiceImpl(estudianteRepo estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    @Override
    public estudiante crear(estudiante e){return estudianteRepository.save(e);}

    @Override
    public List<estudiante> listar(){return estudianteRepository.findAll();}
}
