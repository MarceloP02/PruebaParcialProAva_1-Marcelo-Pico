package ec.utpl.computacion.proava.parcial;

import java.util.Arrays;
import java.util.concurrent.Callable;

// Implementamos Callable indicando que el hilo devolverá un Integer al finalizar
public class BuscadorTarea implements Callable<Integer> {
    
    // Usamos 'final' para garantizar la inmutabilidad y seguridad entre hilos
    private final String[] fila;
    private final String palabraBuscada;
    private final int indice;

    public BuscadorTarea(String[] fila, String palabraBuscada, int indice) {
        this.fila = fila;
        this.palabraBuscada = palabraBuscada;
        this.indice = indice;
    }

    @Override
    public Integer call() {
        // Reemplazo del bucle 'for' tradicional por la API de Streams.
        // Convierte el arreglo en un flujo de datos, filtra las coincidencias y las cuenta.
        long coincidencias = Arrays.stream(fila)
                                   .filter(celda -> celda.equalsIgnoreCase(palabraBuscada))
                                   .count();
        
        System.out.println("Hilo numero-" + indice + " ha finalizado. Se encontro: " + coincidencias);
        
        // Retornamos directamente el resultado, sin necesidad de métodos getter
        return (int) coincidencias;
    }
}