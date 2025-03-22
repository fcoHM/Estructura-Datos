package principales;


import EstructuraDatos.EDLineal.Arreglo;
import Media.archivos_audio.AudioFileRecord;
import entradaSalida.ArchivoTextoD;


public class Practica5Principal {
    public static void main(String[] pruebaLecturaAudio) {
        AudioFileRecord manejadorAudio = new AudioFileRecord("C:/Users/Josef/OneDrive/Documentos/Mis_docs/4toSemestre/Estructura-Datos/ED_4B_2025/src/Media/grabaciones/prueba2.wav");
        
        
        manejadorAudio.leerAudio();
        Arreglo prueba = manejadorAudio.retrasarPista(2);
        //obtener original 
        // ArchivoTextoD.escribir(prueba, "C:/Users/Josef/OneDrive/Documentos/Mis_docs/4toSemestre/Estructura-Datos/ED_4B_2025/src/Media/AudioEscrito/original.txt");
        //manejadorAudio.subirVolumen(5);
        
        //manejadorAudio.bajarVolumen(5);

       

        // cescribir la prueba en txt
        ArchivoTextoD.escribir(prueba, "C:/Users/Josef/OneDrive/Documentos/Mis_docs/4toSemestre/Estructura-Datos/ED_4B_2025/src/Media/AudioEscrito/prueba.txt");
        manejadorAudio.EscribirAudio();
    }
}
