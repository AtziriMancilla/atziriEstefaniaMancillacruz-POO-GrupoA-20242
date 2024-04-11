package biblioteca;

import Usuarios.Gerente;
import Usuarios.Usuario;

import java.util.ArrayList;

public class Biblioteca {
    //cosas que empiezan con @ son anotations
    //@Deprecated significa no tiene más soporte. Como referencia nadamás en el codigo
    public ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
    public Usuario verificarInicioSesion(String usuario, String contrasena){
        for(Usuario usuarioActual:usuarios){
            if(usuarioActual.getNombreUsuario().equals(usuario)){
                if(usuarioActual.getContrasena().equals(contrasena)){
                    return  usuarioActual;
                }
                return null;
            }
        }
        return null;
    }
    public void tester(){
        Gerente gerente=new Gerente("Andrea","Duran","02/09/05","1234")
    }
}
