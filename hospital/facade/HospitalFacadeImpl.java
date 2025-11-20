package hospital.facade;

import java.util.Scanner;

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
}
