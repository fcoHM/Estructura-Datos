package registros.ventas;

import EstructuraDatos.EDLineal.Arreglo;
import entradaSalida.Salida;

public class Gestortienda {
    protected String nombre;
    protected Arreglo notasVenta;
    protected Arreglo vendedores;
    
    public Gestortienda(int cantNotas, String nombre, int cantVendedores){
        this.nombre = nombre;
        notasVenta = new Arreglo(cantNotas);
        vendedores = new Arreglo(cantVendedores);
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
        Vendedor vendedorTem =(Vendedor)vendedores.obtener(0);
        NotaVenta notaTem = null;
        int folioTem =0;

        if(vendedorTem==null){ // no hay notas
            return false;
        }

        int cantidadNotasExistentes = notasVenta.cantidad();
        if (cantidadNotasExistentes == 0){// no hay notas
            folioTem =1;
        }else{
            
            notaTem = (NotaVenta) notasVenta.obtener(cantidadNotasExistentes-1);
            folioTem = notaTem.getFolio()+1;
        } 

        NotaVenta notaNueva = new NotaVenta(cantidadArticulosVendidos, cliente, vendedorTem, fecha, folioTem);
        int retorno = notasVenta.poner(notaNueva);
        if(retorno<0){
            return false;
        }else{

            return true;
        }
    }
    public boolean agregarArticuloNota(int folio, Articulo artComprado, int cant){
        // encontrar la nota que tenga el folio proporcionado 
        int posicionBusqueda = (int)notasVenta.buscar(folio);
        if (posicionBusqueda<0){
            return false;
        }else{
            

            NotaVenta notaTem = (NotaVenta) notasVenta.obtener(posicionBusqueda);
            //usamos metodo de agregra articulo 
            return notaTem.agregarArticulo(artComprado, cant);   
        }
    }


    public void imprimirNota(int folio){
        // Primero encontrar la nota
        int posicionNota = (int) this.notasVenta.buscar(folio);

        if (posicionNota >= 0){ // Puedo impirmirla porque existe
            // Obtenela
            NotaVenta notaTemp = (NotaVenta) this.notasVenta.obtener(posicionNota);
            // Imprimirla
            notaTemp.imprimirNota();
        } else {
            return;
        }
    }
}
