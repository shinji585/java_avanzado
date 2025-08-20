package net.estudios.generics;

import java.util.List;
import java.util.Objects;

public class GenericosExample<T> {
    // los genericos son tipos que nos permiten crear clases de cualquier tipo de datos y que luegos son aplicados en lo que viene siendo las interfaces funcionales
    private List<T> valores;

    // ahora al tener una lista generica podemos ingresar cual quier valor


    public GenericosExample(){
        // constructor vacio
    }
    public GenericosExample(List<T> valores) {
        this.valores = valores;
    }

    public List<T> getValores() {
        return valores;
    }

    public void setValores(List<T> valores) {
        this.valores = valores;
    }

    @Override
    public String toString() {
        return "valores -> " + this.valores.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GenericosExample<?> that = (GenericosExample<?>) o;
        return Objects.equals(valores, that.valores);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(valores);
    }
}
