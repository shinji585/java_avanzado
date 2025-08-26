package net.estudios.ModeladoDatos;

import java.util.List;

public record InstanciaDatos<L extends Comparable<L>>(
        List<? extends Caracteristicas<? extends Comparable, ? extends Comparable>> caracteristicasList,
        L etiquea_Lista) {
}
