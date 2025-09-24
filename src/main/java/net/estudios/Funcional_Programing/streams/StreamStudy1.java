package net.estudios.Funcional_Programing.streams;


import java.util.Arrays;

import org.apache.commons.lang3.RandomStringUtils;

public class StreamStudy1 {
    /*
     * streams: corrientes 
     * 
     * es una api que nos permite manipular o procesar colecciones de forma declarativa y funcional 
     * 
     * Teoria: una streams es una secuencia (corriente) de datos sobre la que puedes aplicar operaciones esto se puede pensar como una cita en memoria asi como lo penso turing y tenemos en cada bloque datos almacenados de tipos similares distintos o lo que sea streams lo que hace es facilitarnos la forma en que recorremos esta secuencia de datos tomando esa cinta como si fuera una corriente 
     * 
     * esta pensando para procesar colecciones (pero no solo: arrays, i/o, etc)
     * 
     * este funciona con el modelo pipeline  en el cual se basa en 3 etapas: fuente (collections), operaciones intermedias (transforman el streams) pero no producen un resultado final inmediato
     * operaciones terminales (cierra el streams y devuelve un resultado concreto)
     */
  public static void main(String[] args) {
    tryArrays();
  }  

  /*
   * vayamos por etepas para estudiar esto primero vamos a estudiar lo que viene siendo la fase uno que es la fuente y para ello se utilizara Arrays  que es un tipo que nos permite manipular datos 
   * 
   * Arrays: clase utilitaria que nos permite manipular arrays tanto unidimnesional como bidimensionales 
   * 
   * este contiene metodos como:
   * Arrays.sort(array) -> el cual ordena un array (numero o de objectos que implemente Comparable) 
   * 
   * Arrays.fill(array,value) ->  rellena todo el array con un mismo valor 
   * 
   * Arrays.equals(array1,array2) -> compara dos arrays elemento a elemento 
   * 
   * Arrays.copyOf(arr,newlenght) -> copia un array en uno nuevo con la longitud indicada nota agrega ceros si no hay valores en el array pasado 
   * 
   * Arrays.toString(array) -> convierte un array en String legible 
   * 
   * 
   * Arrays.streams(array) -> convierte un array en un stream
   */


   public static void tryArrays(){
    int[] numeros = {2,1,4,3,10,6,7,9,8,4}; // aray de 10 numeros 

    // la api Arrays nos permite manipular estos arrays como ordenarlos o 
    System.out.println("array desordenado: " + Arrays.toString(numeros)); // toString nos permite mostrar arrays como valores legibles si no este mostraria la posicion en memoria 
    Arrays.sort(numeros);
    System.out.println("numeros ordenados: " + Arrays.toString(numeros));

    // este tambien nos permite rellenar un array con valores que queramos 
    String[] palabras = new String[5];  // 5 posociones en memoria 
    for (int i = 0;i <= 10;i++) {
        Arrays.fill(palabras, RandomStringUtils.randomAlphanumeric(i));
    }
    System.out.println("Arrays de palabras randoms: " + Arrays.toString(palabras));

    //nos permite verificar si nos arrays son iguales comparando elemento a elementos
    String palabra = "hola mundo"; 
    char[] palabrasChar = palabra.toCharArray();
    String palabras2 = "tu mama";
    char[] palabrasChar2 = palabras2.toCharArray();
    System.out.println("La comparacion del array es: " + Arrays.equals(palabrasChar2,palabrasChar));

    // nos permite copiar un array en otro con la longitud indicada este coloca 0 si no existe esa posicion 
    int[] copia = Arrays.copyOf(numeros, 50);
    System.out.println("array copiado: " + Arrays.toString(copia));

    // por ultimo este nos permite transforma valores a streams 
    System.out.println("La suma de todos los valores dentro de la lista es: " + Arrays.stream(numeros).sum());
   }
}
