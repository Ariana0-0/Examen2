package BusinessLogic.aaTools;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class aaMunisionReader {
    
    public static List<String> aaLeerLineasMunicion() {
        List<String> lineas = new ArrayList<>();
        String filePath = "src/storage/DataFiles/ExoMunision.txt";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (!linea.trim().isEmpty()) {
                    lineas.add(linea.trim());
                }
            }
        } catch (Exception e) {
            System.err.println("Error leyendo archivo de munición: " + e.getMessage());
        }
        return lineas;
    }
    
    public static String aaBuscarMunicionPorTipo(String tipoBusqueda) {
        List<String> lineas = aaLeerLineasMunicion();
        
        // Para Fusil, buscar específicamente
        if (tipoBusqueda.contains("Fusil")) {
            for (String linea : lineas) {
                // Buscar líneas que contengan Munición_Fusil
                if (linea.contains("Munición_Fusil") || linea.contains("Munición_ Fusil")) {
                    // Extraer solo la parte de la munición
                    String[] partes = linea.split(",");
                    for (String parte : partes) {
                        parte = parte.trim();
                        if (parte.contains("Fusil")) {
                            return parte;
                        }
                    }
                }
            }
        }
        
        // Búsqueda general
        for (String linea : lineas) {
            if (linea.contains(tipoBusqueda)) {
                // Intentar extraer solo el elemento específico
                String[] elementos = linea.split(",");
                for (String elemento : elementos) {
                    elemento = elemento.trim();
                    if (elemento.contains(tipoBusqueda)) {
                        return elemento;
                    }
                }
                return linea; // Si no se puede extraer, devolver toda la línea
            }
        }
        
        return "Munición no encontrada para: " + tipoBusqueda;
    }
    
    public static List<String> aaGetTodosLosRecursos() {
        return aaLeerLineasMunicion();
    }
}