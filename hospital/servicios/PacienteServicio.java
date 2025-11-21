package hospital.servicios;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import hospital.object.pacientes.Paciente;

public class PacienteServicio {
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
