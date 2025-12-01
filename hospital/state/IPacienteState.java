package hospital.state;

import java.util.ArrayList;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.usuarios.Doctor;

public interface IPacienteState {
    void agendarCita(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes, ArrayList<Cita> citas, int hora, int dia, int mes); 
    void cancelarCita(ArrayList<Cita> citas, Paciente paciente, int citaId);
    void irACita();
    void salirDelHospital();
    void setContextoPaciente(Paciente contexto);
}
