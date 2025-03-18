package EstructuraDatos.EDnoLineales;

import entradaSalida.Salida;

public class Arreglo3D {
    protected int ancho; //columnas
    protected int alto; //filas
    protected int profundidad;// profunfundad
    protected Object datos[][][]; //donde se van a guardar los datos

    public Arreglo3D(int alto, int ancho, int profundidad){
        this.ancho = ancho;
        this.alto = alto;
        this.profundidad = profundidad;
        datos = new Object[alto][ancho][profundidad];
    }
    public Arreglo3D(int alto, int ancho, int profundidad, Object valor){ //este recibe un valor con el que se va a rellenar todo el cubo
        this(alto, ancho, profundidad);
        //llamar funcion rellenar usando el valor
        rellenar(valor);
    }

    public void rellenar(Object valor){ //llenar los campos de un arreglo
        //para cada dimecion se hace un ciclo, se manejan como arreglos unidimencionales
        //dimension 1, filas
        for(int cadaFila =0; cadaFila < alto; cadaFila ++ ){
            //dimesion 2, columnas
            for (int cadaColumna = 0; cadaColumna < ancho; cadaColumna++){
                //dimencion 3, profunfidad
                for ( int cadaProfunfidad = 0; cadaProfunfidad < profundidad; cadaProfunfidad++){
                    //cada celda se refiere a l
                    datos[cadaFila][cadaColumna][cadaProfunfidad] = valor;
                }
            }
        }
    }

    public void imprimirXcolumnas(){
        // es una rebanada seccion con todas las direcciones
        //dividir el cubo en rebanadas de columnas 
        for (int cadaRebanada =0; cadaRebanada < ancho; cadaRebanada++){ //me representa una rebada del cubo
            //ahora debo imprimir una rebana y como esta formada 
            //perimero agarro los renglones de la matris que es una rebana 
            for (int cadaFila = 0; cadaFila < alto; cadaFila++){  // me representa cada fila/renglon
                //asumo que hay un arreglo unidimencional parar las columnas 
                //aqui no exite la profundidad
                for(int cadaColumna =0; cadaColumna < profundidad; cadaColumna++){
                    Salida.salidaPorDefecto(datos[cadaFila][cadaRebanada][cadaColumna]+""); // me representa cada columna de la fila 
                }
                //cuando se impriman todas las columnas de una fila
                Salida.salidaPorDefecto("\n");
            }
            Salida.salidaPorDefecto("\n");
        }

    }



private boolean validarIndice(int tamanioDimencion, int indiceValidar){
    
    if (indiceValidar>=0 && indiceValidar<tamanioDimencion){
        return true;
    }else{
        return false;
    }
}


//agregar metodos, uno para leer  y otro para cambiar valores en el cubo, en una celda en particular

    public Object obtenerCelda( int fila, int col, int prof){ //para sacar un vaor de una celda 
        if(validarIndice(alto, fila)==true && validarIndice(ancho, col) ==true && validarIndice(profundidad, prof)){
            return datos[fila][col][prof];
        }else{
            return null;
        }

    }



    public boolean cambiarCelda(int fila, int col, int prof, Object valor){
        if(validarIndice(alto, fila)==true && validarIndice(ancho, col) ==true && validarIndice(profundidad, prof)){
            datos[fila][col][prof] = valor;
            return true;
        }else{
            return false;
        }
    }






    
} //fin clase
 