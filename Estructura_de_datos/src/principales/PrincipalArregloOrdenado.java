package principales;

import EstructuraDatos.EDLineal.ArregloOrdenado;
import entradaSalida.Salida;

public class PrincipalArregloOrdenado {
    public static void main(String aprobados[]) {
        ArregloOrdenado lista = new ArregloOrdenado(6);

        lista.poner("m");
        lista.poner("o");
        lista.poner("m");
        lista.poner("v");
        lista.poner("b");
        lista.imprimirDesc();
        Salida.salidaPorDefecto("\n");
        Salida.salidaPorDefecto("buscando t:" +lista.buscar("t"));
        Salida.salidaPorDefecto("buscando v:" +lista.buscar("v"));

        


        
    }   
    
}
