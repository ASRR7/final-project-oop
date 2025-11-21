package hospital.state;
import hospital.object.pacientes.Paciente;

public class PacienteMuerto implements IPacienteState {
    private Paciente contexto;

    @Override
    public void agendarCita() {
        System.out.println("El paciente " + contexto.getNombre() + " está muerto y no puede agendar citas.");
    }

    @Override
    public void cancelarCita() {
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
}