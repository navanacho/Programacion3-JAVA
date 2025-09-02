package Actividad3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Producto p1 = new Producto("Mnazana", 123, 29.99, "Carlos");
        Producto p2 = new Producto("Banana", 321, 30.3, "Juan");

        ProductoDto dto1 = new ProductoDto();
        dto1.setCodigo(155);
        dto1.setNombre("Pera");
        dto1.setPrecio(15.5);

        ProductoDto dto2 = new ProductoDto();
        dto2.setCodigo(654);
        dto2.setNombre("Uva");
        dto2.setPrecio(20.0);

        List<ProductoDto> listaDTO = new ArrayList<>();
        listaDTO.add(dto1);
        listaDTO.add(dto2);

        System.out.println("Lista de Productos");
        for (ProductoDto dto : listaDTO) {
            System.out.println("Codigo: " + dto.getCodigo() + ", Nombre: " + dto.getNombre() + ", Precio: " + dto.getPrecio());
        }
    }
}
