package EstructuraDatos.TrabajoFinal;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.TrabajoFinal.Registros.Fruta;
import entradaSalida.Entrada;
import entradaSalida.Salida;

public class GestorClasificasionFrutas {
    public Arreglo frutas;
    public ClasificadorKNN clasificador;
    public GestorClasificasionFrutas(Arreglo frutas){
        this.frutas = new Arreglo(70); //tamaño fijo
        this.frutas.agregarLista(frutas); // se agregan los valores de la lista nueva
        clasificador = new ClasificadorFrutasKNN();
    }

    public void agregarFruta(){
        Salida.salidaPorDefecto("Cual es el peso:");
        double peso = Entrada.terminalDouble();
        Salida.salidaPorDefecto("Cual es el color: 0)verde  1)rojo  2)amarilla  3) morada\n");
        double color = Entrada.terminalDouble();
        Salida.salidaPorDefecto("Cual es el nombre de la fruta\n");
        String nombre = Entrada.terminalCadenas();
        Fruta nuevaFruta = new Fruta(peso, color, nombre);
        this.frutas.poner(nuevaFruta);
        Salida.salidaPorDefecto("se agrego la fruta!\n");
    }

    public void mostraFrutas(){
        for (int elemento = 0; elemento<frutas.cantidad(); elemento++){
            Fruta fruta = (Fruta)frutas.obtener(elemento);
            Salida.salidaPorDefecto(elemento+".- " + fruta.getNombre()+" peso: "+fruta.getParametro1()+" color: "+fruta.getParametro2()+"\n");
        }
    }
    public void eliminarFruta(){
        Salida.salidaPorDefecto("Ingrese la posicion de la fruta:\n");
        int posFruta = Entrada.terminalDouble().intValue();
        if (posFruta >= 0 && posFruta < this.frutas.cantidad()) {
            Fruta frutaEliminada = (Fruta)this.frutas.quitar(posFruta);
            Salida.salidaPorDefecto("Se elimino: " + frutaEliminada.getNombre()+ " en "+ posFruta +"\n");
        } else {
            Salida.salidaPorDefecto("Posición inválida. No se eliminó ninguna fruta.\n");
        }
    }

    public void clasificarFruta() {
        boolean repetir = true;
        while (repetir) {
            Salida.salidaPorDefecto("Cual es el peso:\n");
            double peso = Entrada.terminalDouble();
            Salida.salidaPorDefecto("Cual es el color: 0)verde  1)rojo  2)amarilla  3) morada\n");
            double color = Entrada.terminalDouble();
            Fruta frutaClas = new Fruta(peso, color, null);
            String nombre = clasificador.clasificar(this.frutas, frutaClas);
            Salida.salidaPorDefecto("es una: " + nombre + ". ¿Quieres agregar esta fruta?\n1)Sí 2)No\n");
            int seleccion = Entrada.terminalDouble().intValue();
            if (seleccion == 1) {
                Salida.salidaPorDefecto("¿Quieres usar el nombre sugerido (" + nombre + ") o escribir uno propio?\n1) Sugerido  2) Escribir propio\n");
                int opcionNombre = Entrada.terminalDouble().intValue();
                if (opcionNombre == 1) {
                    frutaClas.setNombre(nombre);
                } else {
                    Salida.salidaPorDefecto("Escribe el nombre de la fruta:\n");
                    frutaClas.setNombre(Entrada.terminalCadenas());
                }
                frutas.poner(frutaClas);
                Salida.salidaPorDefecto("¡Se agregó correctamente!\n");
                repetir = false;
            } else if (seleccion == 2) {
                Salida.salidaPorDefecto("No se añadió\n");
                repetir = false;
            } else {
                Salida.salidaPorDefecto("Opción no válida. Repite el proceso...\n");
            }
        }
    }

    public void menuOpciones(){
        boolean repetir = true;
        while (repetir) {
            Salida.salidaPorDefecto("Que desea hacer?\n 1) agregar fruta\n 2) eliminar fruta\n 3) clasificar fruta\n 4) mostrar frutas agregadas\n 5) salir \n");
            
            int seleccion = Entrada.terminalDouble().intValue();
            if (seleccion == 1) {
                Salida.salidaPorDefecto("Agrege la fruta de su preferencia\n");
                this.agregarFruta();
            } else if (seleccion == 2) {
                Salida.salidaPorDefecto("Elimine la fruta por su posicion: \n");
                this.mostraFrutas();
                this.eliminarFruta();
            }else if(seleccion == 3){
                Salida.salidaPorDefecto("Clasifique la fruta de su prefrenecia\n");
                clasificarFruta();
            }else if(seleccion == 4){
                Salida.salidaPorDefecto("Frutas guardadas:\n");
                this.mostraFrutas();
                
            }else if(seleccion == 5 ){
                Salida.salidaPorDefecto("Hasta luego...");
                repetir = false;
            } else {
                Salida.salidaPorDefecto("Opción no válida. Repite el proceso...\n");
            }
        }
    }

}
