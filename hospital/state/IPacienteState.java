package hospital.state;

import hospital.object.pacientes.Paciente;

public interface IPacienteState {
    void agendarCita(Paciente p); 
    void cancelarCita(Paciente p);
    void irACita(Paciente p);
    void salirDelHospital(Paciente p);

    void setContextoPaciente(ContextoPaciente contexto);
}
