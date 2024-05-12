package Usuarios;

import Usuarios.utils.Rol;
import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Trabajador extends Usuario{
    private String horario;
    private String areaTrabajo;
    private LocalDate fechaContrato;
    private double sueldo;
    public Trabajador(String nombre, String apellidoPaterno, String apellidoMaterno, LocalDate fechaNacimiento, String numeroTelefono,String nombreUsuario, String contrasena, String horario, String areaTrabajo, double sueldo){
        super(nombre, apellidoPaterno,apellidoMaterno,fechaNacimiento, Rol.TRABAJADOR, numeroTelefono, nombreUsuario, contrasena );
        this.horario = horario;
        this.areaTrabajo = areaTrabajo;
        this.fechaContrato = LocalDate.now();
        this.sueldo = sueldo;
    }
    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
    public String getAreaTrabajo() {
        return areaTrabajo;
    }

    public void setAreaTrabajo(String areaTrabajo) {
        this.areaTrabajo = areaTrabajo;
    }
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString (){
        return String.format("%s, horario: %s, area de trabajo: %s, fecha de contrato: %s, sueldo: %f", super.toString(), horario, areaTrabajo, fechaContrato, sueldo);
    }
    public static void registrarTrabajador() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datoscComun = DatosComun.obtenerDatosComun(Rol.TRABAJADOR);
        String nombre = datoscComun.get(0);
        String apellidoPaterno = datoscComun.get(1);
        String apellidoMaterno = datoscComun.get(2);
        String telefono = datoscComun.get(3);
        String nombreUsuario = datoscComun.get(4);
        String contrasena = datoscComun.get(5);
        System.out.println("Ingresa la fecha de nacimiento");
        LocalDate fechaNacimiento=DatosComun.obtenerFechaNacimiento();
        System.out.println("Ingrese el horario de trabajo");
        String horarioTrabajo = sc.nextLine();
        System.out.println("Ingrese el area de trabajo");
        String areaTrabajo = sc.nextLine();
        System.out.println("Ingrese el sueldo");
        double sueldo = sc.nextDouble();
        Trabajador trabajador = new Trabajador(nombre, apellidoPaterno,apellidoMaterno,fechaNacimiento,telefono, nombreUsuario, contrasena, horarioTrabajo, areaTrabajo, sueldo);
        if (!Biblioteca.usuarios.containsKey(Rol.TRABAJADOR)) {
            Biblioteca.usuarios.put(Rol.TRABAJADOR, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.TRABAJADOR).add(trabajador);
        System.out.println("\nTrabajador Registrado\n");
    }
    public static void mostrarTrabajadores() {
        System.out.println("\nTrabajadores en la biblioteca\n");
        if(Biblioteca.usuarios.get(Rol.TRABAJADOR).isEmpty()){
            System.out.println("No hay trabajadores registrados");
        }
        else {
            int i = 1;
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.TRABAJADOR)) {
                Trabajador trabajador = (Trabajador) usuario;
                System.out.println(i + ") " + trabajador.toString());
                i++;
            }
        }
    }
    public static void borrarTrabajador(){
        Scanner sc=new Scanner(System.in);
        mostrarTrabajadores();
        System.out.println("Selecciona el cliente que deseas eliminar");
        int numTrabajador=sc.nextInt();
        System.out.println("Seleccionaste a: ");
        Biblioteca.usuarios.get(Rol.TRABAJADOR).get(numTrabajador-1).toString();
        System.out.println("¿Deseas eliminarlo? 1) Si 2) Cancelar");
        int opcion= sc.nextInt();
        if(opcion==1){
            Biblioteca.usuarios.get(Rol.TRABAJADOR).remove(numTrabajador-1);
            System.out.println("Trabajador eliminado");
        }
        else{
            System.out.println("Se cancelo la eliminacion");
        }
    }
    public static void editarInfo(){
        Scanner sc=new Scanner(System.in);
        mostrarTrabajadores();
        System.out.println("Selecciona el trabajador: ");
        int numTrabajador=sc.nextInt();
        System.out.println("¿Qué información deseas editar?");
        System.out.println("1) Nombre\n2) Apellido paterno\n3) Apellido Materno\n4) Teléfono\n5) Nombre usuario\n6) Horario\n7) Área de trabajo\n8) Sueldo");
        int opcion=sc.nextInt();
        Trabajador trabajador=(Trabajador) Biblioteca.usuarios.get(Rol.TRABAJADOR).get(numTrabajador-1);
        switch (opcion){
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                trabajador.setNombre(sc.nextLine());
                Biblioteca.usuarios.get(Rol.TRABAJADOR).set(numTrabajador-1,trabajador);
                System.out.println("Nombre modificado");
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido paterno: ");
                trabajador.setApellidoPaterno(sc.nextLine());
                Biblioteca.usuarios.get(Rol.TRABAJADOR).set(numTrabajador-1,trabajador);
                System.out.println("Apellido modificado");
                break;
            case 3:
                System.out.println("Ingrese el nuevo apellido materno: ");
                trabajador.setApellidoMaterno(sc.nextLine());
                Biblioteca.usuarios.get(Rol.TRABAJADOR).set(numTrabajador-1,trabajador);
                System.out.println("Apellido modificado");
                break;
            case 4:
                System.out.println("Ingrese el nuevo telefono: ");
                trabajador.setNumeroTelefono(sc.nextLine());
                Biblioteca.usuarios.get(Rol.TRABAJADOR).set(numTrabajador-1,trabajador);
                System.out.println("Telefono modificado");
                break;
            case 5:
                System.out.println("Ingrese el nuevo nombre de usuario: ");
                trabajador.setNombreUsuario(sc.nextLine());
                Biblioteca.usuarios.get(Rol.TRABAJADOR).set(numTrabajador-1,trabajador);
                System.out.println("Nombre de usuario modificado");
                break;
            case 6:
                System.out.println("Ingrese el nuevo horario: ");
                trabajador.setHorario(sc.nextLine());
                Biblioteca.usuarios.get(Rol.TRABAJADOR).set(numTrabajador-1,trabajador);
                System.out.println("Equipo al que coordina modificado");
                break;
            case 7:
                System.out.println("Ingrese la nueva area de trabajo: ");
                trabajador.setAreaTrabajo(sc.nextLine());
                Biblioteca.usuarios.get(Rol.TRABAJADOR).set(numTrabajador-1,trabajador);
                System.out.println("Numero de personas a su cargo modificado");
                break;
            case 8:
                System.out.println("Ingrese el nuevo sueldo: ");
                trabajador.setSueldo(sc.nextDouble());
                Biblioteca.usuarios.get(Rol.TRABAJADOR).set(numTrabajador-1,trabajador);
                System.out.println("Sueldo modificado");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        }
    }
}


