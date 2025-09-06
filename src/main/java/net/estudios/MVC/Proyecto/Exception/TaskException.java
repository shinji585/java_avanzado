package net.estudios.MVC.Proyecto.Exception;

public class TaskException extends Exception {

    // creamos un costructor que acepta un mensaje como exception y devuelve la excepcion 
    public TaskException(String message){
        super(message);
    }
    
}
