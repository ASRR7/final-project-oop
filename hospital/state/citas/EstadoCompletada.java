package hospital.state.citas;

import hospital.object.recursos.Cita;
import hospital.state.ICitaState;

public class EstadoCompletada implements ICitaState{
    private Cita contexto;
    @Override
    public void setContextoCita(Cita contexto) {
        this.contexto = contexto;
    }
    
    @Override
    public void agendar() {
        System.out.println("No se puede agendar de nuevo una cita completada.");
    }

    @Override
    public void cancelar() {
        System.out.println("No se puede cancelar una cita completada.");
    }

    @Override
    public void completar() {
        System.out.println("La cita ya está completada.");
    }

    @Override
    public String toString() {
        return "Completada";
    }

    
}
