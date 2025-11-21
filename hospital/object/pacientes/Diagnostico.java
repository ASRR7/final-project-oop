package hospital.object.pacientes;

import hospital.object.usuarios.Doctor;

public class Diagnostico {
    private String enfermedad;
    private Doctor doctor;
    private Tratamiento tratamiento;

    public Diagnostico( String enfermedad, Doctor doctor, Tratamiento tratamiento ) {
        this.enfermedad = enfermedad;
        this.doctor = doctor;
        this.tratamiento = tratamiento;
    }

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

    public String toString() {
        return "Diagnostico{" +
                "enfermedad='" + enfermedad + '\'' +
                ", doctor=" + doctor +
                ", tratamiento=" + tratamiento +
                '}';
    }
}
