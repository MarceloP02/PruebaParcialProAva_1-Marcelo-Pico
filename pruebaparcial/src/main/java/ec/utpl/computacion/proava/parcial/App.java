package ec.utpl.computacion.proava.parcial;
public class App {
    public static void main(String[] args) {

        String[][] matriz = {
            {"Marcelo", "Lenin", "Marcelo"},
            {"Adrian",  "Marcelo",   "Pedro"},
            {"Marcelo", "Jefferson",   "Marcelo"}
        };

        String palabraBuscada = "Marcelo";
        int filas = matriz.length;
        Tarea[] hilos = new Tarea[filas];

        System.out.println("Buscando mi nombre dentro de mi matriz: \"" + palabraBuscada + "\"");

        for (int i = 0; i < filas; i++) {
            hilos[i] = new Tarea(matriz[i], palabraBuscada, i);
            hilos[i].start();
        }

        for (Tarea hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int total = 0;
        for (Tarea hilo : hilos) {
            total += hilo.getResultado();
        }

        System.out.println("Un total de " + total + " veces salio el nombre " + palabraBuscada);
    }
}