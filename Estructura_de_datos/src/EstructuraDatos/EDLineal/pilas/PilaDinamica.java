package EstructuraDatos.EDLineal.pilas;

import EstructuraDatos.EDLineal.ListaDin;

public class PilaDinamica implements ListaDatosDin {
    protected ListaDin datos;

    public PilaDinamica(){ // inicia la pila dinamica que es de tamaño indefinido
        datos = new ListaDin();
    }

  
    public boolean vacia() { // utiliza el metodo de vacio de la ListaDin para saber si esta se encuentra vacia
        return datos.vacio();
    }


    //agregar un valor a la pila por medio del metodo ponerInicio o poner de lista din
    public boolean poner(Object valor) { 
        int estado;
        if( vacia()== true){ 
            estado = datos.ponerInicio(valor);//si esta vacia se pone al inicio
        }else{
            estado = datos.poner(valor); // si no esta vacia se pone en el lugar siguiente 
        }

        if (estado == 0){
            return true; // si si lo agregp
        }else if(estado== -1){
            return false; // si no lo agrego
        }else{
            return false; // por si no pasa nada de lo anterior
        }
        
    }

    // se quita el ultimo elemento que entro a la pila por medio del metodo quitar de ListaDin
    public Object quitar() {
        return datos.quitar(); // quita el ultimo nodo y recorre al anterior nodo
    }

  
    public void imprimir() {
        datos.imprimir();
    }


    //muestra el ultimo elemento ingresado a la pila
    public Object verTope() {
        return datos.verFinal();
    }

  
    
}

