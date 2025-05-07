package principales;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ListaDin;
import EstructuraDatos.EDnoLineales.Arreglo2D;
import entradaSalida.Salida;
import tools.comunesBase.TipoTabla;

public class PrincipalListaDin {
    public static void main(String[] args) {
         /* 
        ListaDin lista = new  ListaDin();
        lista.poner("a");
        lista.poner("x");
        lista.poner("m");
        lista.poner("r");
        lista.poner("r");
        
       
        Salida.salidaPorDefecto("inverso\n");
        lista.imprimirDesc();
        Salida.salidaPorDefecto("\nnormal\n");
        lista.imprimir();
        */


        /*
         ListaDin listaNueva = lista.encontarLista("g");
        listaNueva.imprimir();
         */

        
        /*
        Arreglo arreglo = lista.aListaEstatica();
        arreglo.imprimir();
         */


         /* 
        ListaDin lista2 = new ListaDin();
        lista2.poner(1);
        lista2.poner(2);
        lista2.poner(3);

        Arreglo2D arre2d = lista2.aMatriz2D(2,4);
        arre2d.imprimirXColumnas();
        */



        /* 
        // Crear una lista dinámica
        ListaDin lista1 = new ListaDin();
        lista1.poner("A");
        lista1.poner("B");
        lista1.poner("C");

        // Crear otra lista dinámica
        ListaDin lista2 = new ListaDin();
        lista2.poner("D");
        lista2.poner("E");
        lista2.poner("F");

        // Crear un arreglo
        Arreglo arreglo = new Arreglo(3);
        arreglo.poner("G");
        arreglo.poner("H");
        arreglo.poner("I");

        // Probar agregarLista con otra lista dinámica
        System.out.println("Antes de agregar lista2 a lista1:");
        lista1.imprimir();


        boolean resultado1 = lista1.agregarLista(lista2);
        System.out.println("Resultado de agregar lista2 a lista1: " + resultado1);
    
        lista1.imprimir();

        // Probar agregarLista con un arreglo
        

        boolean resultado2 = lista1.agregarLista(arreglo);
        System.out.println("Resultado de agregar arreglo a lista1: " + resultado2);
      
        lista1.imprimir();
        */



        /*
         // Crear una lista dinámica y agregar elementos
        ListaDin listaOriginal = new ListaDin();
        listaOriginal.poner("A");
        listaOriginal.poner("B");
        listaOriginal.poner("C");

        // Imprimir la lista original
        System.out.println("Lista original:");
        listaOriginal.imprimir();

        // Clonar la lista
        ListaDin listaClonada = (ListaDin) listaOriginal.clonar();

        // Imprimir la lista clonada
        System.out.println("Lista clonada:");
        listaClonada.imprimir();

       
        listaOriginal.poner("D");

        System.out.println("Lista original después de agregar un elemento:");
        listaOriginal.imprimir();

        System.out.println("Lista clonada después de modificar la original:");
        listaClonada.imprimir();

         */



         /*
          
        // Crear una matriz 2D de 3x3
        Arreglo2D matriz = new Arreglo2D(3, 3, null);

        // Llenar la matriz con valores
        int valor = 1;
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                matriz.cambiar(fila, columna, valor++);
            }
        }

        // Imprimir la matriz
        System.out.println("Matriz original:");
        for (int fila = 0; fila < 3; fila++) {
            for (int columna = 0; columna < 3; columna++) {
                System.out.print(matriz.obtener(fila, columna) + "\t");
            }
            System.out.println();
        }

        // Crear una lista dinámica
        ListaDin lista1 = new ListaDin();

        // Agregar los elementos de la matriz a la lista por renglón
        System.out.println("\nAgregando elementos de la matriz a la lista por renglón:");
        lista1.agregarMatriz2D(matriz, TipoTabla.RENGLON);
        lista1.imprimir();

          */
        

        /*
         // Imprimir la lista antes de vaciarla
        System.out.println("Lista antes de vaciar:");
        lista.imprimir();

        // Vaciar la lista
        lista.vaciar();

        // Verificar si la lista está vacía
        System.out.println("¿La lista está vacía? " + lista.vacio());

        // Intentar imprimir la lista después de vaciarla
        System.out.println("Lista después de vaciar:");
        lista.imprimir();
         */



         /*
          Salida.salidaPorDefecto("original\n");
        lista.imprimir();
        
        lista.rellenar("j", 4);

        Salida.salidaPorDefecto("rellenada\n");
        lista.imprimir();
          */
        
        /*
         // Crear una lista dinámica
        ListaDin lista = new ListaDin();
        lista.poner("A");
        lista.poner("B");
        lista.poner("A");
        lista.poner("C");
        lista.poner("A");

        // Imprimir la lista
        System.out.println("Lista:");
        lista.imprimir();

        // Contar ocurrencias de "A"
        int ocurrenciasA = lista.contar("A");
        System.out.println("Ocurrencias de 'A': " + ocurrenciasA);

        // Contar ocurrencias de "B"
        int ocurrenciasB = lista.contar("B");
        System.out.println("Ocurrencias de 'B': " + ocurrenciasB);

        // Contar ocurrencias de un elemento que no está en la lista
        int ocurrenciasD = lista.contar("D");
        System.out.println("Ocurrencias de 'D': " + ocurrenciasD);
         */

         
         // Crear una lista dinámica
         ListaDin lista = new ListaDin();

         // Agregar elementos a la lista
         lista.poner("A");
         lista.poner("B");
         lista.poner("C");
         lista.poner("D");
 
         // Imprimir la lista antes de invertir
         System.out.println("Lista antes de invertir:");
         lista.imprimir();
 
         // Invertir la lista
         lista.invertir();
 
         // Imprimir la lista después de invertir
         System.out.println("Lista después de invertir:");
         lista.imprimir();



    }
}
