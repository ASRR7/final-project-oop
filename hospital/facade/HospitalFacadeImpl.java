package hospital.facade;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.recursos.medicamentos.Medicamento;
import hospital.object.usuarios.Admin;
import hospital.object.usuarios.Doctor;
import hospital.object.usuarios.Recepcionista;
import hospital.servicios.*;

import java.util.Scanner;

import javax.print.Doc;

import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class HospitalFacadeImpl {
    protected ArrayList<Doctor> doctores;
    protected ArrayList<Paciente> pacientes;
    protected ArrayList<Medicamento> medicamentos;
    protected ArrayList<Cita> citas;

    public void cargarDatosIniciales() {
        this.doctores = DoctorServicio.leerDoctorTxt();
        this.pacientes = PacienteServicio.leerPacienteTxt();
        this.medicamentos = MedicamentoServicio.leerMedicamentoTxt();
        this.citas = CitaServicio.leerCitaTxt();
    }
    // =========================================
    // PACIENTES
    // =========================================
    public Paciente registrarPaciente(String nombre, String sexo, int edad, boolean esEmbarazo, boolean esLactancia, boolean esGeriatria, boolean esInfancia){
        return PacienteServicio.makePaciente(nombre, sexo, edad, esEmbarazo, esLactancia, esGeriatria, esInfancia);
    }
    public Paciente obtenerPacientePorId(int id){
        return PacienteServicio.obtenerPacientePorId(this.pacientes, id);
    }
    public boolean pedirCita(int pacienteId, double hora, int dia, int mes){
        return CitaServicio.pedirCita(this.doctores, pacienteId, hora, dia, mes);
    }
    public boolean cancelarCita(int pacienteId, int citaId){
        return CitaServicio.cancelarCita(this.citas, pacienteId, citaId);
    }
    public String verHistorialMedico(int pacienteId){
        return PacienteServicio.verHistorialMedico(this.pacientes, pacienteId);
    }

    // =========================================
    // ADMIN
    // =========================================
    public void agregarDoctor(String nombre, String contrasena, double sueldo, String turno, String especialidad){
        DoctorServicio.addDoctor(this.doctores, nombre, contrasena, sueldo, turno, especialidad);
    }
    public void removerDoctor(int doctorId){
        DoctorServicio.removeDoctor(this.doctores, doctorId);
    }
    public String verMedicamentos(){
        return MedicamentoServicio.verMedicamentos(this.medicamentos);
    }
    public boolean agregarMedicamento(int medicamentoId, int cantidad){
        return MedicamentoServicio.agregarMedicamento(this.medicamentos, medicamentoId, cantidad);
    }
    public String generarReportes(){
        return ReporteServicio.generarReportes(this.doctores, this.pacientes, this.medicamentos, this.citas);
    }

    // =========================================
    // DOCTOR
    // =========================================
    public Doctor obtenerDoctorPorId(int id, String contra){
        return DoctorServicio.obtenerDoctorPorId(this.doctores, id, contra);
    }
    public String infoCita(int doctorId, int id){
        return CitaServicio.infoCita(this.citas, doctorId, id);
    }
    public String verCitasAsignadas(int doctorId){
        return CitaServicio.verCitasAsignadas(this.citas, doctorId);
    }
    public String irAConsulta(int doctorId, int citaId){
        return CitaServicio.irAConsulta(this.citas, doctorId, citaId);
    }

    public void cerrarSistema() {
        DoctorServicio.writeDoctorTxt(this.doctores);
        PacienteServicio.writePacienteTxt(this.pacientes);
        MedicamentoServicio.writeMedicamentoTxt(this.medicamentos);
        CitaServicio.writeCitasTxt(this.citas);
    }

}