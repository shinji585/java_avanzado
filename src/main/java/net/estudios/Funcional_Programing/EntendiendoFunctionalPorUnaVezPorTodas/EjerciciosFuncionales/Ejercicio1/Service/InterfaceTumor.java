package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Service;



public interface InterfaceTumor {
    // definimos las funciones que modelaran nuestro modelo 
     boolean  verificarLongitud(double value); // recibe un predicate devuelve el boolean del predicate 
     double sizeTumor(double longitud,double ancho,double altura);
     double predecirRiesto(double longitud,double tasa);
     boolean validarLongitud(double longitud,double tasa); 
}
