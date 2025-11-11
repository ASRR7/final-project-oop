package hospital.object.recursos.Medicamentos;

public class Paracetamol extends Medicamento {
    private int numParacetamolInventario;
    private int numParacetamolVendidos;

    public Paracetamol(String nombre, boolean enEmbarazo, boolean enLactancia, boolean enGeriatria, boolean enInfancia) {
        super(nombre, enEmbarazo, enLactancia, enGeriatria, enInfancia);
    }

    public int getNumParacetamolInventario() {
        return numParacetamolInventario;
    }

    public void setNumParacetamolInventario(int numParacetamolInventario) {
        this.numParacetamolInventario = numParacetamolInventario;
    }

    public int getNumParacetamolVendidos() {
        return numParacetamolVendidos;
    }

    public void setNumParacetamolVendidos(int numParacetamolVendidos) {
        this.numParacetamolVendidos = numParacetamolVendidos;
    }
    
    @Override
    public void sintomasSecundarios() {
        super.sintomasSecundarios();
        System.out.println("Sintomas :3");
    }

    @Override
    public void contraindicaciones() {
        super.contraindicaciones();
        System.out.println("No usar si blabla");
    }
}
