package EstructuraDatos.EDLineal;

import tools.comunesBase.ManipularObjetos;
import tools.comunesBase.TipoOrdenamiento;

public class ArregloOrdenado extends Arreglo{
    protected TipoOrdenamiento tipoOrden; //con esto sabremos como debe estar ordenado 


    public ArregloOrdenado(int tamanio) {
        super(tamanio);
        this.tipoOrden = TipoOrdenamiento.INC; //por si no se da un tipo de orden, el default sera Incremental
    }
    

    public ArregloOrdenado(int maximo, TipoOrdenamiento orden){ // este mconstructor le podemos pasar un tipo de orden en el que deberia de guardarse
        super(maximo);
        this.tipoOrden = orden;
    }

    @Override // buscar un ojeto en de dos formas en DEC o la default que es INC
    public Object buscar(Object valor) { 
        if (tipoOrden == TipoOrdenamiento.DEC) {
            //busqueda decremental
            int posicionB = 0;
            while (posicionB <= indiceSuperior && ManipularObjetos.compararObjetos(valor, datos[posicionB]) < 0) {
                posicionB++;
            }
            if (posicionB > indiceSuperior || ManipularObjetos.compararObjetos(valor, datos[posicionB]) > 0) {
                return -(posicionB + 1); // No encontrado, retorna posición donde debería ir
            } else {
                return posicionB; // Se encontró, retorna la posición
            }
        } else {
            // Búsqueda en orden incremental
            int posicionB = 0;
            while (posicionB <= indiceSuperior && ManipularObjetos.compararObjetos(valor, datos[posicionB]) > 0) {
                posicionB++;
            }
            if (posicionB > indiceSuperior || ManipularObjetos.compararObjetos(valor, datos[posicionB]) < 0) {
                return -(posicionB + 1); // No encontrado, retorna posición donde debería ir
            } else {
                return posicionB; // Se encontró, retorna la posición
            }
        }
    }
    



    @Override
    public Integer poner(Object valor){ //agrega valores en el arreglo segun donde deba de ir 
        if(lleno() ==false){
            int posicionEncontrado =(int) buscar(valor);
            if (posicionEncontrado < 0){
                posicionEncontrado = posicionEncontrado*(-1);
                posicionEncontrado = posicionEncontrado-1;
                for(int posMod = indiceSuperior + 1; posMod > posicionEncontrado; posMod--){
                    datos[posMod] = datos[posMod - 1];
                }
                datos[posicionEncontrado] = valor;
                indiceSuperior++;
                return posicionEncontrado;
            }else{
                return -1;
            }

        }else{
            return -1;
        }
    }

    @Override
    public Object quitar(Object valor) {
        int posicion = (int) buscar(valor); // Buscar la posición del valor
        if (posicion >= 0) {
            Object respaldo = datos[posicion];
            for (int elemento = posicion; elemento <= indiceSuperior; elemento++) {
                this.datos[elemento] = this.datos[elemento + 1]; // Desplazar los elementos hacia la izquierda
            }
            indiceSuperior--; // Actualizar el índice superior
            return respaldo;
        } else {
            return null; // Valor no encontrado
        }
    }

    @Override
    public boolean modificar(int indice, Object valor){//modificar un valor en un arreglo 
        if (indice <= indiceSuperior){
            quitar(indice);
            poner(valor);
            return true;
        }else{
            return false;
        }
    }


    @Override //agregar una lista a la otra siempre y cuando quepa en ella
    public boolean agregarLista(ListaDatos lista2){
        ArregloOrdenado arregloTem = (ArregloOrdenado) lista2;
        if (saberCantidadVacion() >= arregloTem.cantidad()){
            for (int valor = 0; valor <= arregloTem.indiceSuperior; valor++){
                this.poner(arregloTem.datos[valor]);
            }
            return true;
        } else {
            return false;
        }
    }

    public int saberCantidadVacion(){ //metodo aux para saber cuantos espacios hay vacios 
        int contador=0;
        for (int espacio = indiceSuperior+1; espacio <= capacidad; espacio++){
            contador = contador+espacio;
        }
        return contador;
    }



    @Override //se invierte el tipo de orden que tiene el arreglo
    public void invertir(){
        if (tipoOrden == TipoOrdenamiento.DEC){
            setTipoOrden(TipoOrdenamiento.INC);
        } else {
            setTipoOrden(TipoOrdenamiento.DEC);
        }
    
        ArregloOrdenado arregloTemp = new ArregloOrdenado(capacidad, tipoOrden);//arrglo auxiliar
        for(int valor = 0; valor <= indiceSuperior; valor++){
            arregloTemp.poner(this.datos[valor]);
        }
        //igualar los valores de arreglo aux con los de la lista actual
        this.datos = arregloTemp.datos;
        this.indiceSuperior = arregloTemp.indiceSuperior;
    }

    
    public void setTipoOrden(TipoOrdenamiento tipoOrden) { //get auxiliar
        this.tipoOrden = tipoOrden;
    }

    

//------------------------------------------------------------------------------------------
    
