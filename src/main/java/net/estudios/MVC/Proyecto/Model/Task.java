package net.estudios.MVC.Proyecto.Model;

import java.util.Date;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.estudios.MVC.Proyecto.Model.Enums.Prioridad;
import net.estudios.MVC.Proyecto.Model.Util.GenerateID;





@ToString
@Getter
@Setter
@EqualsAndHashCode
public class Task {
    /*
    en esta seccion se estara estudiando inicialmente que es mvc para que sirve y cuales son sus aplicaicones

    Modelo: este se encarga de gestionar la logica de negocio del programa su funcion principal no es la de hacer validaciones o manipular la interaccion entre la vista y el mismo si no de definir las costantes operativas que el sistema debe teer y como este interactua con lo que viene siendo la base de datos 
     */
    

     /// para todo esto tengo en teoria que hacer un gestionador de tareas vamos a comenzar realizando el modlo en el cual se contendran todos los tipos que se utilizaran en la gestion de una tarea 
     private String name; 
     private String description; 
     private Date startDate; 
     private Date endDate; 
     private Prioridad prioridad; 
     private String estado; 
     private User asignado; 
     private Date recordatorio;
     @Setter(AccessLevel.NONE) 
     private String id;

     // esta es mi tarea entonces las tareas son personalizadas tienen distintas formas y ademas de tener distintas formas se pueden utilizar de distintas formas lo siguiente que se hara sera una clase personalizada de esta que funcionara como una clase la cual permitira manejar multiples instancias de esta clase 

     // ahora el id no sera dado por el usuario sera dado por el mismo constructor 
     public Task(){
        this.id = GenerateID.genereTaskID();
     }

     public Task(String name, String description, Date startDate, Date endDate, Prioridad prioridad, String estado,
            User asignado, Date recordatorio) {
                // llamamos al constructor vacio para generar el ID primero 
                this();
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.prioridad = prioridad;
        this.estado = estado;
        this.asignado = asignado;
        this.recordatorio = recordatorio;
     }

     
}
