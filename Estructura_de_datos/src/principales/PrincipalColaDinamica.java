package principales;

import EstructuraDatos.EDLineal.ColaDinamica;
import entradaSalida.Salida;

public class PrincipalColaDinamica {
    public static void main(String[] args) {
         // Crear una instancia de ColaDinamica
        ColaDinamica cola = new ColaDinamica();

        // Probar si la cola está vacía
        Salida.salidaPorDefecto("¿La cola está vacía? " + cola.vacia() + "\n");

        // Agregar elementos a la cola
        Salida.salidaPorDefecto("Agregando elementos a la cola...\n");
        cola.poner(10);
        cola.poner(20);
        cola.poner(30);

        // Mostrar el estado de la cola
        Salida.salidaPorDefecto("¿La cola está vacía? " + cola.vacia() + "\n");

        // Ver el tope de la cola
        Salida.salidaPorDefecto("Elemento en el frente de la cola: " + cola.verTope() + "\n");

        // Imprimir todos los elementos de la cola
        Salida.salidaPorDefecto("Elementos en la cola:\n");
        cola.imprimir();

        // Quitar elementos de la cola
        Salida.salidaPorDefecto("Quitando elementos de la cola...\n");
        Salida.salidaPorDefecto("Elemento quitado: " + cola.quitar() + "\n");
        Salida.salidaPorDefecto("Elemento quitado: " + cola.quitar() + "\n");

        // Ver el tope de la cola después de quitar elementos
        Salida.salidaPorDefecto("Elemento en el frente de la cola: " + cola.verTope() + "\n");

        // Imprimir los elementos restantes en la cola
        Salida.salidaPorDefecto("Elementos restantes en la cola:\n");
        cola.imprimir();

        // Intentar quitar más elementos de los que hay
        Salida.salidaPorDefecto("Quitando el último elemento...\n");
        Salida.salidaPorDefecto("Elemento quitado: " + cola.quitar() + "\n");
        Salida.salidaPorDefecto("¿La cola está vacía? " + cola.vacia() + "\n");
        Salida.salidaPorDefecto("Intentando quitar de una cola vacía: " + cola.quitar() + "\n");
    }
}
