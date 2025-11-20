package hospital.state;

public interface IPacienteState {
    void agendarCita(Paciente paciente);
    void salirDelHospital(Paciente paciente);
}
