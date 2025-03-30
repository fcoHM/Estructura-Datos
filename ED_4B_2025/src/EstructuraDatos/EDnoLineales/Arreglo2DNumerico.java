package EstructuraDatos.EDnoLineales;

import EstructuraDatos.EDLineal.ArregloNumerico;
import entradaSalida.Salida;
import tools.comunesBase.TipoLogaritmo;

public class Arreglo2DNumerico extends Arreglo2D {



    //inicia con un tamanio y valores en cero
    public Arreglo2DNumerico(int renglones, int columnas){
        super(renglones, columnas); // le da un tamanio al arreglo2D
        this.rellenar(0); // se rellena con cero
    }

    //inicioa con un tamanio y con un valor dado por el user
    public Arreglo2DNumerico(int renglones, int columnas, Object valor) {
        super(renglones, columnas);
        if(valor instanceof Number){ //si el valor es perteneciente a la clase Number
            this.rellenar(valor); //se rellena con ese valor
        }else{
            this.rellenar(0); //si no se inician con cero
        }
    }
    

    @Override //rellenar la matriz con algun valor numerico
    public void rellenar(Object valor){
        if(valor instanceof Number){ //validar que valor sea instancia de Number 
            //moverse entre columnas
            for(int columna=0; columna < columnas; columna++){
                //moverse entre filas
                for(int fila=0; fila<filas;fila++){
                    datos[fila][columna] = valor;
                }
            }
        }else{
            return;
        }
    }


    @Override // recuperar un dato
    public Double obtener(int fila, int col){  // se puede cambiar el retorno de la firma mientras se pueda aplicar el polimorfismo
        // Validar los índices
        if (fila < 0 || fila >= filas || col < 0 || col >= columnas) {
            return null;
        }
        // Obtener valor
        Object valor = datos[fila][col];

        if (valor instanceof Number) {
            return ((Number) valor).doubleValue(); // Convierte cualquier número a Double
        }
        return null;
    }


    @Override//cambia un valor del arreglo en una posicion dada y lo remplaza por otro valor dado
    public boolean cambiar(int fila, int col, Object valor){
       if(valor instanceof Number){ //valida si es instancia de number
            if(fila < 0 || fila >= filas || col < 0 || col >= columnas){ // valida los rangos de fila y col
                return false;
            }else{
                datos[fila][col] = valor; //cambia el valor
                return true;
            }
       }else{
            return false;
       }
    }
   


    //----------------------metodos practica 7--------------------
    //multiplica la matriz por un escalar
    public boolean porEscalar(Number escalar){
        double escalarTem = escalar.doubleValue();
        //recorrer filas
        for (int fila=0; fila<this.getFilas();fila++){
            //recorrer columnas
            for (int col=0; col< this.getColumnas();col++){
                Object valor = datos[fila][col];
                // convertir el valor a Double y multiplicarlo por el escalar
                double nuevoValor = ((Number) valor).doubleValue() * escalarTem;
                // cambiar el valor 
                this.cambiar(fila, col, nuevoValor);     
            }
        }
        return true;
    }

    //le aplica un escalar en una posicion dada 
    public boolean porEscalares(ArregloNumerico escalares) {

        int area = this.getFilas() * this.getColumnas(); //tamaño matriz
        if (area != escalares.cantidad()) { //ver si tiene la misma catidad de elementos
            return false; 
        }else{
            int posArreglo = 0; // contador para recorrer el arreglo de escalares

            for (int fila = 0; fila < this.getFilas(); fila++) {
                for (int col = 0; col < this.getColumnas(); col++) {
                    
                    Double valorMatriz = this.obtener(fila, col); //obtener valor matriz
                    Object escalar = escalares.obtener(posArreglo);//obtener valor escalar
        
                
                    double nuevoValor = valorMatriz * ((Number) escalar).doubleValue(); //valor multiplicado por escalar
        
                    this.cambiar(fila, col, nuevoValor);
                    
                    posArreglo++; 
                }
            }
    
            return true;
        }
    }

