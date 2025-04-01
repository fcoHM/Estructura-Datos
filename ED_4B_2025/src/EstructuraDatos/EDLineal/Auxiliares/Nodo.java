package EstructuraDatos.EDLineal.Auxiliares;

public class Nodo {
    protected Object dato;
    protected Nodo ligaDer; // refrencia o una direccion a memoria
    
    public Nodo(Object valor){
        this.dato = valor; // se guarda el dato
        this.ligaDer = null; // se inicia en null la ligaDer 
    }



    // metodos funcionales de la clase


    //get and set 
    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public Nodo getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(Nodo ligaDer) {
        this.ligaDer = ligaDer;
    }

    
    @Override
    public String toString() {
        return dato.toString(); //se convierte en cadena y este valor se regresa para identificarlo o comparaciones
    }

}// end class
