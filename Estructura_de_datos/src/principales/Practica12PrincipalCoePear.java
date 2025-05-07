package principales;

import entradaSalida.Salida;
import registros.Casas_Poblacion.CoePearPoblacionCasas;

public class Practica12PrincipalCoePear {
    public static void main(String[] args) {
        String ruta1 = "C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura_de_datos\\src\\registros\\Casas_Poblacion\\x.txt";
        String ruta2 = "C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura_de_datos\\src\\registros\\Casas_Poblacion\\y.txt";
        CoePearPoblacionCasas co = new CoePearPoblacionCasas();

        if(co.leerDatos(ruta1, ruta2)){
            Salida.salidaPorDefecto("\nSe agregaron los datos de manera correcta\n");
        }else{
            Salida.salidaPorDefecto("\nno se agregaron los datos\n");
        }
    }
}
