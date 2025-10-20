package org.example.cursos.cursosAplication.controllers;


import org.example.cursos.cursosAplication.entities.estudiante;
import org.example.cursos.cursosAplication.service.cursoService;
import org.example.cursos.cursosAplication.service.estudianteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class estudianteController {
    private final estudianteService estudianteService;
    private final cursoService cursoService;

    public estudianteController(estudianteService estudianteService, cursoService cursoService) {
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<estudiante> listar(){
        return estudianteService.listar();
    }

    @PostMapping
    public estudiante crear (@RequestBody estudiante e){
        return estudianteService.crear(e);
    }

    @GetMapping("/{estudianteId}/cursos")
    public List<org.example.cursos.cursosAplication.entities.curso> obtenerCursos(@PathVariable Long estudianteId){
        return cursoService.obtenerCursos(estudianteId);
    }
}
