package pruebas_jar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PruebaFinalJar {

    // Clase para probar la creacion de archivos .txt en un directorio especificado y
    // utilizar .jar para ejecucion desde terminal
    // cuarta vers & ultima.
    // Se implementa la misma logica de Prueba Interactiva pero mejroamos la fecha y logs de errores

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        File dir = new File("data");

        // Agregando variables para formatear fecha
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


        if (!dir.exists()) {
            dir.mkdir();
        }

        File file = new File("data", "pruebas.txt");


        try (FileWriter fw = new FileWriter(file, true)) {

            System.out.println("=== BIENVENIDO ===");
            System.out.println("Ingrese el mensaje que desea guardar en el archivo: ");
            String fechaFormateada = LocalDateTime.now().format(dtf);

            fw.write(scn.nextLine() + " - " + fechaFormateada + "\n");

            System.out.println("[INFO] Archivo creado correctamente en: " + file.getAbsolutePath());

        } catch (IOException e) {
            System.err.println("[ERROR]. Ha fallado algo en el archivo, registrando en LOG.... ");

            // Se incluye log de errores:

            try (FileWriter log = new FileWriter("data/error_logs.txt", true)) {
                String fechaFormateada = LocalDateTime.now().format(dtf);
                log.write("[" + fechaFormateada + "] ERROR: " + e.getMessage() + "\n");
            } catch (IOException logErr) {
                System.err.println("No se ha podido escribir en el log de errores: " + logErr.getMessage());
            }
        }

        scn.close();

    } // main
} //class
