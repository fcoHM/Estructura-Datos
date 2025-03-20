package principales;

import Media.archivos_audio.AudioFileRecord;

public class Practica5Principal {
    public static void main(String[] pruebaLecturaAudio) {
        AudioFileRecord manejadorAudio = new AudioFileRecord("C:/Users/Josef/OneDrive/Documentos/Mis_docs/4toSemestre/Estructura-Datos/ED_4B_2025/src/Media/grabaciones/archivo.wav");
        manejadorAudio.leerAudio();
        
    }
}
