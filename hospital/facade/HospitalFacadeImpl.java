package hospital.facade;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.recursos.Medicamentos.Medicamento;
import hospital.object.usuarios.Doctor;
import hospital.servicios.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HospitalFacadeImpl {
    protected ArrayList<Doctor> doctores = new ArrayList<>();
    protected ArrayList<Paciente> pacientes = new ArrayList<>();
    protected ArrayList<Medicamento> medicamentos = new ArrayList<>();
    protected ArrayList<Cita> citas = new ArrayList<>();

    public String cargarDatosIniciales() {
        try{
            this.doctores.addAll(DoctorServicio.leerDoctorTxt());
            this.pacientes.addAll(PacienteServicio.leerPacienteTxt());
            this.medicamentos.addAll(MedicamentoServicio.leerMedicamentos());
            this.citas.addAll(CitaServicio.leerCitaTxt(doctores, pacientes));
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
    public String mostrarPacientes(){
        try{
            return PacienteServicio.mostrarPacientes(this.pacientes);
        } catch (NullPointerException e){
            return "Error al mostrar los pacientes: " + e.getMessage();
        }
    }
    public Paciente registrarPaciente(String nombre, String sexo, int edad, boolean esEmbarazo, boolean esLactancia, boolean esGeriatria, boolean esInfancia){
        Paciente paciente = PacienteServicio.makePaciente(nombre, sexo, edad, esEmbarazo, esLactancia, esGeriatria, esInfancia);
        if(this.pacientes.add(paciente)){
            return paciente;
        }
        return null;
    }
    public Paciente obtenerPacientePorId(int id){
        return PacienteServicio.searchByIdPaciente(this.pacientes, id);
    }
    public boolean pedirCita(int pacienteId, int hora, int dia, int mes){
        return CitaServicio.pedirCita(this.doctores, this.pacientes, this.citas, pacienteId, hora, dia, mes);
    }
    public boolean cancelarCita(int pacienteId, int citaId){
        try{
            return CitaServicio.cancelarCita(this.citas, pacienteId, citaId);
        }catch (NullPointerException e){
            return false;
        }
    }
    public String verHistorialMedico(int pacienteId){
        String historial = PacienteServicio.pacienteExpediente(this.pacientes, pacienteId);
        if(historial == null){
            return "Paciente sin historial médico.";
        }
        return historial;
    }

    // =========================================
    // ADMIN
    // =========================================
    public String mostrarDoctores(){
        return DoctorServicio.mostrarDoctores(this.doctores);
    }
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
        try{
            return ReporteServicio.generarReportes(this.doctores, this.pacientes, this.medicamentos, this.citas);
        }catch(NoSuchElementException e) {
            return false;
        }
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
        try{
            return CitaServicio.verCitasAsignadas(this.citas, doctorId);
        }catch (NullPointerException e){
            return "No hay citas disponibles. ";
        }
    }
    public String irAConsulta(int doctorId, int citaId){
        return CitaServicio.irAConsulta(this.citas, doctorId, citaId);
    }

    public String cerrarSistema() {
        try{
            DoctorServicio.writeDoctorTxt(this.doctores);
            PacienteServicio.writePacienteTxt(this.pacientes);
            MedicamentoServicio.writeMedicamentoTXT(this.medicamentos);
            CitaServicio.escribirCitaTxt(this.citas);
            return "Saliendo... Los datos han sido guardados correctamente.";
        }catch (IOException e){
            return "Error al guardar los datos: " + e.getMessage();
        }
    }
}