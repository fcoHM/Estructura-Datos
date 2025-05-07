package EstructuraDatos.EDLineal.colaPrioridad;

public class ObjetosComplejos  {
    protected Object objeto; // almacenar cualquier objeto
    protected int prioridad; // nivel de prioridad



    public ObjetosComplejos(Object objeto, int prioridad){
        this.objeto = objeto;
        this.prioridad = prioridad;
    }

    public ObjetosComplejos (){
        this.objeto = "no especificado";
        this.prioridad = 0;
    }

    public Object getObjeto() {
        return objeto;
    }
    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }
    public int getPrioridad() {
        return prioridad;
    }
    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    
}
