package Media.Photos;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import EstructuraDatos.EDnoLineales.Arreglo2D;
import EstructuraDatos.EDnoLineales.Arreglo2DNumerico;
import entradaSalida.Salida;

public class ManipuladorImagenes {
    public BufferedImage imagenOriginal; //iamgen original
    public BufferedImage imagen2; //iamgen respuesta 
    public Arreglo2DNumerico imagenMatriz; //imagen a manipular 
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

//copia que se va a manipular para despue psarala a imagen2
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


//se crea copia lo de imagenMatriz a imagen2 que es el resultado de imagen
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
   
    // crea una imagen segun la imagen2
    public void crearImagen(){
        try{
            ImageIO.write(imagen2, "JPG", new File(nomRuta + File.separator + "copia-" + nomArchivo));
            Salida.salidaPorDefecto("se creo exitosamnete \n");
        }catch(Exception e){
            Salida.salidaPorDefecto("error:"+ e.getMessage()+"\n");
        }
        
    }

    public void cambiarPixel(int pixelY, int pixelX, int valorcolor){
        //cambiar un color de un pixel en la posicion W=i, h=j
        imagen2.setRGB(pixelX, pixelY, valorcolor);
    }


    // obatencion de colores
    public int colorRed(int pixel){
        // se recorre a la derecha 16 ceros y se le aplica una mascara de 8 bits 
        return (pixel>>16)&0xff;
    }
    public int colorBlue(int pixel){
        // se le aplica una mascara de 8 bits
        return pixel&0xff;
    }
    public int colorGreen(int pixel){
        // se recorre a la derecha 8 ceros y se le aplica una mascara de 8 bits
        return (pixel>>8)&0xff;
    }

    public int colorAlfa(int pixel){
        //se recorre a la derecha 24 ceros y se le aplica una mascara de 8 bits
        return (pixel>>24)&0xff;
    }


    //cambiar a escalas de grisis una imagen 
    public void escalaGrises(){
        this.copiaImagenMatriz(); // hacer copia de imagen original en un matriz
        for(int pixelY=0; pixelY<imagenMatriz.getFilas();pixelY++){
            for(int pixelX=0; pixelX<imagenMatriz.getColumnas();pixelX++){
                Double pixelMatriz = imagenMatriz.obtener(pixelY, pixelX); //obatener valor en matriz
                int pixel =pixelMatriz.intValue(); //pasar a entero
                int promedio = (this.colorGreen(pixel)+this.colorBlue(pixel)+this.colorRed(pixel))/3; //sacar promedio  de colores
                int pixelGris = (this.colorAlfa(pixel)<<24|promedio<<16|promedio<<8|promedio ); //generar un valor a 32bits
                imagenMatriz.cambiar(pixelY, pixelX, pixelGris); //regresar a matriz
            }
        }
        this.copiaImagen2();//mandar a imagen resultado
    }

    // subir el brillo o bajar en imagen escala de grises 
    public boolean brillo(int brillo){
        if (imagenMatriz == null){
            return false;
        }else{
            for(int pixelY=0; pixelY<imagenMatriz.getFilas();pixelY++){
                for(int pixelX=0; pixelX<imagenMatriz.getColumnas();pixelX++){
                    int  pixelMatriz = imagenMatriz.obtener(pixelY, pixelX).intValue(); //obatener valor en matriz
                    int alfa = this.colorAlfa(pixelMatriz);//obtener alfa

                    int gris = this.colorBlue(pixelMatriz); //esto poq que es el mismo color en RGB
                    int nuevoGris = gris +brillo;
                    //validar si esta dentro del rango de 0 y 255
                    if(nuevoGris < 0){
                        nuevoGris = 0;
                    }
                    if (nuevoGris > 255){
                        nuevoGris = 255;
                    }

                    int pixelGris = (alfa<<24|nuevoGris<<16|nuevoGris<<8|nuevoGris); //generar un valor a 32bits
                    imagenMatriz.cambiar(pixelY, pixelX, pixelGris); //regresar a matriz
                }
            }
            this.copiaImagen2();//mandar a imagen resultado
            return true;
        }
    }

    

    //invertir una imagen en el ejex
    public void invertirImagenEjeX() {
        this.copiaImagenMatriz(); // copiar la imagen en matriz 
        Arreglo2D copia = this.imagenMatriz.clonar(); // clonar la matriz
    
        for (int pixelY = 0; pixelY < imagenMatriz.getFilas(); pixelY++) {
            for (int pixelX = 0; pixelX < imagenMatriz.getColumnas(); pixelX++) {
                // invertir los píxeles en el eje X
                int valor = (int) copia.obtener(pixelY, imagenMatriz.getColumnas() - 1 - pixelX);
                imagenMatriz.cambiar(pixelY, pixelX, valor);
            }
        }
    
        this.copiaImagen2();
    }


