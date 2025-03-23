package Media.archivos_audio;

import java.io.File;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ArregloNumerico;
import Media.archivos_audio.wavfile.WavFile;
import entradaSalida.ArchivoTextoD;
//import Media.archivos_audio.wavfile.WavFileException;
import entradaSalida.Salida;

public class AudioFileRecord {
    private long numFrames;  // Número de tramas
    private long sampleRate; // Frecuencia de muestreo
    private int numChannels; // Número de canales
    public double[] buffer; // Audio original
    public ArregloNumerico bufferNumerico; // Audio procesado en arreglo numerico
    private String archivo;   // Nombre del archivo
    private WavFile wavFileR; // Archivo leído
    private WavFile wavFileW; // Archivo a escribir
    private String nomArchivo; // Nombre del archivo
    private String nomRuta;    // Ruta del archivo
    private int validBits;     // Bits de discretización

    public AudioFileRecord(String archivo) {
        this.archivo = archivo;
        try {
            File file = new File(archivo);
            wavFileR = WavFile.openWavFile(file);
            nomArchivo = file.getName();
            nomRuta = file.getParent();
        } catch (Exception e) {
            System.err.println("Error al abrir el archivo: " + e.getMessage());
            e.printStackTrace();
        }
        numChannels = wavFileR.getNumChannels();
        numFrames = wavFileR.getNumFrames();
        sampleRate = wavFileR.getSampleRate();
        validBits = wavFileR.getValidBits();
    }

    public void leerAudio() {
        try {
            wavFileR.display();
            buffer = new double[(int) numFrames * numChannels];
            int framesRead = wavFileR.readFrames(buffer, (int) numFrames);

            // Crear una instancia de ArregloNumerico y cargar los datos
            bufferNumerico = new ArregloNumerico(buffer.length);
            bufferNumerico.cargarArreglo(buffer);
        
            if(bufferNumerico != null){ // revisar que el buffer tiviera un contenido
                Salida.salidaPorDefecto("se cargo el audio\n");
            }

            wavFileR.close();
        } catch (Exception e) {
            System.err.println("Error al leer el audio: " + e.getMessage());
            e.printStackTrace();
        }
    }





    public void EscribirAudio() {
        try {
            File file = new File(nomRuta + "/2_" + nomArchivo);
            wavFileW = WavFile.newWavFile(file, numChannels, numFrames, validBits, sampleRate);

            // Escribimos los frames o muestras totales desde bufferNumerico
            double[] datos = new double[bufferNumerico.cantidad()];
            for (int i = 0; i < bufferNumerico.cantidad(); i++) {
                datos[i] = (double) bufferNumerico.obtener(i);
            }
            wavFileW.writeFrames(bufferNumerico.leerArreglo(), (int) numFrames); // aqui en este metodo se espera que le mandemos algo tipo datos[]

            wavFileW.close();
        } catch (Exception e) {
            System.err.println("Error al escribir el audio: " + e.getMessage());
            e.printStackTrace();
        }
    }

    


    // ---------------metodos de manipulacion de audio --------------------------- 
    // se escoguio que esta clase tuviera estos metodos por principio informationExpert

    //metodo get para usar recuperar el BufferBumerico
    public ArregloNumerico getBuffNumerico(){
        return this.bufferNumerico;
    }
    

    //subir el volumen de un audio 
    public void subirVolumen(int intensidad){
        if(intensidad <=0){
            return;
        }else{
            for(int elementoArreglo=0;elementoArreglo<bufferNumerico.cantidad();elementoArreglo++){
                double  valor = (double)bufferNumerico.obtener(elementoArreglo); //obtenemos el valor del arreglo
                
                //multiplicamos el valor por la intencidad 
                valor = valor * intensidad; 
                //lo guardamos en el mismo arreglo numerico 
                bufferNumerico.modificar(elementoArreglo,valor);
                
            }
        }
    }
    
    // bajarle el volumen al audio 
    public void bajarVolumen(int intensidad){
        if(intensidad <=0){
            return;
        }else{
            for(int elementoArreglo=0;elementoArreglo<bufferNumerico.cantidad();elementoArreglo++){
                double  valor = (double)bufferNumerico.obtener(elementoArreglo); //obtenemos el valor del arreglo
                
                //dividimos el valor por la intencidad 
                valor = valor / intensidad; 
                //lo guardamos en el mismo arreglo numerico 
                bufferNumerico.modificar(elementoArreglo,valor);
                
            }
        }
    }


