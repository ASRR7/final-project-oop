package hospital.state;
import java.util.ArrayList;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.usuarios.Doctor;

public class PacienteMuerto implements IPacienteState {
    private Paciente contexto;

    @Override
    public void agendarCita(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes, ArrayList<Cita> citas, int hora, int dia, int mes) {
        System.out.println("El paciente " + contexto.getNombre() + " está muerto y no puede agendar citas.");
    }

    @Override
    public void cancelarCita(ArrayList<Cita> citas, Paciente paciente, int citaId) {
        System.out.println("El paciente " + contexto.getNombre() + " está muerto y no puede cancelar citas.");
    }

    @Override
    public void irACita() {
        System.out.println("El paciente " + contexto.getNombre() + " está muerto y no puede ir a citas.");
    }

    @Override
    public void salirDelHospital() {
        System.out.println("El paciente " + contexto.getNombre() + " ya está fuera del hospital, ya que está muerto.");
    }
    @Override
    public void setContextoPaciente(Paciente contexto) {
        this.contexto = contexto;
    }

    @Override
    public String toString() {
        return "El paciente esta Muerto";
    }
}