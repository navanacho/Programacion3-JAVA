package Actividad3;

public class Producto {
    private String nombre;
    private int codigo;
    private double precio;
    private String autor;

    public Producto(){}

    public Producto(String nombre, int codigo, double precio, String autor) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
