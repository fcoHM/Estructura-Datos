package registros.Carrera;

public class Corredor {
    protected int noCorredor;
    protected String nombre;
    protected int edad;
    protected char sexo;

    public Corredor(int noCorredor, String nombre, int edad,
                    char sexo){
        this.noCorredor=noCorredor;
        this.nombre=nombre;
        this.edad=edad;
        this.sexo=sexo;
    }

    public int getNoCorredor() {
        return noCorredor;
    }

    public void setNoCorredor(int noCorredor) {
        this.noCorredor = noCorredor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString(){
        return ""+noCorredor;
    }
}
