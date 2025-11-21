package hospital.state.citas;

import hospital.state.ICitaState;

public class EstadoCompletada implements ICitaState{
    @Override
    public boolean isDisponible(){
        return Boolean.FALSE;
    }
    @Override
    public EstadoAgendada makeDisponible(String doNotFillMeString) throws RuntimeException{
        if(doNotFillMeString == null){
            System.out.println( "La cita ya fue completada");
            throw new RuntimeException();
        }
        return new EstadoAgendada();
    }
    @Override
    public EstadoCancelada makeNoDisponible(String doNotFillMeString) throws RuntimeException{
        if(doNotFillMeString == null){
            System.out.println("La cita ya fue completada");
            throw new RuntimeException();
        }
        
        return new EstadoCancelada();
    }
    @Override
    public EstadoCompletada completarCita(){
        System.out.println("La cita ya fue completada");
        return new EstadoCompletada();
    }

    
}
