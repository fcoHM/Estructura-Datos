package principales;

import entradaSalida.Salida;
import registros.Casas_Poblacion.CoePearPoblacionCasas;

public class Practica12PrincipalCoePear {
    public static void main(String[] args) {
        String ruta1 = "C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\Estructura-Datos\\Estructura_de_datos\\src\\registros\\Casas_Poblacion\\x.txt";
        String ruta2 = "C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\Estructura-Datos\\Estructura_de_datos\\src\\registros\\Casas_Poblacion\\y.txt";
       
       /* 
        CoePearPoblacionCasas co = new CoePearPoblacionCasas();

        if(co.leerDatos(ruta1, ruta2)){
            Salida.salidaPorDefecto("Se agregaron los datos de manera correcta\n");
        }else{
            Salida.salidaPorDefecto("no se agregaron los datos\n");
        }

        co.iniciar();

        Salida.salidaPorDefecto(co.sxy()+"");
        */


       
        
        CoePearPoblacionCasas coePear = new CoePearPoblacionCasas();

        // Leer datos desde archivos
        if (coePear.leerDatos(ruta1, ruta2)) {
            

            // Inicializar cálculos
            coePear.iniciar();

            // Mostrar resultados
            System.out.println("SXY (Covarianza): " + coePear.sxy());
            System.out.println("SX (Desviación estándar de X): " + coePear.sx());
            System.out.println("SY (Desviación estándar de Y): " + coePear.sy());
            System.out.println("coeficiente de pearson: " + coePear.coeficientePearson());
            
        } else {
            System.out.println("Error al leer los datos.");
        }
    }
}
