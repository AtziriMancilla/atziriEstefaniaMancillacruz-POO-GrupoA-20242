package biblioteca;
import Usuarios.Usuario;
import Usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    static Scanner sc = new Scanner(System.in);

    public static void ejecutarMenu(){
        Biblioteca biblioteca = new Biblioteca();
        Usuario user = new Usuario("Andrea", "Duran", Rol.TRABAJADOR, LocalDate.now(),"Canelita","1234");
        biblioteca.usuarios.add(user);
        Rol rol = null;
        System.out.println("Ingrese usuario");
        String usuario = sc.nextLine();
        for (Usuario usuario1 : biblioteca.usuarios){
            if(usuario1.getNombreUsuario().equals(usuario)){
                System.out.println("Ingrese contraseña");
                String contrasena = sc.nextLine();
                if(usuario1.getContrasena().equals(contrasena)){
                    rol = usuario1.getRol();
                    System.out.println("Bienvenido a la libreria");
                    switch (rol){
                        case CLIENTE:
                            ejecutarMenuCliente();
                            break;
                        case TRABAJADOR:
                            ejecutarMenuTrabajador();
                            break;
                        case GERENTE:
                            ejecutarMenuGerente();
                            break;
                    }
                } else System.out.println("Contraseña inválida");
            }else System.out.println("Usuario no existe, intenta de nuevo");

        }

    }
    public static void ejecutarMenuCliente(){
        boolean flag = true;
        do {
            System.out.println("Seleccione opción deseada");
            System.out.println("1)Ver rentas\n2)Ver Información\n3)Ver libros disponibles\n0)Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: //se muestran las rentas
                    break;
                case 2://se muestra la informacion
                    break;
                case 3: //se muestran los libros disponibles
                    break;
                default:
                    flag=false;
                    break;
                }
        } while (flag);
    }
    public static void ejecutarMenuTrabajador() {
        Boolean flag = true;
        do {
            System.out.println("Seleccione al menu que desea acceder");
            System.out.println("1)Clientes\n2)Libros");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    menuLibros();
                    break;
                case 2:
                    menuClientes();
                    break;
                default:
                    System.out.println("ingrese una opcion valida");
            }
        } while (flag);
    }
    public static void ejecutarMenuGerente() {
            Boolean flag = true;
            do {
                System.out.println("Seleccione al menu que desea acceder");
                System.out.println("1)Clientes y libros \n2)Registrar rentas\n0)Salir");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        ejecutarMenuTrabajador();
                        break;
                    case 2:
                        menuRegistroRentas();
                        break;
                    case 0:
                        flag=false;
                    default:
                        System.out.println("ingrese una opcion valida");
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
        public static void menuClientes() {
            boolean flag = true;
            do {
                System.out.println("Menu");
                System.out.println("1)Registrar cliente\n2)Ver clientes\n3)Modificar cliente\n4)Eliminar cliente 0)Salir");
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
                    default:
                        flag = false;
                        break;
                }
            } while (flag);
        }
        public static void menuRegistroRentas(){
            //aqui vamos a podir la informacion para registrar una renta
        }
    }

