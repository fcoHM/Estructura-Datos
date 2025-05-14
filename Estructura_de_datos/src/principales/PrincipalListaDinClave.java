package principales;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ListaDinClave;
import entradaSalida.Salida;

public class PrincipalListaDinClave {
     public static void main(String[] args) {
        // Crear una instancia de ListaDinClave
        ListaDinClave lista = new ListaDinClave();

        // Probar el método poner
        Salida.salidaPorDefecto("Agregando elementos a la lista:\n");
        lista.poner("Valor1", "Clave1"); // Agregar un nodo con clave "Clave1"
        lista.poner("Valor2", "Clave2"); // Agregar un nodo con clave "Clave2"
        lista.poner("Valor3", "Clave3"); // Agregar un nodo con clave "Clave3"
         // Imprimir la lista
        Salida.salidaPorDefecto("Contenido de la lista:\n");
        lista.imprimir();
        // Intentar agregar un nodo con una clave existente
        Salida.salidaPorDefecto("Reemplazando el valor de una clave existente:\n");
        lista.poner("NuevoValor1", "Clave1"); // Reemplazar el valor de "Clave1"

        // Imprimir la lista
        Salida.salidaPorDefecto("Contenido de la lista:\n");
        lista.imprimir();

        Salida.salidaPorDefecto("eliminando clave3\n");
        lista.quitar("Clave3");
        lista.imprimir();

        Salida.salidaPorDefecto("eliminando valor2\n");
        lista.quitarContenido("Valor2");
        lista.imprimir();

        Salida.salidaPorDefecto("metiendo mas elementos\n");

        lista.poner("Valor2", "Clave2"); // Agregar un nodo con clave "Clave2"
        lista.poner("Valor3", "Clave3");
        lista.imprimir();

        Salida.salidaPorDefecto("buscando clave3\n");
        Salida.salidaPorDefecto(lista.buscar("Clave3")+"\n");

        Salida.salidaPorDefecto("buscando valor3\n");
        Salida.salidaPorDefecto(lista.buscarContenido("Valor3")+"\n");



        Salida.salidaPorDefecto("Contenido de la lista:\n");
        lista.imprimir();

        Salida.salidaPorDefecto("cambienaod NuevoValor1 por valor1, por conyenido \n");
        lista.cambiarValor("NuevoValor1", "Valor 1");
        lista.imprimir();



        Salida.salidaPorDefecto("motrado clave valor: \n");
        lista.mostrar();
        Salida.salidaPorDefecto("mostrando valores:\n");
        lista.mostrarValores();
        Salida.salidaPorDefecto("mostando las pueras claves:\n");
        lista.mostrarClave();


        Salida.salidaPorDefecto("covirtiendo a lista estatica: \n");
        Arreglo arre = lista.aListaEstatica();
        Arreglo contenido =(Arreglo) arre.obtener(1);
        Arreglo claves = (Arreglo) arre.obtener(0);
        Salida.salidaPorDefecto("contenido:\n");
        contenido.imprimir();
        Salida.salidaPorDefecto("claves:\n");
        claves.imprimir();

        /*
        Salida.salidaPorDefecto("vaciando lista:\n");
        Salida.salidaPorDefecto("contenido antes de vaciar\n");
        lista.mostrar();;
        Salida.salidaPorDefecto("despues de vaciar\n");
        lista.vaciar();
        lista.mostrar();
         */
        Salida.salidaPorDefecto("obteniendo Clave1\n");
        Salida.salidaPorDefecto(lista.obtener("Clave1")+"\n");
        /*
         lista.vaciar();
        if(lista.vacio()){
            Salida.salidaPorDefecto("esta vacia la lista\n");
        }
         */
        

        Salida.salidaPorDefecto("cuantos elemento hay\n");
        int canti = lista.cantidad();
        if(canti >0){
            Salida.salidaPorDefecto(canti+"\n");
        }

    }
}
