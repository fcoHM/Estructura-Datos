package EstructuraDatos.EDLineal;

public class ArregloNumerico extends Arreglo {

    public ArregloNumerico(int tamanio) {
        super(tamanio); //para mandar a llamara los atributos de la clase de arriba 
    }

    // metodos sobreEscritos de Arreglo

    
    @Override //debe agregar de tipo Number un numero
    public Integer poner(Object valor) {
        if (valor instanceof Number) {
            return super.poner(valor);
        } else {
            return -1; // Retorna -1 si el valor no es de tipo Number
        }
    }

    @Override
    public boolean modificar(int indice, Object valor) {
        if (valor instanceof Number) {
            return super.modificar(indice, valor);
        } else {
            return false; // retorna false si el valor no es de tipo Number
        }
    }

    @Override
    public Object quitar(Object valor) {
        if (valor instanceof Number) {
           
            return super.quitar(valor);
        } else {
            return null; // retorna null si el valor no es de tipo Number
        }
    }

    @Override
    public Arreglo buscarValores(Object valor) {
        if (valor instanceof Number) {
           
            return super.buscarValores(valor); //poder buscar valores decimales
        } else {
            return null; // retorna null si el valor no es de tipo Number
        }
    }

    @Override
    public boolean modificar(Object valorNuevo, Object valorViejo, int numeroVeces) {
        if (valorNuevo instanceof Number && valorViejo instanceof Number) {
            return super.modificar(valorNuevo, valorViejo, numeroVeces);
        } else {
            return false; // retorna false si alguno de los valores no es de tipo Number
        }
    }

    @Override
    public Object buscar(Object valor) {
        if (valor instanceof Number) {
            
            return super.buscar(valor);
        } else {
            return -1; // retorna -1 si el valor no es de tipo Number
        }
    }


    //metodos de la clase ArregloNumerico

    public boolean porEscalar(Number escalar){ // multiplica un numero(escalar) por todo el arreglo
        if(vacio() == true){
            return false;
        }else{
            double escalarTem = escalar.doubleValue();
            for(int elementoArreglo=0; elementoArreglo<= indiceSuperior;elementoArreglo++){
                double valor = ((Number) datos[elementoArreglo]).doubleValue() * escalarTem;
                datos[elementoArreglo] = valor;
            }
            return true;
        }
    }

    public boolean sumarEscalar(Number escalar){ //a cada elemento le suma el escalar dado
        if (vacio()==true){
            return false;
        }else{
            double escalarTem = escalar.doubleValue();
            for(int elementoArreglo =0; elementoArreglo<=indiceSuperior;elementoArreglo++){
                double valor = ((Number)datos[elementoArreglo]).doubleValue()+escalarTem;
                datos[elementoArreglo] = valor;
            }
            return true;
        }
    }

    public boolean sumar(ArregloNumerico lista2){ // suma los elemeto de un arreglo con los de otro respetando la posicion 
        if ((this.cantidad()== lista2.cantidad())==false){
            return false;
        }else{
            for(int elementoArreglo =0; elementoArreglo<=indiceSuperior;elementoArreglo++){
                double valor = ((Number)this.datos[elementoArreglo]).doubleValue() + ((Number)lista2.datos[elementoArreglo]).doubleValue();
                datos[elementoArreglo]= valor;
            }
            return true;
        }
    }

    public boolean multiplicar(ArregloNumerico lista2){ // multiplica los elemeto de un arreglo con los de otro respetando la posicion 
        if((this.cantidad()==lista2.cantidad())==false){
            return false;
        }else{
            for(int elementoArreglo =0; elementoArreglo<=indiceSuperior;elementoArreglo++){
                double valor = ((Number)this.datos[elementoArreglo]).doubleValue() * ((Number)lista2.datos[elementoArreglo]).doubleValue();
                datos[elementoArreglo]= valor;
            }
            return true;
        }
    }


