package principales;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDnoLineales.Arreglo2D;
import entradaSalida.Salida;

public class Practica6Arrglo2D {
    public static void main(String[] args) {
       // Crear una matriz 3x2 inicializada con valores
        Arreglo2D matriz = new Arreglo2D(3, 2);
        matriz.cambiar(0, 0, 1);
        matriz.cambiar(0, 1, 2);
        matriz.cambiar(1, 0, 3);
        matriz.cambiar(1, 1, 4);
        matriz.cambiar(2, 0, 5);
        matriz.cambiar(2, 1, 6);

        // Imprimir la matriz original
        Salida.salidaPorDefecto("Matriz original:\n");
        matriz.imprimirXColumnas();

        // Realizar la transposición
        matriz.transpuesta();

        // Imprimir la matriz transpuesta
        Salida.salidaPorDefecto("\nMatriz transpuesta:\n");
        matriz.imprimirXColumnas();
    }
}
