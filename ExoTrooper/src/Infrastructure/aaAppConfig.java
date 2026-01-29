package Infrastructure;

import Infrastructure.Tools.aaCMD;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.PrintWriter;

public abstract class aaAppConfig {
    private static final Properties props = new Properties();
    
    // RUTAS RELATIVAS DESDE LA RAIZ DEL PROYECTO
    private static final String APP_PROPERTIES = "storage/DataFiles/app.properties";
    private static final String KEY_DB_NAME = "db.File";
    private static final String KEY_FILE_LOG = "df.logFile";
    private static final String KEY_FILE_MUNITION = "df.Munition";
    
    // Métodos getter
    public static final String getDATABASE() { 
        return getProperty(KEY_DB_NAME); 
    }
    
    public static final String getLOGFILE() { 
        return getProperty(KEY_FILE_LOG); 
    }
    
    public static final String getMUNITIONFILE() { 
        return getProperty(KEY_FILE_MUNITION); 
    }
    
    // Mensajes por defecto
    public static final String MSG_DEFAULT_ERROR = "Error inesperado. Contacte al administrador.";
    public static final String MSG_DEFAULT_CLASS = "undefined";
    public static final String MSG_DEFAULT_METHOD = "undefined";

    static {
        loadConfiguration();
    }

    private static void loadConfiguration() {
        File configFile = new File(APP_PROPERTIES);
        aaCMD.print("Buscando configuración en: " + configFile.getAbsolutePath());
        
        if (!configFile.exists()) {
            aaCMD.printError("✗ Archivo no encontrado: " + APP_PROPERTIES);
            aaCMD.printError("Directorio actual: " + System.getProperty("user.dir"));
            createDefaultConfig();
        }
        
        try (InputStream appProperties = new FileInputStream(configFile)) {
            props.load(appProperties);
            aaCMD.print("✓ Configuración cargada desde: " + APP_PROPERTIES);
            aaCMD.print("✓ LOGFILE: " + getLOGFILE());
            aaCMD.print("✓ MUNITIONFILE: " + getMUNITIONFILE());
        } catch (IOException e) {
            aaCMD.printError("✗ ERROR cargando app.properties: " + e.getMessage());
        }
    }
    
    private static void createDefaultConfig() {
        try {
            File configFile = new File(APP_PROPERTIES);
            File parentDir = configFile.getParentFile();
            
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs();
            }
            
            // Crear archivo de configuración por defecto
            try (PrintWriter writer = new PrintWriter(configFile)) {
                writer.println("# Configuración de la aplicación ExoTrooper");
                writer.println("db.File=storage/DataFiles/exotrooper.db");
                writer.println("df.logFile=storage/DataFiles/ExoTracer.txt");
                writer.println("df.Munition=storage/DataFiles/ExoMunision.txt");
                aaCMD.print("✓ Archivo de configuración creado: " + APP_PROPERTIES);
            }
        } catch (Exception e) {
            aaCMD.printError("Error creando configuración: " + e.getMessage());
        }
    }

    private aaAppConfig(){}

    static String getProperty(String key) {
        String path = props.getProperty(key);
        if(path != null) {
            return path;
        } else {
            aaCMD.printError("ERROR: " + key + " no encontrado en app.properties");
            return null;
        }
    }
}