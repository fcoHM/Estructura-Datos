package principales;

import EstructuraDatos.EDnoLineales.Arreglo3D;
import entradaSalida.Salida;

public class PrincipalArreglo3D {
    public static void main(String[] reprobados) {
        Arreglo3D cubo = new Arreglo3D(5, 4, 3, 0);

        cubo.imprimirXcolumnas();
        cubo.cambiarCelda(0, 0, 1, 90);
        cubo.imprimirXcolumnas();
        
        Object valor = cubo.obtenerCelda(1, 2, 0);
        Salida.salidaPorDefecto("este: " + valor);
    }
}
