package org.example.cursos.cursosAplication.DTO;
import lombok.*;
import org.example.cursos.cursosAplication.entities.profesor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class crearCurso {
    private String nombre;
    private profesor profesor;
}
