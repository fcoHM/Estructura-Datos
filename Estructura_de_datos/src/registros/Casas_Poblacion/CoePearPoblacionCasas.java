package registros.Casas_Poblacion;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ListaDin;
import entradaSalida.Salida;

import static entradaSalida.ArchivoTextoD.*;

public class CoePearPoblacionCasas {
    protected ListaDin x; // numenro de habitacionees
    protected ListaDin y; // costo de las casas

    public CoePearPoblacionCasas(){
        x = new ListaDin();
        y = new ListaDin();
    }

    // leer dos archivos txt y pasarlos a una rareglo para despues a ListaDin
    public boolean leerDatos(String rutaX, String rutaY){
        //leer los archivos desde  un txt
        Arreglo datosX = leer(rutaX);
        Arreglo datosY = leer(rutaY);

        if(datosX.vacio() || datosY.vacio() ){ //si x o y esta vacia
            return false; //si alguna de las dos esta vacia no hace nada 
        }

        //la misma variable se ocupa asi misma para rellenarse
        this.x = this.x.convertirAListaDin(datosX);
        this.y = this.y.convertirAListaDin(datosY);

        if (this.x.vacio() || this.y.vacio()) {
            return false; //si una de las dos listas esta vacia o es nula no hace nada 
        }

        return true;
    }

}
