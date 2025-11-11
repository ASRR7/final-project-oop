package hospital.object.recursos.Medicamentos;

public class Antibiotico extends Medicamento {

    private static int numAntibioticoInventario;
    private static int numAntibioticoVendidos;

    public Antibiotico(String nombre, boolean enEmbarazo, boolean enLactancia, boolean enGeriatria, boolean enInfancia) {
        super(nombre, enEmbarazo, enLactancia, enGeriatria, enInfancia);
    }

    public static int getNumAntibioticoInventario() {
        return numAntibioticoInventario;
    }

    public static void setNumAntibioticoInventario(int numAntibioticoInventario) {
        Antibiotico.numAntibioticoInventario = numAntibioticoInventario;
    }

    public static int getNumAntibioticoVendidos() {
        return numAntibioticoVendidos;
    }

    public static void setNumAntibioticoVendidos(int numAntibioticoVendidos) {
        Antibiotico.numAntibioticoVendidos = numAntibioticoVendidos;
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
