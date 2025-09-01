package Actividad3;

import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        HashSet<Producto> productos = new HashSet<>();
        productos.add(new Producto("Ordenador", "001"));
        productos.add(new Producto("Portatil", "002"));
        productos.add(new Producto("Ordenador gamer", "001"));//duplicado

        for (Producto producto: productos) {
            System.out.println(producto);
        }
    }
}
//