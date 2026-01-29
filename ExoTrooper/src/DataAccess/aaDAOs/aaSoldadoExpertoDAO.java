package DataAccess.aaDAOs;

import DataAccess.aaDTOs.aaSoldadoExpertoDTO;

public class aaSoldadoExpertoDAO {

    public aaSoldadoExpertoDTO aaGetExpertoPorArma(String arma) {
        aaSoldadoExpertoDTO s = new aaSoldadoExpertoDTO();
        
        s.setAaIdSoldadoExperto(1);
        s.setAaNombre("Experto en " + arma);
        s.setAaEspecialidad(arma);
        s.setAaIdPersona(1); 
        return s;
    }
    
    public aaSoldadoExpertoDTO aaGetExpertoPorTipoExobot(String tipoExobot) {
        aaSoldadoExpertoDTO s = new aaSoldadoExpertoDTO();
        
        String arma = "";
        if (tipoExobot.equals("ExoAsalto")) {
            arma = "Fusil";
        } else if (tipoExobot.equals("ExoInfanteria")) {
            arma = "Misil";
        } else if (tipoExobot.equals("ExoMedico")) {
            arma = "BioSensor";
        } else if (tipoExobot.equals("ExoExplorador")) {
            arma = "GPS";
        } else if (tipoExobot.equals("ExoComando")) {
            arma = "Laser";
        } else {
            arma = "Desconocido";
        }
        
        s.setAaIdSoldadoExperto(1);
        s.setAaNombre("Experto " + arma);
        s.setAaEspecialidad(arma);
        s.setAaIdPersona(1);
        
        return s;
    }
}