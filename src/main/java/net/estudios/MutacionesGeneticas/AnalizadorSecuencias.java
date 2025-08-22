package net.estudios.MutacionesGeneticas;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class AnalizadorSecuencias {

    @NotNull
    public static <T extends  Comparable<T>> List<Parbase<T>> analizarMutaciones(@NotNull List<T> secuenciaOriginal, List<T> secuenciaMutada){
    // valido las longitudes
        if (secuenciaOriginal.size() != secuenciaMutada.size()){
            throw new IllegalArgumentException("Las secuencias deben tener la misma longitud");
        }
        List<Parbase<T>> resultados = new ArrayList<>();
        for (int i = 0; i < secuenciaOriginal.size()-1; i++) {
            // comparamos los valores y los agregamos a resultados como si fueran una tupla
            // se crea una tupla de Parbase para despues compararla utilizando el metodo de compareTo creando en parBase
            resultados.add(new Parbase<>(secuenciaOriginal.get(i), secuenciaMutada.get(i)));
        }
        return resultados;
    }
}
