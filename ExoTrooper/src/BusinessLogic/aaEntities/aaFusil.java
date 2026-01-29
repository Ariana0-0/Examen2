package BusinessLogic.aaEntities;

public class aaFusil extends aaArma {
    
    public aaFusil() {
        this.aaTipo = "Fusil";
    }

    @Override
    public boolean aaDisparar() {
        if (aaRecurso != null && aaRecurso.aaConsumir()) {
            return true;
        }
        return false;
    }
}