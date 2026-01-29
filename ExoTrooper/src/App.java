import App.aaDesktopApp.aaForms.ExoTrooperForm;
import Infrastructure.Tools.aaCMD;
import Infrastructure.Tools.aaCMDInput;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║         SISTEMA EXOTROOPER v1.0          ║");
        System.out.println("║     Gestión de Exobots Militares         ║");
        System.out.println("╚══════════════════════════════════════════╝\n");
        
        System.out.println("=== AUTENTICACIÓN REQUERIDA ===");
        
        int intentos = 0;
        boolean acceso = false;

        while (intentos < 3) {
            System.out.println("\n--- Intento " + (intentos + 1) + " de 3 ---");
            String user = aaCMDInput.read("Usuario: ");
            String pass = aaCMDInput.read("Clave: ");

            if (user.equals("patmic") && pass.equals("123")) {
                aaCMD.printGood("✓ Acceso concedido");
                aaCMD.print("Iniciando interfaz gráfica...");
                acceso = true;
                break;
            } else {
                aaCMD.printError("✗ Acceso denegado");
                intentos++;
                if (intentos < 3) {
                    System.out.println("Intente nuevamente...");
                }
            }
        }

        if (acceso) {
            // Iniciar la interfaz gráfica en el hilo de Swing
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        new ExoTrooperForm();
                        aaCMD.print("Interfaz gráfica cargada exitosamente");
                    } catch (Exception e) {
                        aaCMD.printError("Error al cargar la interfaz: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            });
        } else {
            System.out.println("\n══════════════════════════════════════════");
            System.out.println("  ¡DEMASIADOS INTENTOS FALLIDOS!");
            System.out.println("  Sistema bloqueado por seguridad.");
            System.out.println("══════════════════════════════════════════");
            System.exit(0);
        }
    }
}