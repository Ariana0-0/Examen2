package DataAccess.aaDAOs;

import DataAccess.aaDTOs.aaRecursoDTO;

public class aaRecursoDAO {

    public aaRecursoDTO aaGetRecursoPorTipo(String tipo) {
        aaRecursoDTO r = new aaRecursoDTO();
        r.setAaIdRecurso(1);
        r.setAaTipo(tipo);
        
        // Cantidades según tipo
        if (tipo.equals("Munición") || tipo.contains("Munición")) {
            r.setAaCantidad(10);
        } else if (tipo.equals("Energía") || tipo.contains("Energía")) {
            r.setAaCantidad(5);
        } else {
            r.setAaCantidad(0);
        }
        
        return r;
    }
    
    public aaRecursoDTO aaGetRecursoPorArma(String arma) {
        aaRecursoDTO r = new aaRecursoDTO();
        r.setAaIdRecurso(1);
        
        // Asignar tipo y cantidad según arma
        if (arma.equals("Fusil") || arma.equals("Revolver") || 
            arma.equals("Misil") || arma.equals("Mortero") ||
            arma.equals("Laser") || arma.equals("Bayoneta")) {
            r.setAaTipo("Munición");
            r.setAaCantidad(10);
        } else if (arma.equals("GPS") || arma.equals("Giroscopio") ||
                  arma.equals("BioSensor") || arma.equals("BioEscaner")) {
            r.setAaTipo("Energía");
            r.setAaCantidad(5);
        } else {
            r.setAaTipo("Desconocido");
            r.setAaCantidad(0);
        }
        
        return r;
    }
}