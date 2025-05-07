package principales;

//import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ArregloNumerico;
import entradaSalida.Salida;

public class PrincipalArregloNumerico {
    public static void main(String[] pruebas) {
        ArregloNumerico prueba = new ArregloNumerico(5);
        Salida.salidaPorDefecto("agregando cosas de tipo Number y un error\n");
        prueba.poner(1);
        prueba.poner(4);
        prueba.poner(1);
        

        ArregloNumerico lista = new ArregloNumerico(5);
        lista.poner(4);
        
    
        Salida.salidaPorDefecto("probando subLista \n");

        lista.porEscalar(prueba);
        prueba.imprimir();
    }
}
