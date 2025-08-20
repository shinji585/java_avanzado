package net.estudios.generics.restricciones;

public class Utility {
    // con los genericos podemos tener clases las cuales no sean genericos ya que necesitamos alguna acciones exclusivas
    // para establecer algunos metodos genericos lo que hacemos es
    public  <T> void mostrarInformacion(T value){
        System.out.println(value);
    }

    // podemos hacer que esta tambienr reciba mas de un valor generico como una key o cual quier otro tipo pero lo recomedable es utilizar la nomenclatura para los tipos genericos
    public <T,N> void mostrarInformacion_ConNumeros(T value, N number){
        System.out.println(value + " " + number);
    }
}
