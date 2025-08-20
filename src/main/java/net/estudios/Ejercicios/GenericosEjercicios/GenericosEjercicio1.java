package net.estudios.Ejercicios.GenericosEjercicios;

public class GenericosEjercicio1 {
    /*
  Ejercicios de Java Avanzado - Generics
  Tema: Modelación con Generics (desde lo básico hasta lo complejo)
  Objetivo: Mejorar la lógica obligándote a pensar en abstracciones con Generics,
  modelando sistemas complejos como enfermedades, virus virtuales,
  y hasta conceptos inspirados en machine learning o neuroplasticidad.

  Cada bloque sube en dificultad y te obliga a investigar más allá de lo básico.
*/

// =========================
// Nivel 1 - Fundamentos
// =========================
// 1. Crea una clase genérica Box<T> que pueda almacenar un objeto de cualquier tipo.
// 2. Implementa una lista genérica SimpleList<T> con métodos add, get y size.
// 3. Crea una clase Virus<T> que pueda almacenar un "tipo de virus" (String, Integer, etc.).
// 4. Escribe un método genérico que compare dos objetos y devuelva el mayor (usando Comparable<T>).
// 5. Implementa una clase Pair<K,V> y úsala para modelar una relación: (nombreVirus, nivelAmenaza).

// =========================
// Nivel 2 - Aplicaciones básicas
// =========================
// 6. Modela una Poblacion<T> genérica donde T pueda ser Humano o Computadora (para virus informáticos).
// 7. Implementa un método genérico que reciba una lista de virus y filtre los más peligrosos.
// 8. Usa wildcards (<? extends Number>) para calcular el promedio de una lista numérica genérica.
// 9. Implementa una clase genérica Enfermedad<T> con un método infectar(T objetivo).
// 10. Crea una red de conexiones genéricas (Graph<Nodo<T>>) que modele la propagación de un virus.

// =========================
// Nivel 3 - Inspiración en ML / Data
// =========================
// 11. Implementa una clase Dataset<T> genérica que almacene datos de entrenamiento.
// 12. Crea un método genérico que normalice cualquier lista de números (List<? extends Number>).
// 13. Diseña una clase Modelo<T, R> genérica que entrene con datos T y produzca resultados R.
// 14. Implementa una versión simplificada de k-NN usando Generics (con distancia euclidiana).
// 15. Crea una clase genérica Evaluador<T> que pueda comparar dos modelos ML de distintos tipos.

// =========================
// Nivel 4 - Modelación avanzada
// =========================
// 16. Modela la "Neuroplasticidad" creando una RedNeuronal<T> genérica donde T puede ser un tipo de neurona.
// 17. Implementa conexiones sinápticas genéricas entre nodos de distinto tipo.
// 18. Crea un SimuladorDeAprendizaje<T> que actualice pesos en función de experiencias genéricas.
// 19. Diseña un SistemaInmunologico<T> genérico que pueda adaptarse a distintos virus.
// 20. Integra todo en un ecosistema: Poblacion<Humano>, Poblacion<Computadora>, Virus<Malware>,
//     y un SistemaInmunologico que responda dinámicamente.

/*
  Notas:
  - Cada ejercicio te obliga a aprender un aspecto de Generics: bounded types, wildcards, Comparable, etc.
  - Los últimos ejercicios requieren investigar conceptos de ML y neurociencia para inspirar tus clases.
  - Puedes resolver cada bloque incrementalmente: primero los fundamentos, luego los de aplicación, etc.
*/

}
