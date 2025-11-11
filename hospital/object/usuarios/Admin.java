package hospital.object.usuarios;

public class Admin extends Usuario {
    private static int numAdminHist = 0;
    private static int numAdminActual = 0;

    public Admin( String nombre, String contrasena, double sueldo, String turno ) {
        super(nombre, contrasena, sueldo, turno); 
        numAdminHist++;
        numAdminActual++;
    }

    public static int getNumAdminHist() {
        return numAdminHist;
    }
    public static int getNumAdminActual() {
        return numAdminActual;
    }
}
