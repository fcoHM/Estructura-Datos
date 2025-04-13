package registros.ventas;

public class Vendedor {
    public String nombre;
    protected String rfc;
    protected int numeroVendedor;
    protected String fechaNacimiento;

    public Vendedor(String nombre, String rfc, int numeroVendedor, String fechaNacimiento){
        this.nombre = nombre;
        this.rfc = rfc;
        this.numeroVendedor = numeroVendedor;
        this.fechaNacimiento =fechaNacimiento;
    }
 
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getNumeroVendedor() {
        return numeroVendedor;
    }

    public void setNumeroVendedor(int numeroVendedor) {
        this.numeroVendedor = numeroVendedor;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    @Override
    public String toString(){
        return numeroVendedor + "";
    }
}
