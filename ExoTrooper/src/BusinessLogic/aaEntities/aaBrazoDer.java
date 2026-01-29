package BusinessLogic.aaEntities;

//Refactorización
public class aaBrazoDer {
    private aaArma aaArmaEquipada;
    
    public void usar() {
        if (aaArmaEquipada != null) {
            System.out.println("Brazo derecho usando: " + aaArmaEquipada.aaGetTipo());
        }
    }
    
    public void aaEquiparArma(aaArma arma) {
        this.aaArmaEquipada = arma;
        System.out.println("Arma equipada en brazo derecho: " + arma.aaGetTipo());
    }
    
    public boolean aaDisparar() {
        if (aaArmaEquipada != null) {
            return aaArmaEquipada.aaDisparar();
        }
        return false;
    }
    
    public aaArma getAaArmaEquipada() {
        return aaArmaEquipada;
    }
}