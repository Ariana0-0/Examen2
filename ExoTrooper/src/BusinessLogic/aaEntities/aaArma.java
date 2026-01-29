package BusinessLogic.aaEntities;

public abstract class aaArma {
    protected String aaTipo;
    protected aaRecurso aaRecurso;

    public void aaSetRecurso(aaRecurso r) {
        this.aaRecurso = r;
    }
    
    public aaRecurso getAaRecurso() {
        return aaRecurso;
    }
    
    public String aaGetTipo() {
        return aaTipo;
    }

    public abstract boolean aaDisparar();
    
    public boolean aaTieneRecurso() {
        return aaRecurso != null && aaRecurso.aaGetCantidad() > 0;
    }
    
    @Override
    public String toString() {
        return "Arma: " + aaTipo + " - Recurso: " + 
               (aaRecurso != null ? aaRecurso.toString() : "Sin recurso");
    }
}