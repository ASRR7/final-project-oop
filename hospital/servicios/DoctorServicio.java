package hospital.servicios;

import hospital.object.usuarios.Doctor;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
    /**
 * Lee los datos de los doctores desde el archivo de texto y crea la lista de
 * doctores.
 *
 * El método abre el archivo "Doctores.txt" y recupera primero los valores
 * históricos y actuales del conteo de doctores. Después, lee línea por línea
 * los datos de cada doctor (nombre, contraseña, sueldo, turno y especialidad) y
 * los convierte en objetos Doctor que se agregan a la lista.
 *
 * Si el archivo no existe, se lanza una excepción.
 *
 * @return lista con todos los doctores leídos del archivo.
 * @throws FileNotFoundException si el archivo no se encuentra.
 * @version 3
 */
    public class DoctorServicio {
        public static ArrayList<Doctor> leerDoctorTxt() throws FileNotFoundException {
            String fileName = "Doctores.txt";
            String filePath = "hospital/archivosTXT/" + fileName;
            ArrayList<Doctor> doctores = new ArrayList<>();
            try {
                Scanner fileIn = new Scanner(new File(filePath)); 

                int doctoresHist = fileIn.nextInt();
                int doctoresActual = fileIn.nextInt();
                

                while (fileIn.hasNext()) {
                    String nombreDoctor     = fileIn.next();
                    String contraseña       = fileIn.next();
                    double sueldo           = fileIn.nextDouble();
                    String turno            = fileIn.next();
                    String especialidad     = fileIn.next();
                    Doctor doctor = new Doctor(nombreDoctor, contraseña, sueldo, turno, especialidad);
                    doctores.add(doctor);
                }
                Doctor.numDoctoresHist = doctoresHist;
                Doctor.numDoctoresActual = doctoresActual;

            } catch (FileNotFoundException e) {
                throw new FileNotFoundException (e.getMessage());
            }
            return doctores;
        }
        /**
         * Escribe en el archivo de texto la información de todos los doctores.
         *
         * El método sobrescribe el archivo "Doctores.txt" y guarda primero las
         * estadísticas de doctores históricos y actuales. Después escribe los
         * datos de cada doctor (nombre, contraseña, sueldo, turno y
         * especialidad), cada uno en una línea independiente.
         *
         * Si ocurre un error durante la escritura, se lanza una excepción.
         *
         * @param Doctors lista de doctores que se deben guardar en el archivo.
         * @throws IOException si ocurre un problema al abrir o escribir el
         * archivo.
         * @version 3
         */
        public static void writeDoctorTxt(ArrayList<Doctor> Doctors) throws IOException {
            String fileName = "Doctores.txt";
            String filePath = "hospital/archivosTXT/" + fileName;
            String espacio = " "; 
            String lineBreak = "\n";
            try{
                FileWriter myWriter = new FileWriter(filePath);
                String doctoresHist = Integer.toString(Doctor.getNumDoctoresHist());
                String doctoresActual = Integer.toString(Doctor.getNumDoctoresActual());
                String doctorEstadistica = (doctoresHist+espacio+doctoresActual+lineBreak);  
                myWriter.write(doctorEstadistica);
                for(Doctor doctor: Doctors){
                    String nombreDoctor = doctor.getNombre();
                    String contraseña = doctor.getContrasena();
                    String sueldo = Double.toString(doctor.getSueldo());
                    String turno = doctor.getTurno();
                    String especialidad = doctor.getEspecialidad();
                    
                    String doctorInfo = nombreDoctor+espacio +
                        contraseña      + espacio +
                        sueldo          + espacio +
                        turno           + espacio +
                        especialidad    + espacio +
                        lineBreak;
                        myWriter.write(doctorInfo);
                }
                myWriter.close();
            }catch (IOException e) {
                throw new IOException(e);
            }
        }
        /**
         * Busca un doctor por su identificador dentro de la lista.
         *
         * Recorre la lista de doctores y devuelve aquel cuyo id coincida con el
         * valor indicado. Si no existe ningún doctor con ese id, se devuelve
         * null.
         *
         * @param doctores lista de doctores en la que se realizará la búsqueda.
         * @param id identificador del doctor buscado.
         * @return el doctor con el id indicado, o null si no se encuentra.
         * @version 3
         */
        public static Doctor searchByIdDoctor(ArrayList<Doctor> doctores, int id){
            for (Doctor doctor:doctores){
                if(doctor.getId() == id){
                    return doctor;
                }
            }
            return null;
        }
        /**
         * Busca un doctor por su id y contraseña dentro de la lista.
         *
         * Recorre la lista de doctores y devuelve aquel cuyo identificador y
         * contraseña coincidan con los valores proporcionados. Si no se
         * encuentra un doctor con esos datos, se devuelve null.
         *
         * @param doctores lista de doctores donde se realizará la búsqueda.
         * @param id identificador del doctor buscado.
         * @param contra contraseña asociada al doctor.
         * @return el doctor que coincide con id y contraseña, o null si no se
         * encuentra.
         * @version 3
         */
        public static Doctor searchByIdDoctor(ArrayList<Doctor> doctores, int id, String contra){
            for (Doctor doctor:doctores){
                if((doctor.getId() == id) && (doctor.getContrasena().equals(contra))){
                    return doctor;
                }
            }
            return null;
        }
        /**
         * Agrega un nuevo doctor a la lista de doctores.
         *
         * Crea un objeto Doctor con los datos proporcionados y lo añade a la
         * lista recibida como parámetro. No realiza validaciones adicionales.
         *
         * @param doctores lista donde se almacenará el nuevo doctor.
         * @param nombre nombre del doctor.
         * @param contrasena contraseña asignada al doctor.
         * @param sueldo sueldo del doctor.
         * @param turno turno de trabajo del doctor.
         * @param especialidad especialidad del doctor.
         * @version 3
         */
        public static void addDoctor(ArrayList<Doctor> doctores, String nombre, String contrasena, double sueldo, String turno, String especialidad){
            Doctor nuevoDoctor = new Doctor(nombre, contrasena, sueldo, turno, especialidad);
            doctores.add(nuevoDoctor);
        }
        /**
         * Elimina un doctor de la lista según su identificador.
         *
         * Busca en la lista el doctor cuyo id coincida con el indicado. Si lo
         * encuentra, lo elimina y devuelve true. Si no existe un doctor con ese
         * id, devuelve false.
         *
         * @param doctores lista de doctores donde se realizará la eliminación.
         * @param doctorId id del doctor que se desea eliminar.
         * @return true si el doctor fue encontrado y eliminado; false en caso
         * contrario.
         * @version 3
         */
        public static boolean removeDoctor(ArrayList<Doctor> doctores, int doctorId){
            Doctor doctorAEliminar = null;
            for(Doctor doctor:doctores){
                if(doctor.getId() == doctorId){
                    doctorAEliminar = doctor;
                    break;
                }
            }
            if(doctorAEliminar != null){
                doctores.remove(doctorAEliminar);
                return true;
            }
            return false;
        }
        /**
         * Genera un texto con la lista de doctores registrados.
         *
         * Recorre la lista de doctores y construye una cadena que muestra el
         * nombre y el id de cada uno. No realiza validaciones adicionales.
         *
         * @param doctores lista de doctores que se van a mostrar.
         * @return cadena con los nombres e identificadores de todos los
         * doctores.
         * @version 3
         */
        public static String mostrarDoctores(ArrayList<Doctor> doctores){
            String nombreIdDoctores = ("Lista de Doctores:\n");
            for (Doctor d:doctores){
                nombreIdDoctores += ("Nombre: "+d.getNombre()+"\tID: "+d.getId()+"\n") ;
            }
            return nombreIdDoctores;
        }
}