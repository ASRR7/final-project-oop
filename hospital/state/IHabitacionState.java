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

    abstract Boolean isDisponible();
    abstract void addPaciente(Paciente paciente);
    abstract int eliminarPaciente();



}
