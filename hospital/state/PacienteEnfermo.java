package hospital.state;
import hospital.object.pacientes.Paciente;

public class PacienteEnfermo implements IPacienteState {
    private ContextoPaciente contexto;

    @Override
    public void agendarCita(Paciente paciente) {
        System.out.println("Agendando cita para el paciente enfermo: " + paciente.getNombre());
        // Lógica para agendar cita
    }

    @Override
    public void cancelarCita(Paciente paciente) {
        System.out.println("Cancelando cita para el paciente enfermo: " + paciente.getNombre());
        // Lógica para cancelar cita
    }

    @Override
    public void irACita(Paciente paciente) {
        System.out.println("El paciente enfermo " + paciente.getNombre() + " está yendo a su cita.");
        // Lógica para ir a la cita
    }

    @Override
    public void salirDelHospital(Paciente paciente) {
        System.out.println("El paciente enfermo " + paciente.getNombre() + " está saliendo del hospital.");
        // Lógica para salir del hospital
    }

    @Override
    public void salirDelHospital(Object paciente) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setContextoPaciente(ContextoPaciente contexto) {
        this.contexto = contexto;
    }
    
}