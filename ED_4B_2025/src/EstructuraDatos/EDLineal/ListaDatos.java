package EstructuraDatos.EDLineal;

public interface ListaDatos {
    //memoria dinamica y dinamica 
    public boolean vacio();
    public Integer poner(Object valor);
    public Object buscar(Object valor); // es object por que no se puede regresar posicionses de memoria 
    public void imprimir();
    public void imprimirDesc();
    public Object quitar();
    public Object quitar(Object valor);

    public boolean esIgual(ListaDatos lista2);//revisa si dos arreglos son iguales
    public boolean modificar(Object valorNuevo, Object valorViejo, int numeroVeces);
    public Arreglo buscarValores(Object valor);
    public void vaciar();
    public boolean agregarLista(ListaDatos lista2);
    public void invertir();
    public int contar(Object valorViejo);
    public boolean borrarLista(ListaDatos lista2);
    public void rellenar(Object valor, int cantidad);
    public ListaDatos clonar();
    public ListaDatos subLista(int indiceInicial, int indiceFinal);
    public boolean substituir(ListaDatos lista2);


    public ListaDatos arregloDesordenado();    
    public boolean esSublista(ListaDatos lista2);
    public boolean modificarLista(ListaDatos lista2, ListaDatos lista2Nuevos);
    public boolean retenerLista(ListaDatos lista2);
    

    public boolean poner(int indice, Object info);


    public Object verFinal();

    // --------------------- lista din
    public Integer ponerInicio(Object valor);// regresa un intero por que regresa la posicion donde esta fue guardado
    
    public void iniciarIterador();
    public boolean iteradorValido();
    public Object obtenerIterador();
    public void moverseIterador();
    

}
