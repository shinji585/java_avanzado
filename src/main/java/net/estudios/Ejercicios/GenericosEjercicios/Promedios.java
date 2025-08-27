package net.estudios.Ejercicios.GenericosEjercicios;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class Promedios {

    // calculadora de estadisticas generica
    public static double calcularPromedio(@NotNull List<? extends Number> numbers){
        // recorremos la lista
        double sumar_valores = 0;
        for (Number number: numbers){
            // por cada valor lo almacenamos en una variable
            sumar_valores += number.doubleValue();
        }
        // retornarmos el promedio
        return  (double) sumar_valores / numbers.size();
    }

    public static void main(String[] args) {
        List<Integer> valores = Arrays.asList(1,2,3,4,5);

        // calculamos el promedio
        System.out.println("El promedio de la lista -> " + valores + " es -> " + calcularPromedio(valores));
    }
}
