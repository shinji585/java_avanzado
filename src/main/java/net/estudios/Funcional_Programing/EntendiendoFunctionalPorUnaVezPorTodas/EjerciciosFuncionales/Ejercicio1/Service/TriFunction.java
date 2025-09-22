package net.estudios.Funcional_Programing.EntendiendoFunctionalPorUnaVezPorTodas.EjerciciosFuncionales.Ejercicio1.Service;


@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R apply(T t,U u,V v);
}
