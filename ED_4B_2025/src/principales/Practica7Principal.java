package principales;

import EstructuraDatos.EDLineal.ArregloNumerico;
import EstructuraDatos.EDnoLineales.Arreglo2DNumerico;
import entradaSalida.Salida;
import tools.comunesBase.TipoLogaritmo;

public class Practica7Principal {
    public static void main(String[] args) {
        /* 
        Arreglo2DNumerico arreN = new Arreglo2DNumerico(2, 2, 2);
        Salida.salidaPorDefecto("matriz original\n");
        arreN.imprimirXColumnas();
        
        arreN.porEscalar(2);
        Salida.salidaPorDefecto("matriz x2\n");
        arreN.imprimirXColumnas();
        */







        // Crear una matriz numérica 2x2 inicializada con valores
        /* 
        Arreglo2DNumerico matriz = new Arreglo2DNumerico(2, 2, 2);

        // Crear un arreglo numérico con escalares (4 elementos)
        ArregloNumerico escalares = new ArregloNumerico(4);
        escalares.poner(1); // Escalar para la posición (0, 0)
        escalares.poner(2); // Escalar para la posición (0, 1)
        escalares.poner(3); // Escalar para la posición (1, 0)
        escalares.poner(4); // Escalar para la posición (1, 1)

        // Imprimir la matriz original
        Salida.salidaPorDefecto("Matriz original:\n");
        matriz.imprimirXColumnas();

        // Multiplicar la matriz por los escalares
        if (matriz.porEscalares(escalares)) {
            Salida.salidaPorDefecto("\nMatriz después de multiplicar por escalares:\n");
            matriz.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError: El número de escalares no coincide con el tamaño de la matriz.\n");
        }
        */

        /* 
        // Crear una matriz numérica 3x3 inicializada con valores
        Arreglo2DNumerico matriz = new Arreglo2DNumerico(3, 3, 5);

        // Imprimir la matriz original
        Salida.salidaPorDefecto("Matriz original:\n");
        matriz.imprimirXColumnas();

        // Sumar un escalar a la matriz
        double escalar = 3.5;
        if (matriz.sumarEscalar(escalar)) {
            Salida.salidaPorDefecto("\nMatriz después de sumar el escalar " + escalar + ":\n");
            matriz.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError al sumar el escalar a la matriz.\n");
        }
            */

        /*
          // Crear una matriz numérica 2x2 inicializada con valores
          Arreglo2DNumerico matriz = new Arreglo2DNumerico(2, 2, 1);

          // Crear un arreglo numérico con escalares (4 elementos)
          ArregloNumerico escalares = new ArregloNumerico(4);
          escalares.poner(1); // Escalar para la posición (0, 0)
          escalares.poner(2); // Escalar para la posición (0, 1)
          escalares.poner(3); // Escalar para la posición (1, 0)
          escalares.poner(4); // Escalar para la posición (1, 1)
  
          // Imprimir la matriz original
          Salida.salidaPorDefecto("Matriz original:\n");
          matriz.imprimirXColumnas();
  
          // Sumar los escalares a la matriz
          if (matriz.sumarEscalares(escalares)) {
              Salida.salidaPorDefecto("\nMatriz después de sumar los escalares:\n");
              matriz.imprimirXColumnas();
          } else {
              Salida.salidaPorDefecto("\nError: El número de escalares no coincide con el tamaño de la matriz.\n");
          }
         */


         /* 
        // Crear la primera matriz numérica 2x2 inicializada con valores
        Arreglo2DNumerico matriz1 = new Arreglo2DNumerico(2, 2);
        matriz1.cambiar(0, 0, 1);
        matriz1.cambiar(0, 1, 2);
        matriz1.cambiar(1, 0, 3);
        matriz1.cambiar(1, 1, 4);

        // Crear la segunda matriz numérica 2x2 inicializada con valores
        Arreglo2DNumerico matriz2 = new Arreglo2DNumerico(2, 2);
        matriz2.cambiar(0, 0, 5);
        matriz2.cambiar(0, 1, 6);
        matriz2.cambiar(1, 0, 7);
        matriz2.cambiar(1, 1, 8);

        // Imprimir las matrices originales
        Salida.salidaPorDefecto("Matriz 1:\n");
        matriz1.imprimirXColumnas();

        Salida.salidaPorDefecto("\nMatriz 2:\n");
        matriz2.imprimirXColumnas();

        // Multiplicar las matrices
        if (matriz1.multiplicar(matriz2)) {
            Salida.salidaPorDefecto("\nMatriz 1 después de multiplicar por Matriz 2:\n");
            matriz1.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError: Las matrices no tienen el mismo tamaño.\n");
        }
        */


        /* 
        // Crear la primera matriz numérica 2x2 inicializada con valores
        Arreglo2DNumerico matriz1 = new Arreglo2DNumerico(2, 2);
        matriz1.cambiar(0, 0, 1);
        matriz1.cambiar(0, 1, 2);
        matriz1.cambiar(1, 0, 3);
        matriz1.cambiar(1, 1, 4);

        // Crear la segunda matriz numérica 2x2 inicializada con valores
        Arreglo2DNumerico matriz2 = new Arreglo2DNumerico(2, 2);
        matriz2.cambiar(0, 0, 5);
        matriz2.cambiar(0, 1, 6);
        matriz2.cambiar(1, 0, 7);
        matriz2.cambiar(1, 1, 8);

        // Imprimir las matrices originales
        Salida.salidaPorDefecto("Matriz 1:\n");
        matriz1.imprimirXColumnas();

        Salida.salidaPorDefecto("\nMatriz 2:\n");
        matriz2.imprimirXColumnas();

        // Sumar las matrices
        if (matriz1.sumar(matriz2)) {
            Salida.salidaPorDefecto("\nMatriz 1 después de sumar Matriz 2:\n");
            matriz1.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError: Las matrices no tienen el mismo tamaño.\n");
        }
        */





        /* 
        // Crear una matriz numérica 2x2 inicializada con valores
        Arreglo2DNumerico matriz = new Arreglo2DNumerico(2, 2);
        matriz.cambiar(0, 0, 2);
        matriz.cambiar(0, 1, 3);
        matriz.cambiar(1, 0, 4);
        matriz.cambiar(1, 1, 5);

        // Imprimir la matriz original
        Salida.salidaPorDefecto("Matriz original:\n");
        matriz.imprimirXColumnas();

        // Aplicar potencia a la matriz
        int potencia = 3; // Elevar cada elemento al cubo
        if (matriz.aplicarPotencia(potencia)) {
            Salida.salidaPorDefecto("\nMatriz después de aplicar potencia " + potencia + ":\n");
            matriz.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError al aplicar la potencia a la matriz.\n");
        }

        */




        /* 
                // Crear una matriz numérica 2x2 inicializada con valores
        Arreglo2DNumerico matriz = new Arreglo2DNumerico(2, 2);
        matriz.cambiar(0, 0, 1);
        matriz.cambiar(0, 1, 10);
        matriz.cambiar(1, 0, 100);
        matriz.cambiar(1, 1, 1000);

        // Imprimir la matriz original
        Salida.salidaPorDefecto("Matriz original:\n");
        matriz.imprimirXColumnas();

        // Aplicar logaritmo en base 10
        if (matriz.aplicarLogartimo(TipoLogaritmo.BASE10)) {
            Salida.salidaPorDefecto("\nMatriz después de aplicar logaritmo base 10:\n");
            matriz.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError: No se pudo aplicar el logaritmo base 10 (posiblemente hay ceros en la matriz).\n");
        }

        // Reiniciar la matriz con nuevos valores
        matriz.cambiar(0, 0, 2);
        matriz.cambiar(0, 1, 4);
        matriz.cambiar(1, 0, 8);
        matriz.cambiar(1, 1, 16);

        // Imprimir la matriz reiniciada
        Salida.salidaPorDefecto("\nMatriz reiniciada:\n");
        matriz.imprimirXColumnas();

        // Aplicar logaritmo en base 2
        if (matriz.aplicarLogartimo(TipoLogaritmo.BASE2)) {
            Salida.salidaPorDefecto("\nMatriz después de aplicar logaritmo base 2:\n");
            matriz.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError: No se pudo aplicar el logaritmo base 2 (posiblemente hay ceros en la matriz).\n");
        }
        */




        /* 
        // Crear una matriz numérica 4x4
        Arreglo2DNumerico matriz = new Arreglo2DNumerico(4, 3);

        // Imprimir la matriz original
        Salida.salidaPorDefecto("Matriz original:\n");
        matriz.imprimirXColumnas();

        // Generar una matriz diagonal con el valor 7
        int valorDiagonal = 7;
        if (matriz.matrizDiagonal(valorDiagonal)) {
            Salida.salidaPorDefecto("\nMatriz después de generar la diagonal con el valor " + valorDiagonal + ":\n");
            matriz.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError al generar la matriz diagonal.\n");
        }
        */




        /* 
        // Crear una matriz numérica 4x4 inicializada con valores
        Arreglo2DNumerico matriz = new Arreglo2DNumerico(4, 4);
        matriz.cambiar(0, 0, 1);
        matriz.cambiar(0, 1, 2);
        matriz.cambiar(0, 2, 3);
        matriz.cambiar(0, 3, 4);

        matriz.cambiar(1, 0, 5);
        matriz.cambiar(1, 1, 6);
        matriz.cambiar(1, 2, 7);
        matriz.cambiar(1, 3, 8);

        matriz.cambiar(2, 0, 9);
        matriz.cambiar(2, 1, 10);
        matriz.cambiar(2, 2, 11);
        matriz.cambiar(2, 3, 12);

        matriz.cambiar(3, 0, 13);
        matriz.cambiar(3, 1, 14);
        matriz.cambiar(3, 2, 15);
        matriz.cambiar(3, 3, 16);

        // Imprimir la matriz original
        Salida.salidaPorDefecto("Matriz original:\n");
        matriz.imprimirXColumnas();

        // Aplicar el método doblarRenglones
        if (matriz.doblarRenglones()) {
            Salida.salidaPorDefecto("\nMatriz después de doblar renglones:\n");
            matriz.imprimirXColumnas();
        } else {
            Salida.salidaPorDefecto("\nError: No se pudo doblar los renglones porque el número de columnas no es par.\n");
        }
        */






         // Crear una matriz numérica 4x4 inicializada con valores
         Arreglo2DNumerico matriz = new Arreglo2DNumerico(4, 4);
         matriz.cambiar(0, 0, 1);
         matriz.cambiar(0, 1, 2);
         matriz.cambiar(0, 2, 3);
         matriz.cambiar(0, 3, 4);
 
         matriz.cambiar(1, 0, 5);
         matriz.cambiar(1, 1, 6);
         matriz.cambiar(1, 2, 7);
         matriz.cambiar(1, 3, 8);
 
         matriz.cambiar(2, 0, 9);
         matriz.cambiar(2, 1, 10);
         matriz.cambiar(2, 2, 11);
         matriz.cambiar(2, 3, 12);
 
         matriz.cambiar(3, 0, 13);
         matriz.cambiar(3, 1, 14);
         matriz.cambiar(3, 2, 15);
         matriz.cambiar(3, 3, 16);
 
         // Imprimir la matriz original
         Salida.salidaPorDefecto("Matriz original:\n");
         matriz.imprimirXColumnas();
 
         // Aplicar el método doblarColumnas
         if (matriz.doblarColumnas()) {
             Salida.salidaPorDefecto("\nMatriz después de doblar columnas:\n");
             matriz.imprimirXColumnas();
         } else {
             Salida.salidaPorDefecto("\nError: No se pudo doblar las columnas porque el número de filas no es par.\n");
         }

    }//main
}//class
