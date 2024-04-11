public class Empleado extends Persona {
    public String rol;

    public Empleado(String nombre, String apellido, String direccion, String rol) {
        super(nombre, apellido, direccion);
        this.rol = rol;
    }

    public String mostrarInfoConRol() {
        return super.mostrarInfo() + "rol: " + rol;
    }
}