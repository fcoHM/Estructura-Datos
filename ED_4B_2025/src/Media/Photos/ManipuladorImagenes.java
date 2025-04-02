package Media.Photos;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import EstructuraDatos.EDnoLineales.Arreglo2DNumerico;
import entradaSalida.Salida;

public class ManipuladorImagenes {
    protected BufferedImage imagenOriginal; //iamgen original
    protected BufferedImage imagen2; //iamgen respuesta 
    protected Arreglo2DNumerico imagenMatriz; //imagen a manipular 
    protected int w; //ancho
    protected int h;//alto
    protected String archivo; //archivo original
    private String nomArchivo; // nombre del archivo
    private String nomRuta; //nombre de la ruta 

    public ManipuladorImagenes(String ruta){
            this.archivo = ruta; // se guarda la ruta
        try {
            File file = new File(archivo);
            this.imagenOriginal = ImageIO.read(new File(archivo)); //poder mandarle cualquier ruta 
            nomArchivo = file.getName();
            nomRuta = file.getParent();

            //tamanio de la imagen 
            this.w = imagenOriginal.getWidth();
            this.h = imagenOriginal.getHeight();

            this.imagenMatriz = new Arreglo2DNumerico(h, w); //matriz que se manipulara //valores invertidos por que h es alto y w ancho
            this.imagen2 = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB); //se inicia en vacio
        } catch (Exception e) {
            Salida.salidaPorDefecto("Error al cargar la imagen desde la ruta: " + ruta+"\n");
            e.printStackTrace();
            this.imagenOriginal = null; // Inicializar como null si ocurre un error
        }
    }


    public boolean copiaImagenMatriz() {
    if (imagenOriginal == null || imagenMatriz == null) {
        return false;
    } else {
        // Obtener pixel por pixel
        for (int pixelY = 0; pixelY < h; pixelY++) {
            for (int pixelX = 0; pixelX < w; pixelX++) {
                int pixelNuevo = imagenOriginal.getRGB(pixelX, pixelY); // Obtener pixel
                imagenMatriz.cambiar(pixelY, pixelX, pixelNuevo); // Agregar a la matriz
                
            }
        } 
        return true;
    }
}



    public boolean copiaImagen2() {
        if (imagenMatriz == null || imagen2 == null) {
            return false;
        } else {
            // Obtener pixel por pixel
            for (int pixelY = 0; pixelY < h; pixelY++) {
                for (int pixelX = 0; pixelX < w; pixelX++) {
                    Double pixelRecuperado = imagenMatriz.obtener(pixelY, pixelX); // Obtener pixel desde la matriz
                    int pixelNuevo = pixelRecuperado.intValue();
                    imagen2.setRGB(pixelX, pixelY, pixelNuevo); // Poner los valores de matriz en imagen2
                }
            }

            
            return true;
        }
    }
   

    public void crearImagen(){
        try{
            ImageIO.write(imagen2, "JPG", new File(nomRuta+File.separator +"copia-"+nomArchivo));
            Salida.salidaPorDefecto("se creo exitosamnete \n");
        }catch(Exception e){
            Salida.salidaPorDefecto("error:"+ e.getMessage()+"\n");
        }
        
    }

    public void cambiarPixel(int pixelY, int pixelX, int valorcolor){
        //cambiar un color de un pixel en la posicion W=i, h=j
        imagen2.setRGB(pixelX, pixelY, valorcolor);
    }



}// end class
