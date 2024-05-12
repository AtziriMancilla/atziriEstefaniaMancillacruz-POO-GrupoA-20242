package Usuarios;
import Usuarios.utils.Rol;
import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Gerente extends Usuario{
    private String equipoQueCoordina;
    private int personasASuCargo;
    private LocalDate fechaAscenso;
    private double sueldo;
    public Gerente(String nombre, String apellidoPaterno,String apellidoMaterno, String numeroTelefono,LocalDate fechaNacimiento, String nombreUsuario, String contrasena, String equipoQueCoordina, int personasASuCargo){
        super(nombre, apellidoPaterno,apellidoMaterno, fechaNacimiento,Rol.GERENTE, numeroTelefono, nombreUsuario, contrasena);
        this.equipoQueCoordina= equipoQueCoordina;
        this.personasASuCargo= personasASuCargo;
        this.fechaAscenso =LocalDate.now();
    }
    public int getPersonasASuCargo() {
        return personasASuCargo;
    }

    public void setPersonasASuCargo(int personasASuCargo) {
        this.personasASuCargo = personasASuCargo;
    }
    public String getEquipoQueCoordina() {
        return equipoQueCoordina;
    }

    public void setEquipoQueCoordina(String equipoQueCoordina) {
        this.equipoQueCoordina = equipoQueCoordina;
    }
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    @Override
    public String toString(){
        return String.format("%s, fecha de ascenso: %s, equipo que coordina: %s, personas a su cargo: %d, sueldo %f", super.toString(), fechaAscenso, equipoQueCoordina, personasASuCargo,sueldo);
    }
    public static void registrarGerente() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> datoscComun = DatosComun.obtenerDatosComun(Rol.GERENTE);
        String nombre = datoscComun.get(0);
        String apellidoPaterno = datoscComun.get(1);
        String apellidoMaterno = datoscComun.get(2)
        String telefono = datoscComun.get(3);
        String nombreUsuario = datoscComun.get(4);
        String contrasena = datoscComun.get(5);
        System.out.println("Ingresa la fecha de nacimiento");
        LocalDate fechaNacimiento=DatosComun.obtenerFechaNacimiento();
        System.out.println("Ingrese nombre del equipo que coordina");
        String equipo = sc.nextLine();
        System.out.println("Ingrese el numero de personas a su cargo");
        int personasASuCargo = sc.nextInt();
        Gerente gerente = new Gerente(nombre, apellidoPaterno,apellidoMaterno, telefono, fechaNacimiento, nombreUsuario, contrasena, equipo, personasASuCargo);
        if (Biblioteca.usuarios.containsKey(Rol.GERENTE)) {
            Biblioteca.usuarios.put(Rol.GERENTE, new ArrayList<Usuario>());
        }
        Biblioteca.usuarios.get(Rol.GERENTE).add(gerente);
        System.out.println("\nGerente Registrado\n");
    }
    public static void mostrarGerentes() {
        System.out.println("\nGerentes en la biblioteca\n");
        if(Biblioteca.usuarios.get(Rol.GERENTE).isEmpty()){
            System.out.println("No hay gerentes registrados");
        }
        else {
            int i=1;
            for (Usuario usuario : Biblioteca.usuarios.get(Rol.GERENTE)) {
                Trabajador trabajador = (Trabajador) usuario;
                System.out.println(i + ") " + trabajador.toString());
                i++;
            }
        }
    }
    public static void borrarGerente(){
        Scanner sc=new Scanner(System.in);
        mostrarGerentes();
        System.out.println("Selecciona el cliente que deseas eliminar");
        int numGerente=sc.nextInt();
        System.out.println("Seleccionaste a: ");
        Biblioteca.usuarios.get(Rol.GERENTE).get(numGerente-1).toString();
        System.out.println("¿Deseas eliminarlo? 1) Si 2) Cancelar");
        int opcion= sc.nextInt();
        if(opcion==1){
            Biblioteca.usuarios.get(Rol.GERENTE).remove(numGerente-1);
            System.out.println("Gerente eliminado");
        }
        else{
            System.out.println("Se cancelo la eliminacion");
        }
    }
    public static void editarInfo(){
        Scanner sc=new Scanner(System.in);
        mostrarGerentes();
        System.out.println("Seleciona el gerente: ");
        int numGerente=sc.nextInt();
        System.out.println("¿Qué informacion deseas editar?");
        System.out.println("1) Nombre\n2) Apellido\n3) Telefono\n4) Nombre usuario\n5) Equipo que coordina\n6) Personas a su cargo\n7) Sueldo");
        int opcion=sc.nextInt();
        Gerente gerente=(Gerente) Biblioteca.usuarios.get(Rol.GERENTE).get(numGerente-1);
        switch (opcion){
            case 1:
                System.out.println("Ingrese el nuevo nombre: ");
                gerente.setNombre(sc.nextLine());
                Biblioteca.usuarios.get(Rol.GERENTE).set(numGerente-1,gerente);
                System.out.println("Nombre modificado");
                break;
            case 2:
                System.out.println("Ingrese el nuevo apellido paterno: ");
                gerente.setApellidoPaterno(sc.nextLine());
                Biblioteca.usuarios.get(Rol.GERENTE).set(numGerente-1,gerente);
                System.out.println("Apellido modificado");
                break;
            case 3:
                System.out.println("Ingrese el nuevo apellido materno: ");
                gerente.setApellidoPaterno(sc.nextLine());
                Biblioteca.usuarios.get(Rol.GERENTE).set(numGerente-1,gerente);
                System.out.println("Apellido modificado");
                break;
            case 4:
                System.out.println("Ingrese el nuevo telefono: ");
                gerente.setNumeroTelefono(sc.nextLine());
                Biblioteca.usuarios.get(Rol.GERENTE).set(numGerente-1,gerente);
                System.out.println("Telefono modificado");
                break;
            case 5:
                System.out.println("Ingrese el nuevo nombre de usuario: ");
                gerente.setNombreUsuario(sc.nextLine());
                Biblioteca.usuarios.get(Rol.GERENTE).set(numGerente-1,gerente);
                System.out.println("Nombre de usuario modificado");
                break;
            case 6:
                System.out.println("Ingrese el nuevo equipo que coordina: ");
                gerente.setEquipoQueCoordina(sc.nextLine());
                Biblioteca.usuarios.get(Rol.GERENTE).set(numGerente-1,gerente);
                System.out.println("Equipo al que coordina modificado");
                break;
            case 7:
                System.out.println("Ingrese el nuevo numero de personas a su cargo: ");
                gerente.setPersonasASuCargo(sc.nextInt());
                Biblioteca.usuarios.get(Rol.GERENTE).set(numGerente-1,gerente);
                System.out.println("Numero de personas a su cargo modificado");
                break;
            case 8:
                System.out.println("Ingrese el nuevo sueldo: ");
                gerente.setSueldo(sc.nextDouble());
                Biblioteca.usuarios.get(Rol.GERENTE).set(numGerente-1,gerente);
                System.out.println("Sueldo modificado");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + opcion);
        }
    }
}