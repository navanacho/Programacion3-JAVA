package Entites;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@MappedSuperclass
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor

public abstract class Base {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //cuando se crea una clase se queda l valor por defecto (false)
    @Builder.Default
    private Boolean eliminado = Boolean.FALSE;


    public void eliminar(){
        this.eliminado = true;
    }
}
