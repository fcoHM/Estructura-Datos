package EstructuraDatos.examenes.examen1;


import EstructuraDatos.EDLineal.ArregloNumerico;
import EstructuraDatos.EDnoLineales.Arreglo2DNumerico;
import entradaSalida.Entrada;
import entradaSalida.Salida;

public class PruebaRegrecionLineal {
    public static void main(String[] args) {
        String rutaX = "C:\\Users\\Josef\\OneDrive\\Documentos\\Estructura-Datos\\Estructura-Datos\\Estructura_de_datos\\src\\EstructuraDatos\\examenes\\examen1\\x.txt";
        String rutaY = "C:\\Users\\Josef\\OneDrive\\Documentos\\Estructura-Datos\\Estructura-Datos\\Estructura_de_datos\\src\\EstructuraDatos\\examenes\\examen1\\y.txt";
        PredicionLineal pr = new PredicionLineal(rutaX, rutaY);

        if(pr.leerDatos()){ //cargar y verificar que los elementos cargaron bien 
            Salida.salidaPorDefecto("si cargo bien\n");
        }else{
            Salida.salidaPorDefecto("No cargo bien\n");
        }
        
        pr.iniciar(); //poner a iniciar el algoritmo 
        Salida.salidaPorDefecto("termino: "+pr.getIteraciones()+" iteraciones\n"); //avisar cuando ya paro 

        pr.mostarEcuacionFinal(); //mostrar operacion final y = p + b*x

    
        //preguntar al usuario por alguna prediciion 
        
        boolean continuar = true;
        while (continuar) {
            Salida.salidaPorDefecto("Ingrese el valor de x (número de habitaciones):\n");
            double valorX = Entrada.terminalDouble();
            double precioEstimado = pr.calcularPrediccion(valorX)*1000; //dar en un formato mas claro el precio 
            Salida.salidaPorDefecto("El precio estimado es: " + precioEstimado + " $ mil\n"); //mostrar el precio en pantalla 

            // Preguntar si desea continuar
            int seleccion = -1;
            while (seleccion != 0 && seleccion != 1) { //limitar el rango a 0 y 1
                Salida.salidaPorDefecto("¿Desea realizar otra predicción? (0 = No, 1 = Sí):\n");
                    seleccion = Integer.parseInt(Entrada.terminalCadenas());
                    if (seleccion != 0 && seleccion != 1) {
                        Salida.salidaPorDefecto("Por favor, ingrese 0 o 1.\n");
                    }
            }
            if (seleccion == 0) {
                continuar = false;
                Salida.salidaPorDefecto("Saliendo del programa. ¡Gracias!\n");
            }
        }


    }
}
