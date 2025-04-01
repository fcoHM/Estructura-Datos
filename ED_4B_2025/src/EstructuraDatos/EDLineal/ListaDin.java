package EstructuraDatos.EDLineal;

import EstructuraDatos.EDLineal.Auxiliares.Nodo;
import EstructuraDatos.EDLineal.pilas.PilaFija;
import entradaSalida.Salida;

public class ListaDin implements ListaDatos {
    // direcciones de memoria vista en una Clase nodo
    protected Nodo primero; 
    protected Nodo ultimo;


    public ListaDin(){
        // se incia en mull para indicar que no hay nigun nodo
        this.primero = null;
        this.ultimo = null;
    }


    @Override // revisa si esta vacio
    public boolean vacio() {
        if( primero == null){
            return true;
        }else{
            return false;
        }
    }


    @Override
    public Integer ponerInicio(Object valor) {
        Nodo nuevoNodo = new Nodo(valor); //paso de crear espacio de memoria 
        //validar si existe me un error en memoria llena
        if( nuevoNodo != null){
            if( vacio()== true){
                this.primero = nuevoNodo;
                this.ultimo = nuevoNodo;
            }else{
                nuevoNodo.setLigaDer(this.primero); //insercion si no es el primero 
                this.primero = nuevoNodo;
            }
            return 0; // cuando si lo pone 
            
        }else{  // error  no se agrego
            return -1;
        }
        
    }


    @Override
    public Integer poner(Object valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if(nuevoNodo != null){
            if(vacio()==true){ // revisar si esta vacia  y agregar en la primera posicion
                this.primero = nuevoNodo;
                this.ultimo = nuevoNodo;
            }else{
                this.ultimo.setLigaDer(nuevoNodo); // se cambia la liga y el apuntador al nuevo nodo
                this.ultimo =  nuevoNodo;
            }
            return 0; // si se agrego 

        }else{// error
            return -1; // no se agrego 
        }
    }

    @Override
    public Object buscar(Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscar'");
    }

    @Override
    public void imprimir() {
       Nodo temporal = this.primero;
       while (temporal != null) {
            String info =(String) temporal.getDato();
            Salida.salidaPorDefecto(info + " ->");
            temporal = temporal.getLigaDer();
       }
       Salida.salidaPorDefecto("null");
    }

    @Override
    public void imprimirDesc() {
        int tamanio=0;
        Nodo temporal = this.primero;
        
        while(temporal != null){ // se saca la cantidad  de elementos
            tamanio++;
            temporal = temporal.getLigaDer();
        }

        PilaFija pila = new PilaFija(tamanio); // se crea una pila  con el tamanio de datos 

        temporal = this.primero;

        
        while ( temporal != null){ //va guardando los datos en un pila 
            pila.poner(temporal.getDato());
            temporal = temporal.getLigaDer();
            
        }
        while (pila.vacia()!= true) { // imprime lo de la pila 
            Salida.salidaPorDefecto(pila.quitar() + " -> ");
        }
        Salida.salidaPorDefecto("null");
    }


    
    @Override
    public Object quitar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitar'");
    }

    @Override
    public Object quitar(Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitar'");
    }

    @Override
    public boolean esIgual(ListaDatos lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esIgual'");
    }

    @Override
    public boolean modificar(Object valorNuevo, Object valorViejo, int numeroVeces) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificar'");
    }

    @Override
    public Arreglo buscarValores(Object valor) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarValores'");
    }

    @Override
    public void vaciar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'vaciar'");
    }

    @Override
    public boolean agregarLista(ListaDatos lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarLista'");
    }

    @Override
    public void invertir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'invertir'");
    }

    @Override
    public int contar(Object valorViejo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contar'");
    }

    @Override
    public boolean borrarLista(ListaDatos lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarLista'");
    }

    @Override
    public void rellenar(Object valor, int cantidad) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'rellenar'");
    }

    @Override
    public ListaDatos clonar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clonar'");
    }

    @Override
    public ListaDatos subLista(int indiceInicial, int indiceFinal) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subLista'");
    }

    @Override
    public boolean substituir(ListaDatos lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'substituir'");
    }

    @Override
    public ListaDatos arregloDesordenado() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'arregloDesordenado'");
    }

    @Override
    public boolean esSublista(ListaDatos lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'esSublista'");
    }

    @Override
    public boolean modificarLista(ListaDatos lista2, ListaDatos lista2Nuevos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'modificarLista'");
    }

    @Override
    public boolean retenerLista(ListaDatos lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'retenerLista'");
    }

    @Override
    public boolean poner(int indice, Object info) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'poner'");
    }

    @Override
    public Object verFinal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verFinal'");
    }


    
    
}
