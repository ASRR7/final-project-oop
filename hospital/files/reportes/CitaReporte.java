package hospital.files.reportes;

import hospital.object.recursos.Cita;

import java.awt.geom.Arc2D;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class CitaReporte {
    private static String[] meses = {"Enero","Febrero", "Marzo",
                            "Abril", "Mayo", "Junio",
                            "Julio", "Agosto", "Septiembre",
                            "Octubre", "Noviembre", "Diciembre"};



    public static void makeCsvReport(ArrayList<Cita> citas) throws RuntimeException{

        try {
            FileWriter myWriter = new FileWriter("filename.csv");
            myWriter.write("Id,Paciente,Doctor,Consultorio,Fecha,Hora\n");
            for(Cita cita: citas){
                String comma = ",";
                String lineBreak = "\n";
                String idCita = Integer.toString(cita.getId());
                String nombrePaciente = cita.getPaciente().getNombre();
                String nombreDoctor = cita.getDoctor().getNombre();
                String consultorio = Integer.toString(cita.getConsultorio());
                String fecha = Integer.toString(cita.getDia())+"-"+meses[cita.getMes()];
                String hora = Double.toString(cita.getHora());
                String csvField = idCita+comma +
                                nombrePaciente +comma +
                                nombreDoctor + comma +
                                consultorio + comma +
                                fecha + comma +
                                hora + comma +
                                lineBreak;
                myWriter.write(csvField);
            }
            myWriter.close();
            System.out.println("Successfully created file");
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}
