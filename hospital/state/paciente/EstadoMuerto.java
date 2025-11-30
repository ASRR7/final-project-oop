package hospital.state.paciente;

import hospital.object.pacientes.Paciente;

public class EstadoMuerto {
    public void estadoMuerto() {
        
    }
    public void agendarCita(){
        System.out.println("El paciente está muerto, no puede agendar citas");
    }; 
    public void cancelarCita(){
        System.out.println("El paciente está muerto, no puede cancelar citas");
    };
    public void irACita(){
        System.out.println("El paciente está muerto, no puede ir a citas");
    };
    public void salirDelHospital(){
        System.out.println("El paciente ha salido del hospital");
    };
    public void setContextoPaciente(Paciente contexto){
            contexto.setEsEmbarazo(Boolean.FALSE);
            contexto.setEsLactancia(Boolean.FALSE);
            contexto.setEsGeriatria(Boolean.FALSE);
            contexto.setEsInfancia(Boolean.FALSE);

    };
}
