package biblioteca;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.UsuarioEnSesion;
import biblioteca.utils.DatosComun;
import libros.Libro;
import libros.LibroAccion;
import libros.LibroComedia;
import libros.LibroTerror;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

import static Usuarios.utils.Rol.*;

public class Menu {
    private Biblioteca biblioteca = new Biblioteca();
    private Scanner scanner = new Scanner(System.in);

    public void inciarSesion() {
        boolean datosCorrectos = false;

        do {
            System.out.println("BIENVENIDO AL SISTEMA DE LA BIBLIOTECA");
            System.out.println("Inicia sesión para continuar");

            System.out.println("Ingresa tu usuario: ");
            String usuario = scanner.nextLine();

            System.out.println("Ingresa tu contrasena: ");
            String contrasena = scanner.nextLine();

            Usuario usuarioActual = biblioteca.verificarInicioSesion(usuario, contrasena);

            if (usuarioActual != null) {
                UsuarioEnSesion.getInstancia().setUsuario(usuarioActual);
                datosCorrectos = true;
                seleccionarMenu();
            } else {
                System.out.println("Usuario o contrasena incorrectos. Intenta de nuevo.");
            }

        } while (!datosCorrectos);
    }

    // Función lambda
    private void seleccionarMenu() {
        switch (UsuarioEnSesion.getInstancia().getUsuarioActual().getRol()) {
            case CLIENTE -> mostrarMenuCliente();
            case TRABAJADOR -> mostrarMenuTrabajador();
            case GERENTE -> mostrarMenuGerente();
        }
    }

    private void mostrarMenuCliente() {
        int opcion = 0;

        do {
            System.out.println("Menú Cliente");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Ver libros disponibles");
            System.out.println("2. Consultar mis rentas");
            System.out.println("3. Mostrar mis datos");
            System.out.println("4. Editar mi información");
            System.out.println("5. Cerrar sesión");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Libro.mostrarTodosLosLibros();
                    break;
                case 5:
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    inciarSesion();
                    break;
            }
        } while(opcion != 5);
    }

    private void mostrarMenuTrabajador() {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\nMenú Trabajador");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Registrar Libro");
            System.out.println("4. Filtrar libro");
            System.out.println("5. Cerrar sesion");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    biblioteca.registrarCliente();
                    break;
                case 2:
                    biblioteca.mostrarClientes();
                    break;
                case 3:
                    registrarLibroMenu();
                    break;
                case 4:
                    //filtro
                    break;
                case 5:
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    inciarSesion();
                    break;
            }
        } while(opcion != 3);
    }
    private void registrarLibroMenu(){
        Scanner sc=new Scanner(System.in);
        int opcion=0;
        boolean esDatoValido=false;
        do {
            System.out.println("Elegiste registrar un libro");
            System.out.println("Selecciona una opción: ");
            System.out.println("1. Terror\n2. Comedia\n3. Accion\n4. Regresar al menu principal");
            while(!esDatoValido) {
                try {
                    opcion = sc.nextInt();
                    if (opcion < 1 || opcion > 4) {
                        throw new InputMismatchException();
                    }
                    esDatoValido=true;
                } catch (InputMismatchException error) {
                    System.out.println("Opción no valida. Intenta de nuevo");
                }finally {//se ejecuta independientemente de si entra al catch o no
                    scanner.nextLine();
                }
            }
            esDatoValido=false;
            switch (opcion){
                case 1:
                    LibroTerror.registrarLibro();
                    break;
                case 2:
                    LibroComedia.registrarLibro();
                    break;
                case 3:
                    LibroAccion.registrarLibro();
                    break;
            }
        }while (opcion!=4);
    }

    private void mostrarMenuGerente() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("\nMenú Gerente");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Cerrar sesión");
            opcion= DatosComun.pedirNumero();
            switch (opcion) {
                case 1: biblioteca.registrarCliente();
                    break;
                case 2: biblioteca.mostrarClientes();
                    break;
                case 3:
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    inciarSesion();
                    break;
                default:
                    System.out.println("Opción no valida");
                    break;
            }
        } while(opcion != 3);
    }
}