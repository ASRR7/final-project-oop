package hospital.servicios;

import hospital.object.usuarios.Doctor;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

    public class DoctorServicio {
        public static ArrayList<Doctor> leerDoctorTxt() throws IOException {
            String fileName = "Doctores.txt";
            String filePath = "../archivosTXT/" + fileName;
            ArrayList<Doctor> doctores = new ArrayList<>();
            try {
                Scanner fileIn = new Scanner(new FileReader(filePath)); 

                int doctoresHist = fileIn.nextInt();
                int doctoresActual = fileIn.nextInt();
                Doctor.numDoctoresHist = doctoresHist;
                Doctor.numDoctoresActual = doctoresActual;

                while (fileIn.hasNextLine()) {
                    String nombreDoctor     = fileIn.next();
                    String contraseña       = fileIn.next();
                    double sueldo           = fileIn.nextDouble();
                    String turno            = fileIn.next();
                    String especialidad     = fileIn.next();
                    Doctor doctor = new Doctor(nombreDoctor, contraseña, sueldo, turno, especialidad);
                    doctores.add(doctor);
                }


            } catch (IOException e) {
                throw new IOException(e);
            }
            return doctores;
        }

        public static void writeDoctorTxt(ArrayList<Doctor> Doctors) throws IOException {
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
                        contraseña      + espacio +
                        sueldo          + espacio +
                        turno           + espacio +
                        especialidad    + espacio +
                        lineBreak;
                        myWriter.write(doctorInfo);
                }
                myWriter.close();
            }catch (IOException e) {
                throw new IOException(e);
            }
        }
        
        public static Doctor searchByIdDoctor(ArrayList<Doctor> doctores, int id){
            for (Doctor doctor:doctores){
                if(doctor.getId() == id){
                    return doctor;
                }
            }
            return null;
        }

        public static Doctor searchByIdDoctor(ArrayList<Doctor> doctores, int id, String contra){
            for (Doctor doctor:doctores){
                if((doctor.getId() == id) && (doctor.getContrasena().equals(contra))){
                    return doctor;
                }
            }
            return null;
        }

        public static void addDoctor(ArrayList<Doctor> doctores, String nombre, String contrasena, double sueldo, String turno, String especialidad){
            Doctor nuevoDoctor = new Doctor(nombre, contrasena, sueldo, turno, especialidad);
            doctores.add(nuevoDoctor);
        }

        public static boolean removeDoctor(ArrayList<Doctor> doctores, int doctorId){
            Doctor doctorAEliminar = null;
            for(Doctor doctor:doctores){
                if(doctor.getId() == doctorId){
                    doctorAEliminar = doctor;
                    break;
                }
            }
            if(doctorAEliminar != null){
                doctores.remove(doctorAEliminar);
                return true;
            }
            return false;
        }
}