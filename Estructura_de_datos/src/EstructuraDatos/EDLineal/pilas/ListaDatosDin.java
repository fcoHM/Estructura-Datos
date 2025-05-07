package EstructuraDatos.EDLineal.pilas;

public interface ListaDatosDin {
    public boolean vacia();
    public boolean poner(Object valor); // solo me interesa si si pude ponerlo 
    public Object quitar();
    public void imprimir(); // solo para poder observar que hay en la pila
    public Object verTope();
}
