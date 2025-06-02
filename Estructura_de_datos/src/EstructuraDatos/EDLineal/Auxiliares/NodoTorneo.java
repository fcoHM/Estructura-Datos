package EstructuraDatos.EDLineal.Auxiliares;

public class NodoTorneo {
    
    public int valor;
    public int indiceOriginal;

    public NodoTorneo(int valor, int indiceOriginal) {
            this.valor = valor;
        this.indiceOriginal = indiceOriginal;
    }

    @Override
     public String toString() {
        return String.valueOf(valor);
    }

}
