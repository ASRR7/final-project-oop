package hospital.object.usuarios;
import java.util.NoSuchElementException;
import java.util.ArrayList;

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



    public static void addReceptionist(ArrayList<Recepcionista> Recepcionistas, Recepcionista recepcionista){
        Recepcionistas.add(recepcionista);
    }

    public static int removeReceptionist(ArrayList<Recepcionista> Recepcionistas, Recepcionista recepcionista){
        try{
            Recepcionistas.remove(recepcionista);
            System.out.println("Doctor removido exitosamente");
        }
        catch(NoSuchElementException e){
            System.out.println("Doctor no encontrado");
            return -1;
        }
        return 0;
    }

    public static void addDoctor(ArrayList<Doctor> Doctors, Doctor Doctor){
        Doctors.add(Doctor);
        System.out.println("Doctor agregado");
    }
    public static int removeDoctor(ArrayList<Doctor> Doctors, Doctor Doctor){
        try{
            Doctors.remove(Doctor);
            System.out.println("Doctor removido exitosamente");
        }
        catch(NoSuchElementException e){
            System.out.println("Doctor no encontrado");
            return -1;
        }
        return 0;
    }
}
