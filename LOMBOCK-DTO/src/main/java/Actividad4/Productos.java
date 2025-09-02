package Actividad4;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Productos {
    private String nombre;
    private String codigo;
    private String proveedor;
    private double precio;

    public Productos(String nombre, String codigo, String proveedor, double precio) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "nombre='" + nombre + '\'' +
                ", codigo='" + codigo + '\'' +
                ", proveedor='" + proveedor + '\'' +
                ", precio=" + precio +
                '}';
    }


}
