package EstructuraDatos.TrabajoFinal.Axiliares;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.TrabajoFinal.Registros.DistanciaObjeto;

public class MetodosOrdenamientoObjetosDistancia {

    public static Arreglo bubbleSort(Arreglo arregloOriginal) {
        Arreglo arregloOrdenado = new Arreglo(arregloOriginal.cantidad());
        // Copiar los elementos
        for (int indice = 0; indice < arregloOriginal.cantidad(); indice++) {
            arregloOrdenado.poner(arregloOriginal.obtener(indice));
        }
        int cantidadElementos = arregloOrdenado.cantidad();
        for (int pasada = 0; pasada < cantidadElementos - 1; pasada++) {
            for (int indiceActual = 0; indiceActual < cantidadElementos - pasada - 1; indiceActual++) {
                DistanciaObjeto objetoActual = (DistanciaObjeto) arregloOrdenado.obtener(indiceActual);
                DistanciaObjeto objetoSiguiente = (DistanciaObjeto) arregloOrdenado.obtener(indiceActual + 1);
                if (objetoActual.getDistancia() > objetoSiguiente.getDistancia()) {
                    // Intercambiar manualmente
                    Object temporal = arregloOrdenado.obtener(indiceActual);
                    arregloOrdenado.datos[indiceActual] = arregloOrdenado.datos[indiceActual + 1];
                    arregloOrdenado.datos[indiceActual + 1] = temporal;
                }
            }
        }
        return arregloOrdenado;
    }
}
