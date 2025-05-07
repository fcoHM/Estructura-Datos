package principales;

import EstructuraDatos.EDLineal.colaPrioridad.ColaPrioridad;
import EstructuraDatos.EDLineal.colaPrioridad.ObjetosComplejos;

public class PrincipalColaPrioridad {
    public static void main(String[] args) {
        // Crear una cola de prioridad con capacidad de 5 elementos
        ColaPrioridad cola = new ColaPrioridad(5);

        // Probar si la cola está vacía
        System.out.println("¿La cola está vacía? " + cola.vacia());

        // Agregar elementos con diferentes prioridades
        cola.poner(new ObjetosComplejos("Elemento1", 2));
        cola.poner(new ObjetosComplejos("Elemento2", 5));
        cola.poner(new ObjetosComplejos("Elemento3", 5));
        cola.poner(new ObjetosComplejos("Elemento4", 4));

        // Imprimir la cola
        System.out.println("\nCola después de agregar elementos:");
        cola.imprimir();

        // Probar si la cola está llena
        System.out.println("\n¿La cola está llena? " + cola.lleno());

        // Quitar el elemento con mayor prioridad
        System.out.println("\nElemento quitado: " + cola.quitar());

        // Imprimir la cola después de quitar un elemento
        System.out.println("\nCola después de quitar un elemento:");
        cola.imprimir();

        // Agregar otro elemento
        cola.poner(new ObjetosComplejos("Elemento5", 3));
        System.out.println("\nCola después de agregar otro elemento:");
        cola.imprimir();

        // Quitar todos los elementos
        while (!cola.vacia()) {
            System.out.println("\nElemento quitado: " + cola.quitar());
            System.out.println("Cola actual:");
            cola.imprimir();
        }

        // Probar si la cola está vacía después de quitar todos los elementos
        System.out.println("\n¿La cola está vacía? " + cola.vacia());
    }
}
