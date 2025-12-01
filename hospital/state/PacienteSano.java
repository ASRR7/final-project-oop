package hospital.state;
import java.util.ArrayList;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.usuarios.Doctor;
import hospital.servicios.CitaServicio;

public class PacienteSano implements IPacienteState {
    private Paciente contexto;

    @Override
    public void agendarCita(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes, ArrayList<Cita> citas, int hora, int dia, int mes) {
        CitaServicio.pedirCita(doctores, pacientes, citas, contexto.getId(), hora, dia, mes);
    }

    @Override
    public void cancelarCita(ArrayList<Cita> citas, Paciente paciente, int citaId) {
        CitaServicio.cancelarCita(citas, paciente, citaId);
    }

    @Override
    public void irACita() {
        System.out.println("El paciente sano " + contexto.getNombre() + " está yendo a su cita.");
        // Lógica para ir a la cita
    }

    @Override
    public void salirDelHospital() {
        System.out.println("El paciente sano " + contexto.getNombre() + " está saliendo del hospital.");
        // Lógica para salir del hospital
    }

    @Override
    public void setContextoPaciente(Paciente contexto) {
        this.contexto = contexto;
    }

    @Override
    public String toString() {
        return "El paciente esta Sano";
    }
}