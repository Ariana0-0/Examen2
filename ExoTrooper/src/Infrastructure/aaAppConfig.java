package Infrastructure;

import Infrastructure.Tools.aaCMD;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public abstract class aaAppConfig {
    private static final Properties props = new Properties();
   
    private static final String APP_PROPERTIES      = "src/storage/app.properties";
    private static final String KEY_DB_NAME         = "db.File"     ;
    private static final String KEY_FILE_LOG        = "df.logFile"  ;
    private static final String KEY_FILE_MUNITION   = "df.Munition" ;
    
    // Configuración dinámica (Sin recompilar)
    public static final String getDATABASE  (){ return getProperty( KEY_DB_NAME      ); }
    public static final String getLOGFILE   (){ return getProperty( KEY_FILE_LOG     ); }
    public static final String getMUNITIONFILE(){ return getProperty( KEY_FILE_MUNITION ); }
    
    // AppMSGs
    public static final String MSG_DEFAULT_ERROR    = "Ups! Error inesperado. Por favor, contacte al administrador del sistema.";
    public static final String MSG_DEFAULT_CLASS    = "undefined";
    public static final String MSG_DEFAULT_METHOD   = "undefined";

    static {
        try (InputStream appProperties = new FileInputStream(APP_PROPERTIES)) {
            props.load(appProperties);
            aaCMD.print("Configuración cargada desde: " + APP_PROPERTIES);
        } catch (IOException e) {
            aaCMD.printError("ERROR al cargar app.properties: " + e.getMessage());
        }
    }

    private aaAppConfig(){}

    static String getProperty(String key) {
        String path = props.getProperty(key);
        if(path != null) {
            aaCMD.print("AppConfig: " + key + " = " + path);
            return path;
        } else {
            aaCMD.printError("ERROR: " + key + " no encontrado en app.properties");
            return null;
        }
    }
}