package principales;

import entradaSalida.Salida;
import static tools.comunesBase.FuncionesStaticas.esBinario;
import static tools.comunesBase.FuncionesStaticas.convertiDecAHex;
import static tools.comunesBase.FuncionesStaticas.convertirDecBin;
public class PrincipalPractica14 {
    public static void main(String[] args) {
        String binario  = "101001";
        Salida.salidaPorDefecto(binario+"\n");
        if(esBinario(binario,0, binario.length())){
            Salida.salidaPorDefecto("si es binario\n");
        }else{
            Salida.salidaPorDefecto("No es binario\n");
        }


        String nobinario  = "123001";
        Salida.salidaPorDefecto(nobinario+"\n");
        if(esBinario(nobinario,0, nobinario.length())){
            Salida.salidaPorDefecto("si es binario\n");
        }else{
            Salida.salidaPorDefecto("No es binario\n");
        }


        Salida.salidaPorDefecto("valor hexadecimal de 65029:\n");
        Salida.salidaPorDefecto(convertiDecAHex(65029)+"\n");

        Salida.salidaPorDefecto("valor binario 150:\n");
        Salida.salidaPorDefecto(convertirDecBin(150)+"\n");

    }
}
