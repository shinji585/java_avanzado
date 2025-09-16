package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;



public class Ejercicio1 {

    /*
     * La funcion sigmoid convierte cualquier numero real en un valor entre 0 y 1 
     * 
     * tu tarea es implementar utilizando function<Double,Double> sigmoid y probar con los valores -1.0,0.0,1.0,2.0
     * 
     * la funcion esta dada como s(x) = 1/1+e^-x 
     * 
     */

     public static void showData(){
          Function<Double,Double> sigmoide = (a) -> 1/(1+Math.pow(Math.E, -a));

          // creamos un list de los valores que se van a utilizar 
          List<Double> values =  Arrays.asList(-1.0,0.0,1.0,2.0);

          // recorremos los valores y aplicamos la funcion en cada uno de ellos 
          values.forEach(e -> {
            System.out.println("Conversion de " + e + " a: " + sigmoide.apply(e));
          });
     }

     public static void main(String[] args) {
        showData();
     }
    
}
