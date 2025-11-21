package hospital.object.usuarios;
public class Doctor extends Usuario {
    public static int numDoctoresHist = 0;
    public static int numDoctoresActual = 0;
    private String especialidad;

    public Doctor( String nombre, String contrasena, double sueldo, String turno, String especialidad ) {
        super(nombre, contrasena, sueldo, turno); 
        this.especialidad = especialidad;
        numDoctoresHist++;
        numDoctoresActual++;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad( String especialidad ) {
        this.especialidad = especialidad;
    }

    public static int getNumDoctoresHist() {
        return numDoctoresHist;
    }
    public static int getNumDoctoresActual() {
        return numDoctoresActual;
    }
}
