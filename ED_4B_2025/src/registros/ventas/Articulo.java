package registros.ventas;

public class Articulo {
    protected String clave;
    protected String descripcion;
    protected double precioUnitario;

    public Articulo(String clave, String descripcion, double precioUnitario){
        this.clave = clave;
        this.descripcion = descripcion;
        this.precioUnitario = precioUnitario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    
    @Override //siempre immportante, solo debe tener un valor unico irrepetible
    public String toString(){
        return clave;
    }
    
}
