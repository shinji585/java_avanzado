package net.estudios.MutacionesGeneticas;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // probamos el algoritmo
        String secuencia1 = "ATGCTTAGCC";
        String secuencia2 = "ATGCCTTGCC";

        // tengo que convertir las secuencias a pares bases
        // tengo que crear dos litas de pares

        List<String> lista1 = new ArrayList<>();
        List<String> lista2 = new ArrayList<>();

        for (int i = 0; i < secuencia1.length() - 1; i++) {
            // pasamos los caracteres
            char[] arraySecuencia1 = secuencia1.toCharArray();
            char[] arraySecuencia2 = secuencia2.toCharArray();

            // los pasamos a las listas
            lista1.add(String.valueOf(arraySecuencia1[i]));
            lista2.add(String.valueOf(arraySecuencia2[i]));
        }

        // luego de haber llenado las listas con los valores
        System.out.println(lista1.toString());
        System.out.println(lista2.toString());

        // ahora podemos si realizar la comparaciones del producto cartesiano para ver si son iguales y si existe alguna mutuacion
        try{
            List<Parbase<String>> resultados = AnalizadorSecuencias.analizarMutaciones(lista1,lista2);
            // se recorre la lista de resultados
            for (Parbase<String> par: resultados){
                par.imprimirResultados();
            }

            // realizamos las comparciones
            Parbase<String> par1 = new Parbase<>("A","T");
            Parbase<String> par2 = new Parbase<>("A","T");
            System.out.println("\nComprobando si dos pares son iguales usando compareTO: ");
            System.out.println("El par (" + par1.original() + ", " + par1.mutada() + ") es iguala al par (" + par2.original() + ", " + par2.mutada() + ")? : " + (par1.compareTo(par2) == 0));
        }catch (Exception e){
            System.out.println("Error: " +  e.getMessage());
        }
    }
}
