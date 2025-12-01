package hospital.state;
import hospital.object.pacientes.Paciente;

public class PacienteSano implements IPacienteState {
    private Paciente contexto;

    @Override
    public void agendarCita() {
        System.out.println("El paciente sano " + contexto.getNombre() + "agendo una cita.");
    }

    @Override
    public void cancelarCita() {
        System.out.println("El paciente sano " + contexto.getNombre() + "ha cancelado una cita.");
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