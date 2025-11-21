package hospital.main;

import java.util.Scanner;

import javax.print.Doc;

import hospital.object.pacientes.*;
import hospital.object.usuarios.*;
import hospital.state.*;
import hospital.facade.*;


public class Terminal {
    HospitalFacadeImpl facade;
    Paciente paciente;
    Doctor doctor;
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
        System.out.println("2. Ya soy paciente");
        System.out.println("3. Volver al menú principal");
    }
    public void mostrarMenuPacienteInterno(){
        System.out.println("=== Menú Interno de Paciente ===");
        System.out.println("1. Pedir cita médica");
        System.out.println("2. Cancelar cita médica");
        System.out.println("3. Ver historial médico");
        System.out.println("4. Volver al menú de paciente");

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
        System.out.println("3. Ver medicamentos");
        System.out.println("4. Agregar Medicamentos");
        System.out.println("5. Ver Reportes");
        System.out.println("6. Volver al menú principal");
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
                this.registrarPaciente();
                this.menuPacienteInterno();
                break;
            case 2:
                this.soyPaciente();
                this.menuPacienteInterno();
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                break;
            default: System.out.println("Opción inválida.");
        }
    }
    public void menuPacienteInterno(){
        this.mostrarMenuPacienteInterno();
        int opcion = this.leerEntero("Seleccione una opción: ");
        switch (opcion) {
            case 1:
                this.pedirCita(); break;
            case 2:
                this.cancelarCita(); break;
            case 3:
                this.verHistorialMedico(); break;
            case 4: 
                System.out.println("Volviendo al menú de paciente...");
                    break;
        }
    }
    public void menuAdmin(){
        this.mostrarMenuAdmin();
        int opcion = this.leerEntero("Seleccione una opción: ");
        switch (opcion) {
            case 1:
                this.agregarDoctor();
                break;
            case 2:
                this.removerDoctor();
                break;
            case 3:
                this.verMedicamentos();
                break;
            case 4:
                this.agregarMedicamentos();
                break;
            case 5:
                this.verReportes();
                break;
            case 6:
                System.out.println("Volviendo al menú principal...");
                break;
            default: System.out.println("Opción inválida.");
        }
    }
    public void menuDoctor(){
        this.soyDoctor();
        this.mostrarMenuDoctor();
        int opcion = this.leerEntero("Seleccione una opción: ");
        switch (opcion) {
            case 1:
                this.verCitasAsignadas();
                break;
            case 2:
                this.irAConsulta();
                break;
            case 3:
                System.out.println("Volviendo al menú principal...");
                break;
            default: System.out.println("Opción inválida.");
        }
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
        paciente = facade.pacienteServicio.registrarPaciente(nombre, sexo, edad, esEmbarazo, esLactancia, esGeriatria, esInfancia);
        System.out.println("Paciente registrado exitosamente.");
    }
    public void soyPaciente(){
        int id = leerEntero("Ingrese su ID de paciente: ");
        paciente = facade.pacienteServicio.obtenerPacientePorId(id);
        if(paciente != null){
            System.out.println("Bienvenide, " + paciente.getNombre());
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }
    public void pedirCita(){
        double hora = leerDouble("Ingrese la hora de la cita (formato 24h, ej. 14.30): ");
        int dia = leerEntero("Ingresa el día del mes para tu cita: ");
        int mes = leerEntero("Ingresa el número de mes: ");
        if(facade.citaServicio.pedirCita(paciente.getId(), hora, dia, mes)){
            System.out.println("Cita pedida exitosamente.");
        }else {
            System.out.println("No se pudo agendar la cita.");
        }
    }
    public void cancelarCita(){
        int idCita = leerEntero("Ingrese el ID de la cita a cancelar: ");
        if(facade.citaServicio.cancelarCita(paciente.getId(), idCita)){
            System.out.println("Cita cancelada exitosamente.");
        }else {
            System.out.println("No se pudo cancelar la cita.");
        }
    }
    public void verHistorialMedico(){
        System.out.println("Mostrando historial médico...");
        System.out.println(facade.pacienteServicio.verHistorialMedico(paciente.getId()));
    }
    // =========================================
    // ADMIN
    // =========================================
    public void agregarDoctor(){
        String nombre = leerTexto("Ingrese el nombre del doctor: ");
        String contrasena = leerTexto("Ingrese la contraseña del doctor: ");
        double sueldo = leerDouble("Ingrese el sueldo del doctor: ");
        String turno = leerTexto("Ingrese el turno del doctor: ");
        String especialidad = leerTexto("Ingrese la especialidad del doctor: ");

        facade.adminServicio.agregarDoctor(nombre, contrasena, sueldo, turno, especialidad);
        System.out.println("Doctor agregado exitosamente.");
    }
    public void removerDoctor(){
        int id = leerEntero("Ingrese el ID del doctor a remover: ");
        facade.adminServicio.removerDoctor(id);
        System.out.println("Doctor removido exitosamente.");
    }
    public void verMedicamentos(){
        System.out.println("Mostrando medicamentos...");
        System.out.println(facade.medicamentoServicio.verMedicamentos());
    }
    public void agregarMedicamentos(){
        int id = leerEntero("Ingrese el ID del medicamento a agregar: ");
        int cantidad = leerEntero("Ingrese la cantidad a agregar: ");
        facade.medicamentoServicio.agregarMedicamento(id, cantidad);
        System.out.println("Medicamento agregado exitosamente.");
    }
    public void verReportes(){
        System.out.println("Generando reportes...");
        facade.reporteServicio.generarReportes();
        System.out.println("Reportes generados exitosamente.");
    }
    
    // =========================================
    // DOCTOR
    // =========================================
    public void soyDoctor(){
        int id = leerEntero("Ingrese su ID de doctor: ");
        String contra = leerTexto("Ingresa tu contraseña: ");
        doctor = facade.doctorServicio.obtenerDoctorPorId(id, contra);
        if(doctor != null){
            System.out.println("Bienvenide, Dr. " + doctor.getNombre());
        } else {
            System.out.println("Doctor no encontrado.");
        }
    }
    public void irAConsulta(){
        int id = leerEntero("Ingrese el ID de la cita médica: ");
        System.out.println("La consulta ha comenzado.");
        System.out.println("Info de la cita: " + facade.citaServicio.info(id));
        System.out.println("La consulta ha finalizado: " + facade.doctorServicio.irAConsulta(id));
    }
    public void verCitasAsignadas(){
        int id = leerEntero("Ingrese su ID de doctor: ");
        Doctor doctor = facade.doctorServicio.obtenerDoctorPorId(id);
        if(doctor != null){
            facade.doctorServicio.verCitasAsignadas(doctor);
        } else {
            System.out.println("Doctor no encontrado.");
        }
    }
    
    // -------------------------------------------
    // -------------------------------------------
    // -------------------------------------------
    public void cerrar(){
        System.out.println("Cerrando sistema del hospital...");
        facade.cerrarSistema();
        scanner.close();
    }
}