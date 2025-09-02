package Actividad4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Productos p1 = new Productos("Notebook", "1234", "Dell", 1500.0);
        Productos p2 = new Productos("Smartphone", "5678", "Samsung", 800.0);

        ProductosRecord r1 = new ProductosRecord(p1.getCodigo(), p1.getNombre(), p1.getPrecio());
        ProductosRecord r2 = new ProductosRecord(p2.getCodigo(), p2.getNombre(), p2.getPrecio());


        List<ProductosRecord> listaRecords = new ArrayList<>();
        listaRecords.add(r1);
        listaRecords.add(r2);

        System.out.println("Lista de Productos");
        for (ProductosRecord r : listaRecords) {
            System.out.println(r);
        }
    }
}
