package hospital.state;

import hospital.object.recursos.Cita;
public interface ICitaState {

    void setContextoCita(Cita contexto);
    void agendar();   
    void cancelar();  
    void completar(); 
}
