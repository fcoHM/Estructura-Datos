package registros.Casas_Poblacion;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ListaDin;
import static registros.Casas_Poblacion.OperacionesEstadistica.*;


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

    //obtener la cantidad N de elementos
    public int obtenerCantidad(){
        if((this.x.vacio() || this.y.vacio()) == true){
            return -1; //alguna esta vacia
        }else if((this.x.cantidad()==this.y.cantidad())==true){
            return this.x.cantidad(); //regresa el tamaño de alguna
        }else{
            return -1; //no tienen el mismo tamaño
        }
    }


    public double coeficientePearson(){

        /*
          return (obtenerCantidad()* sumatoria(multiplicasionListas(x, y)) - (sumatoria(x)*sumatoria(y)))
        / Math.sqrt((obtenerCantidad()*sumatoria(exponente(x)))- sumatoria(exponente(x)) * (obtenerCantidad()*sumatoria(exponente(y)))- sumatoria(exponente(y)));
         */

         //se cambio por que de la otra manera daba NaN
        int N = obtenerCantidad();
        double sumX = sumatoria(x);
        double sumY = sumatoria(y);
        double sumXY = sumatoria(multiplicasionListas(x, y));
        double sumX2 = sumatoria(exponente(x));
        double sumY2 = sumatoria(exponente(y));

        double numerador = N * sumXY - sumX * sumY;
        double denominador = Math.sqrt((N * sumX2 - sumX * sumX) * (N * sumY2 - sumY * sumY));
        if (denominador == 0) {
           return 0;
        }
        return numerador / denominador;
    }




}
