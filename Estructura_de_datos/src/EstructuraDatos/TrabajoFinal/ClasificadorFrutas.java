package EstructuraDatos.TrabajoFinal;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.TrabajoFinal.Registros.Fruta;

public class ClasificadorFrutas {
    public static void main(String[] args) {
                // Crear un arreglo de frutas conocidas (entrenamiento)
        Arreglo frutas = new Arreglo(15);
        frutas.poner(new Fruta(100, 1, "Manzana"));   // peso, color, clase
        frutas.poner(new Fruta(120, 2, "Manzana"));
        frutas.poner(new Fruta(150, 3, "Pera"));
        frutas.poner(new Fruta(160, 3, "Pera"));
        frutas.poner(new Fruta(90, 1, "Manzana"));

        GestorClasificasionFrutas clasFrutas = new GestorClasificasionFrutas(frutas);
        clasFrutas.menuOpciones();
    }
}
