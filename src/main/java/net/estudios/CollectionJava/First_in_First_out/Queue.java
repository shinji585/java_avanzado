package net.estudios.CollectionJava.First_in_First_out;

import java.util.LinkedList;
import java.util.List;

public class Queue<E> {
    private final LinkedList<E> linkedList;

    // creamos el constructor
    public Queue(List<E> element){
        this.linkedList = new LinkedList<>(element);
    }

    // creamos los metodo
    public void enqueue(E element){
       this.linkedList.addLast(element);
    }
    public E dequeue(){
         if (this.linkedList.isEmpty()){
             throw  new IllegalArgumentException("Warning the queue is empty");
         }
         // si no esta vacio retonramos el elemento
        return  this.linkedList.remove();
    }
    public E peek(){
        if (this.linkedList.isEmpty()){
            throw  new IllegalArgumentException("Warning the queue is empty");
        }
        return  this.linkedList.getFirst();
    }

    public int size(){
        return  this.linkedList.size();
    }

    public void print(){
        for (E valor: this.linkedList){
            System.out.println(valor);
        }
    }
}
