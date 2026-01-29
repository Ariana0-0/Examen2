package BusinessLogic.aaEntities;

//Refactorización
public class aaIABOT {
    private String aaNombre;
    private String aaVersion;
    
    public aaIABOT() {
        this.aaNombre = "IABOT-MK1";
        this.aaVersion = "2.0";
    }
    
    public void asistirEntrenamiento(aaSoldadoExperto experto, aaExoBot exobot) {
        System.out.println(aaNombre + " v" + aaVersion + 
                          " asistiendo en entrenamiento...");
        System.out.println("Soldado Experto: " + experto.getAaNombre());
        System.out.println("Exobot: " + exobot.aaGetTipo());
        System.out.println("Analizando patrones de movimiento...");
        System.out.println("Optimizando sincronización humano-exobot...");
    }
    
    public void verificarMunicion(aaArma arma) {
        if (arma != null && arma.aaTieneRecurso()) {
            System.out.println("IABOT: Munición/Energía disponible");
        } else {
            System.out.println("IABOT: ¡ALERTA! Sin munición/energía");
        }
    }
}