    // debe recrear el filtro del alvin y las ardillas aumentando la velocidad y promediando lo valores 
    public ArregloNumerico acelerarPista(int velocidad) {
        if (velocidad <= 1) {
            return null;
        }
    
        // Calcular el nuevo tamaño del arreglo
        int nuevoTamanio = bufferNumerico.cantidad() / velocidad;
       
    
        ArregloNumerico nuevoBuffer = new ArregloNumerico(nuevoTamanio);
    
        // Promediar las muestras consecutivas
        for (int elementoNArreglo = 0; elementoNArreglo < nuevoTamanio; elementoNArreglo++) {
            double suma = 0.0;
            for (int elemento = 0; elemento < velocidad; elemento++) {
                int indiceOriginal = elementoNArreglo * velocidad + elemento;
                if (indiceOriginal < bufferNumerico.cantidad()) {
                    suma += (double) bufferNumerico.obtener(indiceOriginal);
                }
            }
            double promedio = suma / velocidad;
            nuevoBuffer.poner(promedio);
        }
    
        // Actualizar el buffer y el número de frames
        this.bufferNumerico = nuevoBuffer;
        this.numFrames = nuevoBuffer.cantidad()/numChannels;
    
        return nuevoBuffer;
    }







    //creau un efecto fantamagorico con la alargacion de los audios y relentisacion 
    public ArregloNumerico retrasarPista(int desAceleracion) {
        if (desAceleracion <= 1) {
            return null;
        }
    
        // Calcular el nuevo tamaño del arreglo
        int nuevoTamanio = bufferNumerico.cantidad() * desAceleracion- (desAceleracion - 1);
        ArregloNumerico nuevoBuffer = new ArregloNumerico(nuevoTamanio);
    
        // Insertar las muestras originales y las muestras inventadas
        for (int elementoArreglo= 0; elementoArreglo < bufferNumerico.cantidad(); elementoArreglo++) {
            // Insertar la muestra original
            nuevoBuffer.poner(bufferNumerico.obtener(elementoArreglo));
    
            // Insertar muestras inventadas (relleno) entre las originales
            if (elementoArreglo<bufferNumerico.cantidad() - 1) {
                double muestraActual = (double) bufferNumerico.obtener(elementoArreglo);
                double muestraSiguiente = (double) bufferNumerico.obtener(elementoArreglo+ 1);
    
                for (int elemento = 1; elemento < desAceleracion; elemento++) {
                    double muestraInventada = muestraActual + (muestraSiguiente - muestraActual) * elemento / desAceleracion;
                    nuevoBuffer.poner(muestraInventada);
                }
            }
        }
    
        // Actualizar el buffer y el número de frames
        this.bufferNumerico = nuevoBuffer;
        this.numFrames = nuevoBuffer.cantidad() / numChannels;
    
        return nuevoBuffer;
    }


    //elimina los silencios del audio 
    public ArregloNumerico eliminarSilencio(){
        //saber cuantos ceros hay 
        Arreglo arregloAuxiliar = bufferNumerico.buscarValores(0.0);
        // al tamaño del bufFerNumerico le restamos  la cantidad de ceros encontrados
        int tamaño = bufferNumerico.cantidad() - arregloAuxiliar.cantidad();
        //creamos un arregloNumerico que sera lo que regrese los valores distentos a cero
        ArregloNumerico arregloTemporal = new ArregloNumerico(tamaño);
        for(int elementoArreglo =0;elementoArreglo< bufferNumerico.cantidad(); elementoArreglo++){
            double valor = (double) bufferNumerico.obtener(elementoArreglo);
            if (valor != 0.0){
                arregloTemporal.poner(valor);
            }
        }
        return arregloTemporal;
    }

    //hace que se escuche al reves un audio
    public void invertirEjeX(){
        bufferNumerico.invertir();
    }

    //invierte las fracuencias de la hoda en el eje y
    public void invertirEjeY(){
        for(int elementoArreglo=0; elementoArreglo<bufferNumerico.cantidad(); elementoArreglo++){
            double valor = (double)bufferNumerico.obtener(elementoArreglo); 
            bufferNumerico.modificar(elementoArreglo, -1*(valor)); //se modifica sobre el mismo arreglo multiplicando *-1
        } 
    }


    //analiza el objeto y trata de buscar 
    public double obtenerSenialVocal(){
        bufferNumerico.aplicarPotencia(2);
        return bufferNumerico.suma();
    }


}