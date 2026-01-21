package pruebas_jar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class PruebaFijaDir {

    // Clase para probar la creacion de archivos .txt en un directorio especificado y
    // utilizar .jar para ejecucion desde terminal
    // segunda vers. Trabajando con directorios

    public static void main(String[] args) {

        String msg = "Hola Empresa";
        File dir = new File("data");

        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File("data", "pruebas.txt");

        try (FileWriter fw = new FileWriter(file, true)) {

            fw.write(msg + " - " + LocalDateTime.now() + "\n");

            System.out.println("[INFO] Archivo creado correctamente en: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("[ERROR]. Ha fallado algo en el archivo: " + e.getMessage());
        }

    } //Main
}//class
