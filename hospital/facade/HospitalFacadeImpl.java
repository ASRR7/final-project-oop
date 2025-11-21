package hospital.facade;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.recursos.Medicamentos.Medicamento;
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

    public String cargarDatosIniciales() {
        try{
            //this.doctores = DoctorServicio.leerDoctorTxt();
            this.pacientes = PacienteServicio.leerPacienteTxt();
            this.medicamentos = MedicamentoServicio.leerMedicamentos();
            this.citas = CitaServicio.leerCitaTxt(doctores, pacientes);
            return "Datos iniciales cargados correctamente.";
        } catch (RuntimeException e){
            return "Error al momento de leer los archivos: " + e.getMessage();
        }
        catch (IOException e){
            return "Error al cargar los datos iniciales: " + e.getMessage();
        }
        catch (Exception e){
            return "Error inesperado: " + e.getMessage();
        }
    }
    // =========================================
    // PACIENTES
    // =========================================
    public Paciente registrarPaciente(String nombre, String sexo, int edad, boolean esEmbarazo, boolean esLactancia, boolean esGeriatria, boolean esInfancia){
        return PacienteServicio.makePaciente(nombre, sexo, edad, esEmbarazo, esLactancia, esGeriatria, esInfancia);
    }
    public Paciente obtenerPacientePorId(int id){
        return PacienteServicio.searchByIdPaciente(this.pacientes, id);
    }
    public boolean pedirCita(int pacienteId, int hora, int dia, int mes){
        return CitaServicio.pedirCita(this.doctores, this.pacientes, this.citas, pacienteId, hora, dia, mes);
    }
    public boolean cancelarCita(int pacienteId, int citaId){
        return CitaServicio.cancelarCita(this.citas, pacienteId, citaId);
    }
    public String verHistorialMedico(int pacienteId){
        return PacienteServicio.pacienteExpediente(this.pacientes, pacienteId);
    }

    // =========================================
    // ADMIN
    // =========================================
    public void agregarDoctor(String nombre, String contrasena, double sueldo, String turno, String especialidad){
        DoctorServicio.addDoctor(this.doctores, nombre, contrasena, sueldo, turno, especialidad);
    }
    public boolean removerDoctor(int doctorId){
        return DoctorServicio.removeDoctor(this.doctores, doctorId);
    }
    public String verMedicamentos(){
        return MedicamentoServicio.medicamentosString(this.medicamentos);
    }
    public boolean agregarMedicamento(int medicamentoId, int cantidad){
        return MedicamentoServicio.addMedicamentos(this.medicamentos, cantidad, medicamentoId);
    }
    public boolean generarReportes(){
        return ReporteServicio.generarReportes(this.doctores, this.pacientes, this.medicamentos, this.citas);
    }

    // =========================================
    // DOCTOR
    // =========================================
    public Doctor obtenerDoctorPorId(int id, String contra){
        return DoctorServicio.searchByIdDoctor(this.doctores, id, contra);
    }
    public String infoCita(int doctorId, int citaId){
        return CitaServicio.infoCita(this.citas, doctorId, citaId);
    }
    public String verCitasAsignadas(int doctorId){
        return CitaServicio.verCitasAsignadas(this.citas, doctorId);
    }
    public String irAConsulta(int doctorId, int citaId){
        return CitaServicio.irAConsulta(this.citas, doctorId, citaId);
    }

    public void cerrarSistema() {
        try{
            DoctorServicio.writeDoctorTxt(this.doctores);
            PacienteServicio.writePacienteTxt(this.pacientes);
            MedicamentoServicio.writeMedicamentoTXT(this.medicamentos);
            CitaServicio.escribirCitaTxt(this.citas);
        }catch (IOException e){
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }
}