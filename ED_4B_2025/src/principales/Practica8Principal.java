package principales;

import Media.Photos.ManipuladorImagenes;

public class Practica8Principal {
    public static void main(String[] Ayudaaaaa) {
        ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme.jpg");
        // Probar la función copiaImagenMatriz
        boolean resultadoMatriz = m1.copiaImagenMatriz();
        if (resultadoMatriz) {
            System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
        }

        // Probar la función copiaImagen2
        boolean resultadoImagen2 = m1.copiaImagen2();
        if (resultadoImagen2) {
            System.out.println("La copia de la matriz a la imagen2 se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la matriz a la imagen2.");
        }

        // Crear la imagen a partir de imagen2
        m1.crearImagen();
    }
}
