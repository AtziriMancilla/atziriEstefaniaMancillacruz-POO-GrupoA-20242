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
        if(productosAlimento.isEmpty())
            System.out.println("No hay alimentos");
        else {
            int i = 1;
            for (Alimento alimento : productosAlimento) {
                System.out.println(i + ") " + alimento.obtenerDatosAlimento());
                i++;
            }
        }
    }
    private void mostrarBelleza(){
        if(productosBelleza.isEmpty())
            System.out.println("No hay productos de belleza");
        else {
            int i = 1;
            for (Belleza belleza : productosBelleza) {
                System.out.println(i + ") " + belleza.obtenerInformacion());
                i++;
            }
        }
    }
    private void mostrarElectrodomesticos(){
        if(productosElectrodomestico.isEmpty())
            System.out.println("No hay electrodomesticos");
        else {
            int i = 1;
            for (Electrodomestico electrodomestico : productosElectrodomestico) {
                System.out.println(i + ") " + electrodomestico.obtenerInformacion());
                i++;
            }
        }
    }
    private void mostrarLimpieza(){
        if(productosLimpieza.isEmpty())
            System.out.println("No hay productos de limpieza");
        else {
            int i = 1;
            for (Limpieza limpieza : productosLimpieza) {
                System.out.println(i + ") " + limpieza.obtenerInformacion());
                i++;
            }
        }
    }
    public void mostrarClientes(){
        if(clientes.isEmpty())
            System.out.println("No hay clientes registrados");
        else {
            int i = 1;
            for (Cliente cliente : clientes) {
                System.out.println(i + ") " + cliente.mostrarInfoConFecha());
                i++;
            }
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
                for (int i=0;i<compras.size();i++) {
                    for (int j=0;j<compras.get(i).getProductos().size();j++)
                        if(compras.get(i).getProductos().get(j).getProducto().equals(productosAlimento.get(opcion-1))){
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
                for (int i=0;i<compras.size();i++) {
                    for (int j=0;j<compras.get(i).getProductos().size();j++)
                        if(compras.get(i).getProductos().get(j).getProducto().equals(productosLimpieza.get(opcion-1))){
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
                for (int i=0;i<compras.size();i++) {
                    for (int j=0;j<compras.get(i).getProductos().size();j++)
                        if(compras.get(i).getProductos().get(j).getProducto().equals(productosBelleza.get(opcion-1))){
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
                System.out.println("Seleccione el electrodomestico que desea eliminar: ");
                opcion=sc.nextInt();
                band=false;
                for (int i=0;i<compras.size();i++) {
                    for (int j=0;j<compras.get(i).getProductos().size();j++)
                        if(compras.get(i).getProductos().get(j).getProducto().equals(productosElectrodomestico.get(opcion-1))){
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
            switch (opcion) {
                case 1:
                    System.out.println("**Alimentos**");
                    mostrarAlimentos();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion = sc.nextInt();
                    System.out.println("Seleccione la cantidad de articulos: ");
                    cant = sc.nextInt();
                    if (cant <= productosAlimento.get(opcion - 1).getStock()) {
                        productos.add(new Carrito(productosAlimento.get(opcion - 1), cant));
                        System.out.println("Producto agregado");
                    }
                    else
                        System.out.println("No se puede comprar esa cantidad");
                    break;
                case 2:
                    System.out.println("**Limpieza**");
                    mostrarLimpieza();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion = sc.nextInt();
                    System.out.println("Ingrese la cantidad: ");
                    cant = sc.nextInt();
                    if (cant <= productosAlimento.get(opcion - 1).getStock()) {
                        productos.add(new Carrito(productosLimpieza.get(opcion - 1), cant));
                        System.out.println("Producto agregado");
                    } else
                        System.out.println("No se puede comprar esa cantidad");
                    break;
                case 3:
                    System.out.println("**Belleza**");
                    mostrarBelleza();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion = sc.nextInt();
                    System.out.println("Ingrese la cantidad: ");
                    cant = sc.nextInt();
                    if (cant <= productosAlimento.get(opcion - 1).getStock()){
                            productos.add(new Carrito(productosBelleza.get(opcion - 1), cant));
                            System.out.println("Producto agregado");
                    }
                    else
                        System.out.println("No se puede comprar esa cantidad");
                    break;
                case 4:
                    System.out.println("**Electrodomesticos**");
                    mostrarElectrodomesticos();
                    System.out.println("Seleccione el producto que desea agregar: ");
                    opcion=sc.nextInt();
                    System.out.println("Ingrese la cantidad: ");
                    cant=sc.nextInt();
                    if(cant<=productosAlimento.get(opcion-1).getStock()){
                        productos.add(new Carrito(productosElectrodomestico.get(opcion-1),cant));
                        System.out.println("Producto agregado");
                    }
                    else
                        System.out.println("No se puede comprar esa cantidad");
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
    public void anadirStock(){
        int cant;
        Scanner sc=new Scanner(System.in);
        System.out.println("Seleccione el tipo de producto: ");
        System.out.println("1)Alimentos\n2)Limpieza\n3)Belleza\n4)Electrodomesticos\n5)Salir");
        int opcion= sc.nextInt();
        switch (opcion){
            case 1:
                mostrarAlimentos();
                System.out.println("Ingrese el numero: ");
                opcion=sc.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                cant=sc.nextInt();
                productosAlimento.get(opcion-1).AgregarStock(cant);
                System.out.println("Cantidad agregada con exito");
                break;
            case 2:
                mostrarLimpieza();
                System.out.println("Ingrese el numero: ");
                opcion=sc.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                cant=sc.nextInt();
                productosLimpieza.get(opcion-1).AgregarStock(cant);
                System.out.println("Cantidad agregada con exito");
                break;
            case 3:
                mostrarBelleza();
                System.out.println("Ingrese el numero: ");
                opcion=sc.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                cant=sc.nextInt();
                productosBelleza.get(opcion-1).AgregarStock(cant);
                System.out.println("Cantidad agregada con exito");
                break;
            case 4:
                mostrarElectrodomesticos();
                System.out.println("Ingrese el numero: ");
                opcion=sc.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                cant=sc.nextInt();
                productosElectrodomestico.get(opcion-1).AgregarStock(cant);
                System.out.println("Cantidad agregada con exito");
                break;
            default:
                break;
        }
    }
    public void eliminarStock(){
        int cant;
        Scanner sc=new Scanner(System.in);
        System.out.println("Seleccione el tipo de producto: ");
        System.out.println("1)Alimentos\n2)Limpieza\n3)Belleza\n4)Electrodomesticos\n5)Salir");
        int opcion= sc.nextInt();
        switch (opcion){
            case 1:
                mostrarAlimentos();
                System.out.println("Ingrese el numero: ");
                opcion=sc.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                cant=sc.nextInt();
                if(validarStock(productosAlimento.get(opcion-1),cant)){
                    productosAlimento.get(opcion - 1).quitarDeStock(cant);
                    System.out.println("Cantidad eliminada con exito");
                }
                else
                    System.out.println("No se puede eliminar esa cantidad");
                break;
            case 2:
                mostrarLimpieza();
                System.out.println("Ingrese el numero: ");
                opcion=sc.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                cant=sc.nextInt();
                if(validarStock(productosLimpieza.get(opcion-1),cant)){
                    productosLimpieza.get(opcion - 1).quitarDeStock(cant);
                    System.out.println("Cantidad eliminada con exito");
                }
                else
                    System.out.println("No se puede eliminar esa cantidad");
            case 3:
                mostrarBelleza();
                System.out.println("Ingrese el numero: ");
                opcion=sc.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                cant=sc.nextInt();
                if(validarStock(productosBelleza.get(opcion-1),cant)){
                    productosBelleza.get(opcion - 1).quitarDeStock(cant);
                    System.out.println("Cantidad eliminada con exito");
                }
                else
                    System.out.println("No se puede eliminar esa cantidad");
                break;
            case 4:
                mostrarElectrodomesticos();
                System.out.println("Ingrese el numero: ");
                opcion=sc.nextInt();
                System.out.println("Ingrese la cantidad a agregar: ");
                cant=sc.nextInt();
                if(validarStock(productosElectrodomestico.get(opcion-1),cant)){
                    productosElectrodomestico.get(opcion - 1).quitarDeStock(cant);
                    System.out.println("Cantidad eliminada con exito");
                }
                else
                    System.out.println("No se puede eliminar esa cantidad");
                break;
            default:
                break;
        }
    }
    public Boolean validarStock(Producto producto,int cantidad){
        return producto.getStock() >= cantidad;
    }
    public void tester(){
        Alimento alimento1=new Alimento("Papa",15.5,"15/03/24",15,"31/03/24");
        Alimento alimento2=new Alimento("Melon",2,"15/03/24",20,"31/03/24");
        Electrodomestico electrodomestico1=new Electrodomestico("Licuadora",580,"31/01/24",15,"oster",4.5);
        Electrodomestico electrodomestico2=new Electrodomestico("Air Fryer",1000,"31/01/24",35,"Gourmia",4.5);
        Limpieza limpieza1=new Limpieza("Axion",45,"31/01/24",15,"axion");
        Limpieza limpieza2=new Limpieza("Pinol",25,"31/01/24",22,"Pinol");
        Belleza belleza1=new Belleza("Retinol",800,"31/01/24",35,"La roche posay",30);
        Belleza belleza2=new Belleza("Limpiador facial",300,"31/01/24",35,"La roche posay",300);
        Cliente cliente1=new Cliente("Andrea","Duran","Morelia",LocalDate.now());
        Cliente cliente2=new Cliente("Alejandro","Montejano","Morelia",LocalDate.now());
        clientes.add(cliente1);
        clientes.add(cliente2);
        productosAlimento.add(alimento1);
        productosAlimento.add(alimento2);
        productosLimpieza.add(limpieza1);
        productosLimpieza.add(limpieza2);
        productosBelleza.add(belleza1);
        productosBelleza.add(belleza2);
        productosElectrodomestico.add(electrodomestico1);
        productosElectrodomestico.add(electrodomestico2);
    }
}

