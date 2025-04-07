package principales.Practica9;

import EstructuraDatos.EDLineal.ColaFija;
import entradaSalida.Entrada;
import entradaSalida.Salida;

public class EncriptarMensajes {
    public static void main(String[] args) {
        /*  prueba programa encriptador
        Encriptador en = new Encriptador("Curso de informatica", 3);
        ColaFija posicionesParentesis = new ColaFija(3);
        posicionesParentesis.poner(4); // Posición del primer paréntesis
        posicionesParentesis.poner(11); // Posición del segundo paréntesis
        posicionesParentesis.poner(17); // Posición del tercer paréntesis

        ColaFija tamaniAgrupaciones = new ColaFija(3);
        tamaniAgrupaciones.poner(2); // Tamaño de la primera agrupación
        tamaniAgrupaciones.poner(4); // Tamaño de la segunda agrupación
        tamaniAgrupaciones.poner(3); // Tamaño de la tercera agrupación

        
        Salida.salidaPorDefecto(en.encriptar(posicionesParentesis, tamaniAgrupaciones));

        */
        

        /*  prueba de desEncriptar
        // Crear una instancia de Encriptador
        Encriptador encriptador = new Encriptador();

        // Pedir al usuario un mensaje encriptado
        Salida.salidaPorDefecto("Ingrese el mensaje encriptado que desea desencriptar:\n");
        String mensajeEncriptado = Entrada.terminalCadenas();

        // Desencriptar el mensaje
        String mensajeDesencriptado = encriptador.desEncriptar(mensajeEncriptado);

        // Mostrar el resultado
        Salida.salidaPorDefecto("Mensaje desencriptado: " + mensajeDesencriptado + "\n");


        */




        
        GestorEncriptador gestor = new GestorEncriptador();
        boolean continuar = true;

        while (continuar) {
            // Mostrar el menú de opciones
            Salida.salidaPorDefecto("Seleccione una opción:\n");
            Salida.salidaPorDefecto("1. Encriptar un mensaje\n");
            Salida.salidaPorDefecto("2. Desencriptar un mensaje\n");
            Salida.salidaPorDefecto("3. Salir\n");

            int opcion = Entrada.terminalDouble().intValue();

            switch (opcion) {
                case 1: // Encriptar un mensaje
                    // Pedir el mensaje
                    Salida.salidaPorDefecto("Ingrese el mensaje que desea encriptar:\n");
                    String mensaje = Entrada.terminalCadenas();
                    gestor.pedirMensaje(mensaje);

                    // Pedir la cantidad de agrupaciones
                    Salida.salidaPorDefecto("¿Cuántas agrupaciones tendrá el mensaje?\n");
                    int cantidadAgrupaciones = Entrada.terminalDouble().intValue();
                    gestor.pedirCantidadAgrupaciones(cantidadAgrupaciones);

                    // Pedir las posiciones de los paréntesis
                    for (int indicePos = 0; indicePos < cantidadAgrupaciones; indicePos++) {
                        Salida.salidaPorDefecto("Ingrese la posición del paréntesis de apertura para la agrupación " + (indicePos + 1) + ":\n");
                        int posicion = Entrada.terminalDouble().intValue();
                        gestor.agregarPos(posicion);
                    }

                    // Pedir los tamaños de las agrupaciones
                    for (int indiceTamanio = 0; indiceTamanio < cantidadAgrupaciones; indiceTamanio++) {
                        Salida.salidaPorDefecto("Ingrese el tamaño de la agrupación " + (indiceTamanio + 1) + ":\n");
                        int tamanio = Entrada.terminalDouble().intValue();
                        gestor.agregarTamanioAgrupacion(tamanio);
                    }

                    // Encriptar el mensaje
                    String mensajeEncriptado = gestor.encriptarMensaje();
                    Salida.salidaPorDefecto("Mensaje encriptado: " + mensajeEncriptado + "\n");
                    break;

                case 2: // Desencriptar un mensaje
                    // Pedir el mensaje encriptado
                    Salida.salidaPorDefecto("Ingrese el mensaje encriptado que desea desencriptar:\n");
                    String mensajeEncriptadoParaDesencriptar = Entrada.terminalCadenas();

                    // Desencriptar el mensaje
                    String mensajeDesencriptado = gestor.pedirMensajeEncriptado(mensajeEncriptadoParaDesencriptar);
                    Salida.salidaPorDefecto("Mensaje desencriptado: " + mensajeDesencriptado + "\n");
                    break;

                case 3: // Salir
                    continuar = false;
                    Salida.salidaPorDefecto("¡Gracias por usar el programa de encriptación!\n");
                    break;

                default:
                    Salida.salidaPorDefecto("Opción no válida. Intente de nuevo.\n");
                    break;
            }
        }


        
    }// end1 main
}//end class
