package hospital.object.recursos;

import hospital.object.pacientes.Paciente;
import hospital.object.usuarios.Doctor;
import hospital.state.ICitaState;

public class Cita {
    private ICitaState estado;

    private int hora;
    private int dia;
    private int mes;
    private Doctor doctor;
    private int consultorio;
    private Paciente paciente;
    private int Id;



    public Cita(int hora, int dia, int mes, Doctor doctor, int consultorio, Paciente paciente, ICitaState estado) {
        this.hora = hora;
        this.dia = dia;
        this.mes = mes;
        this.doctor = doctor;
        this.consultorio = consultorio;
        this.paciente = paciente;
        this.Id = 10000*mes+dia*100 +Doctor.getNumDoctoresActual();
        setEstado(estado);
    }
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
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
    public ICitaState getEstado() {
        return estado;
    }

    public void setEstado(ICitaState estado) {
        this.estado = estado;
        this.estado.setContextoCita(this);
    }

    public void agendar() {
        estado.agendar();
    }

    public void cancelar() {
        estado.cancelar();
    }

    public void completar() {
        estado.completar();
    }
    

    public String toString(){
        return "\nCita:" + Id +
                "\n Hora: " + hora +
                "\n Dia: " + dia +
                "\n Mes: " + mes +
                "\n Doctor: " + doctor.getNombre() +
                "\n Consultorio: " + consultorio +
                "\n Paciente: " + paciente +
                "\n Estado: " + estado.toString();
    }
}