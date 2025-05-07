package EstructuraDatos.EDLineal.colaPrioridad;

import EstructuraDatos.EDLineal.pilas.LoteDatos;
import entradaSalida.Salida;

public class ColaPrioridad implements LoteDatos{
    protected Object datos[]; //aqui se alamacena los elementos
    protected int tamanio; //tamaño del arreglo
    protected int indiceSuperior; //saber en que parte se quedo del arreglo 



    public ColaPrioridad(int tamanio){
        datos = new ObjetosComplejos[tamanio];
        this.indiceSuperior = -1;
        this.tamanio = tamanio;
    }


    @Override // saber si esta vacia la cola
    public boolean vacia() {
        if (indiceSuperior ==-1){
            return true; //si esta vacia
        }else{
            return false;
        }
    }


    @Override // saber si ya llego a su limite
    public boolean lleno() {
        if(indiceSuperior == tamanio-1){
            return true; //si esta llena
        }else{
            return false;
        }
    }


    @Override //agregar un valor a la cola
    public boolean poner(Object valor) {
        if (lleno() == false){
            this.indiceSuperior ++;
            datos[this.indiceSuperior] = valor;
            return true;
        }
        else{
            return false;
        }
    }


    @Override //eliminar un objeto segun su prioridad 
    public Object quitar() {
        int prioridad = mayorPrioridad(); // buscar la prioridad mas alta 
        if (vacia()==false) {
            for (int posObjeto = 0; posObjeto <= indiceSuperior; posObjeto++) {
                ObjetosComplejos elemento = (ObjetosComplejos) datos[posObjeto];
                int prioridadObjeto = elemento.getPrioridad(); // elemento respaldado 

                if (prioridad == prioridadObjeto) { // saber si es el que se va a quitar
                    // se quita el elemento y se recorren los espacios 
                    for (int modificacion = posObjeto; modificacion <= indiceSuperior - 1; modificacion++) {
                        datos[modificacion] = datos[modificacion + 1];
                    }
                    indiceSuperior--;
                    return elemento;
                }
            }
        }
        return null; 
    }


    //encontrar le prioridad mas alta 
    private int mayorPrioridad(){
        //recorrer elementos
        int mayor =0;
        if(vacia() == false){
            for(int posObjeto=0; posObjeto<= indiceSuperior; posObjeto++){
                ObjetosComplejos elemento =(ObjetosComplejos) datos[posObjeto]; //obtener valor 
                int prioridadObjeto = elemento.getPrioridad();

                if (mayor < prioridadObjeto) {
                    mayor = prioridadObjeto;
                }
            }
            return mayor;
        }else{
            return 0;
        }
    }


    @Override // imprime objeto por objeto que compone a la cola por prioridad
    public void imprimir() {
        for(int posObjeto=0; posObjeto<=indiceSuperior; posObjeto++){
            ObjetosComplejos elemento = (ObjetosComplejos)datos[posObjeto];
            Object obj = elemento.getObjeto();
            int prioridad = elemento.getPrioridad();
            Salida.salidaPorDefecto("dato: " + obj + ", prioridad: " + prioridad + "\n");
        }
    }


    @Override
    public Object verTope() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'verTope'");
    }
}
