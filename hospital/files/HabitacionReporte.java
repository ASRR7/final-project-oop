package hospital.files;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.*;
import java.util.ArrayList;
import hospital.object.recursos.Habitacion;
import hospital.object.usuarios.Doctor;


public class HabitacionReporte {
    public static void makeReporte(ArrayList<Habitacion> habitaciones) throws RuntimeException{

            try{
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                                        "yyyy-MM-dd HH-mm-ss");
                LocalDateTime now = LocalDateTime.now();
                String dateTimeString = now.format(formatter);
                String os = System.getProperty("os.name");
                String fileName = "Reporte-Habitaciones-" + dateTimeString + ".csv";
                String filePath =  "hospital/files/reportes/reportesHabitaciones/" + fileName ;
                File file = new File(filePath);
                file.createNewFile();
                FileWriter myWriter = new FileWriter(filePath);
                //nombre, contraseña, sueldo, turno, especialidad, doctoresHist, doctoresACtual
                myWriter.write("Piso,Pasillo,NumCamas,Disponible\n");
                String comma = ",";
                String lineBreak = "\n";

                for(Habitacion habitacion: habitaciones){
                    String piso = Integer.toString(habitacion.getPiso());
                    String pasillo = Integer.toString(habitacion.getPasillo());
                    String numCamas = Integer.toString(habitacion.getNumCamas());
                    String disponible = habitacion.getEstado().isDisponible() ? "Disponible" : "No disponible";
                    String csvField = piso+comma +
                            pasillo +comma +
                            numCamas + comma +
                            disponible + comma +
                            lineBreak;
                    myWriter.write(csvField);
                }
                myWriter.close();
                System.out.println("Reporte creado con éxito");

            } 
            catch (IOException e) {

                e.getMessage();
                throw new RuntimeException(e);
            }
            catch (Exception e) {

                e.getMessage();
                throw new RuntimeException(e);
            }


    }
}
