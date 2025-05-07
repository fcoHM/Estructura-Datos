package EstructuraDatos.EDLineal;

import entradaSalida.Salida;

public class Arreglo implements VectorFijo{

    protected Object datos[];
    protected int capacidad;
    protected int indiceSuperior;

    //memoria estatica 
    public Arreglo(int tamanio){
        this.capacidad = tamanio; 
        this.datos = new Object[capacidad]; //para pedir memoria prestada se usa el New
        this.indiceSuperior = -1;
    }

    @Override
    public boolean vacio() {
        if (indiceSuperior == -1){
            return true;
        }
        else{
            return false;
        }
    }


    @Override //revisar si el arreglo esta lleno en vas a el indice y capacidad
    public boolean lleno(){
        if (indiceSuperior == (capacidad - 1)){
            return true;
        }
        else{
            return false;
        }
    }


    @Override // para poder agregar cosas dentro el arreglo 
    public Integer poner(Object valor){
        if (lleno() == false){
            this.indiceSuperior ++;
            datos[this.indiceSuperior] = valor;
            return indiceSuperior;
        }
        else{
            return -1;
        }
    }



    @Override // se hace la busqueda de un objeto dentro del arreglo y lo retorna 
    public Object buscar(Object valor){
        int recorredor;
        recorredor = 0;
        while((recorredor <= indiceSuperior) && (valor.toString().equalsIgnoreCase(datos[recorredor].toString())== false)){ // para que sea falso
            recorredor ++;     // no se puede camparar objetos, asi que se convierten en cadenas de texto, los convierte en el mismo tipo de dato ignorando mayusculas y minusculas
        }
        if (recorredor > indiceSuperior){
            return -1;
        }
        else{
            return recorredor;
        }
    }

    @Override // imprime el arreglo completo 
    public void imprimir(){
        int posicion;
        for (posicion =0; posicion <= this.indiceSuperior; posicion++){
            Salida.salidaPorDefecto(datos[posicion] + "\n");
        }
    }

    @Override // imprime el arregla de manera inversa a la salida 
    public void imprimirDesc(){
        int posicion;
        for(posicion = indiceSuperior; posicion >= 0; posicion --){
            Salida.salidaPorDefecto(datos[posicion] + "\n");
        }
    }

    @Override // quitar el ultimo objeto del arreglo 
    public Object quitar(){
        if(vacio() == false){
            Object  datoExtraido;
            datoExtraido = datos[indiceSuperior];
            indiceSuperior --;
            return datoExtraido;
        }
        else{
            return null;
        }
    }
    

    @Override
    public Object quitar(Object valor ){
        int posicion = (int) buscar(valor); // polimorfimso, casting a un tipo de dato
        Object respaldo;
        if (posicion >= 0){
            respaldo = datos[posicion];
            for(int modificaion = posicion; modificaion <= indiceSuperior - 1; modificaion ++){
                datos[modificaion] = datos[modificaion + 1];
            }
            indiceSuperior --;
            return respaldo;
        }
        else{
            return null;
        }
    }

    @Override
    public int capacidad() {
        return capacidad;
    }

    @Override
    public int cantidad() {
       return indiceSuperior + 1;
    }

    private boolean validaPosicion(int indice){
        if(indice >= 0 && indice<= indiceSuperior){
            return true;
        }
        else{
            //no existe es posicion
            return false;
        }
    }

    //--------------------------------------------------------------------------------------------------------
    @Override // este metodo obtiene un objeto del arreglo indicado por la posicion del indice 
    public Object obtener(int indice) {
        if(validaPosicion(indice)== true){
            //si existe la posicion
            return datos[indice];
        }else{
            //no exite esa posicion
            return null;
        }
    }

