package BusinessLogic.aaEntities;

import BusinessLogic.aaInterfaces.IIAEXO;

public abstract class aaExoBot implements IIAEXO {
    protected boolean aaEntrenado;
    protected aaArma aaArma;
    protected String aaTipo;
    protected int aaAccionesRealizadas = 0;

    public void aaSetArma(aaArma arma) {
        this.aaArma = arma;
    }

    public boolean aaIsEntrenado() {
        return aaEntrenado;
    }
    
    public void aaSetEntrenado(boolean entrenado) {
        this.aaEntrenado = entrenado;
    }
    
    public String aaGetTipo() {
        return aaTipo;
    }
    
    public int aaGetAccionesRealizadas() {
        return aaAccionesRealizadas;
    }
    
    public void aaIncrementarAcciones() {
        aaAccionesRealizadas++;
    }
    
    // Este método será implementado por las clases concretas
    public abstract boolean aaDisparar();
}