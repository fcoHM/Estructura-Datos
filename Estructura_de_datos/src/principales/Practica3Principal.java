package principales;

//import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ArregloOrdenado;
import EstructuraDatos.EDLineal.ListaDatos;
import entradaSalida.Salida;
import tools.comunesBase.TipoOrdenamiento;

public class Practica3Principal {
    public static void main(String[] args) {
        
        ListaDatos lista = new ArregloOrdenado(5);
        Salida.salidaPorDefecto("lista 1\n");
        lista.poner("d");
        lista.poner("e");
        //Salida.salidaPorDefecto("esta en INC\n");
        lista.imprimir();

        Salida.salidaPorDefecto("lista nuevos objetos\n");
        ListaDatos lista3 = new ArregloOrdenado(5);
        lista3.poner("j");
        lista3.poner("k");
        lista3.poner("l");
        lista3.poner("m");
        lista3.poner("n");
        lista3.imprimir();
        
        ArregloOrdenado lista2 = new ArregloOrdenado(5, TipoOrdenamiento.DEC);
        Salida.salidaPorDefecto("lista 2 donde se cambia los valores \n");

        lista2.poner("a");
        lista2.poner("b");
        lista2.poner("c");
        lista2.poner("d");
        lista2.poner("e");
        lista2.imprimir();

        Salida.salidaPorDefecto("substitullendo lista 2 por lista 3\n");
        lista2.substituir(lista3);
        lista2.imprimir();
        
        
        
    }



}
