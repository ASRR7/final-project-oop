package hospital.servicios;

import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

import hospital.object.usuarios.Doctor;

    public class DoctorServicio 
    {
        public static void leerDoctorTxt(ArrayList<Doctor> doctores) {
            String fileName = "Doctores.txt";
            String filePath = "../archivosTXT/" + fileName;
            try {
                Scanner fileIn = new Scanner(new FileReader(filePath)); 
                int doctoresHist = fileIn.nextInt();
                int doctoresActual = fileIn.nextInt();
                Doctor.numDoctoresHist = doctoresHist;
                Doctor.numDoctoresActual = doctoresActual;
                while (fileName.hasNextLine()) {
                    String nombreDoctor = fileIn.next();
                    String contraseña = fileIn.next();
                    double sueldo = fileIn.nextDouble();
                    String turno = fileIn.next();
                    String especialidad = fileIn.next();
                    Doctor doctor = new Doctor(nombreDoctor, contraseña, sueldo, turno, especialidad);
                    doctores.add(doctor);
                }
            } catch (IOException e) {
                System.out.println("Error al leer Doctores.txt");
                e.printStackTrace();
            }
        }

        public static void writeDoctorTxt(ArrayList<Doctor> Doctors) {
            String fileName = "Doctores.txt";
            String filePath = "../archivosTXT/" + fileName;
            String espacio = " "; 
            String lineBreak = "\n";
            try{
                FileWriter myWriter = new FileWriter(filePath);
                String doctoresHist = Integer.toString(Doctor.getNumDoctoresHist());
                String doctoresActual = Integer.toString(Doctor.getNumDoctoresActual());
                String doctorEstadistica = (doctoresHist+espacio+doctoresActual+lineBreak);  
                myWriter.write(doctorEstadistica);
                for(Doctor doctor: Doctors){
                    String nombreDoctor = doctor.getNombre();
                    String contraseña = doctor.getContrasena();
                    String sueldo = Double.toString(doctor.getSueldo());
                    String turno = doctor.getTurno();
                    String especialidad = doctor.getEspecialidad();
                    
                    String doctorInfo = nombreDoctor+espacio +
                        contraseña +espacio +
                        sueldo + espacio +
                        turno + espacio +
                        especialidad + espacio +
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