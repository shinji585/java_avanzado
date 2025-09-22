package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Model;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Tumor {
    private double longitud;
    private double ancho; 
    private double altura;  
    private double tasa_crecimiento;
}
