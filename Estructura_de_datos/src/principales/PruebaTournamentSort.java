package principales;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.Ordenamiento.MetodosOrdenamiento;
import entradaSalida.Salida;


public class PruebaTournamentSort {
   public static void main(String[] args) {
        Arreglo arreglo = new Arreglo(12);
        arreglo.poner(10);
        arreglo.poner(4);
        arreglo.poner(12);
        arreglo.poner(9);
        arreglo.poner(3);
        arreglo.poner(1);
        arreglo.poner(7);
        arreglo.poner(8);
        arreglo.poner(6);
        arreglo.poner(11);
        arreglo.poner(5);
        arreglo.poner(2);

        Salida.salidaPorDefecto("Arreglo original:\n");
        arreglo.imprimir();
        Arreglo arregloOrdenado = MetodosOrdenamiento.tournamentSort(arreglo);

        Salida.salidaPorDefecto("\nArreglo ordenado con Tournament Sort:\n");
        arregloOrdenado.imprimir();
   }
}
