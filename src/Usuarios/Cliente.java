package Usuarios;

import Usuarios.utils.Rol;
import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apellido,String numeroTelefono, String nombreUsuario, String contrasena){
        super(nombre, apellido, Rol.CLIENTE,numeroTelefono, nombreUsuario, contrasena );
        this.fechaRegistro=LocalDate.now();//trae la fecha actual y la asigna a este atributo

    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public void mostrarInfo (){
        System.out.println(fechaRegistro);
    }
    @Override
    public String toString(){
        return String.format("%s, fecha de registro: %s", super.toString(), fechaRegistro);
    }

    public static void registrarCliente() {
        ArrayList<String> datoscComun= DatosComun.obtenerDatosComun(Rol.CLIENTE);
        String nombre=datoscComun.get(0);
        String apellido=datoscComun.get(1);
        String telefono= datoscComun.get(2);
        String nombreUsuario= datoscComun.get(3);
        String contrasena= datoscComun.get(4);
        Cliente cliente=new Cliente(nombre,apellido,telefono,nombreUsuario,contrasena);
        if(!Biblioteca.usuarios.containsKey(Rol.CLIENTE)){
            Biblioteca.usuarios.put(Rol.CLIENTE,new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.CLIENTE).add(cliente);
        System.out.println("\nCliente Registrado\n");
    }
    public static void mostrarClientes() {
        System.out.println("\nClientes en la biblioteca\n");
        if(Biblioteca.usuarios.get(Rol.CLIENTE).isEmpty()){
            System.out.println("No hay clientes registrados");
        }
        else {
            int i = 1;
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.CLIENTE)) {
                Cliente cliente = (Cliente) usuario;
                System.out.println(i + ") " + cliente.toString());
                i++;
            }
        }
    }
    public static void borrarCliente(){
        Scanner sc=new Scanner(System.in);
        mostrarClientes();
        System.out.println("Selecciona el cliente que deseas eliminar");
        int numCliente=sc.nextInt();
        System.out.println("Seleccionaste a: ");
        Biblioteca.usuarios.get(Rol.CLIENTE).get(numCliente-1).toString();
        System.out.println("¿Deseas eliminarlo? 1) Si 2) Cancelar");
        int opcion= sc.nextInt();
        if(opcion==1){
            Biblioteca.usuarios.get(Rol.CLIENTE).remove(numCliente-1);
            System.out.println("Cliente eliminado");
        }
        else{
            System.out.println("Se cancelo la eliminacion");
        }
    }
    public static void editarInfo(){
        Scanner sc=new Scanner(System.in);
        mostrarClientes();
        System.out.println("Selecciona el cliente: ");
        int numCliente=sc.nextInt();
        System.out.println("¿Qué información deseas editar?");
        System.out.println("1) Nombre\n2) Apellido\n3) Teléfono\n4) Nombre usuario\n5) Contraseña");
        int opcion=sc.nextInt();
        Cliente cliente=(Cliente) Biblioteca.usuarios.get(Rol.CLIENTE).get(numCliente-1);
        switch (opcion){
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                cliente.setNombre(sc.nextLine());
                Biblioteca.usuarios.get(Rol.CLIENTE).set(numCliente-1,cliente);
                System.out.println("Nombre modificado");
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido: ");
                cliente.setApellido(sc.nextLine());
                Biblioteca.usuarios.get(Rol.CLIENTE).set(numCliente-1,cliente);
                System.out.println("Apellido modificado");
                break;
            case 3:
                System.out.println("Ingrese el nuevo telefono: ");
                cliente.setNumeroTelefono(sc.nextLine());
                Biblioteca.usuarios.get(Rol.CLIENTE).set(numCliente-1,cliente);
                System.out.println("Telefono modificado");
                break;
            case 4:
                System.out.println("Ingrese el nuevo nombre de usuario: ");
                cliente.setNombreUsuario(sc.nextLine());
                Biblioteca.usuarios.get(Rol.CLIENTE).set(numCliente-1,cliente);
                System.out.println("Nombre de usuario modificado");
                break;
            case 5:
                System.out.println("Ingrese la nueva contraseña: ");
                cliente.setContrasena(sc.nextLine());
                Biblioteca.usuarios.get(Rol.CLIENTE).set(numCliente-1,cliente);
                System.out.println("Equipo al que coordina modificado");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        }
    }
}