package hospital.object.recursos;

import hospital.object.usuarios.Doctor;
import hospital.state.ICitaState; 

public class Cita {
    private ICitaState estado;

    private double hora;
    private int dia;
    private int mes;
    private Doctor doctor;
    private int consultorio;

    public Cita(double hora, int dia, int mes, Doctor doctor, int consultorio) {
        this.hora = hora;
        this.dia = dia;
        this.mes = mes;
        this.doctor = doctor;
        this.consultorio = consultorio;
    }

    public double getHora() {
        return hora;
    }

    public void setHora(double hora) {
        this.hora = hora;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }
}
