package hospital.object.pacientes;

import java.util.ArrayList;

public class Expediente {
    private ArrayList<Diagnostico> diagnosticos;

    public Expediente() {
        this.diagnosticos = new ArrayList<Diagnostico>();
    }

    public Expediente( ArrayList<Diagnostico> diagnosticos ){
        this.diagnosticos = diagnosticos;
    }

    public ArrayList<Diagnostico> getDiagnosticos(){
        return diagnosticos;
    }
    public void setDiagnosticos( ArrayList<Diagnostico> diagnosticos ){
        this.diagnosticos = diagnosticos;
    }

    public void agregarDiagnostico( Diagnostico diagnostico ){
        this.diagnosticos.add( diagnostico );
    }
}
