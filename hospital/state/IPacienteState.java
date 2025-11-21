package hospital.state;

import hospital.object.pacientes.Paciente;

public interface IPacienteState {
    void agendarCita(Paciente paciente);
    void cancelarCita(Paciente paciente);
    void irACita(Paciente paciente);
    void salirDelHospital(Paciente paciente);
}
