package net.estudios.MVC.Proyecto.Model.Util;


import java.time.Instant;
import java.util.Random;


// algoritmo para generar iD 
public class GenerateID {

    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int ID_LENGTH = 10;
    private static long tansCounter = 0;

    // creo un metodo que construya numeros en strings
    public static String genereTaskID() {
        tansCounter++;
        long sequentialID = tansCounter;

        // contamos el tiempo
        long timestamp = Instant.now().toEpochMilli();

        // combinamos el id secuencial y el timstamp para que genere un numero
        long combinedID = Long.parseLong(String.valueOf(timestamp) + String.valueOf(sequentialID));

        Random random = new Random(combinedID);

        StringBuilder sb = new StringBuilder(ID_LENGTH);
        for (int i = 0; i < ID_LENGTH; i++){
            // obtememos el indice aleatorio del alfabeto
            int randomIndex = random.nextInt(ALPHABET.length());
            // añadimos el caracter al ID 
            sb.append(ALPHABET.charAt(randomIndex));
        }
        return sb.toString();
    }
}
