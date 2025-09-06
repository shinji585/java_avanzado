package net.estudios.MVC.Proyecto.Controller;

import java.util.Date;

import net.estudios.MVC.Proyecto.Exception.ArgumentException;
import net.estudios.MVC.Proyecto.Exception.TaskException;
import net.estudios.MVC.Proyecto.Model.Task;
import net.estudios.MVC.Proyecto.Model.User;
import net.estudios.MVC.Proyecto.Model.Enums.Prioridad;
import net.estudios.MVC.Proyecto.Model.PersonalityTypes.TaskDeque;

public class TaskController {

    private final TaskDeque task = new TaskDeque();


    // desde este controller lo que haremos sera manejrar los datos que estan entrenando y saliendo que recibimos los atributos de nuestro task  
    public void addData(
             String description, 
             Date startDate,
             Date endDate,
             Prioridad prioridad, 
             String estado,
             User asignado, 
             Date recordatorio) throws ArgumentException, TaskException{
            
                // ahora ya con los datos definidos tenemos que crear un nuevo tipo de exception que valide que estos datos no este vacios o no sean nulls
               // validamos los datos 
               validateValues(description, startDate, endDate, prioridad, estado, asignado, recordatorio);
               // luego de validar la informacion la pasamos el taskDeque
               task.add(new Task(estado, description, startDate, endDate, prioridad, estado, asignado, recordatorio));
    }
    

    private void validateValues(
             String description, 
             Date startDate,
             Date endDate,
             Prioridad prioridad, 
             String estado,
             User asignado, 
             Date recordatorio
    ) throws ArgumentException{
        if (description == null || description.trim().isEmpty()){
            throw new ArgumentException("The description cannot be null or empty.");
        }
        if (estado == null || estado.trim().isEmpty()){
            throw new ArgumentException("The status cannot be null or empty.");
        }
        if (startDate == null){
            throw new ArgumentException("The start date cannot be null.");
        }
        if (endDate == null){
            throw new ArgumentException("The end date cannot be null.");
        }
        if (prioridad == null){
            throw new ArgumentException("The priority cannot be null.");
        }
        if (asignado == null){
            throw new ArgumentException("The assigned user cannot be null.");
        }

    }
}
