package registros.Carrera;

public class Evento {
    protected String nombre;
    protected String lugar;
    protected int anioFundacion;

    public Evento(String nombre, String lugar, int anioFundacion){
        this.nombre=nombre;
        this.lugar=lugar;
        this.anioFundacion=anioFundacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public int getAnioFundacion() {
        return anioFundacion;
    }

    public void setAnioFundacion(int anioFundacion) {
        this.anioFundacion = anioFundacion;
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
