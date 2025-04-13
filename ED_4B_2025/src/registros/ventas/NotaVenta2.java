package registros.ventas;

import EstructuraDatos.EDLineal.Arreglo;
import EstructuraDatos.EDLineal.ListaDin;
import entradaSalida.Salida;

public class NotaVenta2 {
    protected int folio;
    protected String fecha;
    protected Vendedor vendedorVenta;
    protected Cliente clienteVenta;
    protected ListaDin arcticulosVenta;
    protected ListaDin cantidadArticulos;
    protected double total;

    public NotaVenta2(Cliente cliente, Vendedor vendedor, String fecha, int folio){
        this.clienteVenta = cliente;
        this.vendedorVenta = vendedor;
        this.fecha = fecha;
        arcticulosVenta  = new ListaDin();
        this.cantidadArticulos = new ListaDin();
        this.folio = folio;
        total = 0.0;
    }

    public boolean agregarArticulo(Articulo articuloVendido, int cuantos){
        int resultadoInsercionA = arcticulosVenta.poner(articuloVendido);
        int resultadoInsercionC = cantidadArticulos.poner(cuantos);
        if (resultadoInsercionA == -1 || resultadoInsercionC == -1 ){
            return false;
        }
        else{
            return true;
        }
    }

    private double calcularTotal(){ //arreglos parralelos 
        //variable total  acumulado
        double total = 0.0;
        //rcorrer listas paralelas
        arcticulosVenta.iniciarIterador();
        cantidadArticulos.iniciarIterador();

        while(arcticulosVenta.iteradorValido()==true&& cantidadArticulos.iteradorValido()==true){
            //extraer el articulo guardado  en el arreglo de articulos
            Articulo articuloTem = (Articulo) arcticulosVenta.obtenerIterador();
            double presioUnitario = articuloTem.getPrecioUnitario();
           //obtener elementos comprados 
            int cantidadTem= (int) cantidadArticulos.obtenerIterador();
            //multiplicar para obtener subtotal
            double subtotal = presioUnitario*cantidadTem;
            //acumular subtotal
            total = total + subtotal;
            arcticulosVenta.moverseIterador();
            cantidadArticulos.moverseIterador();
        }
        return total;
    }


    // Metodo para imprimir la nota
    public void imprimirNota(){
        // 1. Encabezado
        Salida.salidaPorDefecto("*NOTA DE VENTA");
        Salida.salidaPorDefecto("Folio: " + this.folio);
        Salida.salidaPorDefecto("\t\t\tFecha: " + this.fecha + "\n");
        Salida.salidaPorDefecto("Vendedor: " + this.vendedorVenta.getNombre() + "\n");
        Salida.salidaPorDefecto("Cliente: " + this.clienteVenta.getNombre() + "\n");

        // 2. Detalla
        // Títulos de las columnas
        Salida.salidaPorDefecto("No. art \t\t Clave \t\t Descripción \t\t Cantidad \t\t Precio U. \t\t Subtotal\n");

        // Imprimir los artículos
        for (int cadaArticulo = 0; cadaArticulo < this.arcticulosVenta.cantidad(); cadaArticulo++){
            // Mostrar el consecutivo (No. Art)
            Salida.salidaPorDefecto("" + (cadaArticulo + 1));
            // Extraer cada artículo y sus propiedades
            // para imprimirlas
            Articulo articuloTemp = (Articulo) this.arcticulosVenta.obtener(cadaArticulo);
            Salida.salidaPorDefecto(articuloTemp.getClave() + "\t");
            Salida.salidaPorDefecto(articuloTemp.getDescripcion() + "\t");
            // Extraer la cantidad de cada artículo vendido
            int cantidadTemporal = (int) cantidadArticulos.obtener(cadaArticulo);
            Salida.salidaPorDefecto(cantidadTemporal + "\t");

            // Mostrar el subtotal
            Salida.salidaPorDefecto(articuloTemp.getPrecioUnitario() + "\t");
            double subtotal = articuloTemp.getPrecioUnitario() * cantidadTemporal;
            Salida.salidaPorDefecto(subtotal + "\n");

        }
        //
        this.total = this.calcularTotal();
        Salida.salidaPorDefecto("\t\t\t\t" + "Total: " + this.total);
    }

    @Override
    public String toString(){
        return""+folio;
    }
    public int getFolio(){
        return folio;
    }

    public Arreglo getArcticulosVenta() {
        return arcticulosVenta;
    }

    public Arreglo getCantidadArticulos() {
        return cantidadArticulos;
    }
    
}

