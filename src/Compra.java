import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
    Cliente cliente;
    ArrayList<Producto> productos;
    double total;
    LocalDate fechaCompra;
    public Compra(Cliente cliente,ArrayList<Producto> productos,LocalDate fechaCompra){
        this.cliente=cliente;
        this.productos=productos;
        this.fechaCompra=fechaCompra;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public double getTotal() {
        return total;
    }
    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public ArrayList<Producto> getProductos() {
        return productos;
    }
    public String mostrarProductos(){
        for(Producto producto:productos) {
            return String.format("");
        }
    }
    public String mostrarCompra(){
        return String.format("Cliente: %s\nProductos: %s",cliente.mostrarInfoConFecha(),);
    }
}
