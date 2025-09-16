package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ejercicio3 {
    /*
     * la prediccion lineal simple se define como un modelo lineal basico de la forma y = m*x+b 
     * 
     * tarea: definir un bifunction que dado un m y b devuelva una funcion que prediga y en base a x 
     */


     public static void showData(){
        BiFunction<Double,Double,Function<Double,Double>> modeloLineal = (a,b) ->  (x -> a*x + b);
        

        Function<Double,Double> recta = modeloLineal.apply(10.5, 3.5); 
        
        System.out.println("resultado para 3.5: " + recta.apply(3.5));
        System.out.println("recta para 10.5: " + recta.apply(10.5));


     }
     public static void main(String[] args) {
        showData();
     }
}