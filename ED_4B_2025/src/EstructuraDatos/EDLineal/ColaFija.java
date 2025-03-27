package EstructuraDatos.EDLineal;

import EstructuraDatos.EDLineal.pilas.LoteDatos;
import entradaSalida.Salida;

public class ColaFija implements  LoteDatos {
    protected int primero;// indica el iguiente elementos
    protected int ultimo;//indica el que llego al final
    protected int capacidad;
    protected Object datos[]; //almacenamiento de datos


    public ColaFija(int tamanio){
        this.capacidad = tamanio;
        this.datos = new Object[capacidad];
        //indicar que esta vacia
        this.primero = -1;
        this.ultimo = -1;
    }



    @Override
    public boolean vacia() {
        if (ultimo ==-1){
            return true;
        }
        return false;
    }



    @Override
    public boolean lleno() {
        if((primero==0&&ultimo==(capacidad-1)) ||(primero == (ultimo+1))){
            return true;
        }else{
            return false;
        }
    }




    @Override
    public boolean poner(Object valor) {
        if(lleno()==false){ //revisa si esta lleno
            if(vacia()==true){ //revisa si es vacio
                datos[0] = valor;
                this.primero = 0;
                this.ultimo =0;
            }else if(ultimo==(capacidad-1)){ // caso frontera circular
                datos[0]=valor;
                ultimo=0;
            }else{//caso circular normal
                ultimo++;
                datos[ultimo]= valor;
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object quitar() {
        if(vacia()==false){ //saber si esta vacia
            Object respaldo = null;
            respaldo = datos[primero];
            if(ultimo == primero){ //ver si hay un unico elemento
                
                primero =-1;
                ultimo=-1;
            }else if(primero==(capacidad-1)){ //esta en el borde y es circular
                primero =0;
        }else{
            //eliminacion lineal
                primero++;
        }
        return respaldo;
        }else{
            return false;
        }
    }

    @Override
    public void imprimir() {
        if(vacia()==false){
            if(primero<=ultimo){
                for(int pos =primero; pos<=(capacidad-1);pos++){
                    Salida.salidaPorDefecto(datos[pos]+" ");
                }
            }else{
                if(primero<=ultimo){
                    for(int pos =primero; pos<=(capacidad-1);pos++){
                     Salida.salidaPorDefecto(datos[pos]+" ");
                    }
                    for(int pos=0; pos<+ultimo;pos++){
                        Salida.salidaPorDefecto(datos[pos]+" ");
                    }
                }
            }
         }else{
            return;
         }
    }

    @Override
    public Object verTope() {
        return null;
    }
    
}
