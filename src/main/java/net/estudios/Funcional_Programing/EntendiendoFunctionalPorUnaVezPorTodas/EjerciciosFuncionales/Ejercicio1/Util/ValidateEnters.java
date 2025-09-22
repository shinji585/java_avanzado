package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Util;


import java.util.Map;

public class ValidateEnters {

    /*
     * en esta seccion se creara el metodo que valie que el dato que se ingresa esta en mm 
     * 
     */

     static final Map<String,Double> typeConvert = Map.of(
        "km",1000.0,
        "hm",100.0,
        "dam",10.0,
        "m",1.0,
        "dm",0.1,
        "cm",0.01,
        "mm", 0.001
);

     // funcion para convertir valores 
     public static double convert(double value, String form, String to){
         return value * (typeConvert.get(to) / typeConvert.get(form)); 
     }


     public static double verifyValue(double value,String typeValue){
        // verificamos si el typevalue es mm pero primero limpiamos 
        typeValue = typeValue.toLowerCase().strip(); // eliminamos espacios y volvemos pequeño el tipo ingresado 

        if (typeValue.equals("mm")){
            return value;
        }
        
        // si el valor no es mm de entrada entonces 
        return convert(value, typeValue, "mm");
     }
    
}