    @Override   //tiene que revolver el arregloOrdenado y devolver un arreglo de tipo Arreglo
    public ListaDatos arregloDesordenado(){
         Arreglo arregloTem = new Arreglo(capacidad); //arreglo aux
         for (int elementoArreglo = 0; elementoArreglo <= this.indiceSuperior; elementoArreglo++) { //copiar los datos en el segundo arreglo
             arregloTem.poner(this.datos[elementoArreglo]);
         }
         // Revolver el arreglo aux
         for (int elemento =0; elemento <= this.indiceSuperior; elemento++ ){
            int indiceAleatorio = (int) (Math.random() * (indiceSuperior + 1)); //generar indice aleatorio
            Object temp = arregloTem.datos[elemento];
            arregloTem.datos[elemento] = arregloTem.datos[indiceAleatorio]; //asignar valor en el idice aleatorio/ evita que se repita
            arregloTem.datos[indiceAleatorio] = temp; //asiga el valor temporal el arreglo
         }

        return arregloTem; //regresamos el valor 
    }


    @Override // ve si una lista 2 es una sublista de la lista actual 
    public boolean esSublista(ListaDatos lista2){
        Arreglo arregloTem = (Arreglo) lista2; // casting 
        if (arregloTem.cantidad() > this.indiceSuperior){ //saber si cantidad de datos es menor que la lista original
           return false;
        }
        
        for (int elementoArreglo = 0; elementoArreglo <= this.indiceSuperior; elementoArreglo++){//iteracion en la lista original
            boolean esSublista = true;
            for (int elemento = 0; elemento <= arregloTem.indiceSuperior; elemento++){ //iteracion en la lista2
            
                Object objeto = arregloTem.datos[elemento]; //obtener el objeto de la lista2
                int eleBuscado = (int) this.buscar(objeto);//buscar el objeto en la lista original 
    
                if (eleBuscado < 0){ //si el valor que retorna la busqueda significa que no esta  y por ende no es sublista
                    esSublista = false;
                    break;
                }
            }
            if (esSublista){ //pero si matiene el valor de true significa que si se encontraron todos los valores lo cual es sublista
                return true;
            }
        }
        return false; 
    }


    @Override
    public boolean modificarLista(ListaDatos lista2, ListaDatos lista2Nuevos) {
        Arreglo arregloTem = (ArregloOrdenado) lista2; // casting
        Arreglo arregloTemNuevo = (ArregloOrdenado) lista2Nuevos;
        
        int cambios = 0; // saber si hubo cambios
        for (int elemetosArreglo = 0; elemetosArreglo <= this.indiceSuperior; elemetosArreglo++) {
            int elementoB = (int) arregloTem.buscar(this.datos[elemetosArreglo]); // buscando elemento en la lista2
            
            if (elementoB >= 0 && elementoB <= arregloTemNuevo.indiceSuperior) { // si está nos regresa un número positivo y sumamos 1 al contador//la segunda condicion es para ver que este en el rango del otro arreglo
                this.datos[elemetosArreglo] = arregloTemNuevo.datos[elementoB];
                cambios++;
            }
        }
        if (cambios>0){ //saber si hubo cambios para saber que retornar
            return true;
        }else{
            return false;
        }
    }


    @Override //este metodo debe dejar los elementos de una lista secundaria
    public boolean retenerLista(ListaDatos lista2){
        ArregloOrdenado arregloTem = (ArregloOrdenado) lista2;
        ArregloOrdenado arre = new ArregloOrdenado(capacidad);

        for(int elemento = 0; elemento <= this.indiceSuperior; elemento++){
            Object objeto = this.datos[elemento];
            int buscado = (int) arregloTem.buscar(objeto);
            if(buscado >= 0){
                arre.poner(objeto);
            }
        }
        
        vaciar();
        for (int elementoArre = 0; elementoArre <= arre.indiceSuperior; elementoArre++){
            Object objeto = arre.datos[elementoArre];
            this.poner(objeto);
        }
        return true;
    }
    

//---------------------------------------------------------------------------------------------
    @Override
    public ListaDatos subLista(int indiceInicial, int indiceFinal) {
        // Método sobreescrito en blanco
        return null;
    }

    @Override
    public boolean redimensionar(int maximo) {
        // Método sobreescrito en blanco
        return false;
    }

    @Override //sustituir los valores de la lista original por los de una lista secundarioa
    public boolean substituir(ListaDatos lista2) {
        ArregloOrdenado arregloTem = (ArregloOrdenado) lista2;
        if (this.cantidad() == arregloTem.cantidad()){
            this.vaciar();
            for(int elementoArreglo =0; elementoArreglo <= arregloTem.indiceSuperior;elementoArreglo++){
                this.poner(arregloTem.datos[elementoArreglo]);
            }
            return true;
        }else{
            return false;
        }
    }



    @Override //agregar un dato en un indice esperado
    public boolean poner(int indice, Object info) {
        
        if (indice >= 0 && indice <= indiceSuperior) { //validar el rango del indice 
            
            int posicionCorrecta = (int) buscar(info); //buscar la poscicion correcta 
            if (posicionCorrecta < 0) {
                posicionCorrecta = -(posicionCorrecta) - 1;
            }
    
          
            if (indice == posicionCorrecta) { //verificar que sea la misma posicion con el indice
                
                for (int elementoArreglo = indiceSuperior; elementoArreglo >= indice; elementoArreglo--) { //mover lo elementos un elemeto arriba 
                    datos[elementoArreglo + 1] = datos[elementoArreglo];
                }
             
                this.datos[indice] = info; //insertar dato
                indiceSuperior++;
                return true;
            } else {
                
                return false;
            }
        } else {
            return false;
        }
    }

    


}// llave final 
