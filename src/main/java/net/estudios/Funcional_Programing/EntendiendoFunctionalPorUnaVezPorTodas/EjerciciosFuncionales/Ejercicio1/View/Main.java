package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.View;

import net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Model.CancerMama;
import net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Model.Persona;
import net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Model.Tumor;
import net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Service.ServiceTumor;
import net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Util.ValidateEnters;

public class Main {
      public static void main(String[] args) {
        // creamos una persona 
        Persona persona = new Persona("camila", 78, 32);

        // creamos un tumor 
        Tumor tumor = new Tumor(ValidateEnters.verifyValue(25, "cm"), ValidateEnters.verifyValue(10, "cm"), ValidateEnters.verifyValue(5, "cm"), 0.8); 

        // utilizamos los servicios 
        ServiceTumor serviceTumor = new ServiceTumor(); 
        

        if (serviceTumor.verificarLongitud(tumor.getLongitud())){
            System.out.println("la longitud resulta peligrosa");
            double longitudPeligrosa = tumor.getLongitud();
            System.out.println("longitud del tumor: " + longitudPeligrosa);
        }

        // calculamos el volumen 
        double volumen = serviceTumor.sizeTumor(tumor.getLongitud(), tumor.getAncho(), tumor.getAltura());
        System.out.println("volumen del tumor: " + volumen);

        // predecimos el riesgo
        double riesgo = serviceTumor.predecirRiesto(volumen, tumor.getTasa_crecimiento());
        System.out.println("el riesgo de que sea tumor tiene un porcentaje de: " + (riesgo*100));

        // validamos si el tumor es grande o crece rapido
        String altoriesto = null;
        if (serviceTumor.validarLongitud(tumor.getLongitud(), tumor.getTasa_crecimiento())){
             altoriesto = "el tumor presenta un alto riego a ser cancer de mama";
        }


        // creamos un objecto de tipo cancer de mama 
        CancerMama cancerMama = new CancerMama(tumor.getLongitud(), tumor.getAncho(), tumor.getAltura(), tumor.getTasa_crecimiento(), persona.getName(), persona.getEdad(), persona.getMasa(),altoriesto);

        System.out.println(cancerMama.getDitamente());
      }
}
