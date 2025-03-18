package principales;

import EstructuraDatos.EDLineal.Arreglo;
import entradaSalida.Entrada;
import entradaSalida.Salida;

public class PrincipalArreglo {
    public static void main(String[] args) {
        Arreglo lista;
        lista  = new Arreglo(5);
        lista.poner("S");
        lista.poner("T");
        lista.poner("M");
        lista.poner("R");
        
        lista.imprimirDesc();
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("buscando M");
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto(lista.buscar("M") + "\n");

/* 
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("buscando J");
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto(lista.buscar("J") + "\n");

*/
        Salida.salidaPorDefecto("eliminando: ");

        String datoElmininar = Entrada.terminalCadenas();
    
       Salida.salidaPorDefecto(lista.quitar(datoElmininar)+ "\n");
       lista.imprimir();
    }
}
