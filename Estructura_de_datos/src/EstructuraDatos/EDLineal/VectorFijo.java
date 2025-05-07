package EstructuraDatos.EDLineal;


public interface VectorFijo extends ListaDatos {
    //metodos estaticos, maneja metodos particulares de memoria estatica 
    
    public boolean lleno();
    public int capacidad();
    public int cantidad();

    public Object obtener(int indice);
    public boolean modificar(int indice, Object valor);
    public boolean modificarLista(Arreglo indicesBusqueda, Arreglo valoresNuevos);
    public Object quitar(int indice);
    public boolean redimensionar(int maximo);

}