    public boolean aplicarPotencia(Number escalar){ // le aplica el exponecial a cada elemeto 
        if (vacio()==true){
            return false;
        }else{
            double exponencial = escalar.doubleValue();
            for(int elementoArreglo =0; elementoArreglo<=indiceSuperior;elementoArreglo++){
                double valor = ((Number)this.datos[elementoArreglo]).doubleValue();
                double resultado = 1;
                for(int exp =0; exp < exponencial; exp++){
                    resultado = resultado * valor;
                }
                datos[elementoArreglo] = resultado;
            }
            return true;
        }
    }


    public boolean aplicarPotencia(ArregloNumerico lista2){ //aplica la potencia que se encuentra en la segunda lista
        if ((this.cantidad() == lista2.cantidad())==false){
            return false;
        }else{
            for(int elementoArreglo =0; elementoArreglo<=indiceSuperior;elementoArreglo++){
                double valor = ((Number)this.datos[elementoArreglo]).doubleValue();
                double resultado = 1;
                for(int exp =0; exp < ((Number)lista2.datos[elementoArreglo]).doubleValue(); exp++){ //el limite/exp es el elemento de la otra lista 
                    resultado = resultado * valor;
                }
                datos[elementoArreglo] = resultado;
            }
            return true;
        }
    }

    public double productoEscalar(ArregloNumerico lista2){ //este metodo saca el producto escalar multiplicando cada elemento y luego los suma todos
        if ((this.cantidad()== lista2.cantidad())==false){
            return -1; // esto regresa por que no se hizo nada 
        }else{
            this.multiplicar(lista2);
            double resultado =0;
            for (int elementoArreglo =0; elementoArreglo<= indiceSuperior; elementoArreglo++){
                resultado = resultado + ((Number)this.datos[elementoArreglo]).doubleValue();
            }
            return resultado;
        }
    }

    public double norma(){ // lo que hace esta funcion es calcular la longitud/norma de un vector
        aplicarPotencia(2);
        double suma = 0;
        double resultado = 0;
        for(int elementoArreglo =0; elementoArreglo<= indiceSuperior; elementoArreglo++){
            suma = suma + ((Number)this.datos[elementoArreglo]).doubleValue();
        }
        resultado = Math.sqrt(suma);
        return resultado;
    }

    public double normaEuclidiana(ArregloNumerico arreglo) { // calcula la norma euclidiana
        if ((this.cantidad() == arreglo.cantidad())==false) {
            return -1;
        } else {
            for (int elementoArreglo = 0; elementoArreglo <= indiceSuperior; elementoArreglo++) { // resta de elementos de la lista actual con la lista secundaria
                double valor = ((Number) this.datos[elementoArreglo]).doubleValue() - ((Number) arreglo.datos[elementoArreglo]).doubleValue();
                this.datos[elementoArreglo] = valor;
            }
            this.aplicarPotencia(2); // aplicar exp
            double suma = 0;
            for (int elementoArreglo = 0; elementoArreglo <= indiceSuperior; elementoArreglo++) { // sumar todos los elementos
                suma = suma + ((Number) this.datos[elementoArreglo]).doubleValue();
            }
            return Math.sqrt(suma); // regresar la raíz
        }
    }
    

    public boolean sumarListaEstatica(Arreglo listas){ // suma a la lista actual un conjunto de listas 
        for(int elementoArreglo =0; elementoArreglo<=listas.indiceSuperior;elementoArreglo++){
            ArregloNumerico arre = (ArregloNumerico) listas.datos[elementoArreglo];
            this.suma(arre); //uso del metodo auxiliar
        }
        return true;
    }

    public boolean suma(Arreglo lista){ // suma los elemento de dos listas segun su posicion
        if ((this.cantidad() == lista.cantidad())==false){ //valida que tengan la misma longitud ambos arreglos 
            return false;
        }else{
            for(int elementoArreglo =0; elementoArreglo<= indiceSuperior;elementoArreglo++){
                double valor = ((Number)this.datos[elementoArreglo]).doubleValue() + ((Number)lista.datos[elementoArreglo]).doubleValue();
                datos[elementoArreglo]= valor;
            }
            return true;
        }
    }



