package hospital.state;

public class EstadoAgendada {
        public boolean isDisponible(){
        return Boolean.TRUE;
    }

    public EstadoAgendada makeDisponible(String doNotFillMeString) {
        System.out.println("La cita ya está agendada");
        return new EstadoAgendada();
    }
    public EstadoCancelada makeNoDisponible(String doNotFillMeString) {
        System.out.println("La cita ha sido cancelada");
        return new EstadoCancelada();
    }
    public EstadoCompletada completarCita(){
        System.out.println( "La cita ya fue completada");
        return new EstadoCompletada();
    }
}
