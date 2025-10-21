package org.example.cursos.controllers;

import org.example.cursos.DTO.crearCurso;
import org.example.cursos.entities.curso;
import org.example.cursos.service.ICursosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cursos")
public class cursoController {
    private final ICursosService cursoService;
    public cursoController(ICursosService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<curso> listar(){
        return cursoService.listarCursos();
    }

    @PostMapping
    public ResponseEntity<curso> crear(@RequestBody crearCurso request){
        curso c = cursoService.crearCursoConProfesor(request.getNombre(), request.getProfesor());
        return ResponseEntity.ok(c);
    }

    @PostMapping("/{cursoId}/estudiantes")
    public ResponseEntity<curso> asignarEstudiantes(@PathVariable("cursoId") Long cursoId, @RequestBody Set<Long> estudianteIds){
        curso c = cursoService.asignarEstudiante(cursoId, estudianteIds);
        return ResponseEntity.ok(c);
    }
}
