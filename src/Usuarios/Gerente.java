package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario{
    private String equipoQueCoordina;
    private int personasASuCargo;
    private LocalDate fechaAscenso;
    private double sueldo;
    public Gerente(String nombre, String apellido, String numeroTelefono, String nombreUsuario, String contrasena, String equipoQueCoordina, int personasASuCargo){
        super(nombre, apellido, Rol.GERENTE, numeroTelefono, nombreUsuario, contrasena);
        this.equipoQueCoordina= equipoQueCoordina;
        this.personasASuCargo= personasASuCargo;
        this.fechaAscenso =LocalDate.now();
    }
    @Override
    public String toString(){
        return String.format("%s, fecha de ascenso: %s, equipo que coordina: %s, personas a su cargo: %d", super.toString(), fechaAscenso, equipoQueCoordina, personasASuCargo);
    }
}