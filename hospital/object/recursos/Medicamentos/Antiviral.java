package hospital.object.recursos.Medicamentos;

public class Antiviral extends Medicamento {
    private static int numAntiviralInventario;
    private static int numAntiviralcoVendidos;

    public Antiviral(String nombre, boolean enEmbarazo, boolean enLactancia, boolean enGeriatria, boolean enInfancia) {
        super(nombre, enEmbarazo, enLactancia, enGeriatria, enInfancia);
    }

    public static int getNumAntiviralInventario() {
        return numAntiviralInventario;
    }

    public static void setNumAntiviralInventario(int numAntiviralInventario) {
        Antiviral.numAntiviralInventario = numAntiviralInventario;
    }

    public static int getNumAntiviralcoVendidos() {
        return numAntiviralcoVendidos;
    }

    public static void setNumAntiviralcoVendidos(int numAntiviralcoVendidos) {
        Antiviral.numAntiviralcoVendidos = numAntiviralcoVendidos;
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
