package net.estudios.Funcional_Programing.streams;



import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams2 {
    static Scanner s = new Scanner(System.in);
   // en esta seccion se seguiran estudiando los streams para ello se utilizara lo siguiente
   // operaciones intermedias:
   // filtrado: filter(predicate),distinct() -> elimina duplicados, limit(n) -> toma los primeros n elementos
    // skip(n) omite los primero n elementos
    // transformacion: map(Function) -> aplica una funcion a cada elemento
    // flatMap(function) -> aplana estructuras complejas (ej: lista de listas -> lista simple)
    // ordenacion: sorted() -> ordena natural o con comparador
    // inspeccion: peek(consumer) -> permite inspeccionar valores en el pipeline (usando para debug)

    // para las operaciones terminales utilizaremos forEach() para imprimis los elementos finales del stream

    public static void main(String[] args) {
        System.out.printf("Lista con streams pero con codigo redundante");
       filtrado();
        System.out.println("\nLista con streams pero sin codigo redundante");
        filtrado2();

        // tenemos un array de tipo string
        String[] names = {"sebastian","samuel","santiago","matha", "francisco","esternomastocletoideo"};
        System.out.println("lista filtrada por longitud: " + transformarDatos(names));
    }
    // filtrado
    public static void filtrado(){
        // filter() nos permite obtener los elementos que cumpla con una condicion logica (predicate)
        List<Integer> numeros = Arrays.asList(1,2,3,4,5,6,181,188,38,29);
        // y tenemos el siguiente predicate
        Predicate<Integer> filtrarValores = (a) -> a % 2 == 0; // filtra todos los elementos pares
        // para hacer esto con streams se hace de la forma
        Stream<Integer> paresStremas = numeros.stream().filter(filtrarValores); // transformamos lso numeros a strema
        // luego obtenemos los resultados en una lista
        List<Integer> paresList = paresStremas.toList();

        System.out.println("lista de numeros pares: " + paresList);
    }

    // otra forma de hacer lo anterior mas rapido
    public static void filtrado2(){
        Random random = new Random();

        // creamos un lista
        List<Integer> valroesAleatorios = new ArrayList<>();

        // preguntamso cuantas numeros randoms quiere que tenga la lista
        System.out.print("ingrese el numero de numeros randoms que quiere que tenga la lista: ");
        int numero = s.nextInt();

        for (int i = 0; i <= numero; i++) {
           valroesAleatorios.add(random.nextInt(i+1));
        }

        // encontramos los numeros pares dentro de la lista y lo guardamos en otra
        List<Integer> numerosParesList = valroesAleatorios.stream().filter((a) -> a % 2 == 0).toList();


        System.out.println("La lista de numeros aleatoria pares es: " + numerosParesList);
    }


    // las transformaciones nos permite cambiar el orden de una lista y ademas de eso modificar los valores que esta se encuentran
    // el problema con java en esto es que dichos valores se modifican y no se puede utilizar el mismo tipo de dato o si?
    public static List<AbstractMap.SimpleEntry<String, Integer>> transformarDatos(String[] nombresCiudades){
        // se nos pide verificar y modificar el dato es decir filtrarlo y modificarlo segun la longitud que esta tenga
        // devolvemos la longitud de los elementos mayores a 10
        return  Arrays.stream(nombresCiudades)
                .map(c -> new AbstractMap.SimpleEntry<>(c,c.length()))
                .filter(entry -> entry.getValue() > 5)
                .toList(); // obtenemos la longitud de los streams
    }


}
