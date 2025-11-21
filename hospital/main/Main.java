package hospital.main;

import hospital.facade.HospitalFacadeImpl;

public class Main {
    public static void main(String[] args) {
        HospitalFacadeImpl facade = new HospitalFacadeImpl();
        Terminal terminal = new Terminal(facade);
        terminal.iniciar();
        terminal.cerrar();
    }
}
