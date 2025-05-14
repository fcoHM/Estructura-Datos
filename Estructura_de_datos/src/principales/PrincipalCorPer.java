package principales;

import registros.Casas_Poblacion.CoePearPoblacionCasas;

public class PrincipalCorPer {
    public static void main(String[] args) {
         // Crear una instancia de la clase
        CoePearPoblacionCasas coePear = new CoePearPoblacionCasas();

        // Rutas de los archivos de prueba
        String rutaX = "C:\\Users\\Josef\\OneDrive\\Documentos\\Estructura-Datos\\Estructura-Datos\\Estructura_de_datos\\src\\registros\\Casas_Poblacion\\x.txt"; // Cambia a la ruta real del archivo
        String rutaY = "C:\\Users\\Josef\\OneDrive\\Documentos\\Estructura-Datos\\Estructura-Datos\\Estructura_de_datos\\src\\registros\\Casas_Poblacion\\y.txt"; // Cambia a la ruta real del archivo

        // Probar el método leerDatos
        if (coePear.leerDatos(rutaX, rutaY)) {
            System.out.println("Datos leídos correctamente.");
        } else {
            System.out.println("Error al leer los datos.");
            return; // Salir si no se pudieron leer los datos
        }

        // Probar el método obtenerCantidad
        int cantidad = coePear.obtenerCantidad();
        if (cantidad != -1) {
            System.out.println("Cantidad de elementos: " + cantidad);
        } else {
            System.out.println("Error: Las listas están vacías o no tienen el mismo tamaño.");
        }


    
        // Probar el método coeficientePearson
        try {
            double coeficiente = coePear.coeficientePearson();
            System.out.println("Coeficiente de Pearson: " + coeficiente);
        } catch (Exception e) {
            System.out.println("Error al calcular el coeficiente de Pearson: " + e.getMessage());
        }
    }
}
