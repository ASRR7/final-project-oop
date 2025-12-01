package hospital.main;

import hospital.facade.HospitalFacadeImpl;

public class Main {

    /**
     * Inicializa el programa principal.
     * <p>
     * Crea la instancia de la facade  {@link hospital.facade.HospitalFacadeImpl}
     * y la envia como argumento al constructor de la instancia de la clase terminal.
     * </p>
     * @version 1
     * @author Equipo 13
     */
    public static void main(String[] args) {
        HospitalFacadeImpl facade = new HospitalFacadeImpl();
        Terminal terminal = new Terminal(facade);
        terminal.iniciar();
        terminal.cerrar();
    }
}
