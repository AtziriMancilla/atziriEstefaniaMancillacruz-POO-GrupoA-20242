package biblioteca.utils;

import Usuarios.Usuario;
import Usuarios.utils.Rol;
import biblioteca.Biblioteca;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DatosComun {
    public static ArrayList<String> obtenerDatosComun(Rol rol){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> datosComun=new ArrayList<>();
        String rolActual = rol == Rol.CLIENTE ? "Cliente": rol == Rol.TRABAJADOR ? "Trabajador" : "Gerente";
        System.out.println(String.format("\n Registrar %s",rolActual));
        System.out.println("Ingresa el nombre: ");
        String nombre=sc.nextLine();
        System.out.println("Ingresa el apellido:");
        String apellido=sc.nextLine();
        String telefono=obtenerNumeroTelefono(rol);
        String nombreUsuario=obtenerNombreUsuario(rol);
        System.out.println("Ingresa la contraseña: ");
        String contrasena=sc.nextLine();
        datosComun.addAll(Arrays.asList(nombre,apellido,telefono,nombreUsuario,contrasena));
        return datosComun;
    }
    private static String obtenerNumeroTelefono(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        boolean numeroExistente = true;
        String telefono = "";

        do {
            System.out.println("Ingresa el numero de telefono");
            telefono = scanner.nextLine();

            numeroExistente = false;
            for (Usuario usuario : Biblioteca.usuarios.get(rol)) {
                if (usuario.getNumeroTelefono().equals(telefono)) {
                    numeroExistente = true;
                }
            }

            if (numeroExistente) {
                System.out.println("El numero ya existe. Intenta de nuevo\n");
            }
        } while (numeroExistente);

        return telefono;
    }

    private static String obtenerNombreUsuario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        boolean nombreUsuarioExistente = true;
        String nombreUsuario = "";

        do {
            System.out.println("Ingresa el el nombre de usuario");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;
            for (Usuario usuario : Biblioteca.usuarios.get(rol)) {
                if (usuario.getNombreUsuario().equals(nombreUsuario)) {
                    nombreUsuarioExistente = true;
                }
            }

            if (nombreUsuarioExistente) {
                System.out.println("El nombre de usuario ya existe. Intenta de nuevo\n");
            }
        } while (nombreUsuarioExistente);

        return nombreUsuario;
    }

}
