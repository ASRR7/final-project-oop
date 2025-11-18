package hospital.object.recursos;

import hospital.object.usuarios.Doctor;
import hospital.state.ICitaState;
import hospital.object.pacientes.Paciente;
import hospital.object.usuarios.Doctor;

public class Cita {
    private ICitaState estado;

    private double hora;
    private int dia;
    private int mes;
    private Doctor doctor;
    private int consultorio;
    private Paciente paciente;
    private int Id;



    public Cita(double hora, int dia, int mes, Doctor doctor, int consultorio, Paciente paciente) {
        this.hora = hora;
        this.dia = dia;
        this.mes = mes;
        this.doctor = doctor;
        this.consultorio = consultorio;
        this.paciente = paciente;
        this.Id = 10000*mes+dia*100 +Doctor.getNumDoctoresActual();
    }
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
