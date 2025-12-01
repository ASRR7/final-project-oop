package hospital.state;

import java.util.ArrayList;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.usuarios.Doctor;

public interface IPacienteState {
    void agendarCita(); 
    void cancelarCita();
    void irACita();
    void salirDelHospital();
    void setContextoPaciente(Paciente contexto);
}
