package registros.ventas;

public class Cliente {
    protected String nombre;
    protected String rfc;
    protected char  sexo;

    public Cliente(String rfc, String nombre, char sexo){
        this.rfc = rfc;
        this.nombre = nombre;
        this.sexo = sexo;
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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString(){
        return rfc;
    }
}
