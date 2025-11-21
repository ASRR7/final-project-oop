package hospital.servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import hospital.object.usuarios.Doctor;

    public class DoctorServicio 
    {
        public statc void leerDoctorTxt() {
            //Por implementar
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