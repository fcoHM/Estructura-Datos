package principales;

import EstructuraDatos.EDLineal.ListaDin;
import entradaSalida.Salida;

public class PrincipalListaDin {
    public static void main(String[] args) {
        ListaDin lista = new  ListaDin();
        lista.poner("a");
        lista.poner("x");
        lista.poner("m");
        lista.poner("r");
        lista.imprimirDesc();

        Salida.salidaPorDefecto("\n");
        lista.imprimir();

        Salida.salidaPorDefecto("\n buscando la m: "+lista.buscarObjeto("m")+"\n");
        Salida.salidaPorDefecto("\n quitar final: "+ lista.quitar()+"\n");
        lista.imprimir();

    }
}
