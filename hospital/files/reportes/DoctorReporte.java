package hospital.files.reportes;

import hospital.object.usuarios.Doctor;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;


public class DoctorReporte {
    public static void makeReporte(ArrayList<Doctor> doctores) throws RuntimeException{

            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                                        "yyyy-MM-dd HH:mm:ss a");
                LocalDateTime now = LocalDateTime.now();
                String dateTimeString = now.format(formatter);
                String os = System.getProperty("os.name");
                String fileName = "Reporte-Doctores-" + dateTimeString + ".csv";
                String filePath = "/reportesDoctores/" + fileName ;
                FileWriter myWriter = new FileWriter(filePath);
                //nombre, contraseña, sueldo, turno, especialidad, doctoresHist, doctoresACtual
                myWriter.write("Doctor,Contraseña,Sueldo,Turno,Especialidad,NumHist,NumActual\n");
                String comma = ",";
                String lineBreak = "\n";

                for(Doctor doctor: doctores){
                    String nombreDoctor = doctor.getNombre();
                    String contraseña = doctor.getContrasena();
                    String sueldo = Double.toString(doctor.getSueldo());
                    String turno = doctor.getTurno();
                    String especialidad = doctor.getEspecialidad();
                    String doctoresHist = Integer.toString(Doctor.getNumDoctoresHist());
                    String doctoresActual = Integer.toString(Doctor.getNumDoctoresActual());
                    String csvField = nombreDoctor+comma +
                            contraseña +comma +
                            sueldo + comma +
                            turno + comma +
                            especialidad + comma +
                            doctoresHist + comma +
                            doctoresActual + comma +
                            lineBreak;
                    myWriter.write(csvField);
                }
                myWriter.close();
                System.out.println("Reporte creado con éxito");

            } 
            catch (IOException e) {
                System.out.println("No se encontró el archivo");
                e.getMessage();
            }
            catch (Exception e) {
                System.out.println("Ocurrió un error");
                e.getMessage();
            }


    }
    
}
