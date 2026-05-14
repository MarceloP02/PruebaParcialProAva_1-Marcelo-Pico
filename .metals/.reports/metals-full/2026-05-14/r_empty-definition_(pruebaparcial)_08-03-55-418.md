error id: file:///C:/Users/USUARIO/Desktop/PruebaParcialProAva_1-Marcelo-Pico/pruebaparcial/src/main/java/ec/utpl/computacion/proava/parcial/App.java:local8
file:///C:/Users/USUARIO/Desktop/PruebaParcialProAva_1-Marcelo-Pico/pruebaparcial/src/main/java/ec/utpl/computacion/proava/parcial/App.java
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol local8
empty definition using fallback
non-local guesses:

offset: 1035
uri: file:///C:/Users/USUARIO/Desktop/PruebaParcialProAva_1-Marcelo-Pico/pruebaparcial/src/main/java/ec/utpl/computacion/proava/parcial/App.java
text:
```scala
package ec.utpl.computacion.proava.parcial;
public class App {
    public static void main(String[] args) {

        String[][] matriz = {
            {"Java", "Python", "Java"},
            {"C++",  "Java",   "Go"},
            {"Java", "Rust",   "Java"}
        };

        String palabraBuscada = "Java";
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
        for (Tarea hilo : hilos) {
            total += hilo.getResultado();
        }

        System.out.println("Un total de  \"" + palabraBuscada + "\" aparece " + total@@ + " veces.");
    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 