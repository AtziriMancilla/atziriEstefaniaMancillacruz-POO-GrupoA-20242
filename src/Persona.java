// Súper Clase - Clase Padre
public class Persona {
    public String nombre;
    public String apellido;
    public String direccion;

    public Persona(String nombre, String apellido, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
    }
    public String mostrarInfo(){
        return String.format("Nombre: %s, Apellido: %s, Direccion: %s",nombre,apellido,direccion);

    }
}