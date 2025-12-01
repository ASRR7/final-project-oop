package hospital.servicios;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Cita;
import hospital.object.recursos.Medicamentos.Medicamento;
import hospital.object.usuarios.Doctor;
import hospital.state.ICitaState;
import hospital.state.PacienteMuerto;
import hospital.state.PacienteSano;
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
    /**
     * <h1>leerCitaTxt</h1>
     * Lee desde el archivo de texto todas las citas registradas en el sistema y
     * las convierte en objetos de tipo Cita.
     *
     * Este método abre el archivo "Citas.txt" ubicado en la ruta
     * "hospital/archivosTXT/" y, a partir de cada línea, recupera la
     * información necesaria para construir la cita: hora, día, mes,
     * consultorio, id del doctor, id del paciente y estado de la cita.
     *
     * Con el id del doctor y del paciente se buscan los objetos
     * correspondientes en las listas proporcionadas. El estado de la cita se
     * traduce a una implementación de ICitaState (EstadoAgendada,
     * EstadoCompletada o EstadoCancelada), que se asigna a cada objeto Cita
     * creado.
     *
     * @param doctores lista de doctores previamente cargados, utilizada para
     * asociar cada cita con su Doctor.
     * @param pacientes lista de pacientes previamente cargados, utilizada para
     * asociar cada cita con su Paciente.
     * @return una lista con todas las citas leídas y construidas a partir del
     * archivo.
     * @throws IOException si ocurre un error al abrir o leer el archivo de
     * citas.
     * @version 3
     * @author Equipo 13
     */
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
    /**
     * <h1>escribirCitaTxt</h1>
     * Escribe en el archivo de texto todas las citas registradas en el sistema.
     *
     * Este método reemplaza por completo el contenido del archivo
     * "hospital/archivosTXT/Citas.txt" y guarda en él la información de cada
     * cita en una sola línea. Los datos se escriben en el siguiente orden:
     * hora, día, mes, consultorio, id del doctor, id del paciente y estado de
     * la cita.
     *
     * Cada cita se transforma en una cadena de texto formateada y luego se
     * almacena línea por línea en el archivo correspondiente.
     *
     * @param citas lista que contiene todos los objetos Cita que deben ser
     * guardados.
     * @throws IOException si ocurre un error durante la apertura o escritura
     * del archivo.
     * @version 3
     * @author Equipo 13
     */
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
    /**
     * <h1>pedirCita</h1>
     * Crea una nueva cita para un paciente.
     *
     * Busca al paciente por su id, asigna un doctor y un consultorio al azar,
     * crea la cita en estado Agendada y la agrega a la lista de citas.
     *
     * @param doctores lista de doctores disponibles.
     * @param pacientes lista de pacientes registrados.
     * @param citas lista donde se guardan todas las citas.
     * @param pacienteId id del paciente que solicita la cita.
     * @param hora hora programada.
     * @param dia día programado.
     * @param mes mes programado.
     * @return true si la cita se creó correctamente.
     * @version 3
     */
    public static boolean pedirCita(ArrayList<Doctor> doctores, ArrayList<Paciente> pacientes, ArrayList<Cita> citas, int pacienteId, int hora, int dia, int mes){
        
        Random aleatorio = new Random();
        Paciente paciente = PacienteServicio.searchByIdPaciente(pacientes, pacienteId);
        int consultorio = aleatorio.nextInt(10) + 1;
        Doctor doctor = doctores.get(aleatorio.nextInt(doctores.size()));
        //aqui falta ampliar los state de citas  
        Cita cita = new Cita(hora, dia, mes, doctor, consultorio, paciente, new EstadoAgendada());
        citas.add(cita);
        return true;
    }

    /**
     * <h1>cancelarCita</h1>
     * Cancela una cita que pertenece a un paciente.
     *
     * Este método busca en la lista de citas aquella que tenga el mismo id que
     * el indicado y que además esté asignada al paciente dado. Si ambas
     * condiciones se cumplen, se llama al método de cancelación del paciente y
     * al método de cancelación de la cita, actualizando sus estados mediante el
     * patrón State.
     *
     * Si la cita no existe o no pertenece al paciente, no se realiza ningún
     * cambio.
     *
     * @param citas lista de todas las citas del sistema.
     * @param paciente paciente dueño de la cita a cancelar.
     * @param citaId id de la cita que se desea cancelar.
     * @return true si la cita se encontró y fue cancelada; false en caso
     * contrario.
     * @version 3
     * @author Equipo 13
     */
    public static boolean cancelarCita (ArrayList<Cita> citas, Paciente paciente, int citaId){
        for (Cita cita: citas){
            System.out.println("CAda cita " + cita.getId() + " id: " + citaId + "; cliente: " + cita.getPaciente().getId() + " iDc: " + paciente.getId());
            if(cita.getId() == citaId && cita.getPaciente().getId() == paciente.getId()){
                paciente.cancelarCita(paciente);
                cita.cancelar();
                return true;
            }
        }
        return false;
    }
    /**
     * <h1>verCitasAsignadas</h1>
     * Devuelve todas las citas asignadas a un doctor.
     *
     * Recorre la lista de citas y agrega a un texto aquellas cuyo doctor tenga
     * el id indicado. Si ocurre un error por datos nulos, se lanza una
     * excepción.
     *
     * @param citas lista de todas las citas del sistema.
     * @param doctorId id del doctor cuyas citas se quieren ver.
     * @return texto con todas las citas asignadas al doctor.
     * @throws NullPointerException si ocurre un acceso nulo durante la
     * búsqueda.
     * @version 3
     */
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
    /**
     * <h1>verCitasAsignadasPaciente</h1>
     * Devuelve todas las citas registradas para un paciente.
     *
     * Recorre la lista de citas y agrega en un texto aquellas cuyo paciente
     * tenga el id indicado. Si ocurre un acceso nulo durante la búsqueda, se
     * lanza una excepción.
     *
     * @param citas lista de todas las citas del sistema.
     * @param pacienteId id del paciente cuyas citas se desean consultar.
     * @return texto con todas las citas asignadas al paciente.
     * @throws NullPointerException si ocurre un acceso nulo durante la lectura.
     * @version 3
     */
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
    /**
     * <h1>infoCita</h1>
     * Obtiene la información de una cita específica asignada a un doctor.
     *
     * Busca en la lista de citas aquella que coincida con el id de la cita y el
     * id del doctor. Si la encuentra, agrega su información al texto de salida;
     * si no, se devuelve solo el encabezado.
     *
     * @param citas lista de todas las citas del sistema.
     * @param doctorId id del doctor al que debe pertenecer la cita.
     * @param citaId id de la cita que se desea consultar.
     * @return texto con la información de la cita si existe, o solo el
     * encabezado si no se encuentra.
     * @version 3
     */
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
    /**
     * <h1>irAConsulta</h1>
     * Atiende una cita y devuelve el resultado de la consulta.
     *
     * Busca la cita indicada por su id y muestra su información. Luego, se
     * genera un resultado aleatorio: el paciente puede fallecer o recuperarse.
     * Si se recupera, se asigna un medicamento también de forma aleatoria y se
     * descuenta la cantidad disponible.
     *
     * El estado del paciente cambia según el resultado y la cita se marca como
     * completada. Si ocurre un acceso nulo durante el proceso, se lanza una
     * excepción.
     *
     * @param citas lista de todas las citas registradas.
     * @param medicamentos lista de medicamentos disponibles.
     * @param doctorId id del doctor que atiende la consulta.
     * @param citaId id de la cita que se desea atender.
     * @return texto con el resultado completo de la consulta.
     * @throws NullPointerException si ocurre un acceso nulo en los datos
     * utilizados.
     * @version 3
     */
    public static String irAConsulta (ArrayList<Cita> citas, ArrayList<Medicamento> medicamentos, int doctorId,  int citaId)throws NullPointerException{
        String consultaInfo = "Iniciando consulta para la cita con ID: "+citaId+": ";
        Random aleatorio = new Random(); 
        int medicinaId, probaMuerte, numMedicaentos; 
        try {
            for (Cita cita : citas) {
                if (cita.getId() == citaId) {
                    consultaInfo += "Consulta iniciada para la cita: " + cita.toString();
                    probaMuerte = aleatorio.nextInt(100);
                    if (probaMuerte <= 20) {
                        consultaInfo += "\nEl paciente ha fallecido durante la consulta.";
                        cita.getPaciente().setState(new PacienteMuerto());
                        cita.completar();
                        return consultaInfo;
                    } else {
                        medicinaId = aleatorio.nextInt(medicamentos.size());
                        consultaInfo += "\nEl paciente se ha curado, tiene que comprar el medicamento: " + medicamentos.get(medicinaId).getNombre();
                        numMedicaentos = aleatorio.nextInt(5) + 1;
                        int medicamentosDisponibles = medicamentos.get(medicinaId).getCantidad();
                        if (numMedicaentos > medicamentosDisponibles) {
                            consultaInfo += "\nNo hay suficientes medicamentos disponibles. Solo se pueden comprar " + medicamentosDisponibles + " unidades.";
                            numMedicaentos = medicamentosDisponibles;
                        } else {
                            consultaInfo += "\nSe han comprado " + numMedicaentos + " unidades del medicamento.";
                        }
                        medicamentos.get(medicinaId).setCantidad(medicamentos.get(medicinaId).getCantidad() - numMedicaentos);

                        cita.getPaciente().setState(new PacienteSano());
                        cita.completar();
                    }
                    break;
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
        return consultaInfo;    
    }
}