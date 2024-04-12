package biblioteca;

import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Biblioteca {
    //cosas que empiezan con @ son anotations
    //@Deprecated significa no tiene más soporte. Como referencia nadamás en el codigo
    public ArrayList <Usuario> usuarios = new ArrayList<>();
    public Usuario verificarInicioSesion(String usuario, String contrasena){
        Usuario us=null;
        for(Usuario usuarioActual:usuarios){
            if(Objects.equals(usuarioActual.getNombreUsuario(), usuario)){
                if(Objects.equals(usuarioActual.getContrasena(), contrasena)){
                    us=usuarioActual;
                }
            }
        }
        return us;
    }
    public void anadirUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    public void mostrar(){
        for (Usuario usuario:usuarios){
            System.out.println(usuario.toString());
        }
    }

}
