package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.*;;

public class PredicatePractice {
    /*
     * la interfaz predicate nos sirve para validar elementos esta nos devuelve un boolean es decir   puede ser true o false y unicamente tenemos que pasarle un valor de entrada
     */



     public static void practicePredicate(){
        // la interfaz predicate recibe un valor y nos devuelve un boolean 
        Predicate<String> validarString = (a) -> a instanceof String;

        System.out.println("la palabra 'hola' es string?: " + validarString.test("hola"));
        System.out.println("el numero 15 es string?: " + validarString.test(Integer.toString(15)));

     }

     public static void main(String[] args) {
      practicePredicate();

      consumerPratice();
     }

     // praticare aqui mismo las otras dos interfaces 

     public static void consumerPratice(){
      // la interfaz consumer recibe un valor y esta no hace mas nada 
      Consumer<String> print = System.out::println; // imprime con salto de linea 

      print.accept("hola mundo");


      List<Integer> numeros = supplierGet(()-> new ArrayList<>());
      Random random = new Random();

      for (int i = 0; i <= random.nextInt(100); i++){
          numeros.add(i);
      }

      System.out.println(numeros);
      }



      // la interfaz supplier se puede pensar como un creador de objectos cada vez que le solicitemos un objecto esta nos devuelve un objecto 
      public static <T>  T supplierGet(Supplier<T> supplier){
         return supplier.get();
      }
}