    public boolean sumarEscalares(ArregloNumerico escalares){// le aplica la suma de escalares que esten en una lista escalares
        for(int elementoArreglo = 0; elementoArreglo<=escalares.indiceSuperior;elementoArreglo++){
            double escalar = ((Number)escalares.datos[elementoArreglo]).doubleValue();
            this.sumarEscalar(escalar);
        }
        return true;
    }


    public double sumarIndices(ArregloNumerico listaIndices){ //suma las posiciones que sean nombradas por el contenido del arreglo recibido
        double suma=0;
        for(int elementoArreglo=0; elementoArreglo<= listaIndices.indiceSuperior;elementoArreglo++){
            int indice = ((Number)listaIndices.datos[elementoArreglo]).intValue();
            if (indice>=0 && indice<=this.indiceSuperior){
                suma = suma + ((Number)this.datos[indice]).doubleValue();
            }
        }
        return suma;
    }

    @Override
    public Arreglo subLista(ArregloNumerico listaIndices){ //genera una pequeña sublista de la lista mas grande segun los indices de otro arreglo
        ArregloNumerico arregloRetorno = new ArregloNumerico(listaIndices.cantidad());
        for (int elementoArreglo = 0; elementoArreglo <= listaIndices.indiceSuperior; elementoArreglo++) {
            int indice = ((Number) listaIndices.datos[elementoArreglo]).intValue();
            if (indice >= 0 && indice <= this.indiceSuperior) {
                arregloRetorno.poner(this.datos[indice]);
            }
        }
        return arregloRetorno;
    }


    public boolean sonLinealmenteDependientes(Arreglo listaVectores){
        if ((this.cantidad()==listaVectores.cantidad())==false){
            return false;
        }else{
            for(int elementoArreglo =0; elementoArreglo<= listaVectores.indiceSuperior;elementoArreglo++){ //aplicando escalar a cada vector
                ArregloNumerico vector = (ArregloNumerico) listaVectores.datos[elementoArreglo];
                this.porEscalar(vector);//metodo auxiliar
            }
            return true;
            //falta como manipular el arreglo como matriz 

        }
    }



    public boolean porEscalar(ArregloNumerico lista){ // a una lista le aplica el escalar segun ambas posicciones sean la misma
        for(int elementoArreglo =0; elementoArreglo <= indiceSuperior;elementoArreglo++){
            lista.porEscalar(((Number)this.datos[elementoArreglo]).intValue());
        }
        return true;
    }



    //------------------ practica 5 -----------------

    //hace una suma de todo lo que esta en el arreglio 
    public double suma(){
        double suma = 0; //acumulador
        for(int elemento=0;elemento<this.cantidad();elemento++){ // recorrido de arreglo 
            suma = suma + (double)this.datos[elemento]; //obtencion de datos 
        }
        return suma; // resultado de la suma 
    }

    //---------------practica 7-------------
    
    public ArregloNumerico convertirAArregloNumerico(Arreglo arreglo){
        if (arreglo == null || arreglo.vacio()) {
        return null; 
        }
         ArregloNumerico arregloNumericoConvertido = new ArregloNumerico(arreglo.cantidad());
        for (int indice = 0; indice < arreglo.cantidad(); indice++) {
            Object elementoActual = Double.parseDouble(arreglo.obtener(indice).toString());
            if (elementoActual instanceof Number) {
                arregloNumericoConvertido.poner(elementoActual); // Agregar el elemento al ArregloNumerico
            } 
        }
        if(arregloNumericoConvertido.vacio()==true){
            return null;
        }else{
            return arregloNumericoConvertido;
        }
    }
}// llave final  