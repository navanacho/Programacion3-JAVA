package org.example.cursos.DTO;
import lombok.*;
import org.example.cursos.entities.profesor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class crearCurso {
    private String nombre;
    private profesor profesor;
}
