import java.time.LocalDate;
import java.util.ArrayList;

public class Compra {
    Cliente cliente;
    ArrayList<Carrito> productos;
    LocalDate fechaCompra;
    public Compra(Cliente cliente,ArrayList<Carrito> productos,LocalDate fechaCompra){
        this.cliente=cliente;
        this.productos=productos;
        this.fechaCompra=fechaCompra;
    }
    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }
    public ArrayList<Carrito> getProductos(){
        return productos;
    }
    public void mostrarProductos(){
        int i=1;
        System.out.println("\tCant\tProducto");
        for (Carrito carrito:productos){
            System.out.println("\t"+carrito.getCantidad()+"\t"+carrito.getProducto().obtenerInformacion());
            i++;
        }
    }
    public double totalCompra(){
        double total=0;
        for (Carrito carrito:productos){
            total+=carrito.subtotal();
        }
        return total;
    }
    public void mostrarCompra() {
        System.out.println("Cliente: " + cliente.mostrarInfoConFecha());
        System.out.println("Fecha de compra: " + fechaCompra);
        mostrarProductos();
        System.out.println("total: "+totalCompra());
    }
}
