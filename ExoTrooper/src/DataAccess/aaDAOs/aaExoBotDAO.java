package DataAccess.aaDAOs;

import DataAccess.aaDTOs.aaExoBotDTO;
import java.util.ArrayList;
import java.util.List;

public class aaExoBotDAO {
    private static List<aaExoBotDTO> aaTabla = new ArrayList<>();
    private static int nextId = 1;

    static {
        aaTabla.add(crear(1, "ExoInfanteria", "SI", 22, 1));
        aaTabla.add(crear(2, "ExoAsalto", "NO", 0, 1));
        aaTabla.add(crear(3, "ExoInfanteria", "NO", 0, 1));
        aaTabla.add(crear(4, "ExoMedico", "NO", 0, 1));
    }

    private static aaExoBotDTO crear(int id, String tipo, String entrenado, 
                                     int acciones, int idPersona) {
        aaExoBotDTO d = new aaExoBotDTO();
        d.setAaIdExoBot(id);
        d.setAaTipo(tipo);
        d.setAaEntrenado(entrenado);
        d.setAaAccionesRealizadas(acciones);
        d.setAaIdPersona(idPersona);
        return d;
    }

    public List<aaExoBotDTO> aaListarTodos() {
        return new ArrayList<>(aaTabla);
    }
    
    public List<aaExoBotDTO> aaListarPorPersona(int idPersona) {
        List<aaExoBotDTO> resultado = new ArrayList<>();
        for (aaExoBotDTO d : aaTabla) {
            if (d.getAaIdPersona() == idPersona) {
                resultado.add(d);
            }
        }
        return resultado;
    }

    public void aaActualizarEntrenamiento(int idExoBot, boolean entrenado) {
        for (aaExoBotDTO d : aaTabla) {
            if (d.getAaIdExoBot() == idExoBot) {
                d.setAaEntrenado(entrenado ? "SI" : "NO");
                break;
            }
        }
    }
    
    public void aaIncrementarAcciones(int idExoBot) {
        for (aaExoBotDTO d : aaTabla) {
            if (d.getAaIdExoBot() == idExoBot) {
                int accionesActuales = d.getAaAccionesRealizadas();
                d.setAaAccionesRealizadas(accionesActuales + 1);
                break;
            }
        }
    }
    
    public void aaAgregarExobot(aaExoBotDTO nuevoExobot) {
        nuevoExobot.setAaIdExoBot(nextId++);
        nuevoExobot.setAaEntrenado("NO");
        nuevoExobot.setAaAccionesRealizadas(0);
        aaTabla.add(nuevoExobot);
    }
}