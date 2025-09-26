package Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Entity
@Table(name = "consulta")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Consulta extends Base{
    private LocalDate fecha;
    private String diagnostico;

    //relacion con paciente
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    //relacion con medicos
    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

    @Override
    public String toString(){
        return "Consulta fecha: " + fecha + " Diagnostico: " + diagnostico;
    }
}
