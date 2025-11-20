package hospital.state;

public class EstadoCancelada {
    public boolean isDisponible(){
        return Boolean.FALSE;
    }

    public EstadoAgendada makeDisponible(String doNotFillMeString) {
        System.out.println("La cita ha sido reagendada");
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
