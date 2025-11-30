package hospital.state.habitacion;

import hospital.object.pacientes.Paciente;
import java.util.Scanner;
import hospital.state.IHabitacionState;
public class EstadoDisponible extends IHabitacionState{

    public EstadoDisponible(int capacidadMaxima,int numPacientes){
        super( Boolean.TRUE, capacidadMaxima, capacidadMaxima);

    }

    public Boolean isDisponible(){
        return this.getDisponible();
    }

    public void addPaciente(Paciente paciente){
        updateDisponible();
        if (isDisponible()){
            this.getPacientes().add(paciente);
            this.setNumPacientes(getNumPacientes()+1);
            System.out.println("Paciente agregado");
        }
        else{
            System.out.println("Habitación a su máxima capacidad");
        }
    }

    public int eliminarPaciente(){
        for(Paciente paciente: this.getPacientes()){
            System.out.println("Nombre:" + paciente.getNombre());
            System.out.println("ID:" + paciente.getId());
            System.out.println("Edad: " + paciente.getEdad());
            System.out.println("Sexo: "+ paciente.getSexo());
        }
        System.out.println("Seleccione el ID del paciente a eliminar: ");


        int idDelete;
        try{
            idDelete = validateData("Seleccione el ID del paciente a eliminar:");
        } catch (RuntimeException e) {
            System.out.println("Favor de ingresar números enteros solamente");
            return -1;
        }
        int indexDelete = 0;

        for(Paciente paciente: this.getPacientes()){
            if (idDelete ==  paciente.getId()){
                this.getPacientes().remove(indexDelete);
                System.out.println("Paciente eliminado");
                this.setNumPacientes(getNumPacientes()-1);
                updateDisponible();
                return 0;
            }
            indexDelete++;
        }
        System.out.println("Id no encontrado");
        return -1;

    }

    private int validateData(String prompt) throws RuntimeException{
        Scanner scanner  =  new Scanner(System.in);
        int option;
        try{
            option = scanner.nextInt();
            scanner.close();
            return option;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void updateDisponible(){
        if (this.getCapacidadMaxima()>this.getNumPacientes()){
            this.setDisponible(Boolean.TRUE);
        }
        else{
            this.setDisponible(Boolean.FALSE);
        }
    }
}
