package registros.Agricola;

import EstructuraDatos.EDLineal.Arreglo;

public class Campesino {
    protected Arreglo registroProduccionesAnual; //se espera guardar arreglos tipo ProduccionAnual
    protected String nombre;
    protected String rancho;

    public Campesino(int tamanio, String nombre, String rancho){ //aqui si pide el temaño del arreglo por si quieren que haya mas años
        this.registroProduccionesAnual = new Arreglo(tamanio);
        this.nombre = nombre;
        this.rancho = rancho;
    }

    //setter y getters
    public Arreglo getCosecha() {
        return registroProduccionesAnual;
    }

    public void setCosecha(Arreglo produccionAnual) {
        this.registroProduccionesAnual = produccionAnual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRancho() {
        return rancho;
    }

    public void setRancho(String rancho) {
        this.rancho = rancho;
    }

    @Override
    public String toString(){
        return nombre;
    }
    
}
