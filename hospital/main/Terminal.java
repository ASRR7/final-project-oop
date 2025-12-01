package hospital.main;

import java.util.Scanner;

import hospital.object.pacientes.*;
import hospital.object.usuarios.*;
import hospital.facade.*;


public class Terminal {
    HospitalFacadeImpl facade;
    Paciente paciente;
    Doctor doctor;
    Scanner scanner = new Scanner(System.in);
    int opcion, opcionInter, opcionInterPaciente;

    public Terminal(HospitalFacadeImpl facade){
        this.facade = facade;
    }
    
    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        String texto;
        try{
            texto = scanner.nextLine();
            if (texto.isEmpty()) {
                throw new IllegalArgumentException();
            }
            return texto;
        } catch (Exception e) {
            System.out.println("El campo no puede estar vacio");
            return leerTexto(mensaje);
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
        System.out.println(facade.cargarDatosIniciales());
        this.menuPrincipal();
    }

    public void menuPrincipal(){
        opcion = 0;
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
        System.out.println("4. Salir del programa");
    }
    public void mostrarMenuPaciente(){
        System.out.println("=== Menú Paciente ===");
        System.out.println("1. Ver pacientes registrados");
        System.out.println("2. Registrarte como paciente");
        System.out.println("3. Ya soy paciente");
        System.out.println("4. Volver al menú principal");
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
        System.out.println("1. Ver Doctores");
        System.out.println("2. Agregar Doctor");
        System.out.println("3. Remover Doctor");
        System.out.println("4. Ver medicamentos");
        System.out.println("5. Agregar Medicamentos");
        System.out.println("6. Crear Reportes");
        System.out.println("7. Volver al menú principal");
    }
    public void mostrarMenuDoctor(){
        System.out.println("=== Menú Doctor ===");
        System.out.println("1. Ver citas asignadas");
        System.out.println("2. Ir a consulta");
        System.out.println("3. Volver al menú principal");
    }

