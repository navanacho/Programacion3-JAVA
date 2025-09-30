package Entites;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "historiClinica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@ToString
public class HistoriaClinica extends Base{
    private String descripcion;

    //relacion con paciente
    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
