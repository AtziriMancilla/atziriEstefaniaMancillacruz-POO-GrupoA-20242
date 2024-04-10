package Usuarios;
import Usuarios.utils.Rol;

import java.time.LocalDate;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol; //enum de tipo rol
    private LocalDate fechaNacimiento;

    private String nombreUsuario;

    private String contrasena;


    public Usuario(String nom, String apellido, Rol rol,LocalDate fechaNacimiento,String nombreUsuario,String contrasena) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        this.fechaNacimiento=fechaNacimiento;
        this.nombreUsuario=nombreUsuario;
        this.contrasena=contrasena;
        CANTIDAD_USUARIOS++;
    }
    public String getNombreUsuario() {
        return nombreUsuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public Rol getRol() {
        return rol;
    }
    @Override
    public String toString(){
        return String.format("Id: %d, Nombre completo: %s %s, rol: %s", id, nombre, apellido, rol);
    }
}

