package net.estudios.CollectionJava;

public class Node<T> {
     T data;
     Node<T> next;

    // creamos el constructor
    public Node(T data){
        this.data = data;
        this.next = null;
    }
}
