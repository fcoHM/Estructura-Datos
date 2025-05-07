package principales.Practica9;

import EstructuraDatos.EDLineal.ColaFija;
import entradaSalida.Entrada;
import entradaSalida.Salida;
import tools.EncriptarMensajes.Encriptador;


public class GestorEncriptador {
    private Encriptador cifrado;
    private ColaFija posParentesis;
    private ColaFija tamanioAgrupaciones;
   
    public GestorEncriptador(){ //iniciar el crifrador de mensajes
        cifrado = new Encriptador();
        
    }

    public void pedirMensaje(String mensaje){ //agregar un mensaje 
        cifrado.setMensaje(mensaje);
    }


    public void pedirCantidadAgrupaciones(int cantidad){ //decir cuantas agrupaciones tendra el mesnaje
        cifrado.setCantidadAgrupacions(cantidad);
        cifrado.setCantidadParentesis(cantidad);
        //iniciar colas
        posParentesis = new ColaFija(cantidad); 
        tamanioAgrupaciones = new ColaFija(cantidad); 
    }

    public String encriptarMensaje(){ //cifrar el mensaje 
        return cifrado.encriptar(posParentesis, tamanioAgrupaciones);
    }

    public void agregarPos(int posicion){ //agregar un posicion a la cola de posiciones
        posParentesis.poner(posicion);
    }
    public void agregarTamanioAgrupacion(int tamanio){ //agregar  un tamanio a la cola de tamnios
        tamanioAgrupaciones.poner(tamanio);
    }

    public String pedirMensajeEncriptado(String mensajeEncriptado){
        return cifrado.desEncriptar(mensajeEncriptado);
    }

}
