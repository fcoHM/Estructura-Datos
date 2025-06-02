package EstructuraDatos.Ordenamiento;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.Auxiliares.NodoTorneo;

public class MetodosOrdenamiento {

   public static Arreglo tournamentSort(Arreglo arregloOriginal) {
        int cantidadElementos = arregloOriginal.cantidad();
        Arreglo arregloOrdenado = new Arreglo(cantidadElementos);

        int tamañoArbolTorneo = 2 * cantidadElementos - 1;
        Arreglo arbolTorneo = new Arreglo(tamañoArbolTorneo);

        // 1. Colocar los elementos del arreglo original como hojas del árbol
        for (int indiceElemento = 0; indiceElemento < cantidadElementos; indiceElemento++) {
            int valorElemento = (Integer) arregloOriginal.obtener(indiceElemento);
            arbolTorneo.ponerEn(cantidadElementos - 1 + indiceElemento, new NodoTorneo(valorElemento, indiceElemento));
        }

        // 2. Construir nodos internos (el torneo)
        for (int indiceNodoInterno = cantidadElementos - 2; indiceNodoInterno >= 0; indiceNodoInterno--) {
            NodoTorneo nodoIzquierdo = (NodoTorneo) arbolTorneo.obtener(2 * indiceNodoInterno + 1);
            NodoTorneo nodoDerecho = (NodoTorneo) arbolTorneo.obtener(2 * indiceNodoInterno + 2);

            if (nodoIzquierdo == null && nodoDerecho == null) {
                arbolTorneo.ponerEn(indiceNodoInterno, null);
            } else if (nodoIzquierdo == null) {
                arbolTorneo.ponerEn(indiceNodoInterno, nodoDerecho);
            } else if (nodoDerecho == null) {
                arbolTorneo.ponerEn(indiceNodoInterno, nodoIzquierdo);
            } else {
                // Comparar por valor
                if (nodoIzquierdo.valor <= nodoDerecho.valor) {
                    arbolTorneo.ponerEn(indiceNodoInterno, nodoIzquierdo);
                } else {
                    arbolTorneo.ponerEn(indiceNodoInterno, nodoDerecho);
                }
            }
        }

        // 3. Extraer ordenadamente los elementos
        for (int iteracionExtraccion = 0; iteracionExtraccion < cantidadElementos; iteracionExtraccion++) {
            NodoTorneo nodoGanador = (NodoTorneo) arbolTorneo.obtener(0);
            arregloOrdenado.poner(nodoGanador.valor);  // Agregar valor ordenado

            // Eliminar la hoja exacta donde estaba ese valor
            int indiceHojaGanadora = cantidadElementos - 1 + nodoGanador.indiceOriginal;
            arbolTorneo.ponerEn(indiceHojaGanadora, null);

            // Reconstruir el árbol desde esa hoja hacia arriba
            int indicePadre = (indiceHojaGanadora - 1) / 2;
            while (indicePadre >= 0) {
                NodoTorneo nodoHijoIzquierdo = null, nodoHijoDerecho = null;

                int indiceHijoIzquierdo = 2 * indicePadre + 1;
                int indiceHijoDerecho = 2 * indicePadre + 2;

                if (indiceHijoIzquierdo < tamañoArbolTorneo)
                    nodoHijoIzquierdo = (NodoTorneo) arbolTorneo.obtener(indiceHijoIzquierdo);
                if (indiceHijoDerecho < tamañoArbolTorneo)
                    nodoHijoDerecho = (NodoTorneo) arbolTorneo.obtener(indiceHijoDerecho);

                if (nodoHijoIzquierdo == null && nodoHijoDerecho == null) {
                    arbolTorneo.ponerEn(indicePadre, null);
                } else if (nodoHijoIzquierdo == null) {
                    arbolTorneo.ponerEn(indicePadre, nodoHijoDerecho);
                } else if (nodoHijoDerecho == null) {
                    arbolTorneo.ponerEn(indicePadre, nodoHijoIzquierdo);
                } else {
                    if (nodoHijoIzquierdo.valor <= nodoHijoDerecho.valor) {
                        arbolTorneo.ponerEn(indicePadre, nodoHijoIzquierdo);
                    } else {
                        arbolTorneo.ponerEn(indicePadre, nodoHijoDerecho);
                    }
                }

                if (indicePadre == 0) break;
                indicePadre = (indicePadre - 1) / 2;
            }
        }

        return arregloOrdenado;
    }
}
