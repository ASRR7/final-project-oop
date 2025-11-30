package hospital.state;
import hospital.object.pacientes.Paciente;
import java.util.ArrayList;

public abstract class IHabitacionState {
    private Boolean disponible;
    private int capacidadMaxima;
    private int numPacientes;
    private ArrayList<Paciente> pacientes;

    public IHabitacionState(Boolean disponible, int capacidadMaxima, int numPacientes) {
        this.disponible = disponible;
        this.capacidadMaxima = capacidadMaxima;
        this.numPacientes = numPacientes;
        this.pacientes = new ArrayList<Paciente>();
    }

    public abstract Boolean isDisponible();
    public abstract void addPaciente(Paciente paciente);
    public abstract int eliminarPaciente();
    public Boolean getDisponible(){
        return disponible;
    };
    public void setDisponible(Boolean disponible){
        this.disponible = disponible;
    }
    public int getCapacidadMaxima(){
        return capacidadMaxima;
    }
    public void setCapacidadMaxima(int capacidadMaxima){
        this.capacidadMaxima = capacidadMaxima;
    }
    public int getNumPacientes(){
        return numPacientes;
    }
    public void setNumPacientes(int numPacientes){
        this.numPacientes = numPacientes;
    }
    public ArrayList<Paciente> getPacientes(){
        return pacientes;
    }
    public void setPacientes(ArrayList<Paciente> pacientes){
        this.pacientes = pacientes;
    }





}
