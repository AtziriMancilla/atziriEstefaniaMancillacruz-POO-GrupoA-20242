package Usuarios;
import Usuarios.utils.Rol;
import java.time.LocalDate;

public class Gerente extends Usuario {
    private LocalDate fechaContrato;
    private double salario;
    private int empleadosACargo ;
    public Gerente(String nombre, String apelllido, Double salario,int empleadosACargo){
        super(nombre, apelllido, Rol.GERENTE);
        this.salario=salario;
        this.fechaContrato=LocalDate.now();//trae la fecha actual y la asigna a este atributo
        this.empleadosACargo=empleadosACargo;
    }

    public LocalDate getFechaRegistro() {
        return fechaContrato;
    }

    public void mostrarInfo (){
        System.out.println(fechaContrato);
    }
    @Override
    public String toString(){
        return String.format("%s, fecha de contrato: %s, salario: %f, num. empleados a cargo: %d", super.toString(), fechaContrato,salario,empleadosACargo);
    }
}
