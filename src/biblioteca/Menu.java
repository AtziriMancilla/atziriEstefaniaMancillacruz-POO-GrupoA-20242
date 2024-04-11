package biblioteca;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    Biblioteca biblioteca=new Biblioteca();
    public void iniciarSesion(){
        boolean datosCorrectos=false;
        do{
            System.out.println("Bienvenido a la biblioteca");
            System.out.println("Inicia sesion para continuar");
            System.out.println("Ingresa tu usuario");
            String usuario=sc.nextLine();
            System.out.println("Ingresa tu contraseña");
            String contrasena=sc.nextLine();
            Usuario usuarioActual=(biblioteca.verificarInicioSesion(usuario,contrasena);
            if(usuarioActual!=null){
                datosCorrectos=true;
                selecionarMenu(usuarioActual);
            }
            else{
                System.out.println("Usuario o contraeña incorrectos. Intenta de nuevo");
            }
        }while (!datosCorrectos);
    }
    //funcion lambda
    private void selecionarMenu(Usuario usuario) {
        switch (usuario.getRol()){
            case CLIENTE -> mostrarMenuCliente();
            case TRABAJADOR -> mostrarMenuTrabajador();
            case GERENTE -> mostrarMenuGerente();
        }
    }//ultima opcion de cada menu cerrarsesion(){
    //metodo que cierre tu sesion y te mande al inicio para iniciar sesion }
    private void mostrarMenuCliente(){

    }
    private void mostrarMenuTrabajador(){

    }
    private void mostrarMenuGerente(){

    }
}
