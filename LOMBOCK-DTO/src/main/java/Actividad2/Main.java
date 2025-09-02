package Actividad2;

public class Main {
    public static void main(String[] args){
        Usuario u1= Usuario.builder()
                .id(1)
                .nombre("Juan")
                .email("juan@gmail.com")
                .build();
        System.out.println("ID: " + u1.getId() + ", Nombre: " + u1.getNombre() + ", Email: " + u1.getEmail());
    }
}
