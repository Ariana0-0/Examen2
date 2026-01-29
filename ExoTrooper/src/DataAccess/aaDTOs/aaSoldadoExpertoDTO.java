package DataAccess.aaDTOs;

public class aaSoldadoExpertoDTO {

    private Integer aaIdSoldadoExperto;
    private String aaNombre;
    private String aaEspecialidad;
    private Integer aaIdPersona;

    public aaSoldadoExpertoDTO() {}

    public aaSoldadoExpertoDTO(String aaNombre, String aaEspecialidad) {
        this.aaNombre = aaNombre;
        this.aaEspecialidad = aaEspecialidad;
    }

    public aaSoldadoExpertoDTO(Integer aaIdSoldadoExperto, String aaNombre,
                               String aaEspecialidad, Integer aaIdPersona) {
        this.aaIdSoldadoExperto = aaIdSoldadoExperto;
        this.aaNombre = aaNombre;
        this.aaEspecialidad = aaEspecialidad;
        this.aaIdPersona = aaIdPersona;
    }

    public Integer getAaIdSoldadoExperto() {
        return aaIdSoldadoExperto;
    }

    public void setAaIdSoldadoExperto(Integer aaIdSoldadoExperto) {
        this.aaIdSoldadoExperto = aaIdSoldadoExperto;
    }

    public String getAaNombre() {
        return aaNombre;
    }

    public void setAaNombre(String aaNombre) {
        this.aaNombre = aaNombre;
    }

    public String getAaEspecialidad() {
        return aaEspecialidad;
    }

    public void setAaEspecialidad(String aaEspecialidad) {
        this.aaEspecialidad = aaEspecialidad;
    }

    public Integer getAaIdPersona() {
        return aaIdPersona;
    }

    public void setAaIdPersona(Integer aaIdPersona) {
        this.aaIdPersona = aaIdPersona;
    }

    @Override
    public String toString() {
        return getClass().getName()
            + "\n IdSoldadoExperto: " + aaIdSoldadoExperto
            + "\n Nombre:          " + aaNombre
            + "\n Especialidad:    " + aaEspecialidad;
    }
}
