package BusinessLogic.aaEntities;

public class aaRevolver extends aaArma {
    
    private int aaBalasEnTambor;
    private final int aaCapacidadTambor = 6;
    
    public aaRevolver() {
        this.aaTipo = "Revolver";
        this.aaBalasEnTambor = aaCapacidadTambor; // Tambor lleno al inicio
    }
    
    public aaRevolver(int balasIniciales) {
        this.aaTipo = "Revolver";
        this.aaBalasEnTambor = Math.min(balasIniciales, aaCapacidadTambor);
    }

    @Override
    public boolean aaDisparar() {
        if (aaBalasEnTambor > 0) {
            aaBalasEnTambor--;
            System.out.println("¡Pum! Revolver disparado. Balas en tambor: " + aaBalasEnTambor + "/" + aaCapacidadTambor);
            
            // También consumir recurso general si está asignado
            if (aaRecurso != null) {
                aaRecurso.aaConsumir();
            }
            
            return true;
        } else {
            System.out.println("¡Click! Revolver sin balas en el tambor");
            return false;
        }
    }
    
    // Método específico para recargar el revólver
    public void aaRecargar() {
        aaBalasEnTambor = aaCapacidadTambor;
        System.out.println("Tambor recargado: " + aaBalasEnTambor + "/" + aaCapacidadTambor);
        
        // Si hay recurso asignado, también consumir para recargar
        if (aaRecurso != null && aaRecurso.aaGetCantidad() >= aaCapacidadTambor) {
            for (int i = 0; i < aaCapacidadTambor; i++) {
                aaRecurso.aaConsumir();
            }
        }
    }
    
    // Método para recargar cierta cantidad de balas
    public void aaRecargar(int cantidadBalas) {
        aaBalasEnTambor = Math.min(aaCapacidadTambor, aaBalasEnTambor + cantidadBalas);
        System.out.println("Recargadas " + cantidadBalas + " balas. Total: " + aaBalasEnTambor + "/" + aaCapacidadTambor);
    }
    
    // Método para girar el tambor (simulación)
    public void aaGirarTambor() {
        System.out.println("¡Clack-clack-clack! Tambor girado");
    }
    
    // Método para revisar si hay balas
    public boolean aaTieneBalas() {
        return aaBalasEnTambor > 0;
    }
    
    // Método para ver balas restantes
    public int aaBalasRestantes() {
        return aaBalasEnTambor;
    }
    
    // Getters
    public int getAaCapacidadTambor() {
        return aaCapacidadTambor;
    }
    
    @Override
    public String aaGetTipo() {
        return aaTipo;
    }
    
    @Override
    public String toString() {
        return "Revolver - Balas: " + aaBalasEnTambor + "/" + aaCapacidadTambor + 
               ", Recurso: " + (aaRecurso != null ? aaRecurso.aaGetTipo() : "Ninguno");
    }
}