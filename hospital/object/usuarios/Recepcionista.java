package hospital.object.usuarios;

public class Recepcionista extends Usuario {
    private static int numRecepcionistaHist = 0;
    private static int numRecepcionistaActual = 0;

    public Recepcionista( String nombre, String contrasena, double sueldo, String turno ) {
        super(nombre, contrasena, sueldo, turno); 
        numRecepcionistaHist++;
        numRecepcionistaActual++;
    }

    public static int getNumRecepcionistaHist() {
        return numRecepcionistaHist;
    }
    public static int getNumRecepcionistaActual() {
        return numRecepcionistaActual;
    }
}
