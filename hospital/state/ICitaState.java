package hospital.state;

import hospital.object.pacientes.Paciente;
public interface ICitaState {
    public boolean isDisponible();
    public EstadoAgendada makeDisponible( String doNotFillMeString);
    public EstadoCancelada makeNoDisponible(String doNotFillMeString );
    public EstadoCompletada completarCita();
    
}