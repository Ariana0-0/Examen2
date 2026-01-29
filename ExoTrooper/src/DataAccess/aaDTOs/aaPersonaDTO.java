package DataAccess.aaDTOs;

public class aaPersonaDTO {

    private Integer aaIdPersona;
    private String aaCedula;
    private String aaClave;
    private String aaFechaCrea;

    public aaPersonaDTO() {}

    public aaPersonaDTO(String aaCedula, String aaClave) {
        this.aaCedula = aaCedula;
        this.aaClave = aaClave;
    }

    public aaPersonaDTO(Integer aaIdPersona, String aaCedula, String aaClave, String aaFechaCrea) {
        this.aaIdPersona = aaIdPersona;
        this.aaCedula = aaCedula;
        this.aaClave = aaClave;
        this.aaFechaCrea = aaFechaCrea;
    }

    public Integer getAaIdPersona() {
        return aaIdPersona;
    }

    public void setAaIdPersona(Integer aaIdPersona) {
        this.aaIdPersona = aaIdPersona;
    }

    public String getAaCedula() {
        return aaCedula;
    }

    public void setAaCedula(String aaCedula) {
        this.aaCedula = aaCedula;
    }

    public String getAaClave() {
        return aaClave;
    }

    public void setAaClave(String aaClave) {
        this.aaClave = aaClave;
    }

    public String getAaFechaCrea() {
        return aaFechaCrea;
    }

    public void setAaFechaCrea(String aaFechaCrea) {
        this.aaFechaCrea = aaFechaCrea;
    }

    @Override
    public String toString() {
        return getClass().getName()
            + "\n IdPersona: " + aaIdPersona
            + "\n Cedula:    " + aaCedula
            + "\n FechaCrea:" + aaFechaCrea;
    }
}
