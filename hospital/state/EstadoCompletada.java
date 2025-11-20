package hospital.state;

public class EstadoCompletada implements ICitaState{
    public boolean isDisponible(){
        return Boolean.FALSE;
    }

    public EstadoAgendada makeDisponible(String doNotFillMeString) throws RuntimeException{
        if(doNotFillMeString == null){
            System.out.println( "La cita ya fue completada");
            throw new RuntimeException();
        }
        return new EstadoAgendada();
    }
    public EstadoCancelada makeNoDisponible(String doNotFillMeString) throws RuntimeException{
        if(doNotFillMeString == null){
            System.out.println("La cita ya fue cancelada");
            throw new RuntimeException();
        }
        
        return new EstadoCancelada();
    }
    public EstadoCompletada completarCita(){
        System.out.println("La cita ya fue completada");
        return new EstadoCompletada();
    }

    
}
