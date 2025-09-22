package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Model;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CancerMama extends Tumor{
    private  Persona persona; 
    private String ditamente;
   public CancerMama(double longitud, double ancho, double altura, double tasa_crecimiento,String name, int edad,double peso,String ditamen) {
        super(longitud, ancho, altura, tasa_crecimiento);
        this.persona = new Persona(name, peso, edad);
        this.ditamente = ditamen;
    }

}
