package org.example.cursos.cursosAplication.controllers;


import org.example.cursos.cursosAplication.entities.profesor;
import org.example.cursos.cursosAplication.repo.profesorRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profesores")
public class profesorController {
    private final profesorRepo profesorRepository;
    public profesorController(profesorRepo profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @GetMapping
    public List<profesor> listar() {
        return profesorRepository.findAll();
    }

    @PostMapping
    public profesor crear (@RequestBody profesor p){
        return profesorRepository.save(p);
    }
}
