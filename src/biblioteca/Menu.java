package biblioteca;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);
    Biblioteca biblioteca=new Biblioteca();
    public void ejecutarMenu(){
        Gerente gerente=new Gerente("Andrea","Duran", LocalDate.now(),"canelita","1234","ventas",15);
        Trabajador trabajador=new Trabajador("Alejandro","Montejano",LocalDate.now(),"dr profesor","abc","8 am- 3 pm","ventas",8000);
        biblioteca.anadirUsuario(gerente);
        biblioteca.anadirUsuario(trabajador);
        boolean datosCorrectos=false;
        do{
            System.out.println("Bienvenido a la biblioteca");
            System.out.println("Inicia sesion para continuar");
            System.out.print("Ingresa tu usuario:");
            String usuario=sc.nextLine();
            System.out.print("Ingresa tu contraseña:");
            String contrasena=sc.nextLine();
            Usuario usuarioActual=biblioteca.verificarInicioSesion(usuario,contrasena);
            if(usuarioActual!=null){
                selecionarMenu(usuarioActual);
            }
            else{
                System.out.println("Usuario o contraseña incorrectos. Intenta de nuevo");
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
        boolean flag = true;
        do {
            System.out.println("Seleccione opción deseada");
            System.out.println("1)Ver rentas\n2)Ver Información\n3)Ver libros disponibles\n0)Cerrar sesion");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: //se muestran las rentas
                    break;
                case 2://se muestra la informacion
                    break;
                case 3: //se muestran los libros disponibles
                    break;
                case 0:
                    flag=false;
                    sc.nextLine();
                    break;
                default:
                    System.out.println("ingrese una opcion valida");
                    break;
            }
        } while (flag);
    }
    private void mostrarMenuTrabajador(){
        Boolean flag = true;
        do {
            System.out.println("Seleccione al menu que desea acceder");
            System.out.println("1)Clientes\n2)Libros\n0)Cerrar Sesion");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    menuLibros();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 0:
                    flag=false;
                    sc.nextLine();
                    break;
                default:
                    System.out.println("ingrese una opcion valida");
                    break;
            }
        } while (flag);
    }
    private void mostrarMenuGerente(){
        Boolean flag = true;
        do {
            System.out.println("Seleccione al menu que desea acceder");
            System.out.println("1)Clientes y libros \n2)Registrar rentas\n0)Cerrar sesion");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    mostrarMenuTrabajador();
                    break;
                case 2:
                    menuRegistroRentas();
                    break;
                case 0:
                    flag=false;
                    sc.nextLine();
                    break;
                default:
                    System.out.println("ingrese una opcion valida");
                    break;
            }
        }while(flag);
    }
    public static void menuLibros() {
        boolean flag = true;
        do {
            System.out.println("Menu de libros");
            System.out.println("1)Registrar Libro\n2)Ver libros disponibles\n3)Modificar Libros\n4)Eliminar libro 0)Salir");
            System.out.println("Seleccione una opcion: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: //metodo para registrar un libro
                    break;
                case 2://metodo mostrar libros
                    break;
                case 3: //metodo modificar libro
                    break;
                case 4: //metodo eliminar libro
                    break;
                default:
                    flag = false;
                    break;
            }
        } while (flag);
    }
    public void menuClientes() {
        boolean flag = true;
        do {
            System.out.println("Menu");
            System.out.println("1)Registrar cliente\n2)Ver clientes\n3)Modificar cliente\n4)Eliminar cliente 0)Cerrar sesion");
            System.out.println("Seleccione una opcion: ");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: //metodo para registrar un cliente
                    break;
                case 2://metodo mostrar clientes
                    break;
                case 3: //metodo modificar cliente
                    break;
                case 4: //metodo eliminar cliente
                    break;
                case 0:
                    flag = false;
                    sc.nextLine();
                    break;
                default:
                    System.out.println("Ingrese una opcion valida");
                    break;
            }
        } while (flag);
    }
    public void menuRegistroRentas(){
        //aqui vamos a podir la informacion para registrar una renta
    }
}
