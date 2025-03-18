package registros.Agricola;

import EstructuraDatos.EDLineal.Arreglo;
import entradaSalida.Salida;

public class EmpleadosGranja {
    public Arreglo empleados;

    public EmpleadosGranja(int tamanio){
        empleados = new Arreglo(tamanio);
    }


    //calcular el promedio anual de lo que recolecto un campesino
    public double calcularPromedioAnualCosechas(){
      return 0.0;

    }

    public double calcularPromedioPorAnio(Campesino campesino){
        //obten el arreglo de sus cosechas anueales 
        Arreglo arregloTem = campesino.getCosecha();
        Arreglo sublista = (Arreglo)arregloTem.obtener(0);
        
        return 0.0;
    }




    //añadir un nuevo campesino a la lista
    public boolean agregarCampesino(String nombre, String rancho){
        if(empleados.lleno()==true){
            return false;
        }else{
            Campesino nuevocaCampesino = new Campesino(5, nombre, rancho);
            empleados.poner(nuevocaCampesino);
            return true;
        }
    }

    public Arreglo getEmpleados(){
        return empleados;
    }
}
