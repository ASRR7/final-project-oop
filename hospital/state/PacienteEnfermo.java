package hospital.state;
import hospital.object.pacientes.Paciente;

public class PacienteEnfermo implements IPacienteState {
    private Paciente contexto;

    @Override
    public void agendarCita() {
        System.out.println("Agendando cita para el paciente enfermo: " + contexto.getNombre());
        // Lógica para agendar cita
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
    
}