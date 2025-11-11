package hospital.object.pacientes;

import hospital.object.usuarios.Doctor;

public class Diagnostico {
    private String enfermedad;
    private Doctor doctor;
    private Tratamiento tratamiento;

    public String getEnfermedad() {
        return enfermedad;
    }
    public void setEnfermedad( String enfermedad ) {
        this.enfermedad = enfermedad;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor( Doctor doctor ) {
        this.doctor = doctor;
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }
    public void setTratamiento( Tratamiento tratamiento ) {
        this.tratamiento = tratamiento;
    }
}
