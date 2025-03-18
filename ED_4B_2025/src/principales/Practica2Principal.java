package principales;

import registros.Agricola.Campesino;
import registros.Agricola.EmpleadosGranja;

public class Practica2Principal {
    public static void main(String[] args) {
        EmpleadosGranja rancho;

        rancho = new EmpleadosGranja(4);
        rancho.agregarCampesino("juan", "El naranjo");
        rancho.agregarCampesino("pablo", "El naranjo");
      
    }
}
