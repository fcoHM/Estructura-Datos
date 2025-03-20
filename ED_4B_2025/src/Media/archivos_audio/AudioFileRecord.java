package Media.archivos_audio;

import java.io.File;
import EstructuraDatos.EDLineal.ArregloNumerico;
import Media.archivos_audio.wavfile.WavFile;
import Media.archivos_audio.wavfile.WavFileException;
import entradaSalida.Salida;

public class AudioFileRecord {
    private long numFrames;  // Número de tramas
    private long sampleRate; // Frecuencia de muestreo
    private int numChannels; // Número de canales
    private double[] buffer; // Audio original
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
                Salida.salidaPorDefecto("se cargo el audio");
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
            wavFileW.writeFrames(datos, (int) numFrames);

            wavFileW.close();
        } catch (Exception e) {
            System.err.println("Error al escribir el audio: " + e.getMessage());
            e.printStackTrace();
        }
    }
}