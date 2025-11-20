package hospital.state;
import hospital.object.pacientes.Paciente;
import java.util.ArrayList;

public abstract class IHabitacionState {
    Boolean disponible;
    int capacidadMaxima;
    int numPacientes;
    ArrayList<Paciente> pacientes;

    public IHabitacionState(Boolean disponible, int capacidadMaxima, int numPacientes) {
        this.disponible = disponible;
        this.capacidadMaxima = capacidadMaxima;
        this.numPacientes = numPacientes;
    }

    public abstract Boolean isDisponible();
    public abstract void addPaciente(Paciente paciente);
    public abstract int eliminarPaciente();



}
