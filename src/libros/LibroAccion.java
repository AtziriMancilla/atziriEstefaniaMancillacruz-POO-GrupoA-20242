package libros;

import biblioteca.Biblioteca;
import biblioteca.utils.DatosComun;
import libros.constants.Genero;
import libros.constants.SubgeneroAccion;
import libros.utils.LibrosUtils;

import java.time.LocalDate;
import java.util.*;

public class LibroAccion extends Libro{
    private SubgeneroAccion subgenero;
    public LibroAccion(String nombre, String autor, String editorial, LocalDate fechaDePublicacion, double precio, int stock, SubgeneroAccion subgenero) {
        super(nombre, autor, editorial, fechaDePublicacion, Genero.COMEDIA, precio, stock);
        this.subgenero = subgenero;
    }
    public SubgeneroAccion getSubgenero() {
        return subgenero;
    }

    public static void registrarLibro() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> datosComun = LibrosUtils.obtenerLibrosDatosComun();

        String nombre = datosComun.get(0);
        String autor = datosComun.get(1);
        String editorial = datosComun.get(2);
        LocalDate fechaPublicacion = LocalDate.parse(datosComun.get(3));
        double precio = Double.parseDouble(datosComun.get(4));
        int stock = Integer.parseInt(datosComun.get(5));

        System.out.println("Ingresa el subgenero del libro");
        System.out.println("Selecciona una opción");
        System.out.println("1. Aventura");
        System.out.println("2. Policiaca");

        int opcionSubgenero = DatosComun.pedirNumero();
        SubgeneroAccion subgeneroInput = null;

        if (opcionSubgenero == 1) {
            subgeneroInput = SubgeneroAccion.AVENTURA;
        } else {
            subgeneroInput = SubgeneroAccion.POLICIACA;
        }

        LibroAccion libroAccion = new LibroAccion(nombre, autor, editorial, fechaPublicacion, precio, stock, subgeneroInput);
    }
    @Override
    public String toString(){
        return String.format("%s, Subgenero: %s",super.toString(),subgenero);
    }
    public static void mostrarLibrosAccion(){
        if(Biblioteca.libros.get(Genero.ACCION).isEmpty()){
            System.out.println("No hay libros de Acción");
        }
        else {
            int i = 1;
            for (Iterator var1 = ((ArrayList) Biblioteca.libros.get(Genero.ACCION)).iterator(); var1.hasNext(); ++i) {
                Libro libro = (Libro) var1.next();
                LibroAccion libroAccioon= (LibroAccion) libro;
                System.out.println("" + i + ") " + libroAccioon.toString());
                i++;
            }
        }
    }
    public static void eliminarLibroTerror(){
        Scanner sc=new Scanner(System.in);
        int numLibro=0;
        boolean band;
        System.out.println("<<Eliminar libro Acción>>");
        mostrarLibrosAccion();
        do {
            try {
                band=false;
                System.out.println("Selecciona el libro que deseas eliminar");
                numLibro = sc.nextInt();
                Biblioteca.libros.get(Genero.ACCION).get(numLibro - 1);
            } catch (IndexOutOfBoundsException | InputMismatchException error) {
                System.out.println("Opcion no valida");
                band=true;
                //revisar sc.nextLine
            }
        }while(band);
        LibroTerror libroTerror=(LibroTerror) Biblioteca.libros.get(Genero.ACCION).get(numLibro - 1);
        if(libroTerror.getStock()==0) {
            System.out.println("Seleccionaste: ");
            System.out.println(Biblioteca.libros.get(Genero.ACCION).get(numLibro - 1).toString());
            int opcion = 0;
            boolean bandera;
            System.out.println("¿Deseas eliminarlo? 1) Sí, Otro número) Cancelar");
            opcion = DatosComun.pedirNumero();
            if (opcion == 1) {
                Biblioteca.libros.get(Genero.ACCION).get(numLibro - 1);
                System.out.println("Libro eliminado");
            }
            if (opcion != 1) {
                System.out.println("Se cancelo la eliminación");
            }
        }
        else{
            System.out.println("No se puede eliminar este libro");
        }
    }

    @Override
    protected void filtrarPorPrecio(double precio) {
        Biblioteca.libros.get(Genero.ACCION)
                .stream()
                .filter(libro -> libro.getPrecio()>=precio)
                .forEach(libro -> System.out.println(libro.toString()));
    }
    @Override
    protected void filtrarPorAutor(String autor) {
        Biblioteca.libros.get(Genero.ACCION)
                .stream()
                .filter(libro -> Objects.equals(libro.getAutor(), autor))
                .forEach(libro -> System.out.println(libro.toString()));
    }
}

