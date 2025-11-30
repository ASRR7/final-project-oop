package hospital.state.paciente;

import hospital.object.pacientes.Paciente;

public class EstadoMuerto implements hospital.state.IPacienteState {
    public void estadoMuerto() {
        
    }
    @Override
    public void agendarCita(){
        System.out.println("El paciente está muerto, no puede agendar citas");
    }; 
    @Override
    public void cancelarCita(){
        System.out.println("El paciente está muerto, no puede cancelar citas");
    };
    @Override
    public void irACita(){
        System.out.println("El paciente está muerto, no puede ir a citas");
    };
    @Override
    public void salirDelHospital(){
        System.out.println("El paciente ha salido del hospital");
    };
    @Override
    public void setContextoPaciente(Paciente contexto){
            contexto.setEsEmbarazo(Boolean.FALSE);
            contexto.setEsLactancia(Boolean.FALSE);
            contexto.setEsGeriatria(Boolean.FALSE);
            contexto.setEsInfancia(Boolean.FALSE);

    };
}
