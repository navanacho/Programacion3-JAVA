package org.example.cursos.cursosAplication.controllers;

import org.example.cursos.cursosAplication.DTO.crearCurso;
import org.example.cursos.cursosAplication.entities.curso;
import org.example.cursos.cursosAplication.service.cursoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cursos")
public class cursoController {
    private final cursoService cursoService;
    public cursoController(cursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<curso> listar(){
        return cursoService.listarCursos();
    }

    @PostMapping
    public ResponseEntity<curso> crear(@RequestBody crearCurso request){
        curso nuevoCurso = cursoService.crearCursoConProfesor(request.getNombre(), request.getProfesor());
        return ResponseEntity.ok(nuevoCurso);
    }

    @PostMapping("/{cursoId}/estudiantes")
    public ResponseEntity<curso> asignarEstudiantes(@PathVariable("cursoId") Long cursoId, @RequestBody Set<Long> estudianteIds){
        curso cursoActualizado = cursoService.asignarEstudiante(cursoId, estudianteIds);
        return ResponseEntity.ok(cursoActualizado);
    }
}
