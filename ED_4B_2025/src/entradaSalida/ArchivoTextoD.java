package entradaSalida;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import EstructuraDatos.EDLineal.Arreglo;

public class ArchivoTextoD {

    public static Arreglo leer(String archivo){
        FileReader input=null;
        int registro=0;
        Arreglo datos=null;
        BufferedReader buffer = null;

        try {
            String cadena=null;
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            datos=new Arreglo((int)buffer.lines().count());
            buffer.close();
            input.close();
            input = new FileReader(archivo);
            buffer = new BufferedReader(input);
            while((cadena = buffer.readLine())!=null) {
                datos.poner(cadena);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try{
                input.close();
                buffer.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        return datos;
    }
    public static void escribir(Arreglo arreglo, String archivo) {
        FileWriter output = null;
        try {
            output = new FileWriter(archivo);
            if (arreglo != null && arreglo.cantidad() > 0) { // Verificar que el arreglo no esté vacío
                for (int posicion = 0; posicion < 100; posicion++) {
                    Object dato = arreglo.obtener(posicion);
                    if (dato != null) { // Verificar que el dato no sea nulo
                        output.write(dato.toString() + "\n");
                    }
                }
            } else {
                System.err.println("El arreglo está vacío o es nulo.");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (output != null) {
                    output.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
