package hospital.state;
import hospital.object.pacientes.Paciente;

public class PacienteMuerto implements IPacienteState {
    @Override
    public void agendarCita(Paciente paciente) {
        System.out.println("El paciente " + paciente.getNombre() + " está muerto y no puede agendar citas.");
    }

    @Override
    public void cancelarCita(Paciente paciente) {
        System.out.println("El paciente " + paciente.getNombre() + " está muerto y no puede cancelar citas.");
    }

    @Override
    public void irACita(Paciente paciente) {
        System.out.println("El paciente " + paciente.getNombre() + " está muerto y no puede ir a citas.");
    }

    @Override
    public void salirDelHospital(Paciente paciente) {
        System.out.println("El paciente " + paciente.getNombre() + " ya está fuera del hospital, ya que está muerto.");
    }
}