    //aplicar la suma de un escalar a una matriz
    public boolean sumarEscalar(Number escalar){
        double escalarTem = escalar.doubleValue();
        //recorre arreglo2D
        for (int fila=0;fila<this.getFilas();fila++){
            for(int col=0; col<this.getColumnas();col++){
                Object valor = datos[fila][col];
                // convertir el valor a Double y multiplicarlo por el escalar
                double nuevoValor = ((Number) valor).doubleValue() + escalarTem;
                // cambiar el valor 
                this.cambiar(fila, col, nuevoValor);  
            }
        }
        return true;
    }


    // hacer sumar por posicion los valores de un matriz y un arregloNumerico
    public boolean sumarEscalares(ArregloNumerico escalares){
        //saber el area de elementos de la matriz
        int area = this.getFilas() * this.getColumnas();
        
        if(area!=escalares.cantidad()){
            return false;
        }else{
            int posArreglo = 0; // contador para recorrer el arreglo de escalares

            for (int fila = 0; fila < this.getFilas(); fila++) {
                for (int col = 0; col < this.getColumnas(); col++) {
                    
                    Double valorMatriz = this.obtener(fila, col); //obtener valor matriz
                    Object escalar = escalares.obtener(posArreglo);//obtener valor escalar
        
                
                    double nuevoValor = valorMatriz + ((Number) escalar).doubleValue(); //valor multiplicado por escalar
        
                    this.cambiar(fila, col, nuevoValor);
                    
                    posArreglo++; 
                }
            }
    
            return true;
        }
    }

    //multiplica la matriz original por una matriz dada
    public boolean multiplicar(Arreglo2DNumerico matriz2){
        //sacar area de las dos matrices 
        int areaOriginal = this.getColumnas()* this.getFilas();
        int areaMatriz = matriz2.getColumnas()*matriz2.getFilas();

        if (areaOriginal!=areaMatriz){ //validar las areas 
            return false;
        }else{
            for(int fila=0; fila<filas;fila++){
                for( int col=0; col<columnas;col++){
                    double valorOri = this.obtener(fila, col);
                    double valorMat = matriz2.obtener(fila, col);

                    this.cambiar(fila, col, valorMat*valorOri); //multiplicar variables y guardarlas en original 
                }
            }
            return true;
        }
    }

    //sumnar dos matrices por posicion
    public boolean sumar(Arreglo2DNumerico matriz2){
        //sacar area de ambas matrices 
        int areaOriginal = this.getColumnas()* this.getFilas();
        int areaMatriz = matriz2.getColumnas()*matriz2.getFilas();
 
        if (areaOriginal!=areaMatriz){ //validar areas
            return false;
        }else{
            for(int fila=0; fila<filas;fila++){
                for( int col=0; col<columnas;col++){
                    double valorOri = this.obtener(fila, col);
                    double valorMat = matriz2.obtener(fila, col);

                    this.cambiar(fila, col, valorMat+valorOri);//sumar elementos y regresar valor
                }
            }
            return true;
        }
    }
    
    // aplicar potencia elemento por elemento 
    public boolean aplicarPotencia(Number escalar){
        double escalarTem = escalar.doubleValue();

        for(int fila=0; fila<filas; fila++){
            for(int col=0; col<columnas; col++){
                double valor = this.obtener(fila, col);
                double valorPotencia = potencia(escalarTem, valor);
                this.cambiar(fila, col, valorPotencia);
            }
        }
        return true;
    }

    private double potencia(double escalar, double valor){
        double resultado =1;
        for(int exp=0; exp<escalar;exp++){
            resultado = resultado*valor;
        }
        return resultado;
    }


    //aplicarle un logaritomo a una matriz 
    public boolean aplicarLogartimo(TipoLogaritmo tipo){
        if(buscarCeros()==true){ //validar que no haya ceros en la matriz 
            return false;
        }else if(tipo == TipoLogaritmo.BASE10){
            for(int fila =0; fila<filas; fila++){
                for(int col=0; col<columnas; col++){
                    double valorMat = this.obtener(fila, col);
                    double valorNuevo = Math.log10(valorMat); // valor en base 10
                    this.cambiar(fila, col, valorNuevo);
                }
            }
            return true;
        }else if(tipo == TipoLogaritmo.BASE2){
            for(int fila =0; fila<filas; fila++){
                for(int col=0; col<columnas; col++){
                    double valorMat = this.obtener(fila, col);
                    double valorNuevo = Math.log(valorMat)/Math.log(2); //valor en base 2
                    this.cambiar(fila, col, valorNuevo);
                }
            }
            return true;
        }else{
            return false;
        }
    }

