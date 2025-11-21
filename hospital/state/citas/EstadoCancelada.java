package hospital.state.citas;

import hospital.state.ICitaState;
public class EstadoCancelada implements ICitaState{
    @Override
    public boolean isDisponible(){
        return Boolean.FALSE;
    }
    @Override
    public EstadoAgendada makeDisponible(String doNotFillMeString) {
        System.out.println("La cita ha sido reagendada");
        return new EstadoAgendada();
    }
    @Override
    public EstadoCancelada makeNoDisponible(String doNotFillMeString) {
        System.out.println("La cita ha sido cancelada");
        return new EstadoCancelada();
    }
    @Override
    public EstadoCompletada completarCita(){
        System.out.println( "La cita ya fue completada");
        return new EstadoCompletada();
    }

     @Override
    public String toString() {
        return "Cancelada";
    }
}
