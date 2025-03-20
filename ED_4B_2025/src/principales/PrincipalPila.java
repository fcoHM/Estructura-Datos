package principales;

import EstructuraDatos.EDLineal.pilas.PilaFija;

public class PrincipalPila {
    public static void main(String[] argumentosPoderosos) {
        PilaFija pila = new PilaFija(6);
        pila.poner("A");
        pila.poner("S");
        pila.poner("T");
        pila.poner("M");
        pila.poner("R");
        
        pila.imprimir();
    }
}
