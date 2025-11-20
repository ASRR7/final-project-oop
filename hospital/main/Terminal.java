package hospital.main;

import java.util.Scanner;

import hospital.object.pacientes.*;
import hospital.object.usuarios.*;
import hospital.state.*;
import hospital.facade.*;


public class Terminal {

    private IHospitalFacade hospitalFacade;

    public Terminal() {
        this.hospitalFacade = new HospitalFacadeImpl();
    }

    public static Admin makeAdmin() {

        String nombre = voidStringValidator("Ingrese el nombre del administrador:");

        String contrasena = voidStringValidator("Ingrese la contraseña del administrador:");


        double sueldo = doubleValidator("Ingrese el sueldo del administrador:");


        String turno = voidStringValidator("Ingrese el turno del administrador:");

        return new Admin(nombre, contrasena, sueldo, turno);
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
