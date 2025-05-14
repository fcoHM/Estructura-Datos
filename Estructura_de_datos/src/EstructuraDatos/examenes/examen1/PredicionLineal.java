package EstructuraDatos.examenes.examen1;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ArregloNumerico;

import entradaSalida.Salida;

import static entradaSalida.ArchivoTextoD.leer;

public class PredicionLineal {
    protected ArregloNumerico x; // numenro de habitacionees
    protected ArregloNumerico y; // costo de las casas
    protected String rutaX; //ruta del archivo x
    protected String rutaY;// tuta del archivo y
    //para operaciones mat
    protected final double alpha = 0.009;
    protected int iteraciones = 100000;
    protected double p = 0;
    protected double b = 0;


    //contructor 
    public PredicionLineal(String rX, String rY){
        this.rutaX = rX;
        this.rutaY = rY;

    }

    // leer dos archivos txt y pasarlos a una rareglo para despues a ListaDin
    public boolean leerDatos(){
        //leer los archivos desde  un txt
        Arreglo arrex = leer(rutaX);
        Arreglo arrey = leer(rutaY);
        int elementos = 0;
        //verificar que tengan el mismo tamaño
        if((arrex.cantidad() == arrey.cantidad())==true){
            elementos = arrex.cantidad(); // y y x tienen la misma cantidad de elementos
            Salida.salidaPorDefecto(elementos +" elementos\n");
        }else{
            Salida.salidaPorDefecto("no misma cantidad\n");
            return false;
        }
        //iniciar los arreglos 
        this.x = new ArregloNumerico(elementos);
        this.y = new ArregloNumerico(elementos);

        this.x = this.x.convertirAArregloNumerico(arrex); //leer archivo de x
        this.y = this.y.convertirAArregloNumerico(arrey);// leer archivo de y 

        if(this.x == null || this.y == null){
            return false; //uno de los dos es nulo
        }else if((this.x.vacio() || this.y.vacio())==true){
            return false; // uno de los dos esta vacio
        }else{
            return true; // todo correcto
        }
    }


    //metodos funcionales 
    public ArregloNumerico calcularPredicciones(){ //calcular predicciones 
        ArregloNumerico arreTem = new ArregloNumerico(this.x.cantidad()); //para guardar las prediciones
        for(int elemento = 0; elemento<this.x.cantidad(); elemento++){
            double pred = p + b * (double) this.x.obtener(elemento);//calcula la prediccion 
            arreTem.poner(pred); //agrega la prediccion
        }
        return arreTem; //regresa el arreglo para ser
    }

    public double calcularFuncionCosto(ArregloNumerico predicciones){ //calacular el error entre predicciones y costo 
        ArregloNumerico diferencias = new ArregloNumerico(predicciones.cantidad());
        for(int elemento=0; elemento < predicciones.cantidad(); elemento++){
            double dif = (double)predicciones.obtener(elemento) - (double)this.y.obtener(elemento); //resta de valor de prediciion - y(costo de casa) 
            diferencias.poner(dif); //agregar a lista de diferencia para manipular con metodos existentes 
        }

        diferencias.aplicarPotencia(2);//elevar al cuadrado toda la lista de diferencias
        double sumatoria = diferencias.suma();//sumatoria de todos los elementos de diferencias
        return sumatoria / (2 * predicciones.cantidad());//sacar valor final de la operacion (1/2m)

    }
    

    public double calcularDerivadaP(ArregloNumerico predicciones){ // derivada parcial para calcular P
        ArregloNumerico diferencia = new ArregloNumerico(predicciones.cantidad());
        for(int elemento = 0; elemento < predicciones.cantidad(); elemento++){
            double dif = (double) predicciones.obtener(elemento) - (double) this.y.obtener(elemento); //resta de valor de prediciion - y(costo de casa) 
            diferencia.poner(dif);// agregar a lista de direncia para manipular con metodos existentes
        }
        
        double sumatoria = diferencia.suma();//sumatoria de todos los elementos de diferencias
        return sumatoria/predicciones.cantidad(); //sacar valor final de la operacion (1/m)

    }

    public double calcularDerivadaB(ArregloNumerico predicciones){ // calculara derivada de b
        ArregloNumerico diferencia = new ArregloNumerico(predicciones.cantidad());
        for(int elemento = 0; elemento < predicciones.cantidad(); elemento++){
            double dif = (double)predicciones.obtener(elemento) - (double)this.y.obtener(elemento);
            dif = dif * (double) this.x.obtener(elemento);
            diferencia.poner(dif);
        }
        double sumatoria = diferencia.suma();
        return sumatoria/predicciones.cantidad();
    }

    public void iniciar(){ //inicia las ireaciones y proceso de la  carga de material de x y y 
        for(int iterador =0; iterador < this.getIteraciones(); iterador++){
            //calcular predicciones
            ArregloNumerico predicciones = calcularPredicciones();
            //calcular derivadas
            double dp = calcularDerivadaP(predicciones);
            double db = calcularDerivadaB(predicciones);
            //actualizar variables p y b
            this.setP(this.getP() - alpha*dp);
            this.setB(this.getB() -alpha*db);
        }
    }

    public double calcularPrediccion(double xNuevo){ //predecir un valor dado
        return p + b * xNuevo;
    }



    public void mostarEcuacionFinal(){ // mostar el resultado de la ecuacion y = p + b*x
        Salida.salidaPorDefecto("Ecuación final: y = " + this.getP() + " + " + this.getB() + "*x\n"); //muesta un texto y muestra el resultado de regrecion lineal
    }





    //poder cambiar las rutas de los archivos
    public String getRutaX() {
        return rutaX;
    }

    public void setRutaX(String rutaX) {
        this.rutaX = rutaX;
    }

    public String getRutaY() {
        return rutaY;
    }

    public void setRutaY(String rutaY) {
        this.rutaY = rutaY;
    }

    public int getIteraciones(){
        return iteraciones;
    }

    public void setIteraciones(int iteraciones){
        this.iteraciones = iteraciones;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }
    
} //end clase
