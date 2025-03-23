package principales;


import EstructuraDatos.EDLineal.Arreglo;
import Media.archivos_audio.AudioFileRecord;
import entradaSalida.ArchivoTextoD;
import entradaSalida.Salida;


public class Practica5Principal {
    public static void main(String[] pruebaLecturaAudio) {
        AudioFileRecord manejadorAudio = new AudioFileRecord("C:/Users/Josef/OneDrive/Documentos/Mis_docs/4toSemestre/Estructura-Datos/ED_4B_2025/src/Media/grabaciones/u.wav");
       //leer el audio dado
        manejadorAudio.leerAudio();
        //analizar la señal
        double valor= manejadorAudio.obtenerSenialVocal();
        Salida.salidaPorDefecto(valor+"");
        
    }
}
