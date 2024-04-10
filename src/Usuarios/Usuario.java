package Usuarios;
import Usuarios.utils.Rol;

public class Usuario {
    private static int CANTIDAD_USUARIOS = 1;
    private int id;
    private String nombre;
    private String apellido;
    private Rol rol; //enum de tipo rol

    public Usuario(String nom, String apellido, Rol rol) {
        this.id = CANTIDAD_USUARIOS;
        this.nombre = nombre;
        this.apellido = apellido;
        this.rol = rol;
        CANTIDAD_USUARIOS++;
    }
    @Override
    public String toString(){
        return String.format("Id: %d, Nombre completo: %s %s, rol: %s", id, nombre, apellido, rol);
    }
}

