package hospital.state;

import hospital.object.pacientes.Paciente;

public interface IPacienteState {
    void agendarCita(); 
    void cancelarCita();
    void irACita();
    void salirDelHospital();
    void setContextoPaciente(Paciente contexto);
}
