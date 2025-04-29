package principales;

import registros.ventas.Articulo;
import registros.ventas.Cliente;
import registros.ventas.Gestortienda;
import registros.ventas.Gestortienda2;

public class PrincialVenta2 {
     public static void main(String[] args) {
        Gestortienda2 tienda= new Gestortienda2("patito SA");

        tienda.agregarvendedor("pedro", "2345tgbnm ", 1, "12/01/2002");
        tienda.agregarvendedor("juana", "0987yhgfcxc ", 2, "1/07/2000");
        Cliente cliente1 = new Cliente("ghnnjnjnjkn", "juan", 'm');
        Articulo art1 = new Articulo("T001","agua", 10);
        
        Articulo art2 = new Articulo("T002","Ruffles", 18);

        tienda.agregarNota(cliente1, "10/03/2025", 10);

        tienda.agregarArticuloNota(1, art1, 2);
        tienda.agregarArticuloNota(1, art2, 1);

        tienda.imprimirNota(1);
    }
}
