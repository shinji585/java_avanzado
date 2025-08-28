package net.estudios.CollectionJava;

public class LikendlistGenerica<T> {
    // creamos un nodo
    private Node<T> head;

    // creamos el constructor
    public  void add(T data){
        Node<T> newNode = new Node<>(data);
        // recibe una data lo que tenemos que hacer para que este metodo agrega datos a el nodo
        if (head == null){
            head =  newNode;
        }else{
            // en el caso contrario buscamos
            Node<T> current = head;
            while (current.next != null){
                // buscamos nos movemos hasta el ultimo valor
                current = current.next;
            }
            // cuando estemos a en el final estaremos en la ultima posicion y guaramos el valor y la referencia
            current.next = newNode;
        }
    }

    public void update(int position,T data){
        Node<T> current = head;
        // recorremos  y inicializamos un contador
        int count = 0;
        while (current != null && count < position){
               current = current.next; // mientras el valor no sea nulo aumenta y aumenta el contador
               count++;
        }
        // y verificamos si el valor es igual a la posicion
        if (count == position){
            // verificamos que el nodo actual no sea null
            if (current == null){
                throw  new IllegalArgumentException("Warning: we couldn't found the argument");
            }else {
              // actualizamos la data
              current.data = data;
            }
        }
    }

    public void foreach(){
        Node<T> current = head;
        while (current != null){
            // mostramos el valor
            System.out.println(current.data);
            current = current.next;
        }
    }

    public static void main(String[] args) {
        LikendlistGenerica<String> nombres = new LikendlistGenerica<>();
        // le pasamos datos
        nombres.add("samuel");
        nombres.add("sebastian");
        nombres.add("santiago");


        nombres.foreach();

    }
}
