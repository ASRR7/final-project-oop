package hospital.object.pacientes;

import hospital.state.IPacienteState;

public class Paciente {
    private static int numPacientesHist;
    private static int numPacientesActual;
    private int id;
    private String nombre;
    private String sexo;
    private int edad;
    private Expediente expediente;
    private IPacienteState estado;
    private Boolean esEmbarazo;
    private Boolean esLactancia;
    private Boolean esGeriatria;
    private Boolean esInfancia;

    public int getNumPacientesHist() {
        return numPacientesHist;
    }
    public int getNumPacientesActual() {
        return numPacientesActual;
    }

    public int getId() {
        return id;
    }
    public void setId( int id ) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo( String sexo ) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad( int edad ) {
        this.edad = edad;
    }

    public Expediente getExpediente() {
        return expediente;
    }
    public void setExpediente( Expediente expediente ) {
        this.expediente = expediente;
    }

    public IPacienteState getEstado() {
        return estado;
    }
    public void setEstado( IPacienteState estado ) {
        this.estado = estado;
    }

    public Boolean getEsEmbarazo() {
        return esEmbarazo;
    }
    public void setEsEmbarazo( Boolean esEmbarazo ) {
        this.esEmbarazo = esEmbarazo;
    }

    public Boolean getEsLactancia() {
        return esLactancia;
    }
    public void setEsLactancia( Boolean esLactancia ) {
        this.esLactancia = esLactancia;
    }

    public Boolean getEsGeriatria() {
        return esGeriatria;
    }
    public void setEsGeriatria( Boolean esGeriatria ) {
        this.esGeriatria = esGeriatria;
    }

    public Boolean getEsInfancia() {
        return esInfancia;
    }
    public void setEsInfancia( Boolean esInfancia ) {
        this.esInfancia = esInfancia;
    }
}
