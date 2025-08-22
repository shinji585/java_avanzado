package net.estudios.Records;

import org.jetbrains.annotations.NotNull;

public record RecordStudy1() {
    // en esta seccion se entenderan los records y su funcionamiento
    // los recors son una entidad que inmutaliza los datos con la cual la definamos
    // esto nos permite trasportar datos de un lado a otro que necesiten ser constantes y no perderce es como una fotografica que hacemos en el tiempo de ellos


    // en los records podemos construir constructores apartes tener metodos estaticos y ademas metodos de instancias y campos estaticos


}
record  Punto2D(double x, double y){
   // podemos definir datos constantes
   public static final  Punto2D ORIGEN = new Punto2D(0,0);

   // crear constructores canonico compactos: se usa para validar los datos
    public Punto2D{
        if (x < 0 || y < 0){
            throw  new IllegalArgumentException("Las coordenadas no pueden ser negativas");
        }
    }
    // constructor alternantivo
    public Punto2D(@NotNull Punto2D otroPunto){
        this(otroPunto.x(), otroPunto.y());
        System.out.println("Se ha creado un nuevo punto apartir de otro.");
    }

    // creamos metodos de instancias
    public double distanciaALOrigen(){
        return  Math.sqrt(x*x + y*y);
    }

    // y sobre todo metodos estaticos
    public static double distanciaEntreDosPuntos(@NotNull Punto2D p1, @NotNull Punto2D p2){
        double dx = p1.x() - p2.x();
        double dy = p1.y() - p2.y();
        return  Math.sqrt(dx*dx + dy*dy);
    }


}