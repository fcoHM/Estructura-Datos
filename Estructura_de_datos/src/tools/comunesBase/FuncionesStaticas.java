package tools.comunesBase;

import EstructuraDatos.EDLineal.Arreglo;

public class FuncionesStaticas {
    
    //saber si es bolean
    public static boolean esBinario(String bin, int pos, int limite){
        
        if(pos>=limite){ //si es mayor la funcion acaba aqui (caso base)
            return true;
        }
        char valor = bin.charAt(pos);
        if(valor != '0' && valor != '1'){ // si no cumple con que sea solo 1 o 0 regresa false
            return false;
        }else{// al cumplir esto se manda a llamar la funcion de nuevo con una pos por delante
            pos++;
            return esBinario(bin, pos, limite);// se regresa lo que la funcion dice(true en caso de recorrer todos los datos, false si un dato no es binario)
        }
    }

    //convertir decimal a hexadecimal
    public static  String  convertiDecAHex(int decimal){
        String valoresHex = "0123456789ABCDEF"; //valores de hexadecimal
        if(decimal > 15){ //mientras el valor decimal se mayor
            int mod = decimal%16; //se le saca el mod que es el indice del valor que buscamos
            return convertiDecAHex(decimal/16) + valoresHex.charAt(mod); //cadena resultado: desconocido + valorConocido
        }else{
            return ""+valoresHex.charAt(decimal); //el valor ya esta dentro del rango de 0 16
        }
    }

    //convertir a binario
    public static String convertirDecBin(int decimal){
        if(decimal == 0){ 
          return ""+0; //en caso de ser 0 regresa 0 evita recursion infinita
        }
        if(decimal == 1){//revisa cuando el valor decimal no haya llegado a 1
            return ""+1; // cuando ya se llego al fin de la operacion 
        }
        //no se a llegado a 1 el decimal
        return convertirDecBin(decimal/2) + decimal%2; //valor desconodido(valor en bin) + mas valor conocido(bin sacado en este llamdo)
    }

}

