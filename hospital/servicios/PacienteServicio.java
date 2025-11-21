package hospital.servicios;


import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import hospital.object.pacientes.Paciente;
import hospital.state.PacienteEnfermo;
import hospital.state.PacienteMuerto;
import hospital.state.PacienteSano;
import hospital.state.IPacienteState;

public class PacienteServicio {
    public static ArrayList <Paciente> leerPacienteTxt() {
        String fileName = "Pacientes.txt";
        String filePath = "../archivosTXT/" + fileName;
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
            System.out.println("Ocurrio un error al leer el archivo.");
        }
        return pacientes;
    }
    public static void writePacienteTxt(ArrayList<Paciente> Pacientes) {
        String fileName = "Pacientes.txt";
        String filePath = "../archivosTXT/" + fileName;
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
        System.out.println("Ocurrió un error al almacenar los dotores.");
        e.printStackTrace();
    }
    }


}