    @Override //saber si la lista es igual a otra 
    public boolean esIgual(ListaDatos lista2) { //se recibe una lista secundaria
        Arreglo arreglo =(Arreglo) lista2; //se hace un casting a la lista ingresada
        if(arreglo instanceof Arreglo){ //se revisa que se intsnacia de Arreglo
            if ((this.indiceSuperior == arreglo.indiceSuperior)==true){ //primero revisa qsi ambos tinen el mismo indice superior que representa la misma canttidad de objetos 
                for(int indiceArreglo = 0; indiceArreglo <= indiceSuperior; indiceArreglo ++){
                    if (this.datos[indiceArreglo].toString().equals(arreglo.datos[indiceArreglo].toString())==false){
                        return false;
                    }
                }
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    

    
    public int contar(Object valorViejo){ //recorre el arreglo en busca de ocurrencia comparando con el objeto antiguo
        int contador = 0;
        for (int indiceArreglo=0; indiceArreglo<=indiceSuperior; indiceArreglo ++){
            if(this.datos[indiceArreglo].equals(valorViejo)){ //revisa que los valores sean iguales
                contador++;
            }
        }
        return contador;
    }

    @Override //modificara el arreglo segun  un objeto viejo el cual se cambiara y uno nuevo que sera el sustituto y un numero que es las veces que se va a cambiar
    public boolean modificar(Object valorNuevo, Object valorViejo, int numeroVeces){ 
        int numeroOcurrencias = contar(valorViejo);
        int vecesNecesarias= numeroVeces-1;
        if((numeroOcurrencias >0) == true){ //revisa que el numero de ocurrencias no sea cero 
            int contador = 0;
            for(int indiceArreglo =0; indiceArreglo <= indiceSuperior; indiceArreglo++){ //recorre el arreglo para ir cambiando el objeto viejo por el nuevo
                if ((vecesNecesarias<=indiceSuperior) && (contador <= vecesNecesarias)){ //revisa que solo se haga segun la veces queramos que se modifique
                    if((this.datos[indiceArreglo].equals(valorViejo))==true ){ //revisa que sea el dato a modificar y lo remplaza
                        this.datos[indiceArreglo] = valorNuevo;//
                    }
                    contador++;
                }
            }
            return true;
        }else{
            return false;
        }
    }


    @Override // modifica un espacio del arreglo segun el indice y un valor nuevo que lo suplante
    public boolean modificar(int indice, Object valor){ 
        if((indice>=0)&&((indice) <= indiceSuperior)){
            this.datos[indice] = valor;
            return true;
        }else{
            return false;
        }
    }

    @Override // pasa los valores de una lista a otra con la referencia de indice sacados desde otra lista 
    public boolean modificarLista(Arreglo indicesBusqueda, Arreglo valoresNuevos){
        //revisa que las dos listas tengan la misma cantidad de elementos y que esa cantidad sea menor o igual a la capacidad de la lista original
        if((valoresNuevos.indiceSuperior == indicesBusqueda.indiceSuperior)&&(valoresNuevos.indiceSuperior <= this.capacidad)){
            for(int indiceArreglo=0; indiceArreglo <= indiceSuperior;indiceArreglo++){
                int indice = (int)indicesBusqueda.datos[indiceArreglo]; 
                if(indice <= this.capacidad){
                    this.datos[indice-1] = valoresNuevos.datos[indiceArreglo]; // -1 por que el usuario no contempla el cero en las posiciones 
                }
               
            }
            return true;
        }else{
            return false;
        }
    }

    
    public void imprimir(Arreglo lista){
        for (int indiceArreglo = 0; indiceArreglo<= lista.indiceSuperior;indiceArreglo++) {
            System.out.println(lista.datos[indiceArreglo]);
        }
    }

    @Override // busca un valor y cuando lo encuentra agrega el indice en otra lista 
    public Arreglo buscarValores(Object valor){
      Arreglo ocurrencias = new Arreglo(this.indiceSuperior);
      for(int indiceArreglo=0; indiceArreglo <= this.indiceSuperior; indiceArreglo++){ //itera sobre todo el arreglo para ir buscando concurrencias
        if(this.datos[indiceArreglo].equals(valor)==true){ //revisa que el objeto sea el que estamos buscando y si es aagrega el indice
            ocurrencias.poner(indiceArreglo);
        }
      }
      return ocurrencias;
    }

    @Override //se quitara el elemento que se encuentre en eñ indice deseado 
    public Object quitar(int indice){
        if (indice>=0 && indice<=indiceSuperior){
            Object dato = datos[indice]; //se le resta 1 por que el usuario lo ve de 1 hasta n elementos y no desde el 0
            for(int modificaion = indice; modificaion <= indiceSuperior; modificaion ++){ 
                datos[modificaion] = datos[modificaion + 1]; //se hace el movimiento de elementos para no dejar espacios vaciaos o nulos 
            }
            indiceSuperior --; //se le resta 1 ya que eliminamos un datos y los elmentos bajan un puesto
            return dato;
        }else{
            return null;
        }
    }

    @Override //regresa el limite superior al inicio  para sobreescribir los datos
    public void vaciar(){
        this.indiceSuperior = -1;
    }

    
    @Override // combina dos listas en una nueva con la medida exacta
    public boolean agregarLista(ListaDatos lista2){
        Arreglo arreglo = (Arreglo)lista2;
        if (lista2 instanceof Arreglo){
            int elementos = this.indiceSuperior+1 + arreglo.indiceSuperior+1;
            Arreglo listaNueva = new Arreglo(elementos);
            for(int indiceArreglo =0; indiceArreglo<=this.indiceSuperior;indiceArreglo++){
                listaNueva.poner(this.datos[indiceArreglo]);
            }
            for (int indiceArreglo =0; indiceArreglo<=arreglo.indiceSuperior;indiceArreglo++){
                listaNueva.poner(arreglo.datos[indiceArreglo]);
            }
            
            return true;
        }else{
            return false;
        }
    }

    @Override // invierte los valores de una lista 
    public void invertir(){
        Arreglo auxiliar = new Arreglo(this.indiceSuperior + 1); //se hace el arreglo aux sumandole 1 al indSup para que quede con el temaño adecuado a los lementos

        for (int indiceArreglo = this.indiceSuperior; indiceArreglo >= 0; indiceArreglo--) { //pasamos en orden inverso los elemento a aux
            auxiliar.poner(this.datos[indiceArreglo]);
        }
      
        for (int indiceArreglo = 0; indiceArreglo <= this.indiceSuperior; indiceArreglo++) { //pasamos lo datos de nuevo a la lista original pero en orden inverso
            this.datos[indiceArreglo] = auxiliar.datos[indiceArreglo];
        }
    }

    @Override // elimina los elementos agregados que pertenescan a otra lista 
    public boolean borrarLista(ListaDatos lista2){
        Arreglo arreglo = (Arreglo) lista2;
        if (arreglo instanceof Arreglo){
            for(int indiceArreglo =0; indiceArreglo<= this.indiceSuperior; indiceArreglo++){
                this.quitar(arreglo.datos[indiceArreglo]);//quita los lemenetos que sean de otra lista 
                indiceSuperior --;
            }
            return true;
        }else{
            return false;
        }

    }

    public void rellenar(Object valor, int cantidad){
        for(int indiceArreglo =indiceSuperior; indiceArreglo<=capacidad-1;indiceArreglo++){
            if(cantidad<=capacidad-1){
                this.poner(valor);
            }
        }
    }

    @Override
    public ListaDatos clonar(){
        Arreglo listaClone = new Arreglo(this.capacidad);
        for(int indiceArreglo = 0; indiceArreglo<= this.indiceSuperior; indiceArreglo++){
            listaClone.poner(this.datos[indiceArreglo]);
        }
        return listaClone;

    }


    @Override //nos hace una pequeña lista que se origino de otra mas grande
    public ListaDatos subLista(int indiceInicial, int indiceFinal){
        indiceInicial = indiceInicial-1; //a los indices se les quita en 1 por que el usuario solo ve de 1 a n u no de 0 a n
        indiceFinal = indiceFinal-1;
        if (indiceInicial < 0 || indiceFinal > this.indiceSuperior || indiceInicial > indiceFinal) { //revisa que los indices no esten mal y estne dentro de los parametros si no acaba la funcion
            return null; 
        }
        Arreglo sublis = new Arreglo(indiceFinal - indiceInicial + 1); //se crea el arreglo con un tamaño justo 

        for (int indiceArreglo = indiceInicial; indiceArreglo <= indiceFinal; indiceArreglo++) {
            sublis.poner(this.datos[indiceArreglo]); //procede con la insercion de los datos
        }
        return sublis;
    }

    @Override
    public boolean redimensionar(int maximo){
        this.capacidad= maximo;
        return true;
    }

    @Override
    public boolean substituir(ListaDatos lista2){
        
        if ((lista2 instanceof Arreglo)) {
            Arreglo nuevaLista = (Arreglo) lista2;
            this.indiceSuperior = -1;// Limpiar la lista actual
            for (int indiceArreglo = 0; indiceArreglo <= nuevaLista.indiceSuperior; indiceArreglo++) {// Copiar elementos de nuevaLista a la lista actual
                this.poner(nuevaLista.datos[indiceArreglo]);
            }
            return true;
        }else{
            return false;
        }
        
    }


    @Override //debe poner cierto objeto en el lugar que yo decida 
    public boolean poner(int indice, Object info){
        if (indice >= 0 && indice<=indiceSuperior) { //verificar que el indice este dentro de los limites
            for (int elementoArreglo = indiceSuperior; elementoArreglo >= indice; elementoArreglo--) {
                this.datos[elementoArreglo + 1] = this.datos[elementoArreglo]; //desplazando los elementos una posicion para agregar el elemento nuevo
            }
            this.datos[indice] = info;//se agrega el valor nuevo
            indiceSuperior++;
            return true;
        } else {
            return false;
        }
    }

//----------------------------------------------------------------------------------------------
    public Arreglo subLista(ArregloNumerico listaIndices){ //recupera elementos del arreglo actual, segun una lista de indices y los regresa en otro arreglo
        Arreglo arregloRetorno = new Arreglo(listaIndices.cantidad());
        for (int elementoArreglo =0; elementoArreglo<= listaIndices.indiceSuperior;elementoArreglo++){
            int indice = ((Number)listaIndices.datos[elementoArreglo]).intValue();
            if (indice>=0 && indice<=this.indiceSuperior){
                arregloRetorno.poner(this.datos[indice]);
            }
        }
        return arregloRetorno;
    }



    //que show profe
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


// ------------------ para pila fija ------------------
@Override
public Object verFinal() { // definir en iterface
    if(vacio()==false){
        return this.datos[indiceSuperior];
    }else{
        return false;
    }
}

//----------------------------para practica 5 - audios-------------------------

public void cargarArreglo(double[] buffer){
    this.indiceSuperior = buffer.length-1; //ajuste del indice superior
    this.capacidad = buffer.length; // ajuste de la capacidad
    this.datos = new Object[buffer.length]; //creacion de arreglo independiente para los valores de buffer

    //para copiar los datos de buffer a datos
    for(int elementoBuffer =0; elementoBuffer<buffer.length;elementoBuffer++){
        this.datos[elementoBuffer] = buffer[elementoBuffer];
    }

}
  
public double[] leerArreglo(){
    double[] copiaArreglo = new double[this.capacidad];
    for(int elementoArreglo=0; elementoArreglo <= indiceSuperior;elementoArreglo++){
        copiaArreglo[elementoArreglo] = (double)this.obtener(elementoArreglo);
    }
    return copiaArreglo;
}



// ------listaDin
@Override
public Integer ponerInicio(Object valor) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'ponerInicio'");
}

@Override
public void iniciarIterador() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'iniciarIterador'");
}

@Override
public boolean iteradorValido() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'iteradorValido'");
}

@Override
public Object obtenerIterador() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'obtenerIterador'");
}

@Override
public void moverseIterador() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'moverseIterador'");
}

@Override
public Object verInicio() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'verInicio'");
}



}// fin clase