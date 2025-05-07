package EstructuraDatos.EDLineal.Auxiliares;

public class NodoABuscar {
    protected Nodo anterior;
    protected Nodo encontrado;


    //get y set 
    public Nodo getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    public Nodo getEncontrado() {
        return encontrado;
    }
    public void setEncontrado(Nodo encontrado) {
        this.encontrado = encontrado;
    }
    
}
