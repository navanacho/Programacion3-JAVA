package Actividad2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("Juan", 85));
        alumnos.add(new Alumno("Ana", 92));
        alumnos.add(new Alumno("Juan", 78)); //duplicado permitido

        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }
}
//