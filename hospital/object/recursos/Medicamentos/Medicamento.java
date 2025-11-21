package hospital.object.recursos.Medicamentos;

public class Medicamento {
    protected String nombre;
    private int cantidad; 
    private boolean enEmbarazo;
    private boolean enLactancia;
    private boolean enGeriatria;
    private boolean enInfancia;

    public Medicamento(String nombre, int cantidad, boolean enEmbarazo, boolean enLactancia, boolean enGeriatria, boolean enInfancia) {
        this.nombre = nombre;
        this.cantidad = cantidad;   
        this.enEmbarazo = enEmbarazo;
        this.enLactancia = enLactancia;
        this.enGeriatria = enGeriatria;
        this.enInfancia = enInfancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContrasena() {
        return cantidad;
    }   
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isEnEmbarazo() {
        return enEmbarazo;
    }

    public void setEnEmbarazo(boolean enEmbarazo) {
        this.enEmbarazo = enEmbarazo;
    }

    public boolean isEnLactancia() {
        return enLactancia;
    }

    public void setEnLactancia(boolean enLactancia) {
        this.enLactancia = enLactancia;
    }

    public boolean isEnGeriatria() {
        return enGeriatria;
    }

    public void setEnGeriatria(boolean enGeriatria ) {
        this.enGeriatria = enGeriatria;
    }

    public boolean isEnInfancia() {
        return enInfancia;
    }

    public void setEnInfancia(boolean enInfancia) {
        this.enInfancia = enInfancia;
    }

    public void sintomasSecundarios() {
        System.out.println("Puede causar efectos secundarios comunes.") ;
    }

    public void contraindicaciones() {
        System.out.println("Consultar con un médico antes de usar.");
    }
}
