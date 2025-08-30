package net.estudios.CollectionJava;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Vector;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class Stack<E>{
    // vamos a utilizar todo lo que se de poo en este ejemplo
    private Queue<E> elementos;
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(java.util.Stack.class));
    // creamos un inicializador del vector
    public  Stack(){
        this.elementos = new ArrayDeque<>();
    }

    // creamos el metodo push el cual recibe un elemento y lo agrega a el la stack
    public void push(E element){
        this.elementos.add(element);

        // actualizamos la lista
        int size = this.sizeStack();
        // recorremos la pila y actualizamos los elementos
        for (int i = 0; i < size-1; i++) {
          E temporal = this.elementos.remove();
          // agramos los elementos removidos temporalmente a la ultima posicion
            this.elementos.add(temporal);
        }
    }

    // creamos el metodo remove
    public E pop(E element){
        if (this.elementos.isEmpty()){
            LOGGER.warning("La pila esta vacia: No se puede hacer pop.");
            return  null;
        }
         return  this.elementos.remove();
    }

    // creamos un metodo para saber su tamaño
    public int sizeStack(){
        return  this.elementos.size();
    }

    // retornamos el elemento mas a la cima
    public E peek(){
        if (this.elementos.isEmpty()){
           LOGGER.warning("La pila esta vacia: No se puede hacer peek");
           return  null;
        }
        return  this.elementos.peek();
    }


    public boolean isEmptyStack(){
        return  this.elementos.isEmpty();
    }

    // creamos un metodo para recorrer todos los elementos
    public void forEach(){
        Consumer<E> mostrarElementos = System.out::println;
        this.elementos.forEach(mostrarElementos);
    }

    public static void main(String[] args) {
        Stack<Integer> elementos = new Stack<>();

        // agregamos elementos
        List<Integer> numeros = List.of(1,2,3,4,5,6,7);
        for (Integer elemento: numeros){
            elementos.push(elemento);
        }

        elementos.forEach();

        int elemento =   elementos.peek();
        System.out.println("El primer elemento primero en salir es -> " + elemento);
    }
}
