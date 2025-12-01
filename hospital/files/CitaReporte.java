package hospital.files;

import hospital.object.recursos.Cita;


import java.time.LocalDateTime;
import java.io.File;
import java.time.format.*;
import java.util.ArrayList;
import java.io.FileWriter;


public class CitaReporte {
    private static String[] meses = {"Enero","Febrero", "Marzo",
                            "Abril", "Mayo", "Junio",
                            "Julio", "Agosto", "Septiembre",
                            "Octubre", "Noviembre", "Diciembre"};


    /**
     * <h1>makeCsvReport</h1>
     * Crea un reporte en formato CSV con la información de cada cita proporcionada
     * @param citas
     * @throws RuntimeException
     */
    public static void makeCsvReport(ArrayList<Cita> citas) throws RuntimeException{

        try {
            String os = System.getProperty("os.name");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(
                                        "yyyy-MM-dd HH-mm-ss");
            LocalDateTime now = LocalDateTime.now();
            String dateTimeString = now.format(formatter);
            String fileName = "Reporte-Citas-" + dateTimeString + ".csv";
            String filePath = "hospital/files/reportes/reportesCitas/" + fileName ;
            File file = new File(filePath);
            file.createNewFile();
            FileWriter myWriter = new FileWriter(filePath);
            myWriter.write("Id,Paciente,Doctor,Consultorio,Fecha,Hora,Estado\n");
            String comma = ",";
            String lineBreak = "\n";
            for(Cita cita: citas){

                String idCita = Integer.toString(cita.getId());
                String nombrePaciente = cita.getPaciente().getNombre();
                String nombreDoctor = cita.getDoctor().getNombre();
                String consultorio = Integer.toString(cita.getConsultorio());
                String fecha = Integer.toString(cita.getDia())+"-"+meses[cita.getMes()];
                String estado = cita.getEstado().toString();
                String hora = Double.toString(cita.getHora());
                String csvField = idCita+comma +
                                nombrePaciente +comma +
                                nombreDoctor + comma +
                                consultorio + comma +
                                fecha + comma +
                                hora + comma +
                                estado + comma +
                                lineBreak;
                myWriter.write(csvField);
            }
            myWriter.close();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
    }
    
}
