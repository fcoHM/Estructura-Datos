package principales;

import EstructuraDatos.EDLineal.Arreglo;
//import entradaSalida.Salida;

public class Practica1Principal {
    public static void main(String[] args) {
        /* 
        Arreglo lista1 = new Arreglo(5);
        lista1.poner("hola");
        lista1.poner("estamos");
        lista1.poner("comparando");
        
        Arreglo lista2 = new Arreglo(6);
        lista2.poner("hola");
        lista2.poner("ests");
        lista2.poner("comparando");

        if(lista1.esIgual(lista2)==true){
            Salida.salidaPorDefecto("si son iguales");
        }else{
            Salida.salidaPorDefecto("son diferentes");
        }
        */

        
        Arreglo indices = new Arreglo(4);
        indices.poner(1);
        indices.poner(2);
        indices.poner(3);
        

        Arreglo valores= new Arreglo(5);
        valores.poner("juan");
        valores.poner("mencho");
        valores.poner("charly");
        valores.poner("chino");
       

        Arreglo lista = new Arreglo(9);
        lista.poner("ines");
        lista.poner("juana");
        lista.poner("mike");


        lista.rellenar("se relleno", 7);
        lista.imprimir();
        //lista.subLista(1, 3);

     
       lista.redimensionar(15);
        //lista.clonar();
        if(lista.substituir(valores)){
            lista.imprimir();
        }
       
        //valores.imprimir();
        //valores.invertir();
        //valores.imprimir();
        //lista.agregarLista(valores);
        //lista.modificarLista(indices, valores); //
        //lista.imprimir();
        //lista.borrarLista(valores);
       //valores.imprimir(valores.buscarValores("juan"));
       
       //valores.imprimir();
        //valores.vaciar();
        //valores.imprimir();
        //valores.poner("esta jalando");
        //valores.imprimir();
        //lista.imprimir();

       // valores.quitar(2);
       
        /* 
        //modificar con 3 parametros
        lista.modificar(10, 3, 2);
        lista.imprimir();
        
        //modificar con 2 parametros
        lista.modificar(3, 90);
        lista.imprimir();
        */
        
    }
}
