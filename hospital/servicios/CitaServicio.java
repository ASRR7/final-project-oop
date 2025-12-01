package hospital.servicios;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.usuarios.Doctor;
import hospital.state.ICitaState;
import hospital.state.citas.EstadoAgendada;
import hospital.state.citas.EstadoCancelada;
import hospital.state.citas.EstadoCompletada;
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
    public static ArrayList<Cita> leerCitaTxt(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes) throws IOException{
        String fileName = "Citas.txt";
        String filePath = "hospital/archivosTXT/" + fileName;
        ArrayList<Cita> citas = new ArrayList<>();
        try {
            Scanner fileIn = new Scanner(new FileReader(filePath));
            while (fileIn.hasNextInt()) {
                ICitaState estado = null;
                int hora = fileIn.nextInt();
                int dia = fileIn.nextInt();
                int mes = fileIn.nextInt();
                int consultorio = fileIn.nextInt();
                int idDoctor = fileIn.nextInt();
                int idPaciente = fileIn.nextInt();
                Paciente paciente = PacienteServicio.searchByIdPaciente(pacientes, idPaciente);
                Doctor doctor = DoctorServicio.searchByIdDoctor(doctores, idDoctor);
                String estadoCita = fileIn.next().trim(); 
                switch (estadoCita) {
                    case "Agendada":
                        estado = new EstadoAgendada();
                        break;
                    case "Completada":
                        estado = new EstadoCompletada();
                        break;
                    case "Cancelada":
                        estado = new EstadoCancelada();
                        break;
                }
                Cita cita = new Cita(hora, dia, mes, doctor, consultorio, paciente, estado);
                citas.add(cita);
            }

        } catch (IOException e) {
            throw new IOException(e);
        }
        return citas;
    }
//double hora, int dia, int mes, Doctor doctor , int consultorio, Paciente paciente
    public static void escribirCitaTxt(ArrayList<Cita> citas) throws IOException {
        String fileName = "Citas.txt";
        String filePath = "hospital/archivosTXT/" + fileName;
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
                String estado = c.getEstado().toString();

                String citaInfo = hora  + espacio
                        + dia           + espacio
                        + mes           + espacio
                        + consultorio   + espacio
                        + idDoctor      + espacio
                        + idPaciente    + espacio
                        + estado
                        + lineBreak;
                myWriter.write(citaInfo);
            }
            myWriter.close();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        } 
    }
    /*pedir cita reciba arraydoctores id paciente array paciente, array citas datos de hora dia y mes, aleatoriamente 
    asigna un doctor disponible en el array y consultorio aleatorio guarda la cita en el array de citas y retorna un booleano*/
    public static boolean pedirCita(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes, ArrayList<Cita> citas, int pacienteId, int hora, int dia, int mes){
        
        Random aleatorio = new Random();
        Paciente paciente = PacienteServicio.searchByIdPaciente(pacientes, pacienteId);
        int consultorio = aleatorio.nextInt(10) + 1;
        Doctor doctor = doctores.get(aleatorio.nextInt(doctores.size()));
        //aqui falta ampliar los state de citas  
        Cita cita = new Cita(hora, dia, mes, doctor, consultorio, paciente, new EstadoAgendada());
        paciente.agendarCita(paciente);
        citas.add(cita);
        return true;
    }

    public static boolean cancelarCita (ArrayList<Cita> citas, Paciente paciente, int citaId){
        for (Cita cita: citas){
            if(cita.getId() == citaId && cita.getPaciente().getId() == paciente.getId()){
                paciente.cancelarCita(paciente);
                cita.cancelar();
                return  true;
            }
        }
        return false;
    }

    public static String verCitasAsignadas (ArrayList<Cita> citas, int doctorId) throws NullPointerException {
        String espacio = " ";
        String citasDoctor = "Citas asignadas al doctor con ID: "+doctorId+":";
        try {
            for (Cita c : citas) {
                if (c.getDoctor().getId() == doctorId) {
                    citasDoctor += c.toString() + espacio;
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
        return citasDoctor;
    }

    public static String verCitasAsignadasPaciente(ArrayList<Cita> citas, int pacienteId) throws NullPointerException {
        String espacio = " ";
        String citasPaciente = "Citas asignadas al paciente con ID: " + pacienteId + ":";
        try {
            for (Cita c : citas) {
                if (c.getPaciente().getId() == pacienteId) {
                    citasPaciente += c.toString() + espacio;
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
        return citasPaciente;
    }

    public static String infoCita (ArrayList<Cita> citas, int doctorId, int citaId){
        String infoDeUnaCita = "Información de la cita con ID: "+citaId+": ";

        for (Cita c: citas){
            if(c.getId() == citaId && c.getDoctor().getId() == doctorId){
                infoDeUnaCita += c.toString();
                break;
            }
        }
        return infoDeUnaCita;
    }
    
    public static String irAConsulta (ArrayList<Cita> citas, int doctorId,  int citaId){
        String consultaInfo = "Iniciando consulta para la cita con ID: "+citaId+": ";
        for (Cita cita: citas){
            if(cita.getId() == citaId){
                consultaInfo += "Consulta iniciada para la cita: " + cita.toString();
                cita.completar();
                break; 
                // TODO : Agregar lógica con states
            }
        }
        return consultaInfo;    
    }
}