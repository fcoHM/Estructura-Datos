package EstructuraDatos.Ordenamiento;

import EstructuraDatos.EDLineal.Arreglo;

public class MetodosOrdenamiento {

    public static Arreglo tournamentSort(Arreglo arregloOriginal) {
        int cantidadElementos = arregloOriginal.cantidad();
        Arreglo arregloOrdenado = new Arreglo(cantidadElementos);

        // Paso 1 se crea el arbol binario 
        int tamañoArbol = 2 * cantidadElementos - 1;
        Arreglo arbolTorneo = new Arreglo(tamañoArbol); // Tamaño del árbol completo

        // inicia las hojas del arbol con lo primeros datos 
        for (int indiceHoja = 0; indiceHoja < cantidadElementos; indiceHoja++) {
            arbolTorneo.ponerEn(cantidadElementos - 1 + indiceHoja, arregloOriginal.obtener(indiceHoja)); // Hojas del árbol
        }

        // llenar los nodos internos del árbol 
        for (int indiceNodoInterno = cantidadElementos - 2; indiceNodoInterno >= 0; indiceNodoInterno--) {
            int indiceHijoIzquierdo = 2 * indiceNodoInterno + 1;
            int indiceHijoDerecho = 2 * indiceNodoInterno + 2;

            Object valorHijoIzquierdo = arbolTorneo.obtener(indiceHijoIzquierdo);
            Object valorHijoDerecho = arbolTorneo.obtener(indiceHijoDerecho);
            // determinar cuál hijo es menor y ponerlo en el padre
            if (valorHijoIzquierdo == null && valorHijoDerecho == null) {
                arbolTorneo.ponerEn(indiceNodoInterno, null);
            } else if (valorHijoIzquierdo == null) {
                arbolTorneo.ponerEn(indiceNodoInterno, valorHijoDerecho);
            } else if (valorHijoDerecho == null) {
                arbolTorneo.ponerEn(indiceNodoInterno, valorHijoIzquierdo);
            } else {

                int valorIzquierdo = (Integer) valorHijoIzquierdo;
                int valorDerecho = (Integer) valorHijoDerecho;
                if (valorIzquierdo < valorDerecho) {
                    arbolTorneo.ponerEn(indiceNodoInterno, valorHijoIzquierdo);
                } else {
                    arbolTorneo.ponerEn(indiceNodoInterno, valorHijoDerecho);
                }
            }
        }

        // hacer los torneos y ir sacando las raices/ganadores 
        for (int iteracionOrdenamiento = 0; iteracionOrdenamiento < cantidadElementos; iteracionOrdenamiento++) {
            arregloOrdenado.poner(arbolTorneo.obtener(0)); // el ganador del torneo se agrega a la salida

            // sacar al ganador del torneo ---> hacerlo null
            int indiceGanador = -1;
            for (int indiceHoja = cantidadElementos - 1; indiceHoja < tamañoArbol; indiceHoja++) {
                if (arbolTorneo.obtener(indiceHoja) != null && arbolTorneo.obtener(indiceHoja).equals(arbolTorneo.obtener(0))) {
                    indiceGanador = indiceHoja;
                    break;
                }
            }

            arbolTorneo.ponerEn(indiceGanador, null); //eliminar ganador 

            // reconstruir el árbol después de eliminar el ganador
            int indicePadre = (indiceGanador - 1) / 2;
            while (indicePadre >= 0) {
                int indiceHijoIzquierdo = 2 * indicePadre + 1;
                int indiceHijoDerecho = 2 * indicePadre + 2;

                Object valorHijoIzquierdo = arbolTorneo.obtener(indiceHijoIzquierdo);
                Object valorHijoDerecho = arbolTorneo.obtener(indiceHijoDerecho);

                if (valorHijoIzquierdo == null && valorHijoDerecho == null) {
                    arbolTorneo.ponerEn(indicePadre, null);
                } else if (valorHijoIzquierdo == null) {
                    arbolTorneo.ponerEn(indicePadre, valorHijoDerecho);
                } else if (valorHijoDerecho == null) {
                    arbolTorneo.ponerEn(indicePadre, valorHijoIzquierdo);
                } else {
                    int valorIzquierdo = (Integer) valorHijoIzquierdo;
                    int valorDerecho = (Integer) valorHijoDerecho;
                    if (valorIzquierdo < valorDerecho) {
                        arbolTorneo.ponerEn(indicePadre, valorHijoIzquierdo);
                    } else {
                        arbolTorneo.ponerEn(indicePadre, valorHijoDerecho);
                    }
                }
                if (indicePadre == 0) break;
                indicePadre = (indicePadre - 1) / 2;
            }
        }

        return arregloOrdenado;
    }
}
