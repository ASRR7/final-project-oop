package hospital.main;

import java.util.Scanner;

import hospital.object.pacientes.*;
import hospital.object.usuarios.*;
import hospital.state.*;


public class Terminal {
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


}
