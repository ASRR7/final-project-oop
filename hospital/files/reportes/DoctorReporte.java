package hospital.files.reportes;

import java.util.ArrayList;
import java.util.Date;
import java.io.FileWriter;
import hospital.object.usuarios.Doctor;


public class DoctorReporte {
    public static void makeReporte(ArrayList<Doctor> doctores) throws RuntimeException{

            try{
                Date date = new Date();
                String os = System.getProperty("os.name");
                String fileName = "Reporte-Doctores-" + Integer.toString(date.getDay())
                        + "-" + Integer.toString(date.getMonth())
                        + "-" + Integer.toString(date.getDay())
                        + "-" + Integer.toString(date.getHours())
                        + ":" + Integer.toString(date.getMinutes())
                        + ":" + Integer.toString(date.getSeconds())
                        + ".csv";
                String filePath = os.startsWith("Windows") ? "\\reportesDoctores\\" + fileName: "/reportesDoctores/" + fileName ;
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

            } catch (Exception e) {
                System.out.println("Ocurrió un error");
                e.printStackTrace();
                throw new RuntimeException(e);
            }


    }
    
}
