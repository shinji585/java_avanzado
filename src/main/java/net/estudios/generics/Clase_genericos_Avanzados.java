package net.estudios.generics;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Clase_genericos_Avanzados {
    /*
    en esta seccion se estaran estudiando los wildcards que se clasifican en dos tipos
    por un lado encontramos ? extends y por el otro encontramos ? super


    los wildcards son un caso especial de genericos nos permite extender de ciertos tipos para poder realizar acciones de un consumer
    y ademas nos permite realizar manipulacion de ellos pero cada uno es de forma diferente

    por ejemplo: para permitir la entrada de cualquier tipo de datos en objectos de tipos genericos el wildcards princiapl que se puede y tiene que utilizar es ?
     */
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        List<Integer> valores = List.of(1,2,3,4,5,6);
        numbers.addAll(valores);

        // realizamos las acciones
        showList(numbers);

        showListInteger(numbers);

        manipulateList(numbers);






    }

    public static void showList(@NotNull List<?> valores){
        // le decimos a el compilador que la lista puede recibir cualquier valor y que ella no sabe que valores esta recibiendo
        // apartir de esto podemos crear acciones genericas y al no saber el tipo hay que tener en cuenta que los valores extiendes es de object
        for (Object o: valores){
            System.out.println("Valor: " + o);
        }
    }

    // para restringir acciones podemos hacer
    public static void showListInteger(@NotNull List<? extends  Integer> valores){
        // ahora al ser de tipo integer podemos realizar acciones unicamente para los numeros
        // por ejemplo podemos verificar que este sea de tipo integer si no que lance una exceptio
        for (Object valor: valores){
            if (valor instanceof  Integer){
                System.out.println("number: " + valor);
            }else{
              throw  new IllegalArgumentException("los tipos no coinciden");
            }
        }
        // este ejemplo es muy estricto por lo que se piernde abstraccion de ciertas cosas incluso esta hasta mal
    }

    // ahora estos metodos estan excelentes por que uno manipula datos sin saber sus tipos y el otro de un tipo especifico pero hay un problema
    // y es que estos tipos de wildcards no nos permiten realizar acciones sobre

    // para realizar acciones sobre unos valores utilizando wildscards debemos de implementar un objecto en concreto no una interface como Number
    // y ademas de eso debemos que tener es que esto es lo contrario de los extends por lo que no podemos realizar sus acciones
    public static void manipulateList(@NotNull List<? super Integer> numbers){
        int promedio = 0;
        for (Object valor: numbers){ // no abstrae el tipo como tal de la lista por lo que tenemos que inferir
            // por ejemplo sumamos
            if (valor instanceof  Integer){
                // calculamos el promedio por ejemplo y lo almacenamos en la misma lista
                promedio += (Integer) valor;
            }
        }
        // realizamos el calculo del promedio
        promedio += promedio / numbers.size();

        numbers.add(promedio);

        // mostramos el valor
        System.out.println(numbers.getLast());
    }



    // los comodines de limites superiores son todos aquellos que tienen la estructura ? extends
    // los comodines de limites inferiores son todos aquellos que tienen la estructrua ? super
}
