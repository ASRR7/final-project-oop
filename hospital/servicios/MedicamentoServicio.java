package hospital.servicios;

import hospital.object.recursos.Medicamentos.Medicamento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MedicamentoServicio {
    public static ArrayList <Medicamento> leerMedicamentos() throws RuntimeException {
        String fileName = "Medicamentos.txt";
        String filePath = "../archivosTXT/" + fileName;
        ArrayList<Medicamento> medicamentos = new ArrayList<>();
        try {
            
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split(",");
                String nombre = info[0];
                int cantidad = Integer.parseInt(info[1]); 
                Boolean esEmbarazo = info[2].equals("Si");
                Boolean esLactancia = info[3].equals("Si");
                Boolean esGeriatria = info[4].equals("Si");
                Boolean esInfancia = info[5].equals("Si");
                medicamentos.add(new Medicamento(nombre, cantidad, esEmbarazo, esLactancia, esGeriatria, esInfancia));
            
                medicamentos.add(new Medicamento(nombre,cantidad, esEmbarazo, esLactancia, esGeriatria, esInfancia));
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return medicamentos;
    }
    public static void writeMedicamentoTXT(ArrayList<Medicamento> medicamentos) throws RuntimeException {
        String fileName = "Medicamentos.txt";
        String filePath = "../archivosTXT/" + fileName;
        String comma = ",";
        String lineBreak = "\n";
        try{
            //tring nombre, int cantidad, boolean enEmbarazo, boolean enLactancia, boolean enGeriatria, boolean enInfancia
        FileWriter myWriter = new FileWriter(filePath);
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
                
    
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //method to add n medicamentos
    public static boolean addMedicamentos(ArrayList<Medicamento> medicamentos, int n, int id) {
        if (n<=0) {
            return false;
        }
        for (Medicamento medicamento: medicamentos) {
            if (medicamento.getId() == id) {
                medicamento.setCantidad(medicamento.getCantidad() + n);
                return true;
            }
        }
        return false;
    }

    public static String medicamentosString(ArrayList<Medicamento> medicamentos) {
        String medicamentosString = "";
        for (Medicamento medicamento: medicamentos) {
            medicamentosString += medicamento.toString() + "\n";
        }
        return medicamentosString;
    }
}
