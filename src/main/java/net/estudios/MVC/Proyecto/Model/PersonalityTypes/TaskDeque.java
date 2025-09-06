package net.estudios.MVC.Proyecto.Model.PersonalityTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import net.estudios.MVC.Proyecto.Exception.TaskException;
import net.estudios.MVC.Proyecto.Model.Person;
import net.estudios.MVC.Proyecto.Model.Task;
import net.estudios.MVC.Proyecto.Util.GenerateID;

public class TaskDeque {
    private  ArrayList<Task> tasks = new ArrayList<>();; 

    // en esta clase lo que haremos sera manejar los datos y sus acciones pero de forma diferente en la cual cada pila lo que tendra es un array de ellas pero enlazadas 

    // los metodos seran agregar,eliminar,buscar por id,buscar por tarea
    
    // ademas de eso voy a implementar un map el cual se encargara de guardar el id del la tarea y guardar la tarea en si si sin agregar el id para una mejor busuqeda 
    private Map<String,Task> filtroTareas = new HashMap<>();


    // creamos el metodo de agregar elemento 
    public void add(Task tarea) throws TaskException{
        // verificamos que la tarea no sea null
        if (tarea == null){
            throw new TaskException("exception: the task is null");
        }

        // luego de verificar que la tarea no sea nulla la agregamos a el task 
        tasks.add(tarea);
        // agregamos la tarea a el filtro de tareas 
        filtroTareas.put(GenerateID.genereTaskID(), tarea);
    }

    // creamos el metodo eliminar que sea por id 
    public Task remove(String id){
        // verificamos que string no sea null 
        Objects.requireNonNullElse(id, "the id pass is empty");

        // despues de verificar que no sea null el id lo que hacemos es buscarlo en el map 
        for (String idMap: filtroTareas.keySet()){
            if (!id.equalsIgnoreCase(idMap)){
                // eliminamos el elemento 
                return filtroTareas.remove(idMap);
            }
        }
        return null;
    }

    // creamos el metodo buscar por id 
    public Task searchByID(String id){
                 // verificamos que string no sea null 
        Objects.requireNonNullElse(id, "the id pass is empty");

        // despues de verificar que no sea null el id lo que hacemos es buscarlo en el map 
        for (String idMap: filtroTareas.keySet()){
            if (id.equalsIgnoreCase(idMap)){
                return filtroTareas.get(idMap);
            }
        }
        return null;
    }

    // buscar tarea por persona 
    public Task searchByPerson(Person person){
       // verificamos que string no sea null 
        Objects.requireNonNullElse(person, "the person pass is empty");

        // despues de verificar que no sea null el id lo que hacemos es buscarlo en el map 
        for (Task task: filtroTareas.values()){
              // cada tastk tiene una persona entonces tenemos que buscar si la persona esta hay 
              if (task.getAsignado().getPersona().equals(person)){
                // retonramos la tarea 
                return task;
              }
        }
        return null;
    }

    // retornar una lista de tareas 
    public ArrayList<Task> listTask(){
        return  (ArrayList<Task>) filtroTareas.values().stream()
                .collect(Collectors.toList());
    }
}
