package principales;

import Media.Photos.ManipuladorImagenes;

public class Practica8Principal {
    public static void main(String[] HelpMe) {
        /* 
         // Crear instancia de ManipuladorImagenes con la ruta de la imagen
         ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme.jpg");

         // Probar la función copiaImagenMatriz
         boolean resultadoMatriz = m1.copiaImagenMatriz();
         if (resultadoMatriz) {
             System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
         } else {
             System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
             return;
         }
 
         // Probar la función copiaImagen2
         boolean resultadoImagen2 = m1.copiaImagen2();
         if (resultadoImagen2) {
             System.out.println("La copia de la matriz a la imagen2 se realizó correctamente.");
         } else {
             System.out.println("No se pudo realizar la copia de la matriz a la imagen2.");
             return;
         }
 
         // Probar los métodos de obtención de colores
         System.out.println("Valores de un pixel específico (32 bits):");
         int pixelX = 10; // Coordenada X del pixel
         int pixelY = 10; // Coordenada Y del pixel
 
         try {
             // Obtener el pixel original
             int pixelOriginal = m1.imagenOriginal.getRGB(pixelX, pixelY);
 
             // Mostrar el valor original completo de 32 bits
             System.out.printf("Pixel (%d, %d) - Original (32 bits): %d\n", pixelX, pixelY, pixelOriginal);
 
             // Mostrar los colores originales
             System.out.printf("  Rojo: %d\n", m1.colorRed(pixelOriginal));
             System.out.printf("  Verde: %d\n", m1.colorGreen(pixelOriginal));
             System.out.printf("  Azul: %d\n", m1.colorBlue(pixelOriginal));
 
             // Obtener el pixel resultante
             int pixelResultante = m1.imagen2.getRGB(pixelX, pixelY);
 
             // Mostrar el valor resultante completo de 32 bits
             System.out.printf("Pixel (%d, %d) - Resultante (32 bits): %d\n", pixelX, pixelY, pixelResultante);
 
             // Mostrar los colores resultantes
             System.out.printf("  Rojo: %d\n", m1.colorRed(pixelResultante));
             System.out.printf("  Verde: %d\n", m1.colorGreen(pixelResultante));
             System.out.printf("  Azul: %d\n", m1.colorBlue(pixelResultante));
         } catch (Exception e) {
             System.out.println("Error al obtener los valores del pixel: " + e.getMessage());
         }
 
         // Crear la imagen a partir de imagen2
         m1.crearImagen();
         */






         /* 
        // Crear instancia de ManipuladorImagenes con la ruta de la imagen
        ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme.jpg");

        // Probar la función copiaImagenMatriz
        boolean resultadoMatriz = m1.copiaImagenMatriz();
        if (resultadoMatriz) {
            System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
            return;
        }

        // Aplicar la función escalaGrises
        System.out.println("Convirtiendo la imagen a escala de grises...");
        m1.escalaGrises();

        // Crear la imagen resultante
        m1.crearImagen();
        System.out.println("La imagen en escala de grises se creó exitosamente.");
        */




        /* 
        // Crear instancia de ManipuladorImagenes con la ruta de la imagen
        ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme.jpg");

        // Probar la función copiaImagenMatriz
        boolean resultadoMatriz = m1.copiaImagenMatriz();
        if (resultadoMatriz) {
            System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
            return;
        }

        // Convertir la imagen a escala de grises
        System.out.println("Convirtiendo la imagen a escala de grises...");
        m1.escalaGrises();
        

        // Ajustar el brillo
        int brillo = -30; // Cambia este valor para aumentar o disminuir el brillo
        System.out.printf("Ajustando el brillo de la imagen en %d unidades...\n", brillo);
        boolean resultadoBrillo = m1.brillo(brillo);
        if (resultadoBrillo) {
            System.out.println("El brillo de la imagen se ajustó correctamente.");
        } else {
            System.out.println("No se pudo ajustar el brillo de la imagen.");
            return;
        }

        // Crear la imagen resultante
        m1.crearImagen();
        System.out.println("La imagen con el brillo ajustado se creó exitosamente.");
        
        */






        /* 
        // Crear instancia de ManipuladorImagenes con la ruta de la imagen
        ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme.jpg");

        // Probar la función copiaImagenMatriz
        boolean resultadoMatriz = m1.copiaImagenMatriz();
        if (resultadoMatriz) {
            System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
            return;
        }

        // Invertir la imagen en el eje X
        System.out.println("Invirtiendo la imagen en el eje X...");
        m1.invertirImagenEjeX();

        // Crear la imagen resultante
        m1.crearImagen();
        System.out.println("La imagen invertida se creó exitosamente.");
        */






        /* 
        // Crear instancia de ManipuladorImagenes con la ruta de la imagen
        ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme.jpg");

        // Probar la función copiaImagenMatriz
        boolean resultadoMatriz = m1.copiaImagenMatriz();
        if (resultadoMatriz) {
            System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
            return;
        }

        // Invertir la imagen en el eje Y
        System.out.println("Invirtiendo la imagen en el eje Y...");
        m1.invertirImagenEjeY();

        // Crear la imagen resultante
        m1.crearImagen();
        System.out.println("La imagen invertida en el eje Y se creó exitosamente.");

    */




        /* 
        // Crear instancia de ManipuladorImagenes con la ruta de la imagen
        ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme.jpg");

        // Probar la función copiaImagenMatriz
        boolean resultadoMatriz = m1.copiaImagenMatriz();
        if (resultadoMatriz) {
            System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
            return;
        }

        // Generar la transpuesta de la imagen
        System.out.println("Generando la transpuesta de la imagen...");
        m1.transpuestaImagen();

        // Mensaje de éxito
        System.out.println("La imagen transpuesta se creó exitosamente.");
        */




        /*
         // Crear instancia de ManipuladorImagenes con la ruta de la imagen
        ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme.jpg");

        // Probar la función copiaImagenMatriz
        boolean resultadoMatriz = m1.copiaImagenMatriz();
        if (resultadoMatriz) {
            System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
            return;
        }

        // Agregar un marco a la imagen
        int grosor = 20; // Grosor del marco en píxeles
        int color = 0xFF0000; // Color del marco (rojo en formato RGB)
        System.out.printf("Agregando un marco de %d píxeles de grosor con color 0x%06X...\n", grosor, color);
        boolean resultadoMargen = m1.margen(grosor, color);
        if (resultadoMargen) {
            System.out.println("El marco se agregó correctamente.");
        } else {
            System.out.println("No se pudo agregar el marco a la imagen.");
            return;
        }

        // Mensaje de éxito
        System.out.println("La imagen con el marco se creó exitosamente.");

         */
        



        // Crear instancia de ManipuladorImagenes con la ruta de la imagen
        ManipuladorImagenes m1 = new ManipuladorImagenes("C:\\Users\\Josef\\OneDrive\\Documentos\\Mis_docs\\4toSemestre\\Estructura-Datos\\ED_4B_2025\\src\\Media\\Photos\\meme-png.png");

        // Probar la función copiaImagenMatriz
        boolean resultadoMatriz = m1.copiaImagenMatriz();
        if (resultadoMatriz) {
            System.out.println("La copia de la imagen a la matriz se realizó correctamente.");
        } else {
            System.out.println("No se pudo realizar la copia de la imagen a la matriz.");
            return;
        }

        // Ajustar la transparencia de la imagen
        int intensidad = 50; // Cambia este valor para aumentar o disminuir la transparencia
        System.out.printf("Ajustando la transparencia de la imagen en %d unidades...\n", intensidad);
        boolean resultadoTransparencia = m1.transparencia(intensidad);
        if (resultadoTransparencia) {
            System.out.println("La transparencia de la imagen se ajustó correctamente.");
        } else {
            System.out.println("No se pudo ajustar la transparencia de la imagen.");
            return;
        }

        // Crear la imagen resultante
        m1.crearImagen();
        System.out.println("La imagen con la transparencia ajustada se creó exitosamente.");




    }//end main
}// end class
