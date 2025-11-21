package hospital.servicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import hospital.object.pacientes.Paciente;
import hospital.object.recursos.Medicamentos.Medicamento;
import hospital.object.usuarios.Doctor;
import hospital.state.IPacienteState;
import hospital.state.PacienteEnfermo;
import hospital.state.PacienteMuerto;
import hospital.state.PacienteSano;

public class MedicamentoServicio {
    public static ArrayList <Medicamento> leerMedicamentos() {
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
            System.out.println("Ocurrio un error al leer el archivo.");
        }
        return medicamentos;
    }
    public static void writeMedicamentoTXT(ArrayList<Medicamento> medicamentos) {
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
                System.out.println("Los datos de los medicamentos han sido almacenados correctamente.");
    
    }catch (IOException e) {
        System.out.println("Ocurrió un error al almacenar los medicamentos.");
        e.printStackTrace();
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
        System.out.println("El medicamento con el id proporcionado no se encontró.");
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
