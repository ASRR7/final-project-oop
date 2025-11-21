package hospital.state.citas;

import hospital.state.ICitaState;
public class EstadoAgendada implements ICitaState {
    @Override
        public boolean isDisponible(){
        return Boolean.TRUE;
    }

    @Override
    public EstadoAgendada makeDisponible(String doNotFillMeString) {
        System.out.println("La cita ya está agendada");
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
        return "Agendada";
    }
}
