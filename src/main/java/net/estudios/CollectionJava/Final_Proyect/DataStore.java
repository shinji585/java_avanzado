package net.estudios.CollectionJava.Final_Proyect;

import java.util.*;
import java.util.stream.Collectors;

public class DataStore<K,T>{
    // creamos una lista para almacenar los datos y un mapa para buscar dichos datos
    private final Map<K,T> buscarDatos;

    // creamos el constructor
    public DataStore(){
        // inicializamos las colecciones  con sus tipos
        this.buscarDatos = new HashMap<>();
    }

    // creamos los metodos
    public void add(K key,T item){
        if (buscarDatos.containsKey(key)){ throw new IllegalArgumentException("The key already exists");}
        // en caso contrario agregamos el elemento a el mapa
        buscarDatos.put(key, item);
      }

      public void remove(K key){
        if (!buscarDatos.containsKey(key)){ throw  new IllegalArgumentException("The key doen't exists");}

        // si la clave esta contenida entonces lo que hacemos es eliminarla utilizando el metodo remove
          buscarDatos.remove(key);
      }

      public T find(K key){
        if (buscarDatos.containsKey(key)){
            return  buscarDatos.get(key);
        }
        return  null;
      }

      public List<T> getAllValues(){
          return buscarDatos.values().stream()
                .collect(Collectors.toList());
      }

      public List<K> getAllKey(){
        return ((List<K>) buscarDatos.keySet().stream().collect(Collectors.toList())).reversed();
      }
}
