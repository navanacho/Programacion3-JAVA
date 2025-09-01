package Actividad3;

import java.util.Objects;

public class Producto {
    private String codigo;
    private String descripcion;

    public Producto(String descripcion, String codigo) {
        this.descripcion = descripcion;
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Producto{codigo" + codigo + ", descripcion=" + descripcion + "}";
    }
}
//