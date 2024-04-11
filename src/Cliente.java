import java.time.LocalDate;

public class Cliente extends Persona{
    LocalDate fechaRegistro;
    public Cliente(String nombre, String apellido, String direccion, LocalDate fechaRegistro) {
        super(nombre, apellido, direccion);
        this.fechaRegistro=fechaRegistro;
    }

    public String mostrarInfoConFecha() {
        return super.mostrarInfo()+", Fecha de registro: "+fechaRegistro;
    }

}
