package biblioteca;

import Usuarios.Cliente;
import Usuarios.Gerente;
import Usuarios.Trabajador;
import Usuarios.Usuario;
import Usuarios.utils.Rol;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
    public void registrarCliente() {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> datos=registrarDatosComun();
        System.out.println("**Fecha de nacimiento**");
        LocalDate fecha=registrarFecha();
        Cliente cliente=new Cliente(datos.get(0), datos.get(1),fecha,datos.get(2), datos.get(3));
        usuarios.add(cliente);
        System.out.println("Cliente creado con exito");
    }
    public void registrarTrabajador() {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> datos=registrarDatosComun();
        System.out.println("**Fecha de nacimiento**");
        LocalDate fecha=registrarFecha();
        System.out.println("Ingrese el horario: ");
        String horario= sc.nextLine();
        System.out.println("Ingrese el area de trabajo: ");
        String areaTrabajo=sc.nextLine();
        System.out.println("Ingrese el sueldo: ");
        double sueldo=sc.nextDouble();
        Trabajador trabajador=new Trabajador(datos.get(0), datos.get(1),fecha,datos.get(2), datos.get(3),horario,areaTrabajo,sueldo);
        usuarios.add(trabajador);
        System.out.println("Trabajador creado con exito");
    }
    public void registrarGerente() {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> datos=registrarDatosComun();
        System.out.println("**Fecha de nacimiento**");
        LocalDate fecha=registrarFecha();
        System.out.println("Ingrese el equipo que coordina: ");
        String equipo= sc.nextLine();
        System.out.println("Ingrese las personas a su cargo: ");
        int personasAsuCargo=sc.nextInt();
        Gerente gerente=new Gerente(datos.get(0), datos.get(1),fecha,datos.get(2), datos.get(3),equipo,personasAsuCargo);
        usuarios.add(gerente);
        System.out.println("Gerente creado con exito");
    }
    public ArrayList<String> registrarDatosComun(){
        Scanner sc=new Scanner(System.in);
        ArrayList<String> datos=new ArrayList<>();
        System.out.println("Ingrese el nombre: ");
        datos.add(sc.nextLine());
        System.out.println("Ingrese el apellido: ");
        datos.add(sc.nextLine());
        System.out.println("Ingrese el nombre de usuario: ");
        datos.add(sc.nextLine());
        System.out.println("Ingrese la contraseña: ");
        datos.add(sc.nextLine());
        return datos;
    }
    public LocalDate registrarFecha(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el año: ");
        int anio=sc.nextInt();
        System.out.println("Ingrese el mes: ");
        int mes=sc.nextInt();
        System.out.println("Ingrese el dia: ");
        int dia=sc.nextInt();
        return LocalDate.of(anio,mes,dia);
    }
    public void mostrarUsuarios(){
        int i=1;
        for (Usuario usuario:usuarios){
            System.out.println(i+") "+usuario.toString());
            i++;
        }
    }
    public void mostrarClientes(){
        int i=1;
        for (Usuario usuario:usuarios){
            if(usuario.getRol()== Rol.CLIENTE) {
                System.out.println(i + ") " + usuario.toString());
                i++;
            }
        }
    }
    public void mostrarTrabajadores(){
        int i=1;
        for (Usuario usuario:usuarios){
            if(usuario.getRol()== Rol.TRABAJADOR) {
                System.out.println(i + ") " + usuario.toString());
                i++;
            }
        }
    }
    public void mostrarGerente(){
        int i=1;
        for (Usuario usuario:usuarios){
            if(usuario.getRol()== Rol.GERENTE) {
                System.out.println(i + ") " + usuario.toString());
                i++;
            }
        }
    }

}
