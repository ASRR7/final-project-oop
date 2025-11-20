package hospital.facade;

import java.util.Scanner;

public class HospitalFacadeImpl implements IHospitalFacade {
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
}
