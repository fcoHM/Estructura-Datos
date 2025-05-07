package principales;

import entradaSalida.Salida;
import tools.comunesBase.matematicas.TratamientoExpresiones;

public class PrincipalExpresionesArit {
    public static void main(String[] args) {
        //
        Salida.salidaPorDefecto((""+TratamientoExpresiones.evaluarPosfija("2 3.3+")));
    }
}
