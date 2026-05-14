error id: file:///C:/Users/USUARIO/Desktop/PruebaParcialProAva_1-Marcelo-Pico/pruebaparcial/src/main/java/ec/utpl/computacion/proava/parcial/App.java:local9
file:///C:/Users/USUARIO/Desktop/PruebaParcialProAva_1-Marcelo-Pico/pruebaparcial/src/main/java/ec/utpl/computacion/proava/parcial/App.java
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol local9
empty definition using fallback
non-local guesses:

offset: 909
uri: file:///C:/Users/USUARIO/Desktop/PruebaParcialProAva_1-Marcelo-Pico/pruebaparcial/src/main/java/ec/utpl/computacion/proava/parcial/App.java
text:
```scala
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

        System.out.println("Buscando el termino:: \"" + palabraBuscada + "\"");

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
        for (Tarea hilo@@ : hilos) {
            total += hilo.getResultado();
        }

        System.out.println("Un total de " + total + "veces salio el nombre " + palabraBuscada);
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 