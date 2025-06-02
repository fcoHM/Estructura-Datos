package EstructuraDatos.TrabajoFinal;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDnoLineales.Arreglo2D;
import EstructuraDatos.TrabajoFinal.Axiliares.MetodosOrdenamientoObjetosDistancia;
import EstructuraDatos.TrabajoFinal.Registros.DistanciaObjeto;
import EstructuraDatos.TrabajoFinal.Registros.ObjetoComparable;

public abstract class ClasificadorKNN<T extends ObjetoComparable> { //indicasion que va ocupar objeto de el tipo de una familia
    //protected Arreglo valores;
    
    public ClasificadorKNN(){
        //this.valores =  valores;
        
    }


    // calculo de las distancias euclidianas
    protected Arreglo calcularDistancias(Arreglo objetos, T objeto1){
        Arreglo distancias = new Arreglo(objetos.cantidad()); // arreglo salida  con la cantidad de elementos
        for( int posObj = 0; posObj < objetos.cantidad(); posObj++){ //recorrer elementos 
            T objeto2 = (T) objetos.obtener(posObj); //recupara un objeto t y lo hace funcional
            double distancia = Math.sqrt(Math.pow(objeto1.getParametro1() - objeto2.getParametro1(), 2) +
                         Math.pow(objeto1.getParametro2() - objeto2.getParametro2(), 2));// se calcula la distacia euclidina del primer objto a cualquier otro
            distancias.poner(new DistanciaObjeto(objeto2, distancia)); // se agrega en un objeto complejo y se guarda
        }
        return distancias; // se regresa la lista de los objetos y su distancia 
    }
    
    // encontra los k vecinos (este no importa el tipo)
    protected Arreglo obtenerKVecinos(Arreglo distanciasOrdenadas, int k) {
        Arreglo vecinos = new Arreglo(k);
        for (int posDis = 0; posDis < k && posDis < distanciasOrdenadas.cantidad(); posDis++) { //itera sobre la lista hasta k pripuesto
            DistanciaObjeto vecino = (DistanciaObjeto) distanciasOrdenadas.obtener(posDis);
            vecinos.poner(vecino.getObjeto());
        }
        return vecinos;
    }
    
    
    protected String votarClase(Arreglo vecinos) {
        int cantidadVecinos = vecinos.cantidad();
        Arreglo2D matrizVotos = new Arreglo2D(cantidadVecinos, 2); // [clase, conteo]
        int totalClasesRegistradas = 0;

        for (int indiceVecino = 0; indiceVecino < cantidadVecinos; indiceVecino++) {
            ObjetoComparable vecinoActual = (ObjetoComparable) vecinos.obtener(indiceVecino);
            String claseVecino = vecinoActual.getNombre(); 
            boolean claseYaRegistrada = false;

            // Buscar si la clase ya está registrada
            for (int indiceClase = 0; indiceClase < totalClasesRegistradas; indiceClase++) {
                if (claseVecino.equals(matrizVotos.obtener(indiceClase, 0))) {
                    int conteoActual = (int) matrizVotos.obtener(indiceClase, 1);
                    matrizVotos.cambiar(indiceClase, 1, conteoActual + 1);
                    claseYaRegistrada = true;
                    break;
                }
            }
            // Si no está registrada, agregarla
            if (!claseYaRegistrada) {
                matrizVotos.cambiar(totalClasesRegistradas, 0, claseVecino);
                matrizVotos.cambiar(totalClasesRegistradas, 1, 1);
                totalClasesRegistradas++;
            }
        }

        // Buscar la clase con más votos
        String claseConMasVotos = null;
        int maximoVotos = 0;
        for (int indiceClase = 0; indiceClase < totalClasesRegistradas; indiceClase++) {
            int conteo = (int) matrizVotos.obtener(indiceClase, 1);
            if (conteo > maximoVotos) {
                maximoVotos = conteo;
                claseConMasVotos = (String) matrizVotos.obtener(indiceClase, 0);
            }
        }
        return claseConMasVotos;
    }


    public String clasificar(Arreglo datos, T objeto){
        Arreglo distancias = calcularDistancias(datos, objeto);
        Arreglo distanciasOrdenadas = MetodosOrdenamientoObjetosDistancia.bubbleSort(distancias);
        Arreglo vecinos = obtenerKVecinos(distanciasOrdenadas, 3);
        
        return votarClase(vecinos);
    }
}
