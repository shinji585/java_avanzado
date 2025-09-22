package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas;


import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

public class Ejercicio2 {

    
     /*
      * en geometria la distancia euclidiana entre dos puntos en 2D se calcula utilizando la combinacion entre dos puntos (x1,y1) y (x2,y2) de la forma raiz cuadrada de (x2-x1)^2 + (y2-y1)^2
      */


     public static void showData(){
        // creamos un objecto de tipo point 
        Point<Integer> puntos1 = new Point(0, 0);
        Point<Integer> punto2 = new Point(3, 4); 

        // ahora si creamos la bifuction
        BiFunction<Point<Integer>,Point<Integer>,Double> euclideDistance = (a,b) -> Math.sqrt(Math.pow(b.getValue1() - a.getValue1(), 2) + Math.pow(b.getValue2() - a.getValue2(), 2));


        // ok ok ahora ya con los valores aplicamos lo que viene siendo la formula de calcular la distnacia de euclides 
        System.out.println("la distancia entre los puntos: " + puntos1.valoresReturn() + " y " +  punto2.valoresReturn() + " esta dada por: " + euclideDistance.apply(puntos1, punto2));
     }
    

     public static void main(String[] args) {
        showData();
     }
} 



@AllArgsConstructor
@Getter
@Setter
class Point<T>{
   T value1; // x
   T value2; // y
   
   public List<T> valoresReturn(){
        return Arrays.asList(this.value1,this.value2);
   }
}