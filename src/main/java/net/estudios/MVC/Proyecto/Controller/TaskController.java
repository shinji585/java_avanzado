package net.estudios.MVC.Proyecto.Controller;

import java.util.Date;
import java.util.List;

import net.estudios.MVC.Proyecto.Exception.ArgumentException;
import net.estudios.MVC.Proyecto.Exception.TaskException;
import net.estudios.MVC.Proyecto.Model.Task;
import net.estudios.MVC.Proyecto.Model.User;
import net.estudios.MVC.Proyecto.Model.Enums.Prioridad;
import net.estudios.MVC.Proyecto.Model.PersonalityTypes.TaskDeque;

public class TaskController {

    private final TaskDeque task;


    public TaskController(TaskDeque task){
       this.task = task;
    }

    // desde este controller lo que haremos sera manejrar los datos que estan entrenando y saliendo que recibimos los atributos de nuestro task  
    public void addData(
             String nombre,
             String description, 
             Date startDate,
             Date endDate,
             Prioridad prioridad, 
             String estado,
             User asignado, 
             Date recordatorio) throws ArgumentException, TaskException{
            
                // ahora ya con los datos definidos tenemos que crear un nuevo tipo de exception que valide que estos datos no este vacios o no sean nulls
               // validamos los datos 
               validateValues(nombre,description, startDate, endDate, prioridad, estado, asignado, recordatorio);
               // luego de validar la informacion la pasamos el taskDeque
               task.add(new Task(nombre, description, startDate, endDate, prioridad, estado, asignado, recordatorio));
    }

    public void remove(String id) throws Exception{
        if (id == null || id.trim().isEmpty()){
            throw new ArgumentException("The id can't be empty");
        }

        try {
            this.task.remove(id);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void showTask() throws Exception{
        List<Task> tasks = this.task.listTask();

        if (tasks.isEmpty()){
            throw new ArgumentException("The list is empty");
        }

        for (Task task: tasks){
            System.out.println(task);
        }
    }

    // metodo para ver todas las tareas y sus ids
    public void showTaskwithID() throws Exception{
        if (this.task == null){
            throw new ArgumentException("The task isn't initiale");
        }
        this.task.showTaskwithID();
    }

    // metodo para actualizar las tareas 
    public void update(Task task, String id) throws Exception{
        if (task == null && (id== null  || id.trim().isEmpty())){
            throw new ArgumentException("Some of the values is null or is empty");
        }
        this.task.update(task, id);
    }


    

    private void validateValues(
             String nombre,
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
        if (nombre == null || nombre.trim().isEmpty()){
            throw new ArgumentException("The description cannot be null or empty.");
        }

    }
}
