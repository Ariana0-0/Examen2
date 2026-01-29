package BusinessLogic.aaEntities;

import BusinessLogic.aaInterfaces.IIAEXO;
import BusinessLogic.aaEntities.aaSoldadoExperto;

//Refactorización
public class aaIAEXO implements IIAEXO {
    private aaExoBot aaExobot;
    
    public aaIAEXO(aaExoBot exobot) {
        this.aaExobot = exobot;
    }
    
    @Override
    public boolean aaEjecutarAccion() {
        if (aaExobot != null && aaExobot.aaIsEntrenado()) {
            // Asistencia de IA para optimizar la acción
            System.out.println("IAEXO: Optimizando ejecución de acción...");
            return aaExobot.aaDisparar();
        }
        return false;
    }
    
    public void aaAsistirEntrenamiento(aaSoldadoExperto soldadoExperto) {
        System.out.println("IAEXO: Asistiendo en entrenamiento con " + 
                          soldadoExperto.getAaNombre());
    }
}