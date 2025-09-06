package net.estudios.MVC.Proyecto.View;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

import net.estudios.MVC.Proyecto.Controller.TaskController;
import net.estudios.MVC.Proyecto.Exception.ArgumentException;
import net.estudios.MVC.Proyecto.Exception.TaskException;
import net.estudios.MVC.Proyecto.Model.User;
import net.estudios.MVC.Proyecto.Model.Enums.Prioridad;

public class ViewData {

    private final TaskController controller;
    private final Scanner sc;

    public ViewData(TaskController controller) {
        this.controller = controller;
        this.sc = new Scanner(System.in);
    }

    // creamos el metodo de show menu
    public void showMenu() {
        int opcion = 0;

        do {

            System.out.println("===================");
            System.out.println("Good " + saludar());
            System.out.println("\tSelect an action to make");
            System.out.println("\t1: Add a task");
            System.out.println("\t2: remove a task");
            System.out.println("\t3: update a task");
            System.out.println("\t4: show the task ");
            System.out.println("\t5: leave");

            opcion = sc.nextInt();

        } while (opcion != 5);
    }

    // voy hacer algo extraño pero que creo que funcionara como quiero
    public String saludar() {
        int hour = LocalTime.now().getHour();
        if (hour >= 6 && hour < 12) {
            return "Morning";
        } else if (hour >= 12 && hour < 18) {
            return "Afternoon";
        } else {
            return "Evening";
        }
    }

    // en esta seccion estara el swith especial
    public void shitchEspeciall(int option) {
        switch (option) {
            case 1 -> {
                // creamos una tarea
            }
            case 2 -> {
                // eliminamos una tare
            }
            case 3 -> {
                // actualizamos una tare
            }
            case 4 -> {
                // mostramos las tareas con sus ids y las tareas solas
            }
            default -> {
                // salimos del programa
            }
        }
    }

    public void createTask() {
        // en este metodo agregaremos las tareas a el controller para ello necesito crea
        // una tarea primero verificando si los datos que se le pasan son correctos pero
        // en el util

        // capturamos el nombre y la descripcion de la tarea 
        System.out.println("Name: " );
        String name = sc.nextLine();
        System.out.println("Description: " );
        String description = sc.nextLine();


        // capturamos la fechas de inicio y final 
        System.out.println("Start date (dd/MM/yyyy HH:mm) : " );
        String startinput = sc.nextLine();
        System.out.println("End date (dd/MM/yyyy HH:mm) : " );
        String endinput = sc.nextLine();
        

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date startdate = null;
        Date enddate = null;
        Date reminder = null;





        // capturamos la prioridad 
        Prioridad[] prioridads = Prioridad.values();
        System.out.println("Select the priority: ");
        int i = 0;
        for(Prioridad priority: prioridads){
             System.out.println((i + 1) + ". " + priority);
             i++;
        }
        int selectionPriority = sc.nextInt();
        Prioridad selection = null;
        if (selectionPriority >= 1 && selectionPriority <= prioridads.length){
             selection = prioridads[selectionPriority-1];
        }

        // capturamos el estado 
        System.out.println("Estate: " );
        String state = sc.nextLine();
        System.out.println("Reminder: " );
        String reminderInput = sc.nextLine();


        
        try {
            // pasamos a date los strings 
            startdate = sdf.parse(startinput);
            enddate = sdf.parse(endinput);
            reminder = sdf.parse(reminderInput); 
        } catch (Exception e) {
             System.out.println("Error: " + e.getMessage());
        }


        // agregamos la tarea a la lista 
        try {
            this.controller.addData(name, description, startdate, enddate, selection, state, null, reminder);
        } catch (ArgumentException | TaskException e) {
            System.out.println("Error de tipo: " + e.getMessage());
        } 
    }

}
