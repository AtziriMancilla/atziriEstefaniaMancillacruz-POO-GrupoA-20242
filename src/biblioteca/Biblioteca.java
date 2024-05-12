package biblioteca;

import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import biblioteca.utils.DatosComun;
import libros.Libro;
import libros.constants.Genero;

import java.time.LocalDate;
import java.util.*;
// borrar y modificar
public class Biblioteca {
    public static final HashMap<Rol, ArrayList<Usuario>> usuarios = new HashMap<>();
    public static final HashMap<Genero, ArrayList<Libro>> libros = new HashMap<>();

    public Biblioteca() {
        Trabajador trabajador = new Trabajador("Andrea", "Duran", "Martinez", LocalDate.now(),"4437277815", "canelita", "1234", "09:00-12:00", "Libreria centro", 30000);
        inicializarHashmap();
        usuarios.get(Rol.TRABAJADOR).add(trabajador);
    }
    public void inicializarHashmap(){
        usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        usuarios.put(Rol.CLIENTE, new ArrayList<Usuario>());

        libros.put(Genero.ACCION, new ArrayList<Libro>());
        libros.put(Genero.TERROR, new ArrayList<Libro>());
        libros.put(Genero.COMEDIA, new ArrayList<Libro>());
    }

    public Usuario verificarInicioSesion(String usuario, String contrasena) {
        for (Map.Entry<Rol,ArrayList<Usuario>> entry: usuarios.entrySet()){
            ArrayList<Usuario> listaUsuarios=entry.getValue();
            for (Usuario usuarioActual: listaUsuarios){
                if(usuarioActual.getNombreUsuario().equals(usuario)&&usuarioActual.getContrasena().equals(contrasena)){
                    return usuarioActual;
                }
            }
        }
        return null;
    }
    public void registrarCliente(){
        Cliente.registrarCliente();
    }
    public void registrarTrabajador() {
        Trabajador.registrarTrabajador();
    }

    public void registrarGerente() {
        Gerente.registrarGerente();
    }

    public void mostrarClientes() {
        Cliente.mostrarClientes();
    }

    public void mostrarTrabajadores() {
        Trabajador.mostrarTrabajadores();
    }

    public void mostrarGerentes() {
        Gerente.mostrarGerentes();
    }
    public void borrarCliente(){
        Cliente.borrarCliente();
    }
    public void borrarTrabajador(){
        Trabajador.borrarTrabajador();
    }
    public void borrarGerente(){
        Gerente.borrarGerente();
    }
}