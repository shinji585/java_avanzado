package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Service;

import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;


public class ServiceTumor implements InterfaceTumor {

    @Override
    public boolean verificarLongitud(double longitud) {
        Predicate<Double>  checkTumor = (a) -> a > 20.0;   
        return checkTumor.test(longitud);
    }

    
    @Override
    public double sizeTumor(double longitud,double ancho,double altura){
       TriFunction<Double,Double,Double,Double> volumen = (a,b,c) -> (Math.PI / 6) * a * b * c;
       return volumen.apply(longitud, ancho, altura);
    }

    @Override
    public double predecirRiesto(double longitud,double tasa){
        BinaryOperator<Double> porcentajeRiesto = (a,b) -> a*b; 
        return porcentajeRiesto.apply(longitud, tasa);
    }

    @Override
    public boolean validarLongitud(double longitud,double tasa){
      BiPredicate<Double,Double> esGrandeYcreceRapido = (tamano,crecimiento) -> tamano >= longitud && crecimiento >= tasa;
      return esGrandeYcreceRapido.test(longitud, tasa);
    }

}
