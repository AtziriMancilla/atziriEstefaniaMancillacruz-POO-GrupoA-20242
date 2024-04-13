public class Producto {
    private static int CANTIDAD_PRODUCTOS = 0;
    private int numeroSerie;
    private String nombre;
    private double precio;
    private String fechaImportacion;
    private int stock;
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public void comprarProducto(int cant) {
        stock-=cant;
    }
    public Producto(String nombre, double precio, String fechaImportacion, int stock) {
        this.numeroSerie = CANTIDAD_PRODUCTOS++;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaImportacion = fechaImportacion;
        this.stock = stock;
        CANTIDAD_PRODUCTOS++;
    }
    protected String obtenerInformacion() {
        return String.format("Nombre: %s, precio %f, fecha de importación: %s, stock: %d",
                nombre, precio, fechaImportacion, stock);
    }
    public void AgregarStock(int cantidad){
        stock+=cantidad;
    }
    public void quitarDeStock(int cantidad){
        stock-=cantidad;
    }
}

