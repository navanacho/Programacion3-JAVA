package org.example.cursos.controllers;


import org.example.cursos.entities.curso;
import org.example.cursos.entities.estudiante;
import org.example.cursos.service.ICursosService;
import org.example.cursos.service.IEstudianteService;
import org.example.cursos.service.cursoServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudiantes")
public class estudianteController {
    private final IEstudianteService estudianteService;
    private final ICursosService cursoService;

    public estudianteController(IEstudianteService estudianteService, ICursosService cursoService) {
        this.estudianteService = estudianteService;
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<estudiante> listar(){
        return estudianteService.listar();
    }


    @PostMapping
    public ResponseEntity<estudiante> crear(@RequestBody estudiante e){
        estudiante nuevoEstudiante = estudianteService.crear(e);
        return ResponseEntity.ok(nuevoEstudiante);
    }

    @GetMapping("/{estudianteId}/cursos")
    public ResponseEntity<List<curso>> cursoEstudiante(@PathVariable long id){
        List<curso> cursos = cursoServiceImpl.cursosEstudiante(id);
        return ResponseEntity.ok(cursos);
    }
}
