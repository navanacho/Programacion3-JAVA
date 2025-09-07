package Actividad4;

import java.util.List;

public class testGenericos {
    public static <T> void imprimiLista(List<T> lista){
        for(T elemento : lista){
            System.out.println(elemento);
        }
    }
}
