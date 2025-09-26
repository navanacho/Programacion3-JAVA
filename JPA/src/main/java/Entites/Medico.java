package Entites;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Medico extends Base {
    private String nombre;
    private String apellido;
    private int edad;
    private String especialidad;
    private String matricula;

    //relacion con consultas
    @OneToMany (mappedBy = "medico", cascade = CascadeType.ALL)
    private List<Consulta> consultas = new ArrayList<>();

    @Override
    public String toString(){
        return "Medico " + nombre + " " + apellido + " edad: " + edad + " Especialidad: " + especialidad + " Matricula: " + matricula;
    }
}
