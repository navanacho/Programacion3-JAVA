package Actividad1;

public class Main {
    public static void main(String[] args){
        Persona p1 = new Persona("Nacho", 25);
        System.out.println("Nombre: " + p1.getNombre() + ", Edad: " + p1.getEdad());

        Persona p2 = new Persona();
        p2.setNombre("Ana");
        p2.setEdad(30);
        System.out.println("Nombre: " + p2.getNombre() + ", Edad: " + p2.getEdad());
    }
}
