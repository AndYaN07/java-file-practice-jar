package pruebas_jar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


public class PruebaFija {

    // Clase para probar la creacion de archivos .txt sin directorio especificado y
    // utilizar .jar para ejecucion desde terminal
    // primera vers

    public static void main(String[] args) {

        File file = new File("pruebas.txt");
        String msg = "Hola Empresa";

        try (FileWriter fw = new FileWriter(file, true)) {

            fw.write(msg + " - " + LocalDateTime.now() + "\n");

            System.out.println("[INFO] Archivo creado correctamente en: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("[ERROR]. Ha fallado algo en el archivo: " + e.getMessage());
        }

    }// Main
} // class
