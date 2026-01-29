package DataAccess.aaDTOs;

public class aaExoBotDTO {
    private Integer aaIdExoBot;
    private String aaTipo;
    private String aaEntrenado;
    private Integer aaAccionesRealizadas; // Este campo estaba faltando
    private Integer aaIdPersona;

    public aaExoBotDTO() {}

    public aaExoBotDTO(String aaTipo) {
        this.aaTipo = aaTipo;
        this.aaEntrenado = "NO";
        this.aaAccionesRealizadas = 0;
    }

    public Integer getAaIdExoBot() { 
        return aaIdExoBot; 
    }
    
    public void setAaIdExoBot(Integer aaIdExoBot) { 
        this.aaIdExoBot = aaIdExoBot; 
    }

    public String getAaTipo() { 
        return aaTipo; 
    }
    
    public void setAaTipo(String aaTipo) { 
        this.aaTipo = aaTipo; 
    }

    public String getAaEntrenado() { 
        return aaEntrenado; 
    }
    
    public void setAaEntrenado(String aaEntrenado) { 
        this.aaEntrenado = aaEntrenado; 
    }

    public Integer getAaAccionesRealizadas() { 
        return aaAccionesRealizadas != null ? aaAccionesRealizadas : 0; 
    }
    
    public void setAaAccionesRealizadas(Integer aaAccionesRealizadas) { 
        this.aaAccionesRealizadas = aaAccionesRealizadas; 
    }

    public Integer getAaIdPersona() { 
        return aaIdPersona; 
    }
    
    public void setAaIdPersona(Integer aaIdPersona) { 
        this.aaIdPersona = aaIdPersona; 
    }

    @Override
    public String toString() {
        return "aaExoBotDTO{" +
               "id=" + aaIdExoBot +
               ", tipo='" + aaTipo + '\'' +
               ", entrenado='" + aaEntrenado + '\'' +
               ", acciones=" + aaAccionesRealizadas +
               '}';
    }
}