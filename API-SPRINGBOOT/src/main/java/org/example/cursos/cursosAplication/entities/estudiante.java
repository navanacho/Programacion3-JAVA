package org.example.cursos.cursosAplication.entities;
import jakarta.persistence.*;
import lombok.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(unique = true)
    private String matricula;

    @ManyToMany(mappedBy = "estudiantes")
    private Set<curso> cursos;
}
