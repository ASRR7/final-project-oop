package hospital.servicios;


import hospital.object.pacientes.Paciente;
import hospital.state.IPacienteState;
import hospital.state.PacienteEnfermo;
import hospital.state.PacienteMuerto;
import hospital.state.PacienteSano;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class PacienteServicio {
    public static Paciente makePaciente(String nombre, String sexo, int edad, boolean esEmbarazo, boolean esLactancia, boolean esGeriatria, boolean esInfancia) throws RuntimeException{
        return new Paciente(nombre, sexo, edad, new PacienteEnfermo(), esEmbarazo, esLactancia, esGeriatria, esInfancia);
    }
    public static ArrayList <Paciente> leerPacienteTxt() throws RuntimeException{
        String fileName = "Pacientes.txt";
        String filePath = "hospital/archivosTXT/" + fileName;
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
            
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                String nombre = info[0];
                String sexo = info[1];  
                int edad = Integer.parseInt(info[2]);
                String estado = info[3];
                IPacienteState pacienteEstado = null;
                boolean esEmbarazo = info[4].equals("Si");
                boolean esLactancia = info[5].equals("Si");
                boolean esGeriatria = info[6].equals("Si");
                boolean esInfancia = info[7].equals("Si");
                switch (estado) {
                    case "El paciente esta Enfermo":
                        pacienteEstado = new PacienteEnfermo();
                        break;
                    case "El paciente esta Sano":
                        pacienteEstado = new PacienteSano();
                        break;
                    case "El paciente esta Muerto":
                        pacienteEstado = new PacienteMuerto();
                        break;
                }
                pacientes.add(new Paciente(nombre, sexo, edad, pacienteEstado, esEmbarazo, esLactancia, esGeriatria, esInfancia));
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pacientes;
    }
    public static void writePacienteTxt(ArrayList<Paciente> Pacientes) throws RuntimeException{
        String fileName = "Pacientes.txt";
        String filePath = "hospital/archivosTXT/" + fileName;
        String comma = ",";
        String lineBreak = "\n";
        try{
        FileWriter myWriter = new FileWriter(filePath);
        for(Paciente paciente: Pacientes){
                    String nombre = paciente.getNombre();
                    String sexo = paciente.getSexo();
                    String edad = Integer.toString(paciente.getEdad());
                    String esEmbarazo = paciente.getEsEmbarazo() ? "Si" : "No";
                    String esLactancia = paciente.getEsLactancia() ? "Si" : "No";
                    String esGeriatria = paciente.getEsGeriatria() ? "Si" : "No";
                    String esInfancia = paciente.getEsInfancia() ? "Si" : "No";
                    String estado = paciente.toString();
                    String pacienteInfo = nombre+comma +
                            sexo +comma +
                            edad + comma +
                            estado + comma +
                            esEmbarazo + comma +
                            esLactancia + comma +
                            esGeriatria + comma +
                            esInfancia + comma +
                            lineBreak;
                    myWriter.write(pacienteInfo);
                }
                myWriter.close();
                System.out.println("Los datos de los doctores han sido almacenados correctamente.");
    
    }catch (IOException e) {
        e.printStackTrace();
    }
    }

    public static Paciente searchByIdPaciente(ArrayList<Paciente> pacientes, int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente;
            }
        }
        return null;
    }

    public static String pacienteExpediente(ArrayList<Paciente> pacientes, int id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getId() == id) {
                return paciente.getExpediente().toString();
            }
        }
        return null;
    }

    public static String mostrarPacientes(ArrayList<Paciente> pacientes) {
        String nombreIdPaciente = ("Lista de Pacientes:\n");
        for (Paciente p : pacientes) {
            nombreIdPaciente += ("Nombre: " + p.getNombre() + "\tID: " + p.getId() + "\n");
        }
        return nombreIdPaciente;
    }
}
