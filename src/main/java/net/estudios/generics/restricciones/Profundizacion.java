package net.estudios.generics.restricciones;

import java.util.Comparator;
import java.util.List;

public class Profundizacion {
    /*
    en esta seccion se profundizaran en los genericos aplicados a metodos
     */

    // podemos tener metodos los cuales sean genericos sin que la clase sea generica en si
    // estos nos facilita el hecho de trabajar con tipos de datos que realizan o se les aplica una misma accion
    // un ejemplo de esto seria
    public static <T> T obtenerPrimerElemento(List<T> lista){
        if (lista == null || lista.isEmpty()){
            return  null;
        }
        return  lista.get(0);
    }

    // ahora viene podemos tener metodos que a su vez esten restringidos por una herencia dicha herencia prohibe que un metodo pueda aceptar valores de un tipo no valido
    public static <T extends Comparable<T>> T obtenerMayor(T obj1, T obj2){
        if (obj1.compareTo(obj2) > 0){
            return  obj1;
        }else{
            return  obj2;
        }
    }


    public static void main(String[] args) {
        // el metodo anterior es generico podemos tener una lista de cualquier tipo a la cual si se la pasamos a este metodo
        // nos devolveria en su lugar el primer elemenento

        List<String> nombres = List.of("santiago","sebastian","samuel");

        // el metodo nos devuelve el primer nombre

        System.out.println("el primer nombre de la lista es: " + obtenerPrimerElemento(nombres));


        // podemos tener una lista ahora o tener dos numeros y la funcion obtener mayor lo que hace es comaparar las cadenas en funcion de la interfaz comparable
        String shorWord = "Hello world";
        String longWord = "today i'll plain to make a big party at my house, do you wanna to come tonight";

        // utilizamos el metodo obtener mayor y este nos devuelve la candena que sea mayor
        System.out.println("la cadena mayor entre '" + shorWord + "' y '" + longWord + "' es -> " + obtenerMayor(shorWord,longWord));
    }
}
