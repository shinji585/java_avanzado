package net.estudios.ModeladoDatos;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public record Caracteristicas<T extends  Comparable<T>,V extends Comparable<V>>(T nombre,V valor)  implements Comparable<V> {

    // la idea aqui es definir una etiqueta la cual comparra atraves de un valor lo que viene siendo los datos
    // en dicha comparacion se debe tomar la longitud de las palabras y ver si estas son mayores a un aspeccto especifico
    // en esta clase de caracteristicas no debo de realizar la descomposicion de los datos si no aceptarlos validarlos y ademas de eso compararlos


    // entendi esta mierda me los voy a culiar a todos manga de brutos que se creen inteligentes por saber hacer simples softwares empresariales
    // creamos un logger para enviar informacion
    private static final Logger LOGGER = Logger.getLogger(Caracteristicas.class.getName());



    // obtenemos las converciones de los datos
    public String convertirNombreString(){
        return  nombre.toString();
    }

    public  int convertirValorA_numero(){
        if (valor instanceof  Integer){
            return (Integer) valor;
        }
        // podria lanzar una advertencia
        LOGGER.log(Level.WARNING, "No se puede hacer la convercion de datos");
        return 0;
    }

    @Override
    public int compareTo(@NotNull V o) {
        return  this.valor.compareTo(o);
    }



    // vamos a crear las ecuaciones de las formulas
    public double calcularScoreCantidad() {
        int palabras = convertirValorA_numero();
        if (palabras <= 10) {
            return 1.0;  // muy spam
        } else if (palabras > 10 && palabras <= 50) {
            return 0.0;  // normal
        } else {  // palabras > 50
            return 0.8;  // posible spam
        }
    }


    // este score es para las palabras claves
    public  double score_palabrasClves(){
        // obtenemos el numero del valor
        return  Math.min(1.0,(double) convertirValorA_numero()/3.0);
    }
}

/*
  el problema es el siguiente necesitamos crear un algoritmo de modelados de datos en el cual se tiene que tener un record
  el cual almacenara las caracteristicas y este record sera de clasificacion por lo que debera clasificar correos electronicos
  las caracteristicas a clasificar son por numero de palabras (nombre) y su valor (contenido)

  estos deben ser de tipo generico V que extiendan de Comparable

 */