    private boolean buscarCeros(){
        for(int fila =0; fila<filas; fila++){
            for(int col=0; col<columnas; col++){
                double valor = this.obtener(fila, col);
                if (valor==0){
                    return true;
                }
            }
        }
        return false;
    }


    //generar una matriz con una diagonal ccon el valor dado
    public boolean matrizDiagonal(Number contenido){
        double contenidoTem= contenido.doubleValue();
        
        for(int fila =0; fila<filas; fila++){
            for(int col=0; col<columnas; col++){
                if(col==fila){
                    this.cambiar(fila, col, contenidoTem);
                }else{
                    this.cambiar(fila, col, 0);
                }
            }
           
        }
        return true;
    }


    public boolean doblarRenglones(){
        //validar que tenga mitad exacta
        if(columnas%2!=0){
            return false;
        }else{
            int mitad=this.getColumnas()/2;
            double suma =0;
            ArregloNumerico arre = new ArregloNumerico(this.filas);
            ArregloNumerico arre2 = new ArregloNumerico(this.filas);

            //primera mitad
            for(int fila =0; fila<this.filas;fila++){
                suma =0;
                for(int col=0; col<mitad;col++){
                    suma = suma +this.obtener(fila, col);
                    
                }
                arre.poner(suma);
            }
            //segunda mitad
            
            for(int fila =0; fila<this.filas;fila++){
                suma =0;
                for(int col=mitad; col<this.columnas;col++){
                    suma = suma +this.obtener(fila, col);
                   
                }
                arre2.poner(suma);
            }

            this.setColumnas(2);
            this.datos = new Object[filas][columnas]; //reiniciamos el espacio con nueva forma
            //copiando primera columna
            for(int elemeto=0;elemeto<arre.cantidad();elemeto++){
                double valor= (double)arre.obtener(elemeto);
                this.cambiar(elemeto, 0, valor);
            }
            //copiando segunda columna
            for(int elemeto=0;elemeto<arre2.cantidad();elemeto++){
                double valor= (double)arre2.obtener(elemeto);
                this.cambiar(elemeto, 1, valor);
            }
            return true;
        }
    }



    public boolean doblarColumnas(){
        //validar que tenda mitad exacta
        if(filas%2!=0){
            return false;
        }else{
            int mitad=this.getFilas()/2;
            double suma =0;
            ArregloNumerico mitad1 = new ArregloNumerico(this.columnas);
            ArregloNumerico mitad2 = new ArregloNumerico(this.columnas);

            //primera mitad
            for (int col = 0; col < this.columnas; col++) {
                suma = 0;
                for (int fila = 0; fila < mitad; fila++) {
                    suma =suma+ this.obtener(fila, col);
                }
                mitad1.poner(suma);
            }
            //segunda mitad
            
            for (int col = 0; col < this.columnas; col++) {
                suma = 0;
                for (int fila = mitad; fila < this.filas; fila++) {
                    suma = suma+ this.obtener(fila, col);
                }
                mitad2.poner(suma);
            }
    
            this.setFilas(2);
            this.datos = new Object[filas][columnas]; //reiniciamos el espacio con nueva forma
            //copiando primera columna
            for (int elemento = 0; elemento < mitad1.cantidad(); elemento++) {
                double valor = (double) mitad1.obtener(elemento);
                this.cambiar(0, elemento, valor);
            }
    
           //copiando segunda columna
            for (int elemento= 0; elemento < mitad2.cantidad(); elemento++) {
                double valor = (double) mitad2.obtener(elemento);
                this.cambiar(1, elemento, valor);
            }
            return true;
        }
    }

}//fin clase
