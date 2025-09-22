package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas;

import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class InterfacesSimplificadoras {

    static Scanner sc = new Scanner(System.in);

    public static void simplificar(int numero,int a1,int b1){
        /*
         * existen unas interfaces que nos permiten simplificar el codigo de function<T,R> y Bifunction<T,T,R> la cual recibe dos parametros y retorna un tipo
         * 
         * estas interfaces son: UnaryOperator<T> el cual es una especializacion de Function<T,R> es decir que el mismo parametro T es el mismo que esta retorna
         * 
         * 
         * la otra interfaz viene siendo BinaryOperator<T> es una especializacion de Bifunction<T,T,R> es decir recibe dos valores del mismo tipo y devuelve un valor del mismo tipo 
         */


         // ejemplo 
         UnaryOperator<Integer> cuadrado = x -> x*x;
         System.out.println("numero al cuadrado: " + cuadrado.apply(numero));
         BinaryOperator<Integer> suma = (a,b) ->  a+b; 
         System.out.println("suma: " + suma.apply(a1, b1));
    }


    public static void main(String[] args) {
        simplificar(10, 15, 25);
    }
    
}
