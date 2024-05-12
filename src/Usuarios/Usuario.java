package Usuarios;
import Usuarios.utils.Rol;

import java.time.LocalDate;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Rol rol;
    private String numeroTelefono;
    private String nombreUsuario;
    private String contrasena;
    private LocalDate fechaNacimiento;

    public Usuario(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, Rol rol, String numeroTelefono, String nombreUsuario, String contrasena) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno= apellidoMaterno;
        this.rol = rol;
        this.fechaNacimiento = fechaNacimiento;
        this.contrasena = contrasena;
        this.nombreUsuario = nombreUsuario;
        this.numeroTelefono = numeroTelefono;
        CANTIDAD_USUARIOS++;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Nombre completo: %s %s %s, rol: %s, numero teléfono: %s, fecha de nacimiento: %s", id, nombre, apellidoPaterno,apellidoMaterno, rol, numeroTelefono,fechaNacimiento);
    }
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }
    public String getApellidoPaterno() {
        return apellidoPaterno;
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
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
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