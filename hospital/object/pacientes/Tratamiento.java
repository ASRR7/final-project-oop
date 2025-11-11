package hospital.object.pacientes;

import java.util.ArrayList;

public class Tratamiento {
    private ArrayList<Receta> recetas;

    public ArrayList<Receta> getRecetas() {
        return recetas;
    }
    public void setRecetas( ArrayList<Receta> recetas ) {
        this.recetas = recetas;
    }
}
