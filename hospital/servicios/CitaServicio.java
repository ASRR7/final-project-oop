package hospital.servicios;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.usuarios.Doctor;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*private double hora;
    private int dia;
    private int mes;
    private Doctor doctor;
    private int consultorio;
    private Paciente paciente;
    private int Id;*/
public class CitaServicio {
    public static ArrayList<Cita> leerCitaTxt(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes) {
        String fileName = "Cita.txt";
        String filePath = "../archivosTXT/" + fileName;
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            Scanner fileIn = new Scanner(new FileReader(filePath));
            while (fileIn.hasNextLine()) {
                double hora = fileIn.nextInt();
                int dia = fileIn.nextInt();
                int mes = fileIn.nextInt();
                int consultorio = fileIn.nextInt();
                int idDoctor = fileIn.nextInt();
                int idPaciente = fileIn.nextInt();
                Paciente paciente = PacienteServicio.searchByIdPaciente(pacientes, idPaciente);
                Doctor doctor = DoctorServicio.searchByIdDoctor(doctores, idDoctor);
                Cita cita = new Cita(hora, dia, mes, doctor, consultorio, paciente);
                citas.add(cita);
            }

        } catch (IOException e) {
            System.out.println("Error al leer Doctores.txt");
            e.printStackTrace();
        }
        return citas;
    }
//double hora, int dia, int mes, Doctor doctor , int consultorio, Paciente paciente
    public static void writeDoctorTxt(ArrayList<Cita> citas) {
        String fileName = "Cita.txt";
        String filePath = "../archivosTXT/" + fileName;
        String espacio = " ";
        String lineBreak = "\n";
        try {
            FileWriter myWriter = new FileWriter(filePath);

            for (Cita c : citas) {
                int hora = c.getHora();
                int dia = c.getDia();
                int mes = c.getMes();
                int consultorio = c.getConsultorio();
                int idDoctor = c.getDoctor().getId();
                int idPaciente = c.getPaciente().getId();

                String citaInfo = hora  + espacio
                        + dia           + espacio
                        + mes           + espacio
                        + consultorio   + espacio
                        + idDoctor      + espacio
                        + idPaciente    + espacio
                        + lineBreak;
                myWriter.write(citaInfo);
            }
            myWriter.close();
            System.out.println("Los datos de las citas han sido almacenados correctamente.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al almacenar las citas.");
            e.printStackTrace();
        }
    }
    /*pedir cita reciba arraydoctores id paciente array paciente, array citas datos de hora dia y mes, aleatoriamente 
    asigna un doctor disponible en el array y consultorio aleatorio guarda la cita en el array de citas y retorna un booleano*/
    public boolean pedirCita(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes, ArrayList<Cita> citas, int pacienteId, double hora, int dia, int mes){
        
        Random aleatorio = new Random();
        Paciente paciente = PacienteServicio.searchByIdPaciente(pacientes, pacienteId);
        //Cita(hora, dia, mes, doctor, consultorio, paciente);
        int hora = aleatorio.nextInt(10) + 1;
        do { 
            
        } while (true);
        if (paciente == null){
            return false;
        }
        //buscar doctor disponible
        if (doctores.size() == 0){
            return false;
        }
        Doctor doctor = doctores.get(0); //selecciona el primer doctor disponible
        
        int consultorio = (int)(Math.random()*10)+1; //consultorio aleatorio entre 1 y 10
        Cita cita = new Cita(hora, dia, mes, doctor, consultorio, paciente);
        citas.add(cita);
        return true;
    }
}
