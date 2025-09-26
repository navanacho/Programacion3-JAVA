package Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Paciente extends Base {
    private String nombre;
    private String apellido;
    private int edad;
    private int DNI;
    private String obraSocial;
    private LocalDate fechaNacimiento;
    private char genero;

    //relacion con consultas
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas = new ArrayList<>();

    //relacion con historia clinica
    @OneToOne (mappedBy = "paciente", cascade = CascadeType.ALL)
    private HistoriaClinica historiaClinica;

    //relacion con medicamento
    @ManyToMany
    @JoinTable (
        name = "pacientes_medicamentos",
        joinColumns = @JoinColumn(name = "paciente_id"),
        inverseJoinColumns = @JoinColumn(name = "medicamento_id")
    )
    private List<Medicamento> medicamentos = new ArrayList<>();

    @Override
    public String toString(){
        return "Paciente " + nombre + " " + apellido + " edad: " + edad + " DNI: " + DNI + " Obra social: " + obraSocial;
    }
}
