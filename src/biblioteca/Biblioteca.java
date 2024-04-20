package biblioteca;

import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.*;

public class Biblioteca {
    HashMap<Rol, ArrayList<Usuario>> usuarios=new HashMap<>();
    //private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    private ArrayList<String> obtenerDatosComun(Rol rol){
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

    public Biblioteca() {
        Trabajador trabajador=new Trabajador("Andrea","Duran","4437277815","canelita","1234","09:00-12:00","Libreria centro",30000);
        usuarios.put(Rol.TRABAJADOR,new ArrayList<Usuario>());
        usuarios.put(Rol.GERENTE,new ArrayList<Usuario>());
        usuarios.put(Rol.CLIENTE,new ArrayList<Usuario>());
        usuarios.get(Rol.TRABAJADOR).add(trabajador);
    }

    public Usuario verificarInicioSesion(String usuario, String contrasena) {
        for (Usuario usuarioActual : usuarios.get(Rol.CLIENTE)) {
            if (usuarioActual.getNombreUsuario().equals(usuario)) {
                if (usuarioActual.getContrasena().equals(contrasena)) {
                    return usuarioActual;
                }

                return null;
            }
        }
        for (Usuario usuarioActual : usuarios.get(Rol.GERENTE)) {
            if (usuarioActual.getNombreUsuario().equals(usuario)) {
                if (usuarioActual.getContrasena().equals(contrasena)) {
                    return usuarioActual;
                }

                return null;
            }
        }
        for (Usuario usuarioActual : usuarios.get(Rol.TRABAJADOR)) {
            if (usuarioActual.getNombreUsuario().equals(usuario)) {
                if (usuarioActual.getContrasena().equals(contrasena)) {
                    return usuarioActual;
                }

                return null;
            }
        }

        return null;
    }

    public void registrarCliente() {
        ArrayList<String> datoscComun=obtenerDatosComun(Rol.CLIENTE);
        String nombre=datoscComun.get(0);
        String apellido=datoscComun.get(1);
        String telefono= datoscComun.get(2);
        String nombreUsuario= datoscComun.get(3);
        String contrasena= datoscComun.get(4);
        Cliente cliente=new Cliente(nombre,apellido,telefono,nombreUsuario,contrasena);
        if(!usuarios.containsKey(Rol.CLIENTE)){
            usuarios.put(Rol.CLIENTE,new ArrayList<Usuario>());
        }
        usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\nCliente Registrado\n");
    }
    public void registrarTrabajador() {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> datoscComun=obtenerDatosComun(Rol.TRABAJADOR);
        String nombre=datoscComun.get(0);
        String apellido=datoscComun.get(1);
        String telefono= datoscComun.get(2);
        String nombreUsuario= datoscComun.get(3);
        String contrasena= datoscComun.get(4);
        System.out.println("Ingrese el horario de trabajo");
        String horarioTrabajo=sc.nextLine();
        System.out.println("Ingrese el area de trabajo");
        String areaTrabajo=sc.nextLine();
        System.out.println("Ingrese el sueldo");
        double sueldo=sc.nextDouble();
        Trabajador trabajador=new Trabajador(nombre,apellido,telefono,nombreUsuario,contrasena,horarioTrabajo,areaTrabajo,sueldo);
        if(!usuarios.containsKey(Rol.TRABAJADOR)){
            usuarios.put(Rol.TRABAJADOR,new ArrayList<Usuario>());
        }
        usuarios.get(Rol.TRABAJADOR).add(trabajador);
        System.out.println("\nTrabajador Registrado\n");
    }
    public void registrarGerente() {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> datoscComun=obtenerDatosComun(Rol.GERENTE);
        String nombre=datoscComun.get(0);
        String apellido=datoscComun.get(1);
        String telefono= datoscComun.get(2);
        String nombreUsuario= datoscComun.get(3);
        String contrasena= datoscComun.get(4);
        System.out.println("Ingrese nombre del equipo que coordina");
        String equipo=sc.nextLine();
        System.out.println("Ingrese el numero de personas a su cargo");
        int personasASuCargo=sc.nextInt();
        Gerente gerente=new Gerente(nombre,apellido,telefono,nombreUsuario,contrasena,equipo,personasASuCargo);
        if(!usuarios.containsKey(Rol.GERENTE)){
            usuarios.put(Rol.GERENTE,new ArrayList<Usuario>());
        }
        usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nGerente Registrado\n");
    }

    public void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca\n");
        for (Usuario usuario : usuarios.get(Rol.CLIENTE)) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(cliente.toString());
        }
    }
    public void mostrarTrabajadores() {
        System.out.println("\nTrabajadores en la biblioteca\n");
        for (Usuario usuario : usuarios.get(Rol.TRABAJADOR)) {
            Trabajador trabajador = (Trabajador) usuario;
            System.out.println(trabajador.toString());
        }
    }
    public void mostrarGerentes() {
        System.out.println("\nGerentes en la biblioteca\n");
        for (Usuario usuario : usuarios.get(Rol.GERENTE)) {
            Trabajador trabajador = (Trabajador) usuario;
            System.out.println(trabajador.toString());
        }
    }

    private String obtenerNumeroTelefono(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        boolean numeroExistente = true;
        String telefono = "";

        do {
            System.out.println("Ingresa el numero de telefono");
            telefono = scanner.nextLine();

            numeroExistente = false;
            for (Usuario usuario : usuarios.get(rol)) {
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

    private String obtenerNombreUsuario(Rol rol) {
        Scanner scanner = new Scanner(System.in);
        boolean nombreUsuarioExistente = true;
        String nombreUsuario = "";

        do {
            System.out.println("Ingresa el el nombre de usuario");
            nombreUsuario = scanner.nextLine();

            nombreUsuarioExistente = false;
            for (Usuario usuario : usuarios.get(rol)) {
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