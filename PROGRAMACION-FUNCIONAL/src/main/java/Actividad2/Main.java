package Actividad2;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.groupingBy;

public class Main {
    public static void main (String[] args){
        List<Alumno> alumnos = List.of(
                new Alumno("Ana", 8.5, "Historia"),
                new Alumno("Pedro", 6.0, "Mattematica"),
                new Alumno("Juan", 9.5, "Matematica"),
                new Alumno("Laura", 7.1, "Fisica"),
                new Alumno("Pablo", 5.5, "Historia"),
                new Alumno("Carla", 9.2, "Fisica"),
                new Alumno("Nacho", 10, "Historia")
        );
        //mostrar aprobados
        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Aprobados: " + aprobados);
        //mostrar promedio de notas
        double promedio = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0);
        System.out.println("Promedio: " + promedio);
        //agrupar alumnos por curso
        Map<String, List<Alumno>> porCurso = alumnos.stream()
                .collect(groupingBy(Alumno ::getCurso));

        porCurso.forEach((curso, lista) ->
                System.out.println(curso + ": " + lista));

        //mejores 3 promedios
        List<Alumno> top3 = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3: " + top3);
    }
}
