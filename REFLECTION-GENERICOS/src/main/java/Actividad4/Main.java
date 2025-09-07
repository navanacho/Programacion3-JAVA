package Actividad4;

import java.util.Arrays;
import java.util.List;
import static Actividad4.testGenericos.imprimiLista;

public class Main {
    public static void main(String[] args){
        //lista de enteros
        List<Integer> listaEnteros = Arrays.asList(10,20,30,40,50);
        System.out.println("Lista de enteros:");
        imprimiLista(listaEnteros);

        //lista de cadenas
        List<String> listaCadenas = Arrays.asList("Hola", "Mundo", "Genericos");
        System.out.println("Lista de cadenas:");
        imprimiLista(listaCadenas);
    }
}
