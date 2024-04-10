package Usuarios;

import Usuarios.utils.Rol;
import java.time.LocalDate;
public class Cliente extends Usuario {
    private LocalDate fechaRegistro;

    public Cliente(String nombre, String apelllido){
        super(nombre, apelllido, Rol.CLIENTE);
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
}
