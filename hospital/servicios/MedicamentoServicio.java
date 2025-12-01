package hospital.servicios;

import hospital.object.recursos.Medicamentos.Medicamento;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class MedicamentoServicio {
    /**
     * <h1>makeMedicamento</h1>
     * Crea un medicamento a partir de los datos proporcionados y lo devuelve
     * @param nombre
     * @param cantidad
     * @param enEmbarazo
     * @param enLactancia
     * @param enGeriatria
     * @param enInfancia
     * @return Medicamento
     * @throws RuntimeException
     */
    public static Medicamento makeMedicamento(String nombre, int cantidad, boolean enEmbarazo, boolean enLactancia, boolean enGeriatria, boolean enInfancia) throws RuntimeException {
        return new Medicamento ( nombre, cantidad, enEmbarazo, enLactancia, enGeriatria, enInfancia);
    }

    /**
     * <h1>leerMedicamentos</h1>
     * Lee los medicamentos desde el archivo Medicamentos.txt, los agrega a un ArrayList y devuelve dicho ArrayList
     * @return ArrayList<Medicamento>
     * @throws RuntimeException
     */
    public static ArrayList <Medicamento> leerMedicamentos() throws RuntimeException {
        String fileName = "Medicamentos.txt";
        String filePath = "hospital/archivosTXT/" + fileName;
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
            

            }
            bufferedReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        return medicamentos;
    }
    /**
     * <h1>writeMedicamentoTXT</h1>
     * Tomando como base un ArrayList de Medicamentos, los añade a Medicamentos.txt para que puedan ser leidos posteriormente
     * @param ArrayList<Medicamento> medicamentos
     * @throws RuntimeException
     */
    public static void writeMedicamentoTXT(ArrayList<Medicamento> medicamentos) throws RuntimeException {
        String fileName = "Medicamentos.txt";
        String filePath = "hospital/archivosTXT/" + fileName;
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

    /**
     * <h1>addMedicamentos</h1>
     * Añade una cantidad dada de un medicamento (accedido por su Id) existente en el ArrayList de medicamentos.
     * Devuelve un booleano correspondiente a si se encontró el medicamento y se añadió la cantidad, validando que esta sea mayor a 0.
     * @param medicamentos
     * @param n
     * @param id
     * @return boolean
     */
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
    /**
     * <h1>medicamentosString</h1>
     * Devuelve un String correspondiente a la concatenación de cada método toString() de cada medicamento
     * @param ArrayList<Medicamento> medicamentos
     * @return String
     */
    public static String medicamentosString(ArrayList<Medicamento> medicamentos) {
        String medicamentosString = "";
        for (Medicamento medicamento: medicamentos) {
            medicamentosString += medicamento.toString() + "\n";
        }
        return medicamentosString;
    }
}
