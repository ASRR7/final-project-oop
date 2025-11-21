package hospital.servicios;

import hospital.files.reportes.*; 
import hospital.object.recursos.*;
import hospital.object.usuarios.*;
import hospital.object.pacientes.*;
import java.util.ArrayList;

public class ReporteServicio {
    public static void crearReporteCita(ArrayList<Cita> citas){
        CitaReporte.makeCsvReport(citas);
    }

    public static void crearReporteDoctor(ArrayList<Doctor> doctores){
        DoctorReporte.makeCsvReport(doctores);
    }

    public static void crearReporteHabitacion(ArrayList<Habitacion> habitaciones){
        HabitacionReporte.makeCsvReport(habitaciones);
    }

    public static void crearReportePaciente(ArrayList<Paciente> pacientes){
        PacienteReporte.makeCsvReport(pacientes);
    }
}
