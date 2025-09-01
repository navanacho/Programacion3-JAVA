package Actividad4;

import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void main(String[] args) {
        HashMap<String, Curso> cursos = new HashMap<>();
        cursos.put("001", new Curso("Matematicas", "Juan Perez"));
        cursos.put("002", new Curso("Fisica", "Maria Gomez"));
        cursos.put("003", new Curso("Quimica", "Carlos Lopez"));

        //recuperar curso por codigo
        String codigoBuscado = "002";
        Curso cursoBuscado = cursos.get(codigoBuscado);
        System.out.println("Curso con codigo " + codigoBuscado + ": " + cursoBuscado);

        for (Map.Entry<String, Curso> entry : cursos.entrySet()) {
            System.out.println("Codigo: " + entry.getKey() + ", " + entry.getValue());
        }
    }
}
//
