package net.estudios.generics.restricciones;

public class Main {
    public static void main(String[] args) {
        // podemos utilizar los metodos genericos de la clase Utility
        String name = "Santiago";
        int edad = 15;

        // utilizamos los metodos genericos para mostrar cualquier tipo de dato
        Utility utility = new Utility();
        utility.mostrarInformacion(name);
        utility.mostrarInformacion(edad);
        // este muestra los datos indivuales y no da errores
        utility.mostrarInformacion_ConNumeros(name,edad);
        // mostramos mas de un valor
    }
}
