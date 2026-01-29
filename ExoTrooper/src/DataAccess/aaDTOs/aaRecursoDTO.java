package DataAccess.aaDTOs;

public class aaRecursoDTO {

    private Integer aaIdRecurso;
    private String aaTipo;
    private Integer aaCantidad;

    public aaRecursoDTO() {}

    public aaRecursoDTO(String aaTipo, Integer aaCantidad) {
        this.aaTipo = aaTipo;
        this.aaCantidad = aaCantidad;
    }

    public aaRecursoDTO(Integer aaIdRecurso, String aaTipo, Integer aaCantidad) {
        this.aaIdRecurso = aaIdRecurso;
        this.aaTipo = aaTipo;
        this.aaCantidad = aaCantidad;
    }

    public Integer getAaIdRecurso() {
        return aaIdRecurso;
    }

    public void setAaIdRecurso(Integer aaIdRecurso) {
        this.aaIdRecurso = aaIdRecurso;
    }

    public String getAaTipo() {
        return aaTipo;
    }

    public void setAaTipo(String aaTipo) {
        this.aaTipo = aaTipo;
    }

    public Integer getAaCantidad() {
        return aaCantidad;
    }

    public void setAaCantidad(Integer aaCantidad) {
        this.aaCantidad = aaCantidad;
    }

    @Override
    public String toString() {
        return getClass().getName()
            + "\n IdRecurso: " + aaIdRecurso
            + "\n Tipo:      " + aaTipo
            + "\n Cantidad:  " + aaCantidad;
    }
}
