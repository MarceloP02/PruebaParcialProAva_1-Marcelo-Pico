package ec.utpl.computacion.proava.parcial;
public class Tarea extends Thread {
    private String[] fila;
    private String palabraBuscada;
    private int indice;
    private int resultado;

    public Tarea(String[] fila, String palabraBuscada, int indice) {
        this.fila = fila;
        this.palabraBuscada = palabraBuscada;
        this.indice = indice;
    }
    @Override
    public void run() {
        resultado = 0;
        for (String celda : fila) {
            if (celda.equalsIgnoreCase(palabraBuscada))
                resultado++;
        }
        System.out.println("Hilonumero-" + indice + " ha finalizado. Se encontro: " + resultado);
    }

    public int getResultado() {
        return resultado;
    }
}