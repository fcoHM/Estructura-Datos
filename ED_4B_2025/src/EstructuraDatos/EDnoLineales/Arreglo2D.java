package EstructuraDatos.EDnoLineales;

import EstructuraDatos.EDLineal.Arreglo;
import entradaSalida.Salida;
import tools.comunesBase.ManipularObjetos;

public class Arreglo2D {
    protected Object datos[][];
    protected int filas;
    protected int columnas;


    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }


    
    
    public Arreglo2D(int renglones, int columnas){
        this.filas = renglones;
        this.columnas = columnas;
        datos = new Object[filas][columnas];
    }


    //inicia un arreglo 2D con un valor dado 
    public Arreglo2D(int renglones, int columnas, Object valor){
        this.filas = renglones;
        this.columnas = columnas;
        datos = new Object[filas][columnas];
        rellenar(valor);
    }
    
    //rellena todo el arreglo2D con un valor que se le da
    public void rellenar(Object valor){
        //moverse entre columnas
        for(int columna=0; columna < columnas; columna++){
            //moverse entre filas
            for(int fila=0; fila<filas;fila++){
                datos[fila][columna] = valor;
            }
        }
    }

    //recupera un valor segun la posicion indicada
    public Object obtener(int fila, int col){
        Object valor = datos[fila][col];
        return valor;
    }

    //cambia un valor del arreglo en una posicion dada y lo remplaza por otro valor dado
    public boolean cambiar(int fila, int col, Object valor){
        if(fila < 0 || fila >= filas || col < 0 || col >= columnas){
            return false;
        }else{
            datos[fila][col] = valor;
            return true;
        }
    }

    //imprime la matriz  x sus columnas
    public void imprimirXColumnas(){
        //recorre las filas
        for(int fila=0; fila<filas; fila++){
            //recorre las columnas 
            for(int col=0;col<columnas;col++){
                Salida.salidaPorDefecto(datos[fila][col]+"");
            }
            Salida.salidaPorDefecto("\n");
        }
    }


    //imprime la matriz x sus renglones
    public void imprimirXRenglones(){
        //recorrer columnas 
        for(int col=0; col<columnas;col++){
            //recorrer filas
            for(int fila =0;fila<filas;fila++){
                Salida.salidaPorDefecto(datos[fila][col]+"");
            }
            Salida.salidaPorDefecto("\n");
        }

    }
    

    //generar una copia del arreglo original 
    public Arreglo2D clonar(){
        Arreglo2D arreTemp = new Arreglo2D(this.filas, this.columnas);
        //recorre las filas
        for(int fila=0; fila<filas; fila++){
            //recorre las columnas 
            for(int col=0;col<columnas;col++){
                Object valor = this.datos[fila][col];
                arreTemp.cambiar(fila, col, valor);
            }
    
        }
        return arreTemp;
    }

    //saber si dos matrices son iguales
    public boolean esIgual(Arreglo2D matriz2){
        if (this.filas != matriz2.getFilas() || this.columnas != matriz2.getColumnas()){
            return false;
        }else{
            for(int fila=0; fila<filas; fila++){
                //recorre las columnas 
                for(int col=0;col<columnas;col++){
                    Object valorArregloOriginal = this.obtener(fila, col);
                    Object valorArregloMatriz = matriz2.obtener(fila, col);
                    
                    //comparar
                    if(ManipularObjetos.compararObjetos(valorArregloOriginal, valorArregloMatriz) != 0){
                        return false;
                    }
                }
            }
            return true;
        }
        
    }

    //rellenar vectores con valores renglon usuario
    public boolean vectorRenglon(int filas, Object info){
        //evaluar rango de fila
        if(filas <0 || filas > this.filas){
            return false;
        }else{
            //recorre las filas
            for(int col=0; col<columnas; col++){
                //recorre las columnas 
                for(int filaInfo=0;filaInfo<=filas;filaInfo++){
                    this.datos[filaInfo][col] = info;
                }
            }
            return true;
        }   
    }

    //rellenar vectores con valores columna usuario
    public boolean vectorColumna(int col, Object info){
        //evaluar rango de fila
        if(col <0 || col> this.filas){
            return false;
        }else{
            //recorre las filas
            for(int fila=0; fila<this.filas; fila++){
                //recorre las columnas 
                for(int colInfo=0;colInfo<=col;colInfo++){
                    this.datos[fila][colInfo] = info;
                }
            }
            return true;
        }   
    }


    // redimenciona el arreglo2D y lo suplanta con lo valores de la matriz que se le pasa 
    public boolean redefinir(Arreglo2D matriz2){
        int valorFilas = matriz2.getFilas();
        int valorCol = matriz2.getColumnas();
        if (valorCol<=0|| valorFilas<=0){
            return false;
        }else{
            // Redimensionar el arreglo actual
            this.filas = valorFilas;
            this.columnas = valorCol;
            //nuevo arreglo con dimeciones nuevas
            this.datos = new Object[filas][columnas]; 

            for(int col=0; col<columnas; col++){
                //recorre las columnas 
                for(int fila=0;fila<matriz2.filas;fila++){
                    Object valorMatriz = matriz2.obtener(fila, col);
                    this.cambiar(fila,col,valorMatriz);
                }
            }
            return true;
        }
    }

    //agregar valores de un arreglo a arreglo2D en modo renglones
    public boolean agregarRenglones(Arreglo arreglo) {
        // Validar que el tamaño 
        if (arreglo.cantidad() != this.getColumnas()) {
            return false; 
        }
    
        // Recorrer las columnas 
        for (int col = 0; col < this.getColumnas(); col++) {
            Object valor = arreglo.obtener(col); 
            this.cambiar(0, col, valor); // Cambiar el valor en la primera fila
        }
    
        return true; 
    }


    //agregar los valores de una arreglo a un arreglo2d
    public boolean agregarColumna(Arreglo arreglo){
        //validar tamaño
        if(arreglo.cantidad()!=this.getFilas()){
            return false;
        }else{
            //reccorrer filas
            for(int fila =0; fila<this.getFilas(); fila++){
                Object valor = arreglo.obtener(fila);
                this.cambiar(fila, 0, valor);
            }
            return true;
        }
    }

    public boolean agregarMatrizXColumna(Arreglo2D matriz2){
        //validar tamaño de filas
        if(this.getColumnas()!= matriz2.getColumnas()){
            return false;
        }else{
            //obtener ultima columna de la original
            int colOriginal = this.getColumnas()-1;
            //nueva longitud a la derecha
            int suma = this.getColumnas() + matriz2.getColumnas();
            //redefinir
            this.setColumnas(suma);
            this.datos = new Object[filas][columnas];


            for(int colOrigen = colOriginal; colOrigen< columnas;colOrigen++){
               

            }
            return true;
        }
    }

    public void transpuesta(){
        //crear un nuevo arreglo con dimensiones invertidas
        Object[][] matrizTemp= new Object[columnas][filas];

        // recorrer la matriz original 
        for (int fila = 0; fila < filas; fila++) {
            for (int col = 0; col < columnas; col++) {
                matrizTemp[col][fila] = this.obtener(fila, col);
            }
        }
        //actualizar tamaño  de la original
        int filasTemp = filas;
        this.filas = columnas;
        this.columnas = filasTemp;

        //reemplazar la original con la transpuesta
        this.datos = matrizTemp;
    }

}//fin clase
