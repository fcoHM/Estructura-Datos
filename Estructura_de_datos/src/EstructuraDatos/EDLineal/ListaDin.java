package EstructuraDatos.EDLineal;

import EstructuraDatos.EDLineal.Auxiliares.Nodo;
import EstructuraDatos.EDLineal.Auxiliares.NodoABuscar;
import EstructuraDatos.EDLineal.pilas.PilaDinamica;
import EstructuraDatos.EDLineal.pilas.PilaFija;
import EstructuraDatos.EDnoLineales.Arreglo2D;
import entradaSalida.Salida;
import tools.comunesBase.TipoTabla;

public class ListaDin implements ListaDatos {
    // direcciones de memoria vista en una Clase nodo
    protected Nodo primero; 
    protected Nodo ultimo;
    protected Nodo iterador;


    public ListaDin(){
        // se incia en mull para indicar que no hay nigun nodo
        this.primero = null;
        this.ultimo = null;
        this.iterador = null;
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

    private NodoABuscar  buscarNodo(Object valor){
        Nodo anterior = primero;
        Nodo encontrado = primero;

        while((encontrado != null && valor.toString().equalsIgnoreCase(encontrado.getDato().toString()) )== false){
            anterior = encontrado;
            encontrado = encontrado.getLigaDer();
        }
        
        if (encontrado != null){ //algo encontro
            NodoABuscar retorno = new NodoABuscar();
            retorno.setAnterior(anterior);
            retorno.setEncontrado(encontrado);
            return retorno;
        }else{
            return null;
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
            // Usar toString() para evitar problemas de conversión
            Salida.salidaPorDefecto(temporal.getDato().toString() + " -> ");
            temporal = temporal.getLigaDer();
        }
        Salida.salidaPorDefecto("null\n");
    }

    @Override // imprimir inverso
    public void imprimirDesc() {
        Nodo temporal = this.primero;
        PilaDinamica pila = new PilaDinamica(); //pila de tamaño indefinido
        
        while (temporal != null){ //va guardando los datos en un pila 
            pila.poner(temporal.getDato());
            temporal = temporal.getLigaDer();
        }
        
        while(pila.vacia() != true){
            Salida.salidaPorDefecto(pila.quitar() + " -> ");
        }
        Salida.salidaPorDefecto("null\n");
    }

    
    
    @Override // se elimina el ultimo elemento de la lista
    public Object quitar() {
        if(vacio() == false){
            Object respaldo = ultimo.getDato(); // se respalda el valor
            if (primero == ultimo){ //si solo hay un elemento
                this.primero = null;
                this.ultimo = null;
            }else{
                /*
                NodoABuscar busqueda = buscarNodo(ultimo.getDato()); // de aqui se se sacn los nodos anterior y 
                busqueda.getAnterior().setLigaDer(null);
                ultimo = busqueda.getAnterior();
                */
                Nodo temporal = primero;
                while (temporal.getLigaDer() != ultimo) { // Buscar el nodo anterior al último
                    temporal = temporal.getLigaDer();
                }
                temporal.setLigaDer(null); // Desconectar el último nodo
                this.ultimo = temporal;

                }
                return respaldo;
        }else{
            return null;
        }
    }

    public Object quitarInicio(){
        if( vacio() == false){
            Object respaldo = primero.getDato(); // Respaldar el dato del primer nodo
            if (primero == ultimo) { // Si solo hay un nodo
                primero = null;
                ultimo = null;
            } else {
                primero = primero.getLigaDer(); // Mover el puntero al siguiente nodo
            }
            return respaldo; // Retornar el dato eliminado
        }else {
            return null; // Si la lista está vacía, retornar null
        }
    }



    // busca un elemento en la lista 
    public Object buscarObjeto(Object valor){
        NodoABuscar busqueda = buscarNodo(valor);
       if(busqueda != null){
            return busqueda.getEncontrado().getDato();
       }else{
        return null;
       }
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
    public boolean borrarLista(ListaDatos lista2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'borrarLista'");
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
       if (ultimo != null){
        return ultimo.getDato();
       }else{
        return null;
       }
    }





    //recirrido de lista

    @Override
    public void iniciarIterador() {
        iterador = primero;
    }


    @Override
    public boolean iteradorValido() {

        if(iterador == null){
            return false;
        }else{
            return true;
        }
    }


    @Override
    public Object obtenerIterador() {
        if(iteradorValido()==true){
            return iterador.getDato();
        }else{
            return null;
        }
    }


    @Override
    public void moverseIterador() {
        if(iteradorValido()==true){
            iterador = iterador.getLigaDer();
        }
    }


    @Override
    public Object verInicio() {
        if (primero != null){
            return primero.getDato();
        }else{
            return false;
        }
    }



    // ------ practica 11

    // encontrar una lista de elementos aparecidos segun un valor
    public ListaDin encontarLista(Object valor){
        if(this.vacio()== true){
            return null;
        }else{
            ListaDin listaTem = new ListaDin();
            iniciarIterador();
            
            while(iteradorValido()== true){ //iterar sobre toda la lista 
                Object iterTem = obtenerIterador(); //se obteniene el iterador 
                if(iterTem == valor){ //se revisa compara los valores
                    listaTem.poner(iterTem);//si son iguales se agrega a una lista 
                }
                moverseIterador(); //mover el iterador
            }
            return listaTem;
        }
    }
    
    //pasar de lista Dinamica a Arreglo estatico
    public Arreglo aListaEstatica(){ 
        if(this.vacio()== true){
            return null;
        }else{
            Arreglo arregloTem = new Arreglo(cantidad()); //iniciar con tamaño
            iniciarIterador();
            while (iteradorValido()== true) {
                arregloTem.poner(obtenerIterador());
                moverseIterador();
            }
            return arregloTem;
        }
    }

    public int cantidad(){
        int cantidad = 0;
        iniciarIterador();
        while (iteradorValido()== true) {
            cantidad++;
            moverseIterador();
        }
        return cantidad;
    }
    

    //pasar a Atteglo 2D
    public Arreglo2D aMatriz2D(int filas, int columnas){
        Arreglo2D matrizResultado = new Arreglo2D(filas, columnas, null);
        if(this.vacio()== true){
            return matrizResultado;
        }else{
            iniciarIterador();
            // variables para la posición actual en la matriz
            int indiceFila = 0;
            int indiceColumna = 0;
            // recorrer los elementos de la lista dinámica
            while (iteradorValido() == true) {
                // colocar el elemento actual de la lista en la posición correspondiente de la matriz
                matrizResultado.cambiar(indiceFila, indiceColumna, obtenerIterador());

                
                moverseIterador();

                // avanzar a la siguiente columna
                indiceColumna++;

                // si se alcanza el límite de columnas, avanzar a la siguiente fila
                if (indiceColumna == columnas) {
                    indiceColumna = 0; // reiniciar el índice de columnas
                    indiceFila++; // avanzar a la siguiente fila

                    // si se alcanza el límite de filas, detener el llenado
                    if (indiceFila == filas) {
                        break;
                    }
                }
            }

            // devolver la matriz llena con los elementos de la lista
            return matrizResultado;
        }
    }

    @Override
    public boolean agregarLista(ListaDatos lista2){
        ListaDin listaTem;
        if(lista2 instanceof Arreglo){ // si es instancia de de Arreglo
            if(lista2.vacio()==true){
                return false;
            }else{
                listaTem = convertirAListaDin((Arreglo)lista2); //convertir de arreglo a listaDin
            }

        }else if(lista2 instanceof ListaDin){
            listaTem = (ListaDin) lista2;
            if(listaTem.vacio()== true){
                return false;
            }
        }else{
            return false;
        }

        listaTem.iniciarIterador();
        while (listaTem.iteradorValido()==true) { //agregar valores desde otra lista 
            this.poner(listaTem.obtenerIterador());
            listaTem.moverseIterador();
        }

        return true;
    }




    public ListaDin convertirAListaDin(Arreglo arreglo){
        ListaDin lista = new ListaDin();
        if(arreglo.vacio()== true){ //si esta vacio el arreglo, regresa vacia la lista
            return lista;
        }else{
            for(int elemento=0; elemento<arreglo.cantidad(); elemento++){ //itera sobre el arreglo y guarda en listaDin los elementos
                Object valor = arreglo.obtener(elemento);
                lista.poner(valor);
            }
            return lista;
        }
    }



    @Override //clonar una listaDin
    public ListaDatos clonar() {
        if(this.vacio()==true){ //si es vacia regresa null
            return null;
        }else{
            ListaDin clon = new ListaDin(); //se instancia una nueva listaDin
            this.iniciarIterador();
            while (this.iteradorValido()==true) { // se mueve dentro de la lista original y se van copiando los datos en la lista nueva
                Object valor = this.obtenerIterador();
                clon.poner(valor);
                this.moverseIterador();
            }
            return clon;
        }
    }

    
    public boolean agregarMatriz2D(Arreglo2D tabla, TipoTabla enumTipoTabla){
        if(enumTipoTabla == TipoTabla.RENGLON){
            for( int posx=0; posx < tabla.getColumnas(); posx++){
                for(int posy=0; posy < tabla.getFilas(); posy++){
                    Object valor = tabla.obtener(posy, posx);
                    this.poner(valor);
                }
            }
            return true;
        }else if( enumTipoTabla == TipoTabla.COLUMNA){
            for( int posy=0; posy < tabla.getFilas(); posy++){
                for( int posx=0; posx < tabla.getColumnas();posx++){
                    Object valor = tabla.obtener(posy, posx);
                    this.poner(valor);
                }
            }
            return true;
        }else{
            return false;
        }
    }


    @Override
    public void vaciar() {
        this.primero = null;
        this.ultimo = null;
        this.iterador = null;
    }



    @Override
    public void rellenar(Object valor, int cantidad) {
        for(int elemento =0; elemento < cantidad; elemento++){
            this.poner(valor);
        }
    }



    
    @Override
    public int contar(Object valor) {
        int contador=0;
        if(this.vacio()== true){ //no hace nada si esta vacia
            return 0;
        }else{
            this.iniciarIterador();
            while(this.iteradorValido()==true) {
                Object elemento = this.obtenerIterador();
                if(elemento == valor){ //revisa si hay datos iguales
                    contador++;
                }
                this.moverseIterador();
            }
            return contador;
        }
    }



    @Override
    public void invertir() {
        if(this.vacio()== true){
            return;
        }else{
            this.iniciarIterador();
            PilaDinamica pila = new PilaDinamica();
            while (this.iteradorValido()==true) {
                pila.poner(this.obtenerIterador());
                this.moverseIterador();
            }
            this.vaciar();
            while (pila.verTope()!=null) {
                this.poner(pila.quitar());
            }
        }
    }


}
