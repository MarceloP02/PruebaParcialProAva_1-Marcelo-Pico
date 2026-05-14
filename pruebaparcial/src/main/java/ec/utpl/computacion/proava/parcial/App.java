package ec.utpl.computacion.proava.parcial;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {

        String[][] matriz = {
            {"Marcelo", "Lenin", "Marcelo"},
            {"Adrian",  "Marcelo",   "Pedro"},
            {"Marcelo", "Jefferson",   "Marcelo"}
        };

        String palabraBuscada = "Marcelo";
        int filas = matriz.length;

        System.out.println("Buscando mi nombre dentro de mi matriz: \"" + palabraBuscada + "\"");

        // 1. Configuramos un Pool de Hilos basado en la capacidad real del procesador
        int nucleosDisponibles = Runtime.getRuntime().availableProcessors();
        ExecutorService ejecutor = Executors.newFixedThreadPool(nucleosDisponibles);

        // 2. Lista para almacenar las "promesas" de resultados (Futures)
        List<Future<Integer>> resultadosFuturos = new ArrayList<>();

        // 3. Reemplazo del primer bucle 'for': Usamos IntStream para enviar las tareas
        IntStream.range(0, filas).forEach(i -> {
            BuscadorTarea tarea = new BuscadorTarea(matriz[i], palabraBuscada, i);
            resultadosFuturos.add(ejecutor.submit(tarea)); // submit() ejecuta la tarea y devuelve un Future
        });

        // 4. Reemplazo de los bucles 'for' de recolección y suma: Usamos Streams para calcular el total
        int total = resultadosFuturos.stream()
            .mapToInt(futuro -> {
                try {
                    // futuro.get() reemplaza a tu hilo.join() y getResultado(). 
                    // Espera automáticamente a que el hilo termine y extrae el valor.
                    return futuro.get();
                } catch (InterruptedException e) {
                    // Restauramos el estado de interrupción (Mejor práctica en concurrencia)
                    Thread.currentThread().interrupt(); 
                    System.err.println("El hilo principal fue interrumpido.");
                    return 0;
                } catch (ExecutionException e) {
                    System.err.println("Error interno en la tarea: " + e.getCause());
                    return 0;
                }
            })
            .sum(); // Suma todos los enteros extraídos del Future

        // 5. Apagamos el administrador de hilos de forma segura
        ejecutor.shutdown();

        System.out.println("Un total de " + total + " veces salio el nombre " + palabraBuscada);
    }
}