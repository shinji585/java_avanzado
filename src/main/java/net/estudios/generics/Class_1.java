package net.estudios.generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

public class Class_1 {
    // en esta seccion se estudiará la clase uno de los genericos
    public static Persona crearPersonas(){
      Supplier<Persona> crearPersonas = Persona::crearConValoresDefecto;
      return crearPersonas.get();
    }
    public static void main(String[] args) {
        Object number = Integer.valueOf(10); // el valor de 10 se pierde
        number = "hola mundo";
        System.out.println(number);

        // llamamos a el metodo objectVisual
        // objectVisual();
        objectVSobjects();

        // ahora al tener lo que viene siendo una lista generica podemos pasar lo que sea por ejemplo
        // ahoira queremos tenemos que tener en cuenta esto nuestro atributo de nuestra clase es T y ese valor lo tomara sus atributos y los metodos segun el tipo que le pasemos a el padre es decir la clase
        GenericosExample<Persona> personas = new GenericosExample<>();

        List<Persona> personaList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            personaList.add(crearPersonas());
        }
        personas.setValores(personaList);

        System.out.println(personas.toString());
    }

    @SuppressWarnings("unchecked")
    public static void objectVisual(){
        // object es una superClase de la cual extiende todos los objectos en java
        // antes en java las collections eran estructuras las cuales no tenía tipos definidos por lo cual las debiamos castear
        ArrayList list = new ArrayList(); // esto no da error y podemos pasar cualquier tipo de dato
        list.add("santiago");
        list.add(45);
        list.add(4.254);
        list.add('k');

        // que pasa con ello que debemos castear si queremos visualizar los tipos de datos por que obtendriamos exceciones
        try{
            for (Object o: list){
                if (o instanceof String){
                    System.out.println(o);
                }else if (o instanceof  Character){
                    System.out.println(o);
                }else if (o instanceof  Integer){
                    System.out.println(o);
                }else if (o instanceof  Double){
                    System.out.println(o);
                }
            }
        }catch (Exception e){
            System.err.println("Error: del tipo: " + e.getLocalizedMessage());
        }
        // el problema con esto es que tenemos que castear y validar las excepciones algo que esta bien pero quita tiempo
        // para ello las personas detras de java incluyeron los genericos y este le dice a el copilador ey mira esta collections o objectos puede ser de cualquier tipo pero se tiene que especificar el tipo
        ArrayList<Integer> listaEnteros = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            listaEnteros.add(i); // agregamos todos los enteros y que pasa si queremos ingresar un valor de un tipo diferente
            byte[] bytesArray = {1,2,4,5,6,6,7,8};
            try{
                   // listaEnteros.add((Integer) bytesArray); no podemos pasar un nuevo tipo por que ya esta definido el tipo de lista
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void objectVSobjects(){
        // objects es una clase utilitaria que nos brida ciertos metodos para poder acceder a ellos y que no nos cause el tan conocido nullpointerException
        String nombre1 = "sebastian";
        String nombre2 = null;

        if (Objects.equals(nombre1,nombre2)){
            System.out.println("Los objectos son iguales");
        }else{
            System.out.println("los objectos son diferentes o uno es nulo ");
        }

        System.out.println("--------------------------------");

        try{
            if (nombre2.equals(nombre1)){
                System.out.println("Los objectos son iguales");
            }else {
                System.out.println("Los objectos son diferentes o uno es nulo");
            }
        }catch (Exception e){
            pass(); // aqui imprime un error pero para que no tumbe el programa invente el pass de python en java para poder seguir escribiend codigo
        }
    }

   static void pass(){
        ;
    }

}
