package DataAccess.aaDAOs;

import DataAccess.aaDTOs.aaPersonaDTO;
import java.time.LocalDate;

public class aaPersonaDAO {

    public aaPersonaDTO aaLogin(String cedula, String clave) {
        // Credenciales hardcodeadas según requerimiento
        if (cedula.equals("patmic") && clave.equals("123")) {
            aaPersonaDTO p = new aaPersonaDTO();
            p.setAaIdPersona(1);
            p.setAaCedula(cedula);
            p.setAaClave(clave);
            p.setAaFechaCrea(LocalDate.now().toString());
            return p;
        }
        return null;
    }
    
    public aaPersonaDTO aaBuscarPorCedula(String cedula) {
        // Simulación de búsqueda
        if (cedula.equals("patmic") || cedula.startsWith("17")) { // Tu cédula probablemente empieza con 17
            aaPersonaDTO p = new aaPersonaDTO();
            p.setAaIdPersona(1);
            p.setAaCedula(cedula);
            p.setAaClave("123");
            p.setAaFechaCrea("2024-01-01");
            return p;
        }
        return null;
    }
}