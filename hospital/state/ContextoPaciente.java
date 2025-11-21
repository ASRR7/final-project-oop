package hospital.state;

import hospital.object.pacientes.Paciente;

public class ContextoPaciente {

    private IPacienteState estado;

    public ContextoPaciente() {
        setState(new PacienteEnfermo());
    }

    public void setState(IPacienteState estado) {
        this.estado = estado;
        this.estado.setContextoPaciente(this);
    }
    
    public void agendarCita(Paciente paciente) {
        this.estado.agendarCita();
    }

    public void cancelarCita(Paciente paciente) {
        this.estado.cancelarCita();
    }

    public void irACita(Paciente paciente) {
        this.estado.irACita();
    }

    public void salirDelHospital(Paciente paciente) {
        this.estado.salirDelHospital();
    }
}
