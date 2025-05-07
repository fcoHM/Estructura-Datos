package principales;

import EstructuraDatos.EDLineal.pilas.PilaDinamica;
import entradaSalida.Salida;

public class PricipalPilaDinamica {
    public static void main(String[] args) {
        // Crear una instancia de PilaDinamica
        PilaDinamica pila = new PilaDinamica();

        // Probar si la pila está vacía
        Salida.salidaPorDefecto("¿La pila está vacía? " + pila.vacia() + "\n");

        // Agregar elementos a la pila
        Salida.salidaPorDefecto("Agregando elementos a la pila...\n");
        pila.poner(10);
        pila.poner(20);
        pila.poner(30);

        // Mostrar el estado de la pila
        Salida.salidaPorDefecto("¿La pila está vacía? " + pila.vacia() + "\n");

        // Ver el tope de la pila
        Salida.salidaPorDefecto("Elemento en el tope de la pila: " + pila.verTope() + "\n");

        // Imprimir todos los elementos de la pila
        Salida.salidaPorDefecto("Elementos en la pila:\n");
        pila.imprimir();

        // Quitar elementos de la pila
        Salida.salidaPorDefecto("Quitando elementos de la pila...\n");
        Salida.salidaPorDefecto("Elemento quitado: " + pila.quitar() + "\n");
        Salida.salidaPorDefecto("Elemento quitado: " + pila.quitar() + "\n");

        // Ver el tope de la pila después de quitar elementos
        Salida.salidaPorDefecto("Elemento en el tope de la pila: " + pila.verTope() + "\n");

        // Imprimir los elementos restantes en la pila
        Salida.salidaPorDefecto("Elementos restantes en la pila:\n");
        pila.imprimir();

        // Intentar quitar más elementos de los que hay
        Salida.salidaPorDefecto("Quitando el último elemento...\n");
        Salida.salidaPorDefecto("Elemento quitado: " + pila.quitar() + "\n");
        Salida.salidaPorDefecto("¿La pila está vacía? " + pila.vacia() + "\n");
        Salida.salidaPorDefecto("Intentando quitar de una pila vacía: " + pila.quitar() + "\n");
    }
}