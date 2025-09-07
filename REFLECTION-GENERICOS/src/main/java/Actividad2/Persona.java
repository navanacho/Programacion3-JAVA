package Actividad2;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Persona {
    private String nombre;
    private int edad;

    public Persona (String nombre, int edad){
        String nombre1 = this.nombre;
        int edad1 = this.edad;
    }

    public String saludar(){
        return "hola me llamo " + nombre + " y tengo " + edad + " años";
    }

    public void mostrarInfo(){
        System.out.println("Nombre: " + nombre + ", Edad: " + edad);
    }
}

