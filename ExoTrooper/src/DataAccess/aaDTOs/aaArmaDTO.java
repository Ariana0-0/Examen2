package DataAccess.aaDTOs;

public class aaArmaDTO {

    private Integer aaIdArma;
    private String aaTipo;
    private String aaAccion;
    private Integer aaIdRecurso;
    private Integer aaIdExoBot;

    public aaArmaDTO() {}

    public aaArmaDTO(String aaTipo, String aaAccion) {
        this.aaTipo = aaTipo;
        this.aaAccion = aaAccion;
    }

    public aaArmaDTO(Integer aaIdArma, String aaTipo, String aaAccion,
                     Integer aaIdRecurso, Integer aaIdExoBot) {
        this.aaIdArma = aaIdArma;
        this.aaTipo = aaTipo;
        this.aaAccion = aaAccion;
        this.aaIdRecurso = aaIdRecurso;
        this.aaIdExoBot = aaIdExoBot;
    }

    public Integer getAaIdArma() {
        return aaIdArma;
    }

    public void setAaIdArma(Integer aaIdArma) {
        this.aaIdArma = aaIdArma;
    }

    public String getAaTipo() {
        return aaTipo;
    }

    public void setAaTipo(String aaTipo) {
        this.aaTipo = aaTipo;
    }

    public String getAaAccion() {
        return aaAccion;
    }

    public void setAaAccion(String aaAccion) {
        this.aaAccion = aaAccion;
    }

    public Integer getAaIdRecurso() {
        return aaIdRecurso;
    }

    public void setAaIdRecurso(Integer aaIdRecurso) {
        this.aaIdRecurso = aaIdRecurso;
    }

    public Integer getAaIdExoBot() {
        return aaIdExoBot;
    }

    public void setAaIdExoBot(Integer aaIdExoBot) {
        this.aaIdExoBot = aaIdExoBot;
    }

    @Override
    public String toString() {
        return getClass().getName()
            + "\n IdArma:  " + aaIdArma
            + "\n Tipo:    " + aaTipo
            + "\n Accion:  " + aaAccion;
    }
}
