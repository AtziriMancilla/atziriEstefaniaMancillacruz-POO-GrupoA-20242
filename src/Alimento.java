public class Alimento extends Producto {
    private String fechaCaducidad;
    public Alimento(String nombre, double precio, String fechaImportacion, int stock, String fechaCaducidad) {
        super(nombre, precio, fechaImportacion, stock);
        this.fechaCaducidad = fechaCaducidad;
    }

    public String obtenerDatosAlimento() {
        return String.format("%s, fecha de caducidad: %s", super.obtenerInformacion(), fechaCaducidad);
    }
}