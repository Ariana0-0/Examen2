package BusinessLogic.aaEntities;

public abstract class aaPersona {
    protected String aaNombre;
    protected String aaCedula;
    protected String aaClave;
    protected Integer aaIdPersona;

    // Constructor por defecto
    public aaPersona() {
    }

    // Constructor con parámetros
    public aaPersona(String nombre, String cedula, String clave) {
        this.aaNombre = nombre;
        this.aaCedula = cedula;
        this.aaClave = clave;
    }

    // Método de autenticación
    public boolean aaAutenticar(String cedula, String clave) {
        return this.aaCedula.equals(cedula) && this.aaClave.equals(clave);
    }

    // Getters y Setters
    public String getAaNombre() {
        return aaNombre;
    }

    public void setAaNombre(String aaNombre) {
        this.aaNombre = aaNombre;
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

    public Integer getAaIdPersona() {
        return aaIdPersona;
    }

    public void setAaIdPersona(Integer aaIdPersona) {
        this.aaIdPersona = aaIdPersona;
    }

    @Override
    public String toString() {
        return "aaPersona{" +
                "nombre='" + aaNombre + '\'' +
                ", cedula='" + aaCedula + '\'' +
                '}';
    }
}