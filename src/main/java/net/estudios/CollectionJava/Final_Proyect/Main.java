package net.estudios.CollectionJava.Final_Proyect;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        DataStore<UUID,String> dataStore = new DataStore<>();

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese un nombre: ");
            String nombre = s.nextLine();

            Persona persona = new Persona(UUID.randomUUID(),nombre);


            // el id se genera de forma automatica
            dataStore.add(persona.id(),persona.nombre());
        }

        // finalizado el ciclo aplicamos los metodos desarrolados
        System.out.println("las keys disponibles son: " + dataStore.getAllKey());
        System.out.print("Ingrese un nombre para ver si se encuentra en la lista: ");
        String nombre_Encontrar = s.nextLine();

        System.out.println("el nombre encontrado en la key es "  + dataStore.find(UUID.fromString(nombre_Encontrar)));

        // utilizamos el metodo remove
        System.out.print("En funcion de los ID presentado elimine uno: ");
        String eliminar = s.nextLine();

        dataStore.remove(UUID.fromString(eliminar));

        System.out.println(dataStore.getAllValues());




    }
}
