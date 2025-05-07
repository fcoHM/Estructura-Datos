package tools.EncriptarMensajes;


import EstructuraDatos.EDLineal.ColaFija;
import EstructuraDatos.EDLineal.pilas.PilaFija;


public class Encriptador {
    protected String mensaje;
    protected int cantidadAgrupacions;
    protected int cantidadParentesis;
    

    
    public Encriptador(String mensaje, int agrupaciones){
        this.mensaje = mensaje; //mensaje a encriptar
        this.cantidadAgrupacions = agrupaciones; //numero de agrupaciones que van a haber 
        this.cantidadParentesis = cantidadAgrupacions*2; //numero de parentesis que va a llevar la nueva cadena
    }

    public Encriptador(){
        this.cantidadParentesis=0;
        this.cantidadAgrupacions=0;
        this.mensaje ="";
    }

    public String encriptar(ColaFija posicionesParentesis, ColaFija tamanioAgrupaciones){
        String resultado = ""; // Resultado final
        PilaFija textoInvertido = new PilaFija(mensaje.length()); // Pila para invertir caracteres
        int posCaracter = 0; // Posición actual en la cadena

        //recorrer caracteres
        while(posCaracter<mensaje.length()){
            //validar que no este la posicion de parentesis  y ver si la posicion es de un parentesis -1 ya que el usuario va poner valores desde 1
            if (posicionesParentesis.vacia() != true && posCaracter ==(int) posicionesParentesis.verTope()-1){
                posicionesParentesis.quitar();//se quita el tope en la cola
                resultado = resultado+"(";

                //tamaño de la agrupacion 
                int tamanio = (int)tamanioAgrupaciones.quitar();
                //
                for(int carEncrip =0; carEncrip< tamanio && posCaracter < mensaje.length(); carEncrip++){
                    textoInvertido.poner(mensaje.charAt(posCaracter));//se agrega el caracter de la posicion original
                    posCaracter++; //el contador aumenta
                }

                //vaciar la pila en resultado
                while(textoInvertido.vacia() != true){
                    resultado = resultado + textoInvertido.quitar();
                }

                //se cierra el parentesis
                resultado =resultado + ")";

            }else{
                //si no es una posicion donde deba de ir un parentesis solo se agrega a la cadena
                resultado = resultado + mensaje.charAt(posCaracter);
                posCaracter++;
            }

        }
        return resultado;
    }



    public String desEncriptar(String mensajeEncriptado){
        String resultado =""; //cadena  resultado 
        PilaFija reInvertir = new PilaFija(mensajeEncriptado.length()); //cola donde metemos valores invertidos 

        int posCaracter=0;
        //obtener caracter a caracter
        while(posCaracter < mensajeEncriptado.length()){ 
            char caracter = mensajeEncriptado.charAt(posCaracter);
            if (caracter == '(') {// revisar si es inicio de una agrupacion
                
                posCaracter++; //si es todos los valores siguientes se mandan a una pila, hasta encontrar un cierre 
                while (posCaracter < mensajeEncriptado.length() && mensajeEncriptado.charAt(posCaracter) != ')') {
                    
                    reInvertir.poner(mensajeEncriptado.charAt(posCaracter)); //se agregan a pila
                    posCaracter++;
                }
    
                // se regresan los caracteres a la cadena  resultado despues de un cierre 
                while (!reInvertir.vacia()) {
                    resultado = resultado + reInvertir.quitar();
                }
    
                posCaracter++; 
            }else{
                //si no es un caracter entre parentesis solo se agrega a la cadena
                resultado = resultado + caracter;
                posCaracter++;
            }
        }
        return resultado;
    }



   

    //set y get 

    public String getMensaje() {
        return mensaje;
    }


    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


    public int getCantidadAgrupacions() {
        return cantidadAgrupacions;
    }


    public void setCantidadAgrupacions(int cantidadAgrupacions) {
        this.cantidadAgrupacions = cantidadAgrupacions;
    }


    public int getCantidadParentesis() {
        return cantidadParentesis;
    }


    public void setCantidadParentesis(int cantidadParentesis) {
        this.cantidadParentesis = cantidadParentesis*2;
    }




    

}//end clase
