package registros.Agricola;

public class Cosecha {
    protected String productoCosechado; //nombre de lo que se esta cosechando 
    protected double pesoCosechado;

    public Cosecha(String productoCosechado, double pesoCosechado){
        this.productoCosechado = productoCosechado;
        this.pesoCosechado = pesoCosechado;
    }

    //setters y getters
    public String getProductoCosechado() {
        return productoCosechado;
    }
    public void setProductoCosechado(String productoCosechado) {
        this.productoCosechado = productoCosechado;
    }
    public double getPesoCosechado() {
        return pesoCosechado;
    }
    public void setPesoCosechado(double pesoCosechado) {
        this.pesoCosechado = pesoCosechado;
    }
    
}
