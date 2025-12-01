package hospital.state.citas;

import hospital.object.recursos.Cita;
import hospital.state.ICitaState;

public class EstadoCancelada implements ICitaState{
    private Cita contexto;
    @Override
    public void setContextoCita(Cita contexto) {
        this.contexto = contexto;
    }

    @Override
    public void agendar() {
        System.out.println("Re-agendando cita cancelada.");

        ICitaState nuevo = new EstadoAgendada();
        nuevo.setContextoCita(contexto);
        contexto.setEstado(nuevo);
    }

    @Override
    public void cancelar() {
        System.out.println("La cita ya está cancelada.");
    }

    @Override
    public void completar() {
        System.out.println("No se puede completar una cita cancelada.");
    }
    
    @Override
    public String toString() {
        return "Cancelada";
    }
}
