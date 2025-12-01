package hospital.state.citas;

import hospital.object.recursos.Cita;
import hospital.state.ICitaState;

public class EstadoAgendada implements ICitaState {
    private Cita contexto;  

    @Override
    public void setContextoCita(Cita contexto) {
        this.contexto = contexto;
    }

    public void agendar() {
        System.out.println("La cita ya está agendada.");
    }

    @Override
    public void cancelar() {
        ICitaState nuevo = new EstadoCancelada();
        contexto.setEstado(nuevo);
    }

    @Override
    public void completar() {
        System.out.println("La cita ha sido completada.");

        ICitaState nuevo = new EstadoCompletada();
        nuevo.setContextoCita(contexto);
        contexto.setEstado(nuevo);
    }

     @Override
    public String toString() {
        return "Agendada";
    }
}
