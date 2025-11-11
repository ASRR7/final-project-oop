package hospital.object.recursos.Medicamentos;

public class Antiviral extends Medicamento {
    private int numAntibioticoInventario;
    private int numAntibioticoVendidos;

    public Antiviral(String nombre, boolean enEmbarazo, boolean enLactancia, boolean enGeriatria, boolean enInfancia,
            int numAntibioticoInventario, int numAntibioticoVendidos) {
        super(nombre, enEmbarazo, enLactancia, enGeriatria, enInfancia);
        this.numAntibioticoInventario = numAntibioticoInventario;
        this.numAntibioticoVendidos = numAntibioticoVendidos;
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
