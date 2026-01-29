package Infrastructure;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class aaExoTracer {
    private static final String FILE_PATH = "src/storage/DataFiles/ExoTracer.txt";
    private static final DateTimeFormatter formatter = 
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    public static void aaLog(String msg) {
        String timestamp = LocalDateTime.now().format(formatter);
        String logEntry = timestamp + " - " + msg;
        
        // Escribir en consola
        System.out.println(logEntry);
        
        // Escribir en archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            writer.println(logEntry);
        } catch (Exception e) {
            System.err.println("Error escribiendo en tracer: " + e.getMessage());
        }
    }
    
    public static void write(String msg) {
        aaLog(msg);
    }
}