package hospital.state;
import java.util.ArrayList;
import java.util.Scanner;

import hospital.object.pacientes.Paciente;
import hospital.servicios.CitaServicio;
import hospital.object.recursos.Cita;
import hospital.object.usuarios.Doctor;
import hospital.servicios.*;


public class PacienteEnfermo implements IPacienteState {
    private Paciente contexto;
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void agendarCita(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes, ArrayList<Cita> citas, int hora, int dia, int mes) {
        CitaServicio.pedirCita(doctores, pacientes, citas, contexto.getId(), hora, dia, mes);
    }

    @Override
    public void cancelarCita() {
        System.out.println("Cancelando cita para el paciente enfermo: " + contexto.getNombre());
        // Lógica para cancelar cita
    }

    @Override
    public void irACita() {
        System.out.println("El paciente enfermo " + contexto.getNombre() + " está yendo a su cita.");
        // Lógica para ir a la cita
    }

    @Override
    public void salirDelHospital() {
        System.out.println("El paciente enfermo " + contexto.getNombre() + " está saliendo del hospital.");
        // Lógica para salir del hospital
    }

    @Override
    public void setContextoPaciente(Paciente contexto) {
        this.contexto = contexto;
    }

    @Override
    public String toString() {
        return "El paciente esta Enfermo";
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            scanner.next();
        }
        int dato = scanner.nextInt();
        scanner.nextLine();
        return dato;
    }
    
}