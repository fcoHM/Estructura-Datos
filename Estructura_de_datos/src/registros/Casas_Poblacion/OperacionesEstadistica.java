package registros.Casas_Poblacion;


import EstructuraDatos.EDLineal.ListaDin;

public class OperacionesEstadistica {

    //hacer la sumatoria de los elementos de una lista dinamica
    public static double sumatoria(ListaDin lista){
        lista.iniciarIterador();
        double suma = 0;
        while(lista.iteradorValido()==true){
            suma = suma + Double.parseDouble(lista.obtenerIterador().toString());
            lista.moverseIterador();
        }
        return suma;
    }

    //regresar una lista con valores exponenciados
    public static ListaDin exponente(ListaDin lista){
        if(lista.vacio()==true){
            return null;
        }else{
            ListaDin listaTem = new ListaDin();
            lista.iniciarIterador();
            while(lista.iteradorValido()==true){
                double valor = Double.parseDouble(lista.obtenerIterador().toString());
                listaTem.poner(valor*valor); //valor exponencido
                lista.moverseIterador();
            }
            return listaTem;
        }
    }

    //calcular primedio
    public static double promedio(ListaDin lista){
         if(lista.vacio()==true){
            return -1;
        }
        return sumatoria(lista)/lista.cantidad();
    }

    //multiplicar dos listas dinamicas

    public static ListaDin multiplicasionListas(ListaDin lista1, ListaDin lista2){
        if ((lista1.vacio() || lista2.vacio())==true){
            return null;
        }else{
            ListaDin listaTem = new ListaDin();
            lista1.iniciarIterador();
            lista2.iniciarIterador();
            while((lista1.iteradorValido()&& lista2.iteradorValido())==true){
                double valorA = Double.parseDouble(lista1.obtenerIterador().toString());
                double valorB = Double.parseDouble(lista2.obtenerIterador().toString());

                listaTem.poner(valorA*valorB);
                lista1.moverseIterador();
                lista2.moverseIterador();
            }
            return listaTem;
        }

    }

}
