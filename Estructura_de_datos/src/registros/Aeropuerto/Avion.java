package registros.Aeropuerto;

public class Avion {
    protected String modelo;
    protected int capacidad;
    protected String aerolinea;

    
    public Avion(String modelo, int capacidad, String aerolinea) {
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.aerolinea = aerolinea;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    public String getAerolinea() {
        return aerolinea;
    }
    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }
    
}
