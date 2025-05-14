package principales;

import entradaSalida.Salida;
import registros.Casas_Poblacion.CoePearPoblacionCasas;

public class Practica12PrincipalCoePear {
    public static void main(String[] args) {
        String ruta1 = "C:\\Users\\Josef\\OneDrive\\Documentos\\Estructura-Datos\\Estructura-Datos\\Estructura_de_datos\\src\\registros\\Casas_Poblacion\\x.txt";
        String ruta2 = "C:\\Users\\Josef\\OneDrive\\Documentos\\Estructura-Datos\\Estructura-Datos\\Estructura_de_datos\\src\\registros\\Casas_Poblacion\\y.txt";
       
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
            
            double coefi = coePear.coeficientePearson();
            Salida.salidaPorDefecto(coefi+"");
            if(coefi == 1){
                Salida.salidaPorDefecto("correlacion positiva perfecta\n");
            }else if(coefi == 0){
                Salida.salidaPorDefecto("no hay correlacion\n");
            }else if(coefi > 0 && coefi<1){
                Salida.salidaPorDefecto("correlacion positiva \n");
            }else if (coefi ==-1){
                Salida.salidaPorDefecto("correlacion negativa perfecta\n");
            }else if( coefi<0 && coefi <-1){
                Salida.salidaPorDefecto("correlacion negativa\n");
            }
            
        }
    }
}
