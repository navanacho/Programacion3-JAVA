package Actividad3;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import static java.util.Collections.list;
import static java.util.stream.Collectors.*;

public class Main {
    public static void main(String[] args){
        List<Producto> productos = List.of(
                new Producto("Monitor", "Electrónica", 150, 10),
                new Producto("Teclado", "Electrónica", 50, 25),
                new Producto("Silla", "Muebles", 200.20, 5),
                new Producto("Mesa", "Muebles", 300.5, 2),
                new Producto("Lámpara", "Iluminación", 120.0, 12)
        );

        //productos precio mayor a 100 ordenados de forma descendente
        List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());
        System.out.println("Productos con precio mayor a 100 (ordenados): " + caros);
        //agrupar productos por categoria y calcular stock
        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(groupingBy(
                        Producto ::getCategoria,
                        summingInt(Producto :: getStock)
                ));
        System.out.println("Stock total por categoria: " + stockPorCategoria);
        //generar strin con nombre y precio separados por ;
        String listado = productos.stream()
                .map(p -> p.getNombre() + " $" + p.getPrecio())
                .collect(Collectors.joining("; "));
        System.out.println("Listado: " + listado);
        //calcular pormedio general y por categoria
        double promedioGeneral = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0);
        System.out.println("Promedio general: " + promedioGeneral);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(groupingBy(
                   Producto::getCategoria,
                   averagingDouble(Producto::getPrecio)
                ));
        System.out.println("Precio promedio por categoria: " + promedioPorCategoria);
    }
}
