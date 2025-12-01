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
    public void agendarCita() {
        System.out.println("Agendando cita para el paciente enfermo: " + contexto.getNombre());
    }

    @Override
    public void cancelarCita() {
        System.out.println("Cancelando cita para el paciente sano: " + contexto.getNombre());
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

}