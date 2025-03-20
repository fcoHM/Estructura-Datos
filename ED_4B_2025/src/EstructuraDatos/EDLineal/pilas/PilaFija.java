package EstructuraDatos.EDLineal.pilas;

import EstructuraDatos.EDLineal.Arreglo;

public class PilaFija implements LoteDatos { //no se extendio de arreglo, por que hay metodos que vilan el principio lifo

    protected Arreglo pila; //la pila es o funciona igual que un arreglo

    public PilaFija(int tamanio){
        pila = new Arreglo(tamanio);
    }


    @Override
    public boolean vacia() {
        return pila.vacio();
    }

    @Override
    public boolean lleno() {
        return pila.lleno();
    }

    @Override
    public boolean poner(Object valor) {
       int retorno = pila.poner(valor);
       if(retorno >=0){
            return true;
       }else{
            return false;
       }
    }

    @Override
    public Object quitar() {
        return pila.quitar();
    }

    @Override
    public void imprimir() {
        pila.imprimirDesc();
    }


    @Override
    public Object verTope() {
        return pila.verFinal();
    }

    

    
}
