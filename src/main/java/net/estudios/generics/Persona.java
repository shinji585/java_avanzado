package net.estudios.generics;

public record Persona(String name,int edad,String personalidad) {
   @org.jetbrains.annotations.NotNull
   @org.jetbrains.annotations.Contract(" -> new")
   public static Persona crearConValoresDefecto(){
       return  new Persona(null,0,null);
   }
}
