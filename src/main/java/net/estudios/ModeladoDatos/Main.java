package net.estudios.ModeladoDatos;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Main {
    // definimos los pesos
    static final double w1 = 0.3;
    static final double w2 = 0.7;

    public static void main(String[] args) {
        System.out.println("=== PRUEBA DEL SISTEMA DE CLASIFICACIÓN DE SPAM ===\n");

        // Prueba 1: Correo con posible spam
        String correo1 = "¡GRATIS! Oferta increíble solo hoy. Haz clic ahora para ganar dinero fácil.";
        System.out.println("CORREO 1: " + correo1);
        probarCorreo(correo1, "spam");

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Prueba 2: Correo normal
        String correo2 = "Hola, ¿cómo estás? Nos vemos mañana en la reunión.";
        System.out.println("CORREO 2: " + correo2);
        probarCorreo(correo2, "no-spam");

        System.out.println("\n" + "=".repeat(60) + "\n");

        // Prueba 3: Instancias manuales usando los datos reales
        System.out.println("=== PRUEBAS CON INSTANCIAS MANUALES ===");

        // Instancia 1 - Simulando correo spam
        List<Caracteristicas<String, Integer>> caracteristicas1 = List.of(
                new Caracteristicas<>("CantidadPalabras", 15),
                new Caracteristicas<>("CantidadCoincidencia", 4)
        );
        InstanciaDatos<String> instancia1 = new InstanciaDatos<>(caracteristicas1, "spam");
        procesarInstancia(instancia1, "Instancia Manual 1");

        System.out.println();

        // Instancia 2 - Simulando correo normal
        List<Caracteristicas<String, Integer>> caracteristicas2 = List.of(
                new Caracteristicas<>("CantidadPalabras", 8),
                new Caracteristicas<>("CantidadCoincidencia", 0)
        );
        InstanciaDatos<String> instancia2 = new InstanciaDatos<>(caracteristicas2, "no-spam");
        procesarInstancia(instancia2, "Instancia Manual 2");
    }

    // Método para probar un correo completo
    public static void probarCorreo(String correo, String etiquetaEsperada) {
        // Obtenemos las características automáticamente
        List<Caracteristicas<String,Integer>> lista_datos = Utility.buscarCoincidencias(correo);

        // Mostramos las características encontradas
        System.out.println("Características encontradas:");
        for (Caracteristicas<String,Integer> caracteristica : lista_datos) {
            System.out.println("  - " + caracteristica.nombre() + ": " + caracteristica.valor());
        }

        // Creamos la instancia de datos
        InstanciaDatos<String> instancia = new InstanciaDatos<>(lista_datos, etiquetaEsperada);

        // Procesamos la instancia
        procesarInstancia(instancia, "Correo Analizado");
    }

    // Método para procesar una instancia y calcular scores
    public static void procesarInstancia(@NotNull InstanciaDatos<String> instancia, String titulo) {
        System.out.println("--- " + titulo + " ---");
        System.out.println("Etiqueta: " + instancia.etiquea_Lista());

        double scoreCantidad = 0.0;
        double scorePalabrasClaves = 0.0;

        // Calculamos los scores de cada característica
        for (Caracteristicas<?, ?> caracteristica : instancia.caracteristicasList()) {
            String nombre = caracteristica.convertirNombreString();
            int valor = caracteristica.convertirValorA_numero();

            System.out.println("Procesando: " + nombre + " = " + valor);

            if (nombre.equals("CantidadPalabras") || nombre.equals("longitud")) {
                scoreCantidad = caracteristica.calcularScoreCantidad();
                System.out.println("  Score por cantidad de palabras: " + scoreCantidad);
            } else if (nombre.equals("CantidadCoincidencia") || nombre.equals("palabrasClave")) {
                scorePalabrasClaves = caracteristica.score_palabrasClves();
                System.out.println("  Score por palabras clave: " + scorePalabrasClaves);
            }
        }

        // Calculamos el score final
        double scoreFinal = score_final(scoreCantidad, scorePalabrasClaves);
        System.out.println("SCORE FINAL: " + String.format("%.3f", scoreFinal));

        // Interpretamos el resultado
        String prediccion = scoreFinal > 0.5 ? "SPAM" : "NO-SPAM";
        System.out.println("PREDICCIÓN: " + prediccion);

        // Verificamos si coincide con la etiqueta
        String etiquetaReal = instancia.etiquea_Lista().toUpperCase();
        boolean esCorrecta = prediccion.equals(etiquetaReal) ||
                (prediccion.equals("NO-SPAM") && etiquetaReal.equals("NO-SPAM"));
        System.out.println("RESULTADO: " + (esCorrecta ? "✓ CORRECTO" : "✗ INCORRECTO"));
    }

    // Método score_final (importante - no eliminar)
    public static double score_final(double score_cantidad, double score_palabrasClaves) {
        // realizamos la formula
        return (w1 * score_cantidad + w2 * score_palabrasClaves) / (w2 + w1);
    }
}