    public void menuPacientes(){
        opcionInter = 0;
        while(opcionInter != 4){
            this.mostrarMenuPaciente();
            opcionInter = this.leerEntero("Seleccione una opción: ");
            switch (opcionInter) {
                case 1:
                    this.mostrarPacientes();
                    break;
                case 2:
                    this.registrarPaciente();
                    this.menuPacienteInterno();
                    break;
                case 3:
                    this.soyPaciente();
                    this.menuPacienteInterno();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default: System.out.println("Opción inválida.");
            }
        }
    }
    public void menuPacienteInterno(){
        opcionInterPaciente = 0;
        while(opcionInterPaciente != 4){
            this.mostrarMenuPacienteInterno();
            opcionInterPaciente = this.leerEntero("Seleccione una opción: ");
            switch (opcionInterPaciente) {
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
    }
    public void menuAdmin(){
        opcionInter = 0;
        while(opcionInter != 7){
            this.mostrarMenuAdmin();
            opcionInter = this.leerEntero("Seleccione una opción: ");
            switch (opcionInter) {
                case 1:
                    this.mostrarDoctores();
                    break;
                case 2:
                    this.agregarDoctor();
                    break;
                case 3:
                    this.removerDoctor();
                    break;
                case 4:
                    this.verMedicamentos();
                    break;
                case 5:
                    this.agregarMedicamentos();
                    break;
                case 6:
                    this.generarReportes();
                    break;
                case 7:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default: System.out.println("Opción inválida.");
            }
        }
    }
    public void menuDoctor(){
        if(this.soyDoctor()){
            opcionInter = 0;
            while(opcionInter != 3){
                this.mostrarMenuDoctor();
                opcionInter = this.leerEntero("Seleccione una opción: ");
                switch (opcionInter) {
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
        }
    }
    

    // =========================================
    // PACIENTES
    // =========================================
    public void mostrarPacientes(){
        System.out.println("Mostrando pacientes registrados...");
        System.out.println(facade.mostrarPacientes());
    }
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
        try{
            paciente = facade.registrarPaciente(nombre, sexo, edad, esEmbarazo, esLactancia, esGeriatria, esInfancia);
            System.out.println("Paciente registrado exitosamente.");
        }catch(RuntimeException e){
            System.out.println("Ocurrió un error al guardar al paciente.");
        }
    }
    public void soyPaciente(){
        int id = leerEntero("Ingrese su ID de paciente: ");
        paciente = facade.obtenerPacientePorId(id);
        if(paciente != null){
            System.out.println("Bienvenide, " + paciente.getNombre());
        } else {
            System.out.println("Paciente no encontrado.");
        }
    }
    public void pedirCita(){
        int hora = leerEntero("Ingrese la hora de la cita (formato 24h): ");
        if(hora < 0 || hora > 23){
            System.out.println("Hora inválida.");
            return;
        }
        int dia = leerEntero("Ingresa el día del mes para tu cita: ");
        if(dia < 1 || dia > 30){
            System.out.println("Día inválido.");
            return;
        }
        int mes = leerEntero("Ingresa el mes: ");
        if(mes < 1 || mes > 12){
            System.out.println("Mes inválido.");
            return;
        }

        if(facade.pedirCita(paciente.getId(), hora, dia, mes)){
            System.out.println("Cita pedida exitosamente.");
        }else {
            System.out.println("No se pudo agendar la cita.");
        }
    }
    public void cancelarCita(){
        int idCita = leerEntero("Ingrese el ID de la cita a cancelar: ");
        if(facade.cancelarCita(paciente.getId(), idCita)){
            System.out.println("Cita cancelada exitosamente.");
        }else {
            System.out.println("No se pudo cancelar la cita.");
        }
    }
    public void verHistorialMedico(){
        System.out.println("Mostrando historial médico...");
        System.out.println(facade.verHistorialMedico(paciente.getId()));
    }
    // =========================================
    // ADMIN
    // =========================================
    public void mostrarDoctores(){
        System.out.println("Mostrando doctores registrados...");
        System.out.println(facade.mostrarDoctores());
    }
    public void agregarDoctor(){
        String nombre = leerTexto("Ingrese el nombre del doctor: ");
        String contrasena = leerTexto("Ingrese la contraseña del doctor: ");
        double sueldo = leerDouble("Ingrese el sueldo del doctor: ");
        String turno = leerTexto("Ingrese el turno del doctor (Matutino, vespertino, Nocturno): ");
        String especialidad = leerTexto("Ingrese la especialidad del doctor: ");

        facade.agregarDoctor(nombre, contrasena, sueldo, turno, especialidad);
        System.out.println("Doctor agregado exitosamente.");
    }
    public void removerDoctor(){
        int id = leerEntero("Ingrese el ID del doctor a remover: ");
        if(facade.removerDoctor(id)){
            System.out.println("Doctor removido exitosamente.");
        } else {
            System.out.println("No se pudo remover el doctor.");
        }
    }
    public void verMedicamentos(){
        System.out.println("Mostrando medicamentos...");
        System.out.println(facade.verMedicamentos());
    }
    public void agregarMedicamentos(){
        int id = leerEntero("Ingrese el ID del medicamento a agregar: ");
        int cantidad = leerEntero("Ingrese la cantidad a agregar: ");
        if(cantidad > 0){
            if(facade.agregarMedicamento(id, cantidad)){
                System.out.println("Medicamento agregado exitosamente.");
            }else {
                System.out.println("No se pudo agregar el medicamento.");
            }
        }else {
            System.out.println("Cantidad inválida.");
        }
    }
    public void generarReportes(){
        System.out.println("Generando reportes...");
        if(facade.generarReportes()){
            System.out.println("Reportes generados exitosamente.");
        }else {
            System.out.println("No se pudo generar los reportes.");
        }
    }
    
    // =========================================
    // DOCTOR
    // =========================================
    public boolean soyDoctor(){
        this.mostrarDoctores();
        int id = leerEntero("Ingrese su ID de doctor: ");
        String contra = leerTexto("Ingresa tu contraseña: ");
        doctor = facade.obtenerDoctorPorId(id, contra);
        if(doctor != null){
            System.out.println("Bienvenide, Dr. " + doctor.getNombre());
            return true;
        } else {
            System.out.println("Doctor no encontrado.");
            return false;
        }
    }
    public void irAConsulta(){
        int id = leerEntero("Ingrese el ID de la cita médica: ");
        System.out.println("La consulta ha comenzado.");
        System.out.println("Info de la cita: " + facade.infoCita(doctor.getId(), id));
        System.out.println("La consulta ha finalizado: " + facade.irAConsulta(doctor.getId(), id));
    }
    public void verCitasAsignadas(){
        if(doctor != null){
            System.out.println("Mostrando citas asignadas...");
            System.out.println(facade.verCitasAsignadas(doctor.getId()));
        } else {
            System.out.println("Doctor no encontrado.");
        }
    }
    
    // -------------------------------------------
    // -------------------------------------------
    // -------------------------------------------
    public void cerrar(){
        System.out.println(facade.cerrarSistema());
        scanner.close();
    }
}