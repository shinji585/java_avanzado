package net.estudios.Funcional_Programing;

public class Funcional1 {
  public static void main(String[] args) {
    // llamamos la funcion apply pero primero tenemos que crear una instancia de ella 
    Operation sum = (a,b) -> a+b; 
    Operation less = (a,b) -> a-b;


    System.out.println(sum.apply(10, 20));
    System.out.println(less.apply(25, 10));

    // aplicamos lo que viene siendo las expresiones funcionales que definimos y obtenemos lo que viene siendo un resultado 
  }    
}


/*
 * En programación funcional, toda computación se describe como una función que recibe argumentos y devuelve resultados.
 * 
 * En Java, representamos este concepto con interfaces funcionales, que tienen exactamente un método abstracto.
 */


 /*
  * Estas interfaces se pueden instanciar usando expresiones lambda, lo que nos permite escribir código más conciso y declarativo.

  Además, pueden incluir métodos static y default para agregar funcionalidad adicional sin romper la regla de un solo método abstracto
  */

@FunctionalInterface // la anotacion funcional obliga a el compilador tener que verificar que la interfaz tenga un unico metodo abstracto esta no puede tener mas de un metodo 
interface Operation{
    int apply(int a,int b);
}