import App.aaDesktopApp.aaForms.ExoTrooperForm;
import Infrastructure.Tools.aaCMD;
import Infrastructure.Tools.aaCMDInput;
import Infrastructure.Tools.aaCMDProgress;
import Infrastructure.aaExoTracer;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("╔══════════════════════════════════════════╗");
            System.out.println("║         SISTEMA EXOTROOPER v1.0          ║");
            System.out.println("║     Gestión de Exobots Militares         ║");
            System.out.println("╚══════════════════════════════════════════╝\n");
            
            // Mostrar progreso
            aaCMDProgress.showSpinner();
            
            System.out.println("=== AUTENTICACIÓN REQUERIDA ===");
            
            int intentos = 0;
            boolean acceso = false;
            final int MAX_INTENTOS = 3;

            while (intentos < MAX_INTENTOS) {
                System.out.println("\n--- Intento " + (intentos + 1) + " de " + MAX_INTENTOS + " ---");
                String user = aaCMDInput.read("Usuario (patmic o cédula): ");
                String pass = aaCMDInput.read("Clave: ");

                // Validar credenciales
                if ((user.equals("patmic") && pass.equals("123")) || 
                    (user.equals("1726965542") && pass.equals("123"))) {
                    
                    aaCMD.printGood("✓ Acceso concedido");
                    aaExoTracer.write("GOOD : Acceso concedido para: " + user);
                    acceso = true;
                    break;
                } else {
                    aaCMD.printError("✗ Acceso denegado");
                    aaExoTracer.write("ERROR: Acceso denegado para: " + user);
                    intentos++;
                    
                    if (intentos < MAX_INTENTOS) {
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
                            aaCMD.print("Iniciando interfaz gráfica...");
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
        } catch (Exception e) {
            aaCMD.printError("Error fatal en la aplicación: " + e.getMessage());
            System.exit(1);
        }
    }
}