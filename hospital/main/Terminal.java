package hospital.main;

import java.util.Scanner;

import hospital.object.pacientes.*;
import hospital.object.usuarios.*;
import hospital.state.*;
import hospital.facade.*;


public class Terminal {
    HospitalFacadeImpl facade;
    Scanner scanner = new Scanner(System.in);

    public Terminal(HospitalFacadeImpl facade){
        this.facade = facade;
    }
    
    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String texto;
        try{
            texto = scanner.nextLine();
            scanner.close();
            if (texto.isEmpty()) {
                throw new IllegalArgumentException();
            }
            return texto;
        } catch (Exception e) {
            System.out.println("El campo no puede estar vacio");
        }
    }

    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            scanner.next();
        }
        int dato = scanner.nextInt();
        scanner.nextLine();
        return dato;
    }

    private double leerDouble(String mensaje) {
        System.out.print(mensaje);
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor ingrese un monto válido: ");
            scanner.next();
        }
        double dato = scanner.nextDouble();
        scanner.nextLine();
        return dato;
    }


    public void iniciar(){
        System.out.println("Iniciando sistema del hospital...");
        facade.cargarDatosIniciales(); 
        this.menuPrincipal();
    }

    public void menuPrincipal(){
        int opcion = 0;
        while(opcion != 4){
            this.mostrarMenuUsuario();
            opcion = this.leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1: this.menuPacientes(); break;
                case 2: this.menuAdmin(); break;
                case 3: this.menuDoctor(); break;
                case 4: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida.");
            }
        }
        
        cerrar();
    }

    public void mostrarMenuUsuario(){
        System.out.println("=== Sistema de Gestión del Hospital ===");
        System.out.println("1. Soy un paciente");
        System.out.println("2. Soy Admin");
        System.out.println("3. Soy un doctor");
        System.out.println("4. Salir");
    }
    public void mostrarMenuPaciente(){
        System.out.println("=== Menú Paciente ===");
        System.out.println("1. Registrarte como paciente");
        System.out.println("2. Pedir cita médica");
        System.out.println("3. Cancelar cita médica");
        System.out.println("4. Ver historial médico");
        System.out.println("5. Ir a consulta");
        System.out.println("6. Volver al menú principal");
    }
    public void mostrarMenuRecepcionista(){
        System.out.println("=== Menú Recepcionista ===");
        System.out.println("1. Registrar cita a paciente");
        System.out.println("2. Cancelar cita de paciente");
        System.out.println("3. Volver al menú principal");
    }
    public void mostrarMenuAdmin(){
        System.out.println("=== Menú Admin ===");
        System.out.println("1. Agregar Doctor");
        System.out.println("2. Remover Doctor");
        System.out.println("3. Agregar Medicamentos");
        System.out.println("4. Volver al menú principal");
    }
    public void mostrarMenuDoctor(){
        System.out.println("=== Menú Doctor ===");
        System.out.println("1. Ver citas asignadas");
        System.out.println("2. Ir a consulta");
        System.out.println("3. Volver al menú principal");
    }

    public void menuPacientes(){
        this.mostrarMenuPaciente();
        int opcion = this.leerEntero("Seleccione una opción: ");
        switch (opcion) {
            case 1:
                this.registrarPaciente(); break;
            case 2:
                this.pedirCita(); break;
            case 3:
                this.cancelarCita(); break;
            case 4:
                this.verHistorialMedico(); break;
            case 5:
                this.irAConsulta(); break;
            case 6:
                System.out.println("Volviendo al menú principal...");
                break;
        
            default: System.out.println("Opción inválida.");
        }
    }
    public void menuCitas(){

    }
    public void menuAdmin(){

    }
    public void menuDoctores(){

    }
    

    // =========================================
    // PACIENTES
    // =========================================
    public void registrarPaciente(){
        String nombre = leerTexto("Ingrese el nombre del paciente: ");
        String sexo = leerTexto("Ingrese el sexo del paciente: ");
        int edad = leerEntero("Ingrese la edad del paciente: ");
        Boolean esEmbarazo = leerTexto("¿Está en embarazo? (1: si/ 0:no): ") == "1";
        Boolean esLactancia = leerTexto("¿Está en lactancia? (1: si/ 0:no): ") == "1";
        Boolean esGeriatria = false;
        Boolean esInfancia = false;

        if(edad>65){
            esGeriatria = true;
        } else if(edad<12){
            esInfancia = true;
        }
        facade.pacienteServicio.registrarPaciente(nombre, sexo, edad, esEmbarazo, esLactancia, esGeriatria, esInfancia);
    }


    public void cerrar(){
        System.out.println("Cerrando sistema del hospital...");
        facade.cerrarSistema();
        scanner.close();
    }
}