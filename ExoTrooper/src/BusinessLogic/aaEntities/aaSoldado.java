package BusinessLogic.aaEntities;

public class aaSoldado extends aaPersona {
    protected aaExoBot aaExobot;
    protected String aaRango;
    protected String aaEspecialidad;

    public aaSoldado(String nombre, String cedula, String clave, String rango, String especialidad) {
        super(nombre, cedula, clave);
        this.aaRango = rango;
        this.aaEspecialidad = especialidad;
    }

    public void aaAsignarExobot(aaExoBot exobot) {
        this.aaExobot = exobot;
        System.out.println("Exobot asignado al soldado: " + aaNombre);
    }

    public boolean aaEntrenarExobot() {
        if (aaExobot != null) {
            if (aaExobot instanceof aaExoAsalto) {
                ((aaExoAsalto) aaExobot).aaEntrenar();
                return true;
            }
        }
        return false;
    }

    public boolean aaEjecutarAccionExobot() {
        if (aaExobot != null && aaExobot.aaIsEntrenado()) {
            return aaExobot.aaEjecutarAccion();
        }
        return false;
    }

    public aaExoBot getAaExobot() {
        return aaExobot;
    }

    public void setAaExobot(aaExoBot aaExobot) {
        this.aaExobot = aaExobot;
    }

    public String getAaRango() {
        return aaRango;
    }

    public void setAaRango(String aaRango) {
        this.aaRango = aaRango;
    }

    public String getAaEspecialidad() {
        return aaEspecialidad;
    }

    public void setAaEspecialidad(String aaEspecialidad) {
        this.aaEspecialidad = aaEspecialidad;
    }

    @Override
    public String toString() {
        return "aaSoldado{" +
                "nombre='" + aaNombre + '\'' +
                ", cedula='" + aaCedula + '\'' +
                ", rango='" + aaRango + '\'' +
                ", especialidad='" + aaEspecialidad + '\'' +
                ", exobot=" + (aaExobot != null ? aaExobot.aaGetTipo() : "Ninguno") +
                '}';
    }
}