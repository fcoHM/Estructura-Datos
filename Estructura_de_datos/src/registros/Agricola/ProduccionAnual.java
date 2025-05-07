package registros.Agricola;

import EstructuraDatos.EDLineal.Arreglo;

public class ProduccionAnual {
    protected Arreglo prodruccionAnual; //aqui se van a guardar 12 objetos tipo cosecha
    protected String anio;

    public ProduccionAnual(String anio){
        prodruccionAnual = new Arreglo(11); // este mide 12 por que es la cantiodad de meses que tiene un año
        this.anio = anio; // nombre del año con el cual lo identificamos
    }

    //setter y getters
    public Arreglo getProdruccionAnual() {
        return prodruccionAnual;
    }
    public void setProdruccionAnual(Arreglo prodruccionAnual) {
        this.prodruccionAnual = prodruccionAnual;
    }
    public String getAnio() {
        return anio;
    }
    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    @Override
    public String toString(){
        return anio;
    }
}
