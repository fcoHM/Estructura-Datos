package EstructuraDatos.EDLineal;

import EstructuraDatos.EDLineal.Auxiliares.Nodo;
import EstructuraDatos.EDLineal.Auxiliares.NodoClaveValor;
import entradaSalida.Salida;

public class ListaDinClave {
     // direcciones de memoria vista en una Clase nodo
    protected NodoClaveValor primero; 
    protected NodoClaveValor ultimo;
    protected NodoClaveValor iterador;
    

    //Constructor que inicia la lista en null
    public ListaDinClave() {
        this.primero = null;
        this.ultimo = null;
        this.iterador = null;
    }

    // metodos para moverse en una lista
    
   
    public void iniciarIterador() {
         iterador = primero;
    }

    public boolean iteradorValido() {
        if(iterador == null){
            return false;
        }else{
            return true;
        }
    }

   
    public Object obtenerIterador() {
        if(iteradorValido()==true){
            return iterador.getDato();
        }else{
            return null;
        }
    }


    public Object obtenerClaveIterador(){
         if(iteradorValido()==true){
            return iterador.getClave();
        }else{
            return null;
        }
    }


    public void moverseIterador() {
        if(iteradorValido()==true){
            iterador = iterador.getLigaDer();
        }
    }


    // metodos funcionales de la clase

    public boolean vacio() {  //sabe si esta vacia la lista
        if( primero == null){
            return true;
        }else{
            return false;
        }
    }
 
    public boolean existeClave(Object clave){ //saber si existe un clave o no
        this.iniciarIterador();
        while(this.iteradorValido()==true){ //se itera sobre la lista 
            Object claveList = this.obtenerClaveIterador();//se obtiene la calve de cada nodo
            if(clave.equals(claveList)==true){ //se compara la clave nueva con la de los nodos ya existente 
                return true; //si ta
            }
        }
        return false; // no ta
    }


    public boolean poner(Object valor, Object clave){ //agregar un nuevo nodo al iniciosin que se repita la clave
        //buscar si existe la clave
        if(this.vacio() != true){
            this.iniciarIterador();
            while (this.iteradorValido()) {
                if (clave.equals(this.obtenerClaveIterador())) {
                    // si la clave ya existe remplazar el valor
                    this.iterador.setDato(valor);
                    return true;
                }
                this.moverseIterador();
            }
        }
        //agregar si es que no existe
        NodoClaveValor nuevoNodo = new NodoClaveValor(valor, clave);
        if(nuevoNodo != null){
            if(this.vacio()==true){ //si esta vacia la lista, el primero y ultimo, son el nuevo nodo
                this.primero = nuevoNodo;
                this.ultimo = nuevoNodo;
                return true;
            }else{ // si no esta vacia, primero se hace el nuevo nodo, y al nuevo nodo le damos la refrenecia de ultimo nodo
                this.ultimo.setLigaDer(nuevoNodo);
                this.ultimo = nuevoNodo;
                return true;
            }
        }
        return false;
    }

    public Object quitar(Object clave){ //eliminar por clave 
        if(this.vacio()==true){ //saber si esta vacia
            return null;
        }
        NodoClaveValor nodoAnterior = null; //elemento previo al iterador
        this.iniciarIterador();
        
        while (this.iteradorValido()==true) {
            if(clave.equals(this.obtenerClaveIterador())==true){ //saber si la clave es igual
                Object dato = this.obtenerIterador(); //valor removido
                //elimiar primer nodo
                if(nodoAnterior == null){ //saber que no hay anterior
                    this.primero = this.iterador.getLigaDer();
                    if(this.primero == null){//significa que la lista quedo vacia 
                        this.ultimo = null;//avisarle al ultimo que quedo vacia
                    }
                }else{
                    nodoAnterior.setLigaDer(this.iterador.getLigaDer());//al anterior le damos a liga derecha que esta despues del elemento a quitar
                    if(this.iterador == ultimo){
                        this.ultimo = nodoAnterior; //nuevo nodo ultimo
                    }
                }
                return dato;
            }
            nodoAnterior = this.iterador; // cambiar el anterior a la pos del iterador por si no es igual
            this.moverseIterador();//mover a enfrente del anterior
        }
        return null; //si no se hizo nada 
    }



    public Object quitarContenido(Object valor ){ //eliminar por ccontenido
        if(this.vacio()==true){ //saber si esta vacia
            return null;
        }
        NodoClaveValor nodoAnterior = null; //elemento previo al iterador
        this.iniciarIterador();
        
        while (this.iteradorValido()==true) {
            if(valor.equals(this.obtenerIterador())==true){ //saber si la clave es igual
                Object dato = this.obtenerIterador(); //valor removido
                //elimiar primer nodo
                if(nodoAnterior == null){ //saber que no hay anterior
                    this.primero = this.iterador.getLigaDer();
                    if(this.primero == null){//significa que la lista quedo vacia 
                        this.ultimo = null;//avisarle al ultimo que quedo vacia
                    }
                }else{
                    nodoAnterior.setLigaDer(this.iterador.getLigaDer());//al anterior le damos a liga derecha que esta despues del elemento a quitar
                    if(this.iterador == ultimo){
                        this.ultimo = nodoAnterior; //nuevo nodo ultimo
                    }
                }
                return dato;
            }
            nodoAnterior = this.iterador; // cambiar el anterior a la pos del iterador por si no es igual
            this.moverseIterador();//mover a enfrente del anterior
        }
        return null; //si no se hizo nada 
    }


