package net.estudios.ModeladoDatos;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Utility {


    // creamos un logger
    static final Logger LOGGER = Logger.getLogger(Utility.class.getName());
    // creamos un metodo que reciba un String y lo convierta a una lista y no lo devuelva
    @NotNull
    public static List<String> toString_List(@NotNull String word){
        String[] wordArray = word.split(" ");
        // retornamos la lista
        return Arrays.asList(wordArray);
    }

    // crear un metodo que recorra el json y me devuelva una lista de las palabras que este contiene
    @NotNull
    public static  List<String> dataSetWord(){
        // obtenemos la ruta mediante el nombre del json
        Path jsonRUta = Paths.get("src/main/java/net/estudios/ModeladoDatos/Dataset.json");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (Reader reader = Files.newBufferedReader(jsonRUta)){
            // deserializamos el json a la clase de datasetSpam
            DatasetSpam datasetSpam = gson.fromJson(reader,DatasetSpam.class);

            // ahora al ser el datasetSpam una clase con una tributo de lista podemos retornarlo
            return  datasetSpam.getSpam();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // algoritmo para contar la cantidad de palabras en una cadena
    public static int cantidadPalabras(@NotNull String palabra){
        String palabra_SIN_espacios = palabra.trim();
        // dividmimos la cadena por una o mas espeacios en balanco y contamos
        String[] palabras = palabra_SIN_espacios.split("\\s");
        return  palabras.length;
    }

    @Nullable
    public static String to_String(Object valor){
        try{
            if (valor instanceof  String){
                return  (String) valor;
            }
            LOGGER.warning("No se pudo hacer el casting de la variable notificar al sistema");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return  null;
    }

    // ahora despues de validar que los datos sean instancia del el record la siguiente parte es verificar desde el json que los datos
    // no esten en el clasificacion de palabras
    public static  boolean verificarDatos(String palabra_verificar){
        // osea lo que tengo que verificar es si la palabra ingresada coincide con la lista
        List<String> palabras_prohibidas = Utility.dataSetWord(); // obtenemos las palabras

        // luego obtenemos la logitdu de las palabra
        int longitud_palabra = Utility.cantidadPalabras(Objects.requireNonNull(Utility.to_String(palabra_verificar)));


        // luego de obtener la longitud de la palabra podemos ahora hacer la comparacion y busqueda si hay spam
        for (String palabra: palabras_prohibidas){
            if (palabra_verificar.equalsIgnoreCase(palabra)){
                    return  true;
            }
        }
        return  false;
    }

    // ahora despues de obtener las palabras y que estos nos devuelvan un estado el ultimo paso seria crear un metodo que verificar los segun los tipos
    @org.jetbrains.annotations.Unmodifiable
    @NotNull
    public static List<Caracteristicas<String,Integer>> buscarCoincidencias(String corre_valuar){
        // ok convertirmos el correo a una lista
        List<String> dataSet = Utility.toString_List(corre_valuar);

        // despues obtenemos la cantidad de palabras del correo
        int correo_longitud = Utility.cantidadPalabras(corre_valuar);

        // comenzamos a realizar las compraciones en un bucle
        int i = 0;
        for (String palabra: dataSet){
            // creamos un contador de coincidencia
            if (Utility.verificarDatos(palabra)){
                i++; // aumentamos el contador
            }
        }
        // luego de haber realizando todas las comparaciones obtenemos unas metricas de palabras que
        Caracteristicas<String,Integer> dato1 = new Caracteristicas<>("CantidadPalabras",correo_longitud);
        // ahora pasamos el numero de palabras que no coinciden
        Caracteristicas<String,Integer> dato2 = new Caracteristicas<>("CantidadCoincidencia",i);

        return  List.of(dato1,dato2);
    }
}
