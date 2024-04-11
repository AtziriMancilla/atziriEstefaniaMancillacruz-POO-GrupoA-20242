import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Tienda {
    private ArrayList<Limpieza> productosLimpieza = new ArrayList<Limpieza>();
    private ArrayList<Alimento> productosAlimento = new ArrayList<Alimento>();
    private ArrayList<Electrodomestico> productosElectrodomestico = new ArrayList<Electrodomestico>();
    private ArrayList<Belleza> productosBelleza = new ArrayList<Belleza>();
    private ArrayList<Compra> compras = new ArrayList<Compra>();
    private ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    private Scanner scanner = new Scanner(System.in);

    //metodo que pide datos al usuario
    private ArrayList<String> registrarDatosComun() {
        ArrayList<String> datosComun = new ArrayList<String>();

        System.out.println("Ingresa el nombre: ");
        String nombre = scanner.nextLine();
        datosComun.add(nombre);

        System.out.println("Ingresa el precio: ");
        double precio = scanner.nextDouble();
        datosComun.add(String.valueOf(precio));

        System.out.println("Ingresa la fecha de importación: ");
        String fechaImportacion = scanner.nextLine();
        datosComun.add(fechaImportacion);

        System.out.println("Ingresa el stock: ");
        int stock = scanner.nextInt();
        datosComun.add(String.valueOf(stock));

        return datosComun;
    }

    public void registrarProductoLimpieza() {
        System.out.println("\n** Registro Producto Limpieza **");

        ArrayList<String> datos =  registrarDatosComun();
        String nombre = datos.get(0);
        double precio = Double.parseDouble(datos.get(1));
        String fechaImportacion = datos.get(2);
        int stock = Integer.parseInt(datos.get(3));

        System.out.println("Ingresa la marca: ");
        String marca = scanner.nextLine();

        Limpieza limpieza = new Limpieza(nombre, precio, fechaImportacion, stock, marca);
        productosLimpieza.add(limpieza);

        System.out.println("\nProducto Registrado");
    }

    public void registrarProductoAlimento() {
        System.out.println("\n** Registro Producto Alimento **");

        ArrayList<String> datos =  registrarDatosComun();
        String nombre = datos.get(0);
        double precio = Double.parseDouble(datos.get(1));
        String fechaImportacion = datos.get(2);
        int stock = Integer.parseInt(datos.get(3));

        System.out.println("Ingresa la fecha de caducidad: ");
        String fechaCaducidad = scanner.nextLine();

        Alimento alimnento = new Alimento(nombre, precio, fechaImportacion, stock, fechaCaducidad);
        productosAlimento.add(alimnento);

        System.out.println("\nProducto Registrado");
    }
    public void registrarProductoBelleza() {
        System.out.println("\n** Registro Producto Belleza**");

        ArrayList<String> datos =  registrarDatosComun();
        String nombre = datos.get(0);
        double precio = Double.parseDouble(datos.get(1));
        String fechaImportacion = datos.get(2);
        int stock = Integer.parseInt(datos.get(3));

        System.out.println("Ingresa la marca: ");
        String marca = scanner.nextLine();
        System.out.println("Ingresa el total de ml: ");
        double contenidoMl = scanner.nextDouble();

        Belleza belleza = new Belleza(nombre, precio, fechaImportacion, stock, marca,contenidoMl);
        productosBelleza.add(belleza);

        System.out.println("\nProducto Registrado");
    }
    public void registrarProductoElectrodomestico() {
        System.out.println("\n** Registro Producto Electrodomestico**");

        ArrayList<String> datos =  registrarDatosComun();
        String nombre = datos.get(0);
        double precio = Double.parseDouble(datos.get(1));
        String fechaImportacion = datos.get(2);
        int stock = Integer.parseInt(datos.get(3));

        System.out.println("Ingresa la marca: ");
        String marca = scanner.nextLine();
        System.out.println("Ingresa el voltaje: ");
       double voltaje = scanner.nextDouble();

        Electrodomestico electrodomestico = new Electrodomestico(nombre, precio, fechaImportacion, stock, marca,voltaje);
        productosElectrodomestico.add(electrodomestico);

        System.out.println("\nProducto Registrado");
    }
    public void registrarCliente(){
        System.out.println("\n** Registro Cliente**");
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese el nombre");
        String nombre=sc.nextLine();
        System.out.println("Ingrese el apellido");
        String apellido=sc.nextLine();
        System.out.println("Ingrese la direccion: ");
        String direcion=sc.nextLine();
        LocalDate fechaRegistro=LocalDate.now();
        clientes.add(new Cliente(nombre,apellido,direcion,fechaRegistro));
    }
    public void mostrarProductos(){
        System.out.println("**Lista de productos**");
        System.out.println("Productos limpieza");
        mostrarLimpieza();
        System.out.println("Alimentos");
        mostrarAlimentos();
        System.out.println("Productos belleza");
        mostrarBelleza();
        System.out.println("Electrodomesticos");
        mostrarElectrodomesticos();
    }
    private void mostrarAlimentos(){
        int i=1;
        for (Alimento alimento:productosAlimento){
            System.out.println(i+") "+alimento.obtenerDatosAlimento());
            i++;
        }
    }
    private void mostrarBelleza(){
        int i=1;
        for (Belleza belleza:productosBelleza){
            System.out.println(i+") "+belleza.obtenerInformacion());
            i++;
        }
    }
    private void mostrarElectrodomesticos(){
        int i=1;
        for (Electrodomestico electrodomestico:productosElectrodomestico){
            System.out.println(i+") "+electrodomestico.obtenerInformacion());
            i++;
        }
    }
    private void mostrarLimpieza(){
        int i=1;
        for (Limpieza limpieza:productosLimpieza){
            System.out.println(i+") "+limpieza.obtenerInformacion());
            i++;
        }
    }
    public void mostrarClientes(){
        int i=1;
        for(Cliente cliente:clientes){
            System.out.println(i+") "+cliente.mostrarInfoConFecha());
            i++;
        }
    }
    public void eliminarProducto(){
        Scanner sc=new Scanner(System.in);
        System.out.println("**Eliminar producto**");
        System.out.println("1)Alimento\n2)Limpieza\n3)Belleza\n4)Electrodomestico");
        System.out.println("Seleccione el tipo de producto");
        int opcion=sc.nextInt();
        switch (opcion){
            case 1:
                mostrarAlimentos();
                System.out.println("Seleccione el alimento que desea eliminar: ");
                opcion=sc.nextInt();
                boolean band=false;
                for (Compra compra: compras) {
                    if (compra.getProductos().contains(productosAlimento.get(opcion - 1))) {
                        band = true;
                        break;
                    }
                }
                if (band){
                    System.out.println("No se puede eliminar este producto");
                }
                else {
                    productosAlimento.remove(opcion-1);
                    System.out.println("Producto eliminado");
                }
                break;
            case 2:
                mostrarLimpieza();
                System.out.println("Seleccione el producto de limpieza que desea eliminar: ");
                opcion=sc.nextInt();
                band=false;
                for (Compra compra: compras) {
                    if (compra.getProductos().contains(productosLimpieza.get(opcion - 1))) {
                        band = true;
                        break;
                    }
                }
                if (band){
                    System.out.println("No se puede eliminar este producto");
                }
                else {
                    productosLimpieza.remove(opcion-1);
                    System.out.println("Producto eliminado");
                }
                break;
            case 3:
                mostrarBelleza();
                System.out.println("Seleccione el producto de belleza que desea eliminar: ");
                opcion=sc.nextInt();
                band=false;
                for (Compra compra: compras) {
                    if (compra.getProductos().contains(productosBelleza.get(opcion - 1))) {
                        band = true;
                        break;
                    }
                }
                if (band){
                    System.out.println("No se puede eliminar este producto");
                }
                else {
                    productosBelleza.remove(opcion-1);
                    System.out.println("Producto eliminado");
                }
                break;
            case 4:
                mostrarElectrodomesticos();
                System.out.println("Seleccione el alimento que desea eliminar: ");
                opcion=sc.nextInt();
                band=false;
                for (Compra compra: compras) {
                    if (compra.getProductos().contains(productosElectrodomestico.get(opcion - 1))) {
                        band = true;
                        break;
                    }
                }
                if (band){
                    System.out.println("No se puede eliminar este producto");
                }
                else {
                    productosElectrodomestico.remove(opcion-1);
                    System.out.println("Producto eliminado");
                }
                break;
            default:
                System.out.println("Opcion no valida");
                break;
        }
    }
    public void eliminarCliente(){
        Scanner sc=new Scanner(System.in);
        System.out.println("**Eliminar cliente**");
        mostrarClientes();
        System.out.println("Seleccione una opcion: ");
        int opcion=sc.nextInt();
        boolean band=false;
        for (Compra compra: compras) {
            if (Objects.equals(compra.getCliente(), clientes.get(opcion - 1))) {
                band = true;
                break;
            }
        }
        if (band){
            System.out.println("No se puede eliminar este cliente");
        }
        else {
            clientes.remove(opcion-1);
            System.out.println("Cliente eliminado");
        }
    }
    public void realizarCompra(){
        Scanner sc=new Scanner(System.in);
        System.out.println("**Realizar Compra**");
        System.out.println("Seleccione el cliente");
        int opcion= sc.nextInt();
        Cliente cliente=clientes.get(opcion-1);
        boolean band=true;
        ArrayList<Producto> productos=new ArrayList<Producto>();
        do {
            System.out.println("1)Alimentos\n2)Limpieza\n3)Belleza\n4)Electrodomesticos\n5)Salir");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("**Alimentos**");
                    mostrarAlimentos();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    productos.add(productosAlimento.get(opcion-1));
                    break;
                case 2:
                    System.out.println("**Limpieza**");
                    mostrarLimpieza();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    productos.add(productosLimpieza.get(opcion-1));
                    break;
                case 3:
                    System.out.println("**Belleza**");
                    mostrarBelleza();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    productos.add(productosBelleza.get(opcion-1));
                    break;
                case 4:
                    System.out.println("**Electrodomesticos**");
                    mostrarElectrodomesticos();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    productos.add(productosElectrodomestico.get(opcion-1));
                    break;
                default:
                    band=false;
                    break;
            }
        }while(band);
        LocalDate fechaCompra=LocalDate.now();
        compras.add(new Compra(cliente,productos,fechaCompra));
    }

}

