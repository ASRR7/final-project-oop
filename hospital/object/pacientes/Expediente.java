package hospital.object.pacientes;

import java.util.ArrayList;

public class Expediente {
    private ArrayList<Diagnostico> diagnosticos;

    public ArrayList<Diagnostico> getDiagnosticos(){
        return diagnosticos;
    }
    public void setDiagnosticos( ArrayList<Diagnostico> diagnosticos ){
        this.diagnosticos = diagnosticos;
    }
}
