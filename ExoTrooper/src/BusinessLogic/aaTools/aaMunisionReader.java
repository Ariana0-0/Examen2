package BusinessLogic.aaTools;

import Infrastructure.Tools.aaCMD;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//refactorización
public class aaMunisionReader {
    
    public static String aaBuscarMunicionPorTipo(String tipoBusqueda) {
        String filePath = "storage/DataFiles/ExoMunision.txt";
        
        File file = new File(filePath);
        if (!file.exists()) {
            aaCMD.printError("Archivo no encontrado: " + filePath);
            aaCMD.printError("Ruta absoluta: " + file.getAbsolutePath());
            return "Archivo no encontrado: " + filePath;
        }
        
        List<String> recursosEncontrados = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                procesarLinea(linea, tipoBusqueda, recursosEncontrados);
            }
        } catch (Exception e) {
            return "Error leyendo archivo: " + e.getMessage();
        }
        
        if (recursosEncontrados.isEmpty()) {
            return "Munición no encontrada para: " + tipoBusqueda;
        }
        
        return recursosEncontrados.get(0);
    }
    
    private static void procesarLinea(String linea, String tipoBusqueda, List<String> resultados) {
        linea = linea.replace("\t", " ")
                     .replace("  ", " ")
                     .replace(" ,", ",")
                     .replace(", ", ",")
                     .trim();
        
        if (linea.isEmpty()) return;
        
        String[] elementos = linea.split(",");
        
        for (String elemento : elementos) {
            elemento = elemento.trim();
            if (elemento.isEmpty()) continue;
            
            if (tipoBusqueda.equalsIgnoreCase("Fusil") || 
                tipoBusqueda.equalsIgnoreCase("Munición_Fusil") ||
                tipoBusqueda.contains("Fusil")) {
                
                if (elemento.contains("Fusil")) {
                    String limpio = limpiarRecurso(elemento);
                    if (!resultados.contains(limpio)) {
                        resultados.add(limpio);
                    }
                }
            }
            else if (elemento.contains(tipoBusqueda)) {
                String limpio = limpiarRecurso(elemento);
                if (!resultados.contains(limpio)) {
                    resultados.add(limpio);
                }
            }
        }
    }
    
    private static String limpiarRecurso(String recurso) {
        return recurso.replace("_ ", "_")
                      .replace(" _", "_")
                      .replace("  ", " ")
                      .trim();
    }
}