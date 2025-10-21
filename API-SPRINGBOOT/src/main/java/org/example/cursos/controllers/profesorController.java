package org.example.cursos.controllers;


import org.example.cursos.entities.profesor;
import org.example.cursos.repo.profesorRepo;
import org.springframework.http.ResponseEntity;
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
        profesor saved = profesorRepository.save(p);
        return ResponseEntity.ok(saved).getBody();
    }

    @GetMapping("/{id}")
    public ResponseEntity<profesor> obtener (@PathVariable Long id){
        return profesorRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        if (!profesorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        profesorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
