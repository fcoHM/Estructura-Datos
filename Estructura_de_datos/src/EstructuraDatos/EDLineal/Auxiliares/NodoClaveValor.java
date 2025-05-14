package EstructuraDatos.EDLineal.Auxiliares;

public class NodoClaveValor {
    protected Object clave; // valor numerico que debe ser unico
    protected Object dato; // espacio donde se guarda un Objeto
    protected NodoClaveValor ligaDer; // referencia a un nodo siguiente en una ista 

    //constructor 
    public NodoClaveValor(Object objeto, Object clave) {
        this.dato = objeto;
        this.clave = clave; 
        this.ligaDer = null;
    }

    //geters y setter para clave
    public Object getClave() {
        return clave;
    }
    public void setClave(Object clave) {
        this.clave = clave;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object objeto) {
        this.dato = objeto;
    }

    public NodoClaveValor getLigaDer() {
        return ligaDer;
    }

    public void setLigaDer(NodoClaveValor ligaDer) {
        this.ligaDer = ligaDer;
    }
    
    @Override
    public String toString() {
        return dato.toString(); //se convierte en cadena y este valor se regresa para identificarlo o comparaciones
    }
}