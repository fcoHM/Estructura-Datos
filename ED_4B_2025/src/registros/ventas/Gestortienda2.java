package registros.ventas;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ListaDin;
import entradaSalida.Salida;

public class Gestortienda2 {
    protected String nombre;
    protected ListaDin notasVenta;
    protected ListaDin vendedores;
    
    public Gestortienda2(String nombre){
        this.nombre = nombre;
        notasVenta = new ListaDin();
        vendedores = new ListaDin();
    }

    public boolean agregarvendedor(String nombre, String rfc, int numeroVendedor, String fechaNacimiento){
        Vendedor vendedorTem = new Vendedor(nombre, rfc, numeroVendedor, fechaNacimiento);
        int retorno = vendedores.poner(vendedorTem);
        if (retorno<0){
            return false;
        }else{
            return true;
        }
    }

    public boolean agregarNota(Cliente cliente, String fecha, int cantidadArticulosVendidos){
        //tenemos cliente y fecha voy a obtener de manera interna el folio y el vendedor 
        Vendedor vendedorTem = (Vendedor)vendedores.verInicio();
        
        int folioTem =0;

        if(vendedorTem==null){ // no hay notas
            return false;
        }

        NotaVenta notaTem = (NotaVenta)notasVenta.verFinal(); // se obtiene la nota
       
        if (notaTem == null){// no hay notas
            folioTem =1;
        }else{
            
            //obtener la nota de arriba

            folioTem = notaTem.getFolio()+1;
        } 

        NotaVenta2 notaNueva = new NotaVenta2(cliente, vendedorTem, fecha, folioTem);
        int retorno = notasVenta.poner(notaNueva);
        if(retorno<0){
            return false;
        }else{

            return true;
        }
    }
    public boolean agregarArticuloNota(int folio, Articulo artComprado, int cant){
        // encontrar la nota que tenga el folio proporcionado 
        NotaVenta2 notaTem = (NotaVenta2)notasVenta.buscarObjeto(folio); // esa nota no ta

        if (notaTem == null){
            return false;
        }else{// si ta la nota
            //extraer la nota que ya se hizo
            //usamos metodo de agregra articulo 
            return notaTem.agregarArticulo(artComprado, cant);   
        }
    }


    public void imprimirNota(int folio){
        // Primero encontrar la nota
        NotaVenta2 notaTem = (NotaVenta2) notasVenta.buscarObjeto(folio);

        if (notaTem != null){ // Puedo impirmirla porque existe
            // Obtenela
            // Imprimirla
            notaTem.imprimirNota();
        } else {
            return;
        }
    }
}
