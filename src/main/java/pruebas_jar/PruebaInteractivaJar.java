package pruebas_jar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class PruebaInteractivaJar {

    // Clase para probar la creacion de archivos .txt en un directorio especificado y
    // utilizar .jar para ejecucion desde terminal
    // tercera vers. Trabajando con scanner para guardar dentro del archivo un mensaje ingresado por el usuario

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        File dir = new File("data");

        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File("data", "pruebas.txt");


        try (FileWriter fw = new FileWriter(file, true)) {

            System.out.println("=== BIENVENIDO ===");
            System.out.println("Ingrese el mensaje que desea guardar en el archivo: ");

            fw.write(scn.nextLine() + " - " + LocalDateTime.now() + "\n");

            System.out.println("[INFO] Archivo creado correctamente en: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("[ERROR]. Ha fallado algo en el archivo: " + e.getMessage());
        }

        scn.close();

    } // Main
} // Class
