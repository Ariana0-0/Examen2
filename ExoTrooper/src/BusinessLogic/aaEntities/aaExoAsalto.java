package BusinessLogic.aaEntities;

public class aaExoAsalto extends aaExoBot {
    
    private String aaArmaEquipada; // "Fusil" o "Revolver"
    
    public aaExoAsalto() {
        this.aaTipo = "ExoAsalto";
        this.aaEntrenado = false;
        this.aaAccionesRealizadas = 0;
        this.aaArmaEquipada = "Fusil"; //  arma principal
    }
    
    public aaExoAsalto(String armaInicial) {
        this();
        if (armaInicial.equals("Revolver") || armaInicial.equals("Fusil")) {
            this.aaArmaEquipada = armaInicial;
        }
    }
    
    public void aaEntrenar() {
        this.aaEntrenado = true;
        System.out.println("ExoAsalto entrenado para usar " + aaArmaEquipada);
    }
    
    public void aaEntrenar(String arma) {
        if (arma.equals("Fusil") || arma.equals("Revolver")) {
            this.aaArmaEquipada = arma;
            this.aaEntrenado = true;
            System.out.println("ExoAsalto entrenado específicamente para " + arma);
        }
    }
    
    @Override
    public boolean aaDisparar() {
        if (!aaEntrenado) {
            System.out.println("ERROR: Exobot no entrenado");
            return false;
        }
        
        if (aaArma != null) {
            boolean disparoExitoso = aaArma.aaDisparar();
            if (disparoExitoso) {
                aaAccionesRealizadas++;
                System.out.println("Disparo exitoso con " + aaArma.aaGetTipo());
                return true;
            }
        }
        return false;
    }
    
    public boolean aaDispararCon(String tipoArma) {
        if (aaArma != null && aaArma.aaGetTipo().equals(tipoArma)) {
            return aaDisparar();
        } else {
            System.out.println("ERROR: Arma " + tipoArma + " no equipada. Arma actual: " + 
                             (aaArma != null ? aaArma.aaGetTipo() : "Ninguna"));
            return false;
        }
    }
    
    public boolean aaDispararConFusil() {
        return aaDispararCon("Fusil");
    }
    
    public boolean aaDispararConRevolver() {
        return aaDispararCon("Revolver");
    }
    
    @Override
    public boolean aaEjecutarAccion() {
        
        return aaDispararConFusil();
    }
    
    public void aaCambiarArma(String nuevaArma) {
        if (nuevaArma.equals("Fusil") || nuevaArma.equals("Revolver")) {
            this.aaArmaEquipada = nuevaArma;
            System.out.println("Arma cambiada a: " + nuevaArma);
        }
    }
    
    public String getAaArmaEquipada() {
        return aaArmaEquipada;
    }
}