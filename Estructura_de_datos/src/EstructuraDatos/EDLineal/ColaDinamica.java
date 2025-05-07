package EstructuraDatos.EDLineal;

import EstructuraDatos.EDLineal.pilas.ListaDatosDin;
import EstructuraDatos.EDLineal.pilas.LoteDatos;

public class ColaDinamica  implements ListaDatosDin{
    protected ListaDin datos;

    public ColaDinamica(){
        datos = new ListaDin(); //lugar donde se va a guardar los datos
    }

    // revisar  si esta vacia
    public boolean vacia() { 
        return datos.vacio();
    }

    
    // agregar datos a la lista dinamica 
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

  
    public Object quitar() {
        return datos.quitarInicio();
    }

   
    public void imprimir() {
        datos.imprimir();
    }

    
    public Object verTope() {
       return datos.verInicio();
    }
    
}
