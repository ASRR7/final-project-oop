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

    public static int integerValidator(String prompt){
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        int option;
        try{
            option = scanner.nextInt();
            scanner.close();
            return option;
        } catch (Exception e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
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
                throw new RuntimeException("El campo no puede estar vacio");
            }
            return option;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
