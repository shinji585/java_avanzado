package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Functional {
  
    /*
     * en esta seccion se estara estudiando la interfaz funcional Functional<T,R> y cuales son sus usos
     * 
     * la interfaz funcional Function<T,R> toma un valor de entrada y aplica una funcion de tipo R retornando R y dandonos como resultado lo que viene siendo el resultado de la funcion esta es sencilla de aplica y la veremos en un ejemplo 
     */

     public static int lenghtString(String word){
        // nuestra tarea aqui es tomar lo que viene siendo un word y devolver lo que viene siendo su longitud pero utilizando programacion funcional 
        Function<String,Integer> lenght = String::length;

        return lenght.apply(word);
     }

     // estudio de bifunction<T,U,R> esta interfaz funcional es la extension de lo que viene siendo function pero con la diferencia que se utiliza para cuando tenemos dos parametros y queremos retornar un unico valor 

     static BiFunction<Integer,Integer,Integer> division = (a,b) -> a/b;
     
     public static  void aumentarDIvision(){
          Function<Integer,Integer> mensaje = (a) ->  a*2;
          
          System.out.println("entre 10 y 5 y obtenemos: " + division.andThen(mensaje).apply(10, 5));
     }

    public static void main(String[] args) {
         // aplicamos lo que viene siendo la funcion a una tarea en especifica 

         System.out.println("La longitud de la palabra 'Hola mundo' es: " + lenghtString("Hola mundo"));

         // otra forma de hacer esto y muestra de que se utiliza function por debajo es en map 

         Map<String,Integer> lenght = new HashMap<>();

         System.out.println("La longitud de la palabra 'Hola mundo' es: " + lenght.computeIfAbsent("Hola mundo", String::length));
         // no sabia que map tuviera ese metodo y ese uso cuantos problemas pude haber resulto mas rapido con el 



         // uso the andthen
         Function<Integer,Double> funcionCompuesta = reducidor.andThen(multiplicador);

         System.out.println("Funcion compuesta: " + funcionCompuesta.apply(20));

         aumentarDIvision();
    }
    /*
     * analizando los metodos de function<T,R>: 
     *   1/ R apply(T t) aplica la funcion a un valor de entrada y devuelve la salidad 
     * 
     *   2/ andthen es un metodo o funcion que primero aplica la funcion que la llama y luego la que viene despues 
     */

     // ejemplo the andthen 
     static Function<Integer,Number> reducidor = (a) -> a/2;
     static Function<Number,Double> multiplicador = (a) -> a.doubleValue()*5;

     // entonces para que quede claro andthen ejecuta la funcion actual y luego la que pasas como argumento
     // compose ejecuta la funcion que pasas como argumento y luego la actual 
}
