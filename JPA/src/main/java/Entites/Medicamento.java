package Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicamentos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class Medicamento extends Base {
    private String nombre;
    private String droga;
    private int pesoEnGramos;

    //relacion con paciente
    @ManyToMany(mappedBy = "medicamentos")
    private List<Paciente> pacientes = new ArrayList<>();

}
