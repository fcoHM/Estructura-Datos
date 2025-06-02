package EstructuraDatos.TrabajoFinal.Registros;

public class DistanciaObjeto {
    protected Object objeto;
    protected double distancia;
    

    public DistanciaObjeto(Object objeto, double distancia) {
        this.objeto = objeto; //objeto T  de familia ObjetoComparable
        this.distancia = distancia;
    }
    //set y get
    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    @Override  // para poder usar el metodo tournament sort
    public String toString(){
        return distancia+"";
    }
   
}