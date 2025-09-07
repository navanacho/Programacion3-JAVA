package Actividad2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) throws Exception{
        Class<?> clase = Persona.class;

        System.out.println("contructores de persona");
        for (Constructor<?> constructor : clase.getDeclaredConstructors()){
            System.out.println(constructor);
        }

        //instancias con reflection
        Constructor<?> constructor = clase.getDeclaredConstructor(String.class, int.class);
        Object persona = constructor.newInstance("ignacio", 25);

        //modificar en tiempo de ejecucion
        Field campoNombre = clase.getDeclaredField("nombre");
        campoNombre.setAccessible(true);
        campoNombre.set(persona, "juan");

        //invocar metodo mostrarinfo
        Method metodoMostrarInfo = clase.getDeclaredMethod("mostrarInfo");
        metodoMostrarInfo.invoke(persona);

        //modificar encapsulamieno de saludar
        Method metodoSaludar = clase.getDeclaredMethod("saludar");

        int modifiers = metodoSaludar.getModifiers();
        System.out.println("antes: " + Modifier.toString(modifiers));
        metodoSaludar.setAccessible(true);
        System.out.println("despues: private");
        String saludo = (String) metodoSaludar.invoke(persona);
        System.out.println("Metodo saludar: " + saludo);


    }
}
