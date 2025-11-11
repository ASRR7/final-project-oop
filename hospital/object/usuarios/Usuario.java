package hospital.object.usuarios;

public abstract class Usuario {
    protected String nombre;
    private String contrasena;
    private double sueldo;
    private String turno;

    public Usuario( String nombre, String contrasena, double sueldo, String turno ) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.sueldo = sueldo;
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena( String contrasena ) {
        this.contrasena = contrasena;
    }

    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo( double sueldo ) {
        this.sueldo = sueldo;
    }

    public String getTurno() {
        return turno;
    }
    public void setTurno( String turno ) {
        this.turno = turno;
    }
}