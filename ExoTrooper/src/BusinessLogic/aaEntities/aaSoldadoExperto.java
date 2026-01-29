package BusinessLogic.aaEntities;

public class aaSoldadoExperto extends aaSoldado {
    private String aaTipoArmaEspecialidad;
    private int aaAniosExperiencia;

    // Constructor
    public aaSoldadoExperto(String nombre, String cedula, String clave, 
                           String rango, String especialidad, 
                           String tipoArmaEspecialidad, int aniosExperiencia) {
        super(nombre, cedula, clave, rango, especialidad);
        this.aaTipoArmaEspecialidad = tipoArmaEspecialidad;
        this.aaAniosExperiencia = aniosExperiencia;
    }

    // Constructor simplificado (para usar en el formulario)
    public aaSoldadoExperto(String nombre, String tipoArmaEspecialidad) {
        super(nombre, "EXP001", "experto123", "Sargento", "Entrenador de Armas");
        this.aaTipoArmaEspecialidad = tipoArmaEspecialidad;
        this.aaAniosExperiencia = 5;
    }

    // Verificar si puede entrenar un tipo de arma específico
    public boolean aaPuedeEntrenar(String tipoArma) {
        return aaTipoArmaEspecialidad.equalsIgnoreCase(tipoArma);
    }

    // Entrenar un Exobot específico
    public boolean aaEntrenarExobotEspecifico(aaExoBot exobot, String tipoArma) {
        if (aaPuedeEntrenar(tipoArma)) {
            if (exobot instanceof aaExoAsalto && tipoArma.equals("Fusil")) {
                ((aaExoAsalto) exobot).aaEntrenar();
                return true;
            }
        }
        return false;
    }

    // Getters y Setters específicos
    public String getAaTipoArmaEspecialidad() {
        return aaTipoArmaEspecialidad;
    }

    public void setAaTipoArmaEspecialidad(String aaTipoArmaEspecialidad) {
        this.aaTipoArmaEspecialidad = aaTipoArmaEspecialidad;
    }

    public int getAaAniosExperiencia() {
        return aaAniosExperiencia;
    }

    public void setAaAniosExperiencia(int aaAniosExperiencia) {
        this.aaAniosExperiencia = aaAniosExperiencia;
    }

    @Override
    public String toString() {
        return "aaSoldadoExperto{" +
                "nombre='" + aaNombre + '\'' +
                ", especialidad='" + aaEspecialidad + '\'' +
                ", armaEspecialidad='" + aaTipoArmaEspecialidad + '\'' +
                ", añosExperiencia=" + aaAniosExperiencia +
                '}';
    }
}