package hospital.servicios;

import hospital.files.*; 
import hospital.object.pacientes.*;
import hospital.object.recursos.*;
import hospital.object.recursos.Medicamentos.Medicamento;
import hospital.object.usuarios.*;
import java.util.ArrayList;

public class ReporteServicio {
    public static void crearReporteCita(ArrayList<Cita> citas){
        CitaReporte.makeCsvReport(citas);
    }

    public static void crearReporteDoctor(ArrayList<Doctor> doctores){
        DoctorReporte.makeReporte(doctores);
    }

    public static void crearReporteHabitacion(ArrayList<Habitacion> habitaciones){
        HabitacionReporte.makeReporte(habitaciones);
    }

    public static void crearReportePaciente(ArrayList<Paciente> pacientes){
        PacienteReporte.makeReporte(pacientes);
    }

    public static boolean generarReportes(ArrayList<Doctor>doctores, ArrayList<Paciente>pacientes, ArrayList<Medicamento>medicamentos, ArrayList<Cita>citas){
        try{
            crearReporteCita(citas);
            // crearReporteDoctor(doctores);
            // crearReportePaciente(pacientes);
            return true;
        } catch (Exception e){
            System.out.println(e);
            return false;
        }
    }
}
