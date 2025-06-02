package EstructuraDatos.TrabajoFinal.Registros;
//base de cualquier objeto
public abstract class ObjetoComparable<T> {
    public double parametro1;
    public double parametro2;
    public String nombre;
    
    public ObjetoComparable(double parametro1, double parametro2, String nombre){
        this.parametro1 = parametro1;
        this.parametro2 = parametro2;
        this.nombre = nombre;
    }

   
    public double getParametro1() {
        return parametro1;
    }

    public void setParametro1(double parametro1) {
        this.parametro1 = parametro1;
    }

    public double getParametro2() {
        return parametro2;
    }

    public void setParametro2(double parametro2) {
        this.parametro2 = parametro2;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
    
}
