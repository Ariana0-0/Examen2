package Infrastructure;

import Infrastructure.Tools.aaCMD;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class aaExoTracer {
    private static final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void write(String msg) {
        aaLog(msg);
    }
    
    public static void aaLog(String msg) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " - " + msg;
        
        // Escribir en consola
        System.out.println(logEntry);
        
        // Escribir en archivo
        writeToFile(logEntry);
    }
    
    private static void writeToFile(String logEntry) {
        String filePath = "storage/DataFiles/ExoTracer.txt";
        
        try {
            // Asegurar que el directorio existe
            File file = new File(filePath);
            File parentDir = file.getParentFile();
            
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // Crear directorios si no existen
                aaCMD.print("Directorio creado: " + parentDir.getAbsolutePath());
            }
            
            // Escribir en el archivo
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {
                writer.println(logEntry);
            }
        } catch (Exception e) {
            System.err.println("Error escribiendo en tracer: " + e.getMessage());
            System.err.println("Ruta intentada: " + new File(filePath).getAbsolutePath());
        }
    }
}