package hospital.state;
import hospital.object.pacientes.Paciente;

public class PacienteSano implements IPacienteState {
    private Paciente contexto;

    @Override
    public void agendarCita() {
        System.out.println("Agendando cita para el paciente sano: " + contexto.getNombre());
        // Lógica para agendar cita
    }

    @Override
    public void cancelarCita() {
        System.out.println("Cancelando cita para el paciente sano: " + contexto.getNombre());
        // Lógica para cancelar cita
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
}