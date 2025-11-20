package hospital.state;

import hospital.object.pacientes.Paciente;

public class EstadoLimpieza extends IHabitacionState {

    public EstadoLimpieza(int capacidadMaxima){
        super(Boolean.FALSE, capacidadMaxima, 0);
    }

    public Boolean isDisponible(){
        return isDisponible();
    }

    public void addPaciente(Paciente paciente){
        System.out.println("Habitación en limpieza, no se pueden añadir pacientes");
    }

    public int eliminarPaciente(){
        System.out.println("Habitación en limpieza, no se pueden añadir pacientes");
        return -1;
    }

}
