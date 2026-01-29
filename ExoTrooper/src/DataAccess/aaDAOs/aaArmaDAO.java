package DataAccess.aaDAOs;

import DataAccess.aaDTOs.aaArmaDTO;

public class aaArmaDAO {
    
    public aaArmaDTO aaGetArmaPorExobot(String tipoExobot) {
        aaArmaDTO a = new aaArmaDTO();
        
        a.setAaIdArma(1);
        
        if (tipoExobot.equals("ExoAsalto")) {
            a.setAaTipo("Fusil");
            a.setAaAccion("disparar");
        } else if (tipoExobot.equals("ExoInfanteria")) {
            a.setAaTipo("Misil");
            a.setAaAccion("disparar");
        } else if (tipoExobot.equals("ExoMedico")) {
            a.setAaTipo("BioSensor");
            a.setAaAccion("asistir");
        } else if (tipoExobot.equals("ExoExplorador")) {
            a.setAaTipo("GPS");
            a.setAaAccion("detectar");
        } else if (tipoExobot.equals("ExoComando")) {
            a.setAaTipo("Laser");
            a.setAaAccion("disparar");
        }
        
        a.setAaIdRecurso(1);
        a.setAaIdExoBot(1);
        
        return a;
    }
}