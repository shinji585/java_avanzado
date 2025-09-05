package net.estudios.MutacionesGeneticas;

import org.jetbrains.annotations.NotNull;



public record Parbase<T extends Comparable<T>>(T original, T mutada) implements  Comparable<Parbase<T>> {

    // verificamos las istancias
    public Parbase{
          // validamos las bases de adn con el regex "[ATGC]"
        if (original instanceof  String && mutada instanceof  String){
            // obtenemos el patron regex
            String patronRegex = "[ATGC]";
            // verficiamos con un if
            if (!((String) original).matches(patronRegex) || !((String) mutada).matches(patronRegex)){
                throw  new IllegalArgumentException("Error: las bases genericas deben ser 'A', 'T', 'G', 'C'");
            }
        }

    }

    @Override
    public int compareTo(@NotNull Parbase<T> otroPar) {
        if (this.original.equals(otroPar.original) && this.mutada.equals(otroPar.mutada)){
            return  0; // verifica que sean iguales
        }
        return  -1;  // verifica que sean defiretenes
    }

    // creamos un metodo para imprimir los resultados
    public void imprimirResultados(){
        if (this.original.equals(this.mutada)){
            System.out.println("No hay mutaciones en el par: (" + this.original + ", " + this.mutada + ")");
        }else {
            System.out.println("Mutacion detectada -> (" + this.original + ", " + this.mutada + ")");
        }
    }
}
