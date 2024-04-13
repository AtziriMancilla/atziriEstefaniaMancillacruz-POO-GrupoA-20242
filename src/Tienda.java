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
        mostrarClientes();
        int opcion= sc.nextInt();
        Cliente cliente=clientes.get(opcion-1);
        boolean band=true;
        ArrayList<Carrito> productos=new ArrayList<>();
        int cant=0;
        do {
            System.out.println("1)Alimentos\n2)Limpieza\n3)Belleza\n4)Electrodomesticos\n5)Salir");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:
                    System.out.println("**Alimentos**");
                    mostrarAlimentos();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    System.out.println("Seleccione la cantidad de articulos: ");
                    cant=sc.nextInt();
                    if(cant<=productosAlimento.get(opcion-1).getStock())
                        productos.add(new Carrito(productosAlimento.get(opcion-1),cant));
                    break;
                case 2:
                    System.out.println("**Limpieza**");
                    mostrarLimpieza();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    cant=sc.nextInt();
                    if(cant<=productosAlimento.get(opcion-1).getStock())
                        productos.add(new Carrito(productosLimpieza.get(opcion-1),cant));
                    break;
                case 3:
                    System.out.println("**Belleza**");
                    mostrarBelleza();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    cant=sc.nextInt();
                    if(cant<=productosAlimento.get(opcion-1).getStock())
                        productos.add(new Carrito(productosBelleza.get(opcion-1),cant));
                    break;
                case 4:
                    System.out.println("**Electrodomesticos**");
                    mostrarElectrodomesticos();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    cant=sc.nextInt();
                    if(cant<=productosAlimento.get(opcion-1).getStock())
                        productos.add(new Carrito(productosElectrodomestico.get(opcion-1),cant));
                    break;
                default:
                    band=false;
                    break;
            }
        }while(band);
        LocalDate fechaCompra=LocalDate.now();
        compras.add(new Compra(cliente,productos,fechaCompra));
        System.out.println("Compra realizada con exito");
    }
    public void mostrarCompras(){
        if(compras.isEmpty())
            System.out.println("No hay compras registradas");
        else{
            int i = 1;
            for (Compra compra:compras){
                System.out.println("Compra: "+i);
                compra.mostrarCompra();
                i++;
            }
        }
    }
    public void tester(){
        Alimento alimento1=new Alimento("Papa",15.5,"15/03/24",15,"31/03/24");
        Alimento alimento2=new Alimento("Melon",2,"15/03/24",20,"31/03/24");
        Cliente cliente=new Cliente("Andrea","duran","Morelia",LocalDate.now());
        clientes.add(cliente);
        productosAlimento.add(alimento1);
        productosAlimento.add(alimento2);
    }
}

