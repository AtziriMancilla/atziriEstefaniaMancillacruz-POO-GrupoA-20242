package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;
public class Trabajador extends Usuario{
    private String horario;
    private String areaTrabajo;
    private LocalDate fechaContrato;
    private double sueldo;
    public Trabajador(String nombre, String apellido,  LocalDate fechaNacimiento, String nombreUsuario, String contrasena, String horario, String areaTrabajo, double sueldo){
        super(nombre, apellido, Rol.TRABAJADOR, fechaNacimiento, nombreUsuario, contrasena );
        this.horario = horario;
        this.areaTrabajo = areaTrabajo;
        this.fechaContrato = LocalDate.now();
        this.sueldo = sueldo;
    }
    @Override
    public String toString (){
        return String.format("%s, horario: %s, area de trabajo: %s, fecha de contrato: %s, sueldo: %d", super.toString(), horario, areaTrabajo, fechaContrato, sueldo);
    }
}


