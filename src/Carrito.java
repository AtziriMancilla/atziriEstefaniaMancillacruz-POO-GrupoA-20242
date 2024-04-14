public class Carrito {
    private Producto producto;
    private int cantidad;
    public Carrito(Producto producto,int cantidad) {
        this.producto=producto;
        this.cantidad=cantidad;
        comprar(cantidad);
    }
    public Producto getProducto() {
        return producto;
    }
    public double subtotal(){
        return producto.getPrecio()*cantidad;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void comprar(int cantidad){
        producto.comprarProducto(cantidad);
    }
}
