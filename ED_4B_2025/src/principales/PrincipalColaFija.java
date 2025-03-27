package principales;

import EstructuraDatos.EDLineal.ColaFija;
import entradaSalida.Salida;

public class PrincipalColaFija {
    public static void main(String[] args) {
        ColaFija cola = new ColaFija(4);
        cola.poner("a");
        cola.poner("b");
        cola.poner("c");
        cola.poner("d");

        cola.imprimir();
        Salida.salidaPorDefecto("\n");
        cola.quitar();
        Salida.salidaPorDefecto("\n");
        cola.imprimir();

    }
}