    //invertir una imagen en el ejey
    public void invertirImagenEjeY(){
        this.copiaImagenMatriz(); // copiar la imagen en matriz 
        Arreglo2D copia = this.imagenMatriz.clonar(); // clonar la matriz
    
        for (int pixelY = 0; pixelY < imagenMatriz.getFilas(); pixelY++) {
            for (int pixelX = 0; pixelX < imagenMatriz.getColumnas(); pixelX++) {
                // invertir los píxeles en el eje X
                int valor = (int) copia.obtener(imagenMatriz.getFilas()-1-pixelY,pixelX);
                imagenMatriz.cambiar(pixelY, pixelX, valor);
            }
        }
        this.copiaImagen2();
    }



    //crear imagen con imagen dada
    public void crearImagen(BufferedImage image){
        try{
            ImageIO.write(image, "JPG", new File(nomRuta+File.separator +"copia-"+nomArchivo));
            Salida.salidaPorDefecto("se creo exitosamnete \n");
        }catch(Exception e){
            Salida.salidaPorDefecto("error:"+ e.getMessage()+"\n");
        }
        
    }


    //copia una matriz a una imagen 
    public boolean copiarAMatriz(BufferedImage image) {
        if (imagenMatriz == null || image == null) {
            return false;
        } else {
            // Obtener pixel por pixel
            for (int pixelY = 0; pixelY < imagenMatriz.getFilas(); pixelY++) {
                for (int pixelX = 0; pixelX < imagenMatriz.getColumnas(); pixelX++) {
                    Double pixelRecuperado = imagenMatriz.obtener(pixelY, pixelX); // Obtener pixel desde la matriz
                    if (pixelRecuperado != null) { // Validar que no sea nulo
                        int pixelNuevo = pixelRecuperado.intValue();
                        image.setRGB(pixelX, pixelY, pixelNuevo); // Poner los valores de matriz
                    } else {
                        image.setRGB(pixelX, pixelY, 0); // Si es nulo, asignar un valor por defecto (negro)
                    }
                }
            }
            return true;
        }
    }
    
    //se le aplica matriz transpuesta a la imagen matriz y se crea una imagen 
    public void transpuestaImagen(){
        imagenMatriz.transpuesta();
        BufferedImage imagenTem = new BufferedImage(h, w,BufferedImage.TYPE_INT_RGB );
        this.copiarAMatriz(imagenTem);
        crearImagen(imagenTem);
    }


    //crear un margen
    public boolean margen(int grosor, int color){

        if (imagenMatriz == null) { //revisar que no sea null
            return false;
        }else{

            // crear una nueva matriz con espacio para un marco
            int nuevasFilas = imagenMatriz.getFilas() + 2 * grosor;
            int nuevasColumnas = imagenMatriz.getColumnas() + 2 * grosor;
            Arreglo2DNumerico nuevaMatriz = new Arreglo2DNumerico(nuevasFilas, nuevasColumnas);

            // rellenar el marco con el color especificado
            for (int fila = 0; fila < nuevasFilas; fila++) {
                for (int col = 0; col < nuevasColumnas; col++) {
                    //revisar  que el grosor no sea mas garnde que el numero de filas y columnas
                    if (fila < grosor || fila >= nuevasFilas - grosor || col < grosor || col >= nuevasColumnas - grosor) {
                        nuevaMatriz.cambiar(fila, col, color); // agregar marco
                    } else {
                        // copiar los valores de la imagen original al centro de la nueva matriz
                        int valorOriginal = imagenMatriz.obtener(fila - grosor, col - grosor).intValue();
                        nuevaMatriz.cambiar(fila, col, valorOriginal);
                    }
                }
            }

            // actualizar la matriz de la imagen y las dimensiones
            this.imagenMatriz = nuevaMatriz;
            this.h = nuevasFilas;
            this.w = nuevasColumnas;

            // crear la imagen con el marco
            BufferedImage imagenConMargen = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
            this.copiarAMatriz(imagenConMargen);
            crearImagen(imagenConMargen);
            return true;
        }
    }



    //opacidad de la imagen 
    public boolean transparencia(int intensidad){
        if (imagenMatriz == null){
            return false;
        }else{
            for(int pixelY=0; pixelY<imagenMatriz.getFilas();pixelY++){
                for(int pixelX=0; pixelX<imagenMatriz.getColumnas();pixelX++){
                    //obtener pixel
                    int pixelMatriz = imagenMatriz.obtener(pixelY, pixelX).intValue();
                    //obtener colores
                    int rojo = colorRed(pixelMatriz);
                    int verde = colorGreen(pixelMatriz);
                    int azul = colorBlue(pixelMatriz);
                    int alfa = colorAlfa(pixelMatriz);

                    int nuevoAlfa = alfa + intensidad;

                    if (nuevoAlfa<0){
                        nuevoAlfa =0;
                    }
                    if(nuevoAlfa >255){
                        nuevoAlfa = 255;
                    }

                    int nuevoPixel = (nuevoAlfa<<24| rojo<<16| verde<<8|azul);
                    imagenMatriz.cambiar(pixelY, pixelX, nuevoPixel);

                }
            }
            this.copiaImagen2();//mandar a imagen resultado
            return true;
        }
    
    }


}// end class
