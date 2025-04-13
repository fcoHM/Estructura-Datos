package registros.Aeropuerto;

// Cambiar el import para que coincida con la ubicación real de ColaPrioridad
import EstructuraDatos.EDLineal.colaPrioridad.ColaPrioridad;
import EstructuraDatos.EDLineal.colaPrioridad.ObjetosComplejos;
import entradaSalida.Entrada;
import entradaSalida.Salida;
import EstructuraDatos.EDLineal.Arreglo;

public class GestorAeropuerto {
    
    protected ColaPrioridad pista1;
    protected ColaPrioridad pista2;
    protected ColaPrioridad pista3;
    protected Arreglo aviones;

    public GestorAeropuerto(int capacidadPista, int cantidadAviones){
        pista1 = new ColaPrioridad(capacidadPista);
        pista2 = new ColaPrioridad(capacidadPista);
        pista3 = new ColaPrioridad(capacidadPista);
        aviones = new Arreglo(cantidadAviones);
    }


    //agregar un elemento en una cola de prioridad
    public boolean agregarAvionPista(int pista, Object objet, int prioridad) {
        ObjetosComplejos objeto = new ObjetosComplejos(objet, prioridad); //objet debe ser el avion 
        switch (pista) { //saber en que pista se va a agregar
            case 1:
                return pista1.poner(objeto); 
            case 2:
                return pista2.poner(objeto);
            case 3:
                return pista3.poner(objeto);
            default:
                return false; 
        }
    }

    //sacar un avion de una cola de prioridad
    public Object despejarAvionPista(int pista){
        switch (pista) {
            case 1:
                return pista1.quitar();
            case 2:
                return pista2.quitar();
            case 3:
                return pista3.quitar();
            default:
                return null;
        }
    }



    public Object obtenerAvion(int avion){
        return aviones.obtener(avion-1);
    }

    //mostar aviones por medelos
    public void verAviones() {
        for (int avionPos= 0; avionPos< aviones.cantidad(); avionPos++) { // Iterar sobre todos los aviones
            Avion avion = (Avion) aviones.obtener(avionPos); // Obtener cada avión
            if (avion != null) {
                Salida.salidaPorDefecto("Avión " + (avionPos + 1) + ": Modelo  " + avion.getModelo() + "\n");
            }
        }
    }


    public int agregarNuevoAvion(Avion avion){
        return aviones.poner(avion);
    }

    
    public boolean menuOpciones() {
        boolean continuar = true;
        while (continuar) { 
            Salida.salidaPorDefecto("¿Qué deseas hacer?\n" +
                "1) Agregar nuevo avión\n" +
                "2) Agregar avión a pista\n" +
                "3) Dar salida a avión\n" +
                "4) Salir\n");
            int seleccion = Entrada.terminalDouble().intValue();
            switch (seleccion) {
                case 1:
                    Salida.salidaPorDefecto("Modelo: ");
                    String modelo = Entrada.terminalCadenas();

                    Salida.salidaPorDefecto("Capacidad: ");
                    int capacidad = Entrada.terminalDouble().intValue();

                    Salida.salidaPorDefecto("Aerolínea: ");
                    String aerolinea = Entrada.terminalCadenas();

                    Avion avion = new Avion(modelo, capacidad, aerolinea);
                    if (this.agregarNuevoAvion(avion)!=-1){
                        Salida.salidaPorDefecto("Se pudo agregar el avión\n");

                    }else{
                        Salida.salidaPorDefecto("No se pudo agregar el avión\n");
                    }

                    break;

                case 2:
                    Salida.salidaPorDefecto("escoja el avión:\n");
                    this.verAviones();
                    int sele = Entrada.terminalDouble().intValue();
                    Avion avionTem = (Avion) this.obtenerAvion(sele);
                    if (avionTem != null) {
                        Salida.salidaPorDefecto("Qué prioridad tiene? ");
                        int prioridad = Entrada.terminalDouble().intValue();

                        Salida.salidaPorDefecto("en qué pista debe ir? (solo hay 3) ");
                        int pista = Entrada.terminalDouble().intValue();

                        if (this.agregarAvionPista(pista, avionTem, prioridad)) {
                            Salida.salidaPorDefecto("Se pudo agregar el avión a la pista\n");
                        } else {
                            Salida.salidaPorDefecto("No se pudo agregar el avión a la pista Verifique la pista o la capacidad.\n");
                        }
                    } else {
                        Salida.salidaPorDefecto("El avión selwccionado no es válido\n");
                    }
                    break;

                case 3:
                    Salida.salidaPorDefecto("De qué pista quiere dar salida? ");
                    int se = Entrada.terminalDouble().intValue();
                    ObjetosComplejos avionTempComplejo = (ObjetosComplejos) despejarAvionPista(se);
                    if (avionTempComplejo != null) {
                        Avion avionTemp = (Avion) avionTempComplejo.getObjeto(); // obtener avion 
                        Salida.salidaPorDefecto("Se le dio salida al avión: " + avionTemp.getModelo() + " en la pista: " + se + "\n");
                    } else {
                        Salida.salidaPorDefecto("No hay aviones en la pista seleccionada\n");
                    }
                    break;

                case 4:
                    continuar = false; //salir del programa
                    break;

                default:
                    Salida.salidaPorDefecto("Opción no válida, Intente de nuevo\n");
                    break;
            }
        }
        return true; 
    }

}

