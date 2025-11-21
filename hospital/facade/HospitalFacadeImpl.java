package hospital.facade;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.medicamentos.Medicamento;
import hospital.object.usuarios.Admin;
import hospital.object.usuarios.Doctor;
import hospital.object.usuarios.Recepcionista;
import hospital.servicios.*;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class HospitalFacadeImpl {
    protected PacienteServicio pacienteServicio;
    protected DoctorServicio doctorServicio;
    protected CitaServicio citaServicio;
    protected MedicamentoServicio medicamentoServicio;

    public void cargarDatosIniciales() {
        // Cargar datos iniciales de doctores
        ArrayList<Doctor> doctores = new ArrayList<>();
        DoctorServicio.leerDoctorTxt(doctores);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        PacienteServicio.leerPacienteTxt(pacientes);
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        MedicamentoServicio.leerMedicamentoTxt(medicamentos);
    }

    public static void writeDoctorTxt(ArrayList<Doctor> Doctors) {
        String fileName = "Doctores.txt";
        String filePath = "../archivosTXT/" + fileName;
        String comma = ",";
        String lineBreak = "\n";
        try{
        FileWriter myWriter = new FileWriter(filePath);
        for(Doctor doctor: Doctors){
                    String nombreDoctor = doctor.getNombre();
                    String contraseña = doctor.getContrasena();
                    String sueldo = Double.toString(doctor.getSueldo());
                    String turno = doctor.getTurno();
                    String especialidad = doctor.getEspecialidad();
                    String doctoresHist = Integer.toString(Doctor.getNumDoctoresHist());
                    String doctoresActual = Integer.toString(Doctor.getNumDoctoresActual());
                    String doctorInfo = nombreDoctor+comma +
                            contraseña +comma +
                            sueldo + comma +
                            turno + comma +
                            especialidad + comma +
                            doctoresHist + comma +
                            doctoresActual + comma +
                            lineBreak;
                    myWriter.write(doctorInfo);
                }
                myWriter.close();
                System.out.println("Los datos de los doctores han sido almacenados correctamente.");
    
    }catch (IOException e) {
        System.out.println("Ocurrió un error al almacenar los dotores.");
        e.printStackTrace();
    }
    }

}