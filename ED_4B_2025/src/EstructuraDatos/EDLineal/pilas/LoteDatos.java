package EstructuraDatos.EDLineal.pilas;

public interface LoteDatos {
    public boolean vacia();
    public boolean lleno();
    public boolean poner(Object valor); // solo me interesa si si pude ponerlo 
    public Object quitar();
    public void imprimir(); // solo para poder observar que hay en la pila
    public Object verTope();
}
