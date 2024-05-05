package Usuarios;
import Usuarios.utils.Rol;

import java.time.LocalDate;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol;
    private String numeroTelefono;
    private String nombreUsuario;
    private String contrasena;
    private LocalDate fechaNacimiento;

    public Usuario(String nombre, String apellido, LocalDate fechaNacimiento, Rol rol, String numeroTelefono, String nombreUsuario, String contrasena) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.numeroTelefono = numeroTelefono;
        CANTIDAD_USUARIOS++;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Nombre completo: %s %s, rol: %s, numero teléfono: %s, fecha de nacimiento: %s", id, nombre, apellido, rol, numeroTelefono,fechaNacimiento);
    }

    public Rol getRol() {
        return rol;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}