    public Object buscar(Object clave){ //buscar por clave
        if(this.vacio()==true){//no hacer nada si esta vacia 
            return null;
        }
        this.iniciarIterador();
        while (this.iteradorValido()==true) {
            if (clave.equals(this.obtenerClaveIterador())==true) { //ver si la clave es igaul a la buscada
                return this.iterador;//regresarla si esta 
            }
            this.moverseIterador();
        }
        return null; //no ta
    }



     public Object buscarContenido(Object valor){ //buscar por clave
        if(this.vacio()==true){//no hacer nada si esta vacia 
            return null;
        }
        this.iniciarIterador();
        while (this.iteradorValido()==true) {
            if ((valor == this.obtenerIterador())==true) { //ver si la clave es igaul a la buscada
                return this.iterador;//regresarla si esta 
            }
            this.moverseIterador();
        }
        return null; //no ta
    }


    public boolean cambiar(Object clave, Object valor){ //cambiar contenido mediante busqueda por clave
        if(this.vacio()==true){//no hccer nada si esta vacia 
            return false;
        }
        this.iniciarIterador();
        while (this.iteradorValido()==true) {
            if((clave.equals(this.obtenerClaveIterador()) == true)){
                this.iterador.setDato(valor);//cabiar cotenido
                return true;
            }
            this.moverseIterador();
        }
        return false;

    }


    public boolean cambiarValor(Object valorViejo, Object valorNuevo){ //cambiar contenido mediante busqueda por contenido
        if(this.vacio()==true){//no hccer nada si esta vacia 
            return false;
        }
        this.iniciarIterador();
        while (this.iteradorValido()==true) {
            if(((valorViejo==this.obtenerIterador())== true)){
                this.iterador.setDato(valorNuevo);//cabiar cotenido
                return true;
            }
            this.moverseIterador();
        }
        return false;

    }


    public void mostrar(){ //debe mostrar clave y valor 
        this.iniciarIterador();
        while (iteradorValido()==true) {
            Object clave = this.obtenerClaveIterador();
            Object valor = this.obtenerIterador();
            Salida.salidaPorDefecto( valor+":"+clave +" -> ");
            this.moverseIterador();
        }
        Salida.salidaPorDefecto("null\n");
    }

    public void mostrarClave(){ //debe mostar las pueras claves
        this.iniciarIterador();
        while (iteradorValido()==true) {
            Salida.salidaPorDefecto(this.obtenerClaveIterador() + " -> ");
            this.moverseIterador();
        }
        Salida.salidaPorDefecto("null\n");
    }

    public void mostrarValores(){ //debe mostar los puros valores 
        this.iniciarIterador();
        while (iteradorValido()==true) {
            Salida.salidaPorDefecto(this.obtenerIterador() + " -> ");
            this.moverseIterador();
        }
        Salida.salidaPorDefecto("null\n");
    }


    public int cantidad(){//cuenta la cantidad de elementos en una lista 
        int cantidad = 0;
        iniciarIterador();
        while (iteradorValido()== true) {
            cantidad++;
            moverseIterador();
        }
        return cantidad;
    }

    
    public Arreglo aListaEstatica(){ //debe regresar un arrglo con contenidos y claves
        if(vacio()==true){
            return null;
        }
        int tamanio = this.cantidad();
        Arreglo claves = new Arreglo(tamanio);
        Arreglo contenidos = new Arreglo(tamanio);
        Arreglo listaTem = new Arreglo(2);//arreglo reultado pos:0 = claves, pos:1 = contenidos
        this.iniciarIterador();
        while (this.iteradorValido()==true){
            Object clave = this.obtenerClaveIterador();
            Object valor = this.obtenerIterador();
            claves.poner(clave); //agregar a Arreglo de claves 
            contenidos.poner(valor);// agregar a Arreglo de contenidos
            this.moverseIterador();
        }
        listaTem.poner(claves); //agregar a resultado
        listaTem.poner(contenidos);
        return listaTem;
    }

    public void vaciar(){ //vaciar una lista 
        this.primero = null;
        this.ultimo = null;
        this.iterador = null;
    }


    public Object obtener(Object clave){//obtener un elemento segun la clave 
        if (this.vacio()==true) {
            return null;
        }
        this.iniciarIterador();
        while (this.iteradorValido()==true) {
            if (clave.equals(this.obtenerClaveIterador())) {
                return this.iterador;
            }
            this.moverseIterador();
        }
        return null;
    }

    public void imprimir() { //imprimir una lista 
        this.iniciarIterador();
        while (iteradorValido()==true) {
            Salida.salidaPorDefecto(this.obtenerIterador() + " -> ");
            this.moverseIterador();
        }
        Salida.salidaPorDefecto("null\n");
    }

}
