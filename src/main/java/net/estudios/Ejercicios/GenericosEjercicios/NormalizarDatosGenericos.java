package net.estudios.Ejercicios.GenericosEjercicios;

import java.util.*;

public class NormalizarDatosGenericos {
    // para este problema tengo que crear un metodo que normalize los datos y que reciba dos listas parametrizadas
    // en teoria tenemos que retornar la lista de salida?
    public static List<? super Double> normalizadorDatos(List<? extends Number> datos){
       if (datos.isEmpty()) return null;

        // buscamos los valores maximos y minimos
        List<? super Double> valores_salida = new ArrayList<>();
        double min =  datos.getFirst().doubleValue();
        double max =  datos.getFirst().doubleValue();
        for (Number dato: datos){
            if (dato.doubleValue() < min){
                // ahora el valor min toma el valor del que viene para buscar su valor minimo
                min = dato.doubleValue();
            }
            if (dato.doubleValue() > max){
                // aumentamos para ver si el maximo esta mas arriba
                max = dato.doubleValue();
            }
            // luego de obtener los valores aplicamos la formula
        }

        for (Number dato2: datos){
            valores_salida.add(formula(min,max,dato2.doubleValue()));
        }
        // retornamos la lista
        return  valores_salida;
    }

    public static double formula(double min,double max,double value){
        return  (value - min)/(max-min);
    }

    public static void main(String[] args) {
        List<Integer> datosEntrada = Arrays.asList(10, 20, 30, 40, 50);

        // datos decimales
        List<Double> datosEntradaDecimales = Arrays.asList(5.5, 12.0, 8.8, 15.1, 2.3);

        List<? super Double> resultadosInt = normalizadorDatos(datosEntrada);

        List<? super Double> resultadosDouble = normalizadorDatos(datosEntradaDecimales);


        System.out.println("Resultados");
        System.out.println(resultadosInt);
        System.out.println(resultadosDouble);
    }
}
