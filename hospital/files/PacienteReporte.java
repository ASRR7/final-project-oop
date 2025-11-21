package hospital.files;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import hospital.object.pacientes.Paciente;

public class PacienteReporte {
    public static void makeReporte(ArrayList<Paciente> pacientes) throws RuntimeException{

            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                                        "yyyy-MM-dd HH:mm:ss a");
                LocalDateTime now = LocalDateTime.now();
                String dateTimeString = now.format(formatter);
                String os = System.getProperty("os.name");
                String fileName = "Reporte-Pacientes-" + dateTimeString + ".csv";
                String filePath = "hospital/files/reportesPacientes/" + fileName ;
                File file = new File(filePath);
                file.createNewFile();
                FileWriter myWriter = new FileWriter(filePath);
                //nombre, contraseña, sueldo, turno, especialidad, doctoresHist, doctoresACtual
                myWriter.write("nombre,sexo,edad,estado,esEmbarazo,esLactancia,esGeriatria,esInfancia\n");
                String comma = ",";
                String lineBreak = "\n";

                for(Paciente paciente: pacientes){
                    String nombre = paciente.getNombre();
                    String sexo = paciente.getSexo();
                    String edad = Integer.toString(paciente.getEdad());
                    String esEmbarazo = paciente.getEsEmbarazo() ? "Si" : "No";
                    String esLactancia = paciente.getEsLactancia() ? "Si" : "No";
                    String esGeriatria = paciente.getEsGeriatria() ? "Si" : "No";
                    String esInfancia = paciente.getEsInfancia() ? "Si" : "No";
                    String estado = paciente.toString();
                    String csvField = nombre+comma +
                            sexo +comma +
                            edad + comma +
                            estado + comma +
                            esEmbarazo + comma +
                            esLactancia + comma +
                            esGeriatria + comma +
                            esInfancia + comma +
                            lineBreak;
                    myWriter.write(csvField);
                }
                myWriter.close();
            }
                

            catch(IOException e) {
                e.getMessage();
            }
            catch (Exception e) {
                System.out.println("Ocurrió un error");
                e.getMessage();
            }


    }
}

