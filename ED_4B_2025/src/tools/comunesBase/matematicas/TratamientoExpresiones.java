package tools.comunesBase.matematicas;

import EstructuraDatos.EDLineal.pilas.PilaFija;

public class TratamientoExpresiones {
    
    // convertir  una expresion infija a postfija
    public static String convertirInfijaPostfija(String infija){
        return "";
    }
    // dconvertir una expresion infija en prefija
    // evaluar una expresion infija
    public Double evaluarInfija(String infija){
        String postFija = convertirInfijaPostfija(infija);
        return evaluarPosfija(postFija);
    }

    // evaluar una expresion postfija
    public static Double evaluarPosfija(String postfija){
        PilaFija pila = new PilaFija(postfija.length());
        for(int posToken = 0; posToken<postfija.length(); posToken++){
            // paso 1: tokenizar izq--->derecha
            char token = postfija.charAt(posToken);
            // paso 2: si es operando se mete en la pila
            if(isOperando(token+"")== true){
                if (pila.poner(token+"")==false){
                    return null;
                }
            }else{
                 // paso 3: ssi es operador se extraren dos operandos, el primer operando op2 se calcula la operacion con ese token y se mete el resultado en la pila
                // el resultado esta en la pila
                String op2 = (String) pila.quitar();
                String op1 = (String) pila.quitar();
                Double numero1 = Double.parseDouble(op2);
                Double numero2 = Double.parseDouble(op1);
                Double resultado = operacionAritmetica(token, numero1, numero2);
                if(resultado == null){
                    return null;
                }
                if (pila.poner(resultado+"")==false) {
                    return null;
                }
            }

        }
         String cadenaResultado = (String) pila.quitar();
         if (cadenaResultado == null){
            return null;
         }
        return Double.parseDouble(cadenaResultado);
    }


    
    //  evaliar una expresion  prefija
    public  static boolean isOperando(String token){
        if (token.equals("+")== true){
            return false;
        }else if(token.equals("/")==true){
            return false;
        }else if(token.equals("*")==true){
            return false;
        }else if(token.equals("^")==true){
            return false;
        }else if(token.equals("%")==true){
            return false;
        }else if(token.equals("(")==true){
            return false;
        }else if(token.equals(")")==true){
            return false;
        }else if(token.equals(")")==true){
            return false;
        }else{ // es operando
            return true;
        }
    }


    public static Double operacionAritmetica(char operador, Double op1, Double op2){
        if(operador=='+'){
            return op1+op2;
        }else if(operador == '-'){
            return op1-op2;
        }else if (operador == '/'){
            return op1/op2;
        }else if (operador == '*'){
            return op1*op2;
        }else if (operador == '^'){
            return Math.pow(op1, op2);
        }else if (operador == '%'){
            return op1%op2;
        }else{
            return null;
        }
    }

}
