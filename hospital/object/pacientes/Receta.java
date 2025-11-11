package hospital.object.pacientes;

import hospital.object.recursos.Medicamentos.Medicamento;

public class Receta {
    private Medicamento medicamento;
    private double dosis;
    private int tiempoEntreDosis;

    public Receta( Medicamento medicamento, double dosis, int tiempoEntreDosis ) {
        this.medicamento = medicamento;
        this.dosis = dosis;
        this.tiempoEntreDosis = tiempoEntreDosis;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }
    public void setMedicamento( Medicamento medicamento ) {
        this.medicamento = medicamento;
    }

    public double getDosis() {
        return dosis;
    }
    public void setDosis( double dosis ) {
        this.dosis = dosis;
    }

    public int getTiempoEntreDosis() {
        return tiempoEntreDosis;
    }
    public void setTiempoEntreDosis( int tiempoEntreDosis ) {
        this.tiempoEntreDosis = tiempoEntreDosis;
    }
}
