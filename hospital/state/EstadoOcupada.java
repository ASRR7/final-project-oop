package hospital.state;

import hospital.object.pacientes.Paciente;
import java.util.Scanner;
public class EstadoOcupada extends IHabitacionState{

    public EstadoOcupada(int capacidadMaxima,int numPacientes){
        super( capacidadMaxima==numPacientes? Boolean.FALSE : Boolean.TRUE, capacidadMaxima, capacidadMaxima);

    }


    public Boolean isDisponible(){
        return disponible;
    }

    public void addPaciente(Paciente paciente){
        if (numPacientes<capacidadMaxima){
            disponible = Boolean.TRUE;
        }
        else{
            disponible = Boolean.FALSE;
        }
       if (isDisponible()){
           pacientes.add(paciente);
           numPacientes++;
           System.out.println("Paciente agregado");
       }
       else{
           System.out.println("Habitación a su máxima capacidad");
       }
    }

    public int eliminarPaciente(){
        for(Paciente paciente: pacientes){
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

        for(Paciente paciente: pacientes){
            if (idDelete ==  paciente.getId()){
                pacientes.remove(indexDelete);
                System.out.println("Paciente eliminado");
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
            return option;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
