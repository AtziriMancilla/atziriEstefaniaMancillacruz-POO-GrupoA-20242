package biblioteca;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.UsuarioEnSesion;
import java.time.LocalDate;
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
            System.out.println("3. Cerrar sesión");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    biblioteca.registrarCliente();
                    break;
                case 2:
                    biblioteca.mostrarClientes();
                    break;
                case 3:
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    inciarSesion();
                    break;
            }
        } while(opcion != 3);
    }

    private void mostrarMenuGerente() {
        Scanner scanner = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("\nMenú Gerente");
            System.out.println("Selecciona una opción para continuar");
            System.out.println("1. Registrar Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Cerrar sesión");

            switch (opcion) {
                case 1: biblioteca.registrarCliente();
                    break;
                case 2: biblioteca.mostrarClientes();
                    break;
                case 3:
                    UsuarioEnSesion.getInstancia().cerrarSesion();
                    inciarSesion();
                    break;
            }
        } while(opcion != 3);
    }
}