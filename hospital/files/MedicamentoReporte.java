package hospital.files;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import hospital.object.recursos.Medicamentos.Medicamento;


public class MedicamentoReporte {
    public static void makeReporte(ArrayList<Medicamento> medicamentos) throws RuntimeException{

            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                                        "yyyy-MM-dd HH-mm-ss");
                LocalDateTime now = LocalDateTime.now();
                String dateTimeString = now.format(formatter);
                String fileName = "Reporte-Medicamentos-" + dateTimeString + ".csv";
                String filePath = "hospital/files/reportes/reportesMedicamentos/" + fileName ;
                File file = new File(filePath);
                file.createNewFile();
                FileWriter myWriter = new FileWriter(filePath);
                //nombre, contraseña, sueldo, turno, especialidad, doctoresHist, doctoresACtual
                myWriter.write("Nombre,Cantidad,EnEmbarazo,EnLactancia,EnGeriatria,EnInfancia\n");
                String comma = ",";
                String lineBreak = "\n";
                for(Medicamento medicamento: medicamentos){
                    String nombre = medicamento.getNombre();
                    String cantidad = Integer.toString(medicamento.getCantidad());
                    String enEmbarazo = medicamento.isEnEmbarazo() ? "Si" : "No";
                    String enLactancia = medicamento.isEnLactancia() ? "Si" : "No";
                    String enGeriatria = medicamento.isEnGeriatria() ? "Si" : "No";
                    String enInfancia = medicamento.isEnInfancia() ? "Si" : "No";

                    String medInfo = nombre+comma +
                            cantidad +comma +
                            enEmbarazo + comma +
                            enLactancia + comma +
                            enGeriatria + comma +
                            enInfancia + comma +
                            lineBreak;
                    myWriter.write(medInfo);
                }

                myWriter.close();
                System.out.println("Reporte creado con éxito");

            } 
            catch (IOException e) {


                throw new RuntimeException(e);
            }
            catch (Exception e) {

                throw new RuntimeException(e);
            }


    }
}
