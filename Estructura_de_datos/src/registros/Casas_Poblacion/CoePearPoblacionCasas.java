package registros.Casas_Poblacion;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ListaDin;
import entradaSalida.Salida;

import static entradaSalida.ArchivoTextoD.*;

public class CoePearPoblacionCasas {
    protected ListaDin x; // numenro de habitacionees
    protected ListaDin y; // costo de las casas

    protected double mediaX; //media de x
    protected ListaDin Res_MedX;
    protected ListaDin ResMedXexp;

    protected double mediaY; // media de y
    protected ListaDin Res_MedY;
    protected ListaDin ResMedYexp;

    protected ListaDin multi;
    protected double SXY;
    

    public CoePearPoblacionCasas(){
        x = new ListaDin();
        y = new ListaDin();
    }

    // leer dos archivos txt y pasarlos a una rareglo para despues a ListaDin
    public boolean leerDatos(String rutaX, String rutaY){
        //leer los archivos desde  un txt
        Arreglo datosX = leer(rutaX);
        Arreglo datosY = leer(rutaY);

        if(datosX.vacio() || datosY.vacio() ){ //si x o y esta vacia
            return false; //si alguna de las dos esta vacia no hace nada 
        }

        //la misma variable se ocupa asi misma para rellenarse
        this.x = this.x.convertirAListaDin(datosX);
        this.y = this.y.convertirAListaDin(datosY);

        if (this.x.vacio() || this.y.vacio()) {
            return false; //si una de las dos listas esta vacia o es nula no hace nada 
        }

        return true;
    }

    

    public void medX(){
        mediaX = this.x.media();
    }
    public  void medY(){
        mediaY = this.y.media();
    }


    // el valor de cada pos - el valor de la media
    public void  resMediaValorX(){
        Res_MedX = this.x.valorMenosMedia();
    }
    public void resMediaValorY(){
        Res_MedY = this.y.valorMenosMedia();
    }

    

    // saplicar exp 2 a los obtneido

    public double expResMediaValoX(){
        ResMedXexp = Res_MedX.expoLista();
        
        return ResMedXexp.sumatoria();
    }

    public double expResMediaValoY(){
        ResMedYexp = Res_MedY.expoLista();
        
        return ResMedYexp.sumatoria();
    }

    // listas exponenciadas multiplicadas
    public double multiplicasionLista() {
        multi = this.Res_MedX.multiplicarPorLista(this.Res_MedY); // Usar las listas originales
        return multi.sumatoria();
    }


    public void iniciar(){
        resMediaValorX();
        resMediaValorY();
        expResMediaValoX();
        expResMediaValoY();
    }


    public double sxy() { // Covarianza
        return multiplicasionLista() / this.Res_MedX.cantidad(); // Usar Res_MedX para la cantidad
    }
    

    public double sx(){
        return Math.sqrt(ResMedXexp.sumatoria()/ResMedXexp.cantidad());
    }

    public double sy(){
        return Math.sqrt(ResMedYexp.sumatoria()/ResMedYexp.cantidad());
    }


    public double coeficientePearson(){
        return (this.sxy()/(this.sx()*this.sy()));
    }


}
