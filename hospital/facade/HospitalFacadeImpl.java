package hospital.facade;

import hospital.object.usuarios.Admin;
import hospital.object.usuarios.Doctor;
import hospital.object.usuarios.Recepcionista;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;

public class HospitalFacadeImpl {
    public static int desplegarMenu(String texto, int n, Scanner sc) {
        int opcion;
        do {
            System.out.print("\n" + texto);
            opcion = sc.nextInt();
            sc.nextLine();
            if (opcion < 1 || opcion > n) {
                System.out.println("Error: opcion no valida...");
            }
        } while (opcion < 1 || opcion > n);
        return opcion;
    }
    public void administrador (Scanner sc) {
        int opcionAdmin;
        do {
            opcionAdmin = desplegarMenu("Menu Administrador\n1. Contratar Doctor\n2. Despedir Doctor\n3. Ver Reportes\n4. Salir\nIngrese una opcion: ", 4, sc);
            switch (opcionAdmin) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    
                    break;
                case 4:
                    System.out.println("Saliendo del menú de administrador...");
                    break;
            }
        } while (opcionAdmin != 4);
    }
        public static Doctor makeDoctor() {


        String nombre = voidStringValidator("Ingrese el nombre del doctor: ");

        String contrasena =voidStringValidator("Ingrese la contraseña del doctor: ");

        double sueldo = doubleValidator("Ingrese el sueldo del doctor: ");

        String turno = voidStringValidator("Ingrese el turno del doctor: ");

        String especialidad = voidStringValidator("Ingrese la especialidad del doctor:");

        return new Doctor(nombre, contrasena, sueldo, turno, especialidad);
    }

    public static Admin makeAdmin() {

        String nombre = voidStringValidator("Ingrese el nombre del administrador:");


        String contrasena = voidStringValidator("Ingrese la contraseña del administrador:");


        double sueldo = doubleValidator("Ingrese el sueldo del administrador:");


        String turno = voidStringValidator("Ingrese el turno del administrador:");

        return new Admin(nombre, contrasena, sueldo, turno);
    }
    public static Recepcionista makeRecepcionista() {

        String nombre = voidStringValidator("Ingrese el nombre del administrador:");


        String contrasena = voidStringValidator("Ingrese la contraseña del administrador:");


        double sueldo = doubleValidator("Ingrese el sueldo del administrador:");


        String turno = voidStringValidator("Ingrese el turno del administrador:");

        return new Recepcionista(nombre, contrasena, sueldo, turno);
    }

    
    public static int integerValidator(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        int option;
        try{
            option = scanner.nextInt();
            scanner.close();
            return option;
        } catch (Exception e) {
            System.out.println("Favor de ingresar un número entero");
            return integerValidator(prompt);
        }
    }
    public static double doubleValidator(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        double option;
        try{
            option = scanner.nextDouble();
            scanner.close();
            return option;
        } catch (Exception e) {
            System.out.println("Favor de ingresar un número");
            return doubleValidator(prompt);
        }
    }

    public static String voidStringValidator(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        String option;
        try{
            option = scanner.nextLine();
            scanner.close();
            if (option.isEmpty()) {
                throw new IllegalArgumentException();
            }
            return option;
        } catch (Exception e) {
            System.out.println("El campo no puede estar vacio");
            return voidStringValidator(prompt); 
        }
    }

    public static void writeDoctorTxt(ArrayList<Doctor> Doctors) {
        String fileName = "Doctores.txt";
        String filePath = "../archivosTXT/" + fileName;
        String comma = ",";
        String lineBreak = "\n";
        try{
        FileWriter myWriter = new FileWriter(filePath);
        for(Doctor doctor: Doctors){
                    String nombreDoctor = doctor.getNombre();
                    String contraseña = doctor.getContrasena();
                    String sueldo = Double.toString(doctor.getSueldo());
                    String turno = doctor.getTurno();
                    String especialidad = doctor.getEspecialidad();
                    String doctoresHist = Integer.toString(Doctor.getNumDoctoresHist());
                    String doctoresActual = Integer.toString(Doctor.getNumDoctoresActual());
                    String doctorInfo = nombreDoctor+comma +
                            contraseña +comma +
                            sueldo + comma +
                            turno + comma +
                            especialidad + comma +
                            doctoresHist + comma +
                            doctoresActual + comma +
                            lineBreak;
                    myWriter.write(doctorInfo);
                }
                myWriter.close();
                System.out.println("Los datos de los doctores han sido almacenados correctamente.");
    
    }catch (IOException e) {
        System.out.println("Ocurrió un error al almacenar los dotores.");
        e.printStackTrace();
    }
    }

}
