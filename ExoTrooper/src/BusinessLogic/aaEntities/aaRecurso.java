package BusinessLogic.aaEntities;

public class aaRecurso {
    private int aaCantidad;
    private String aaTipo;

    public aaRecurso(String tipo, int cantidad) {
        this.aaTipo = tipo;
        this.aaCantidad = cantidad;
    }

    public boolean aaConsumir() {
        if (aaCantidad > 0) {
            aaCantidad--;
            return true;
        }
        return false;
    }

    public int aaGetCantidad() {
        return aaCantidad;
    }
    
    public String aaGetTipo() {
        return aaTipo;
    }
}