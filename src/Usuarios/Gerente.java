package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;
import java.util.ArrayList;

public class Gerente extends Usuario {
    private LocalDate fechaContrato;
    private double salario;
    private int empleados ;
    public Gerente(String nombre, String apelllido, Double salario){
        super(nombre, apelllido, Rol.GERENTE);
        this.salario=salario;
        this.fechaContrato=LocalDate.now();//trae la fecha actual y la asigna a este atributo

    }

    public LocalDate getFechaRegistro() {
        return fechaContrato;
    }

    public void mostrarInfo (){
        System.out.println(fechaContrato);
    }
    @Override
    public String toString(){
        return String.format("%s, fecha de contrato: %s, salario: %f", super.toString(), fechaContrato,salario);
    }
}
