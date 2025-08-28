package net.estudios.Ejercicios.GenericosEjercicios;

import java.util.ArrayList;
import java.util.List;

public record AnalizadorTendencias<T extends  Number & Comparable<T>>(String nombre, T valor) {
    public  List<T> encontrarPicos(List<? extends AnalizadorTendencias<T>> valores){
       // ahora tengo que entender lo que queremos hacer
        List<T> listaValores = new ArrayList<>();
        for (AnalizadorTendencias<T> valor: valores){
            // recorro la lista de valores y obtengo su valor y lo guardo en la listaValores
            listaValores.add(valor.valor());
        }
        return listaValores;
    